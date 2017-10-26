package ganko.movil.ganko1.ui.farm

import android.arch.lifecycle.ViewModel
import ganko.movil.ganko1.data.dao.FincaDao
import ganko.movil.ganko1.data.model.Finca
import ganko.movil.ganko1.data.model.FincaResponse
import ganko.movil.ganko1.data.prefs.UserSession
import ganko.movil.ganko1.net.FincaClient
import ganko.movil.ganko1.net.ResponseData
import ganko.movil.ganko1.utils.applySchedulers
import ganko.movil.ganko1.utils.validateResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Ana Marin on 18/10/2017.
 */
class MainViewModel @Inject constructor(val fincaClient: FincaClient, val fincaDao: FincaDao, val userSession: UserSession): ViewModel(){


    fun getAllRemote(): Observable<List<Finca>> = fincaClient.getAllFincas(userSession.token)
            .flatMap{validateResponse(it)}
            .applySchedulers()

    fun getAllLocal(): Flowable<List<Finca>> = fincaDao.all().applySchedulers()

    fun deleteRemote(id:Long): Observable<ResponseData<FincaResponse>> = fincaClient.deleteFinca(userSession.token,id).applySchedulers()

}