package ganko.movil.ganko1.ui.farm

import android.arch.lifecycle.ViewModel
import ganko.movil.ganko1.data.dao.FarmDao
import ganko.movil.ganko1.data.model.Farm
import ganko.movil.ganko1.data.model.FarmResponse
import ganko.movil.ganko1.data.prefs.UserSession
import ganko.movil.ganko1.net.FarmClient
import ganko.movil.ganko1.net.ResponseData
import ganko.movil.ganko1.utils.applySchedulers
import ganko.movil.ganko1.utils.validateResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Ana Marin on 18/10/2017.
 */
class FarmViewModel @Inject constructor(val farmClient: FarmClient, val farmDao: FarmDao, val userSession: UserSession): ViewModel(){

    fun getAllRemote(): Observable<List<Farm>> = farmClient.getAllFincas(userSession.token)
            .flatMap{validateResponse(it)}
            .applySchedulers()

    fun getAllLocal(): Flowable<List<Farm>> = farmDao.all(userSession.userId).applySchedulers()

    fun deleteRemote(id:Long): Observable<ResponseData<FarmResponse>>
            = farmClient.deleteFinca(userSession.token,id).applySchedulers()

    fun deleteLocal(farm: Farm)
            = Observable.fromCallable { farmDao.delete(farm) }
            .applySchedulers()

    fun ss(farm: Farm){
        userSession.farm = farm.nombre
        userSession.farmID = farm.id.toString()
    }

}