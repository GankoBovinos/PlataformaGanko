package ganko.movil.ganko1.ui.farm.add

import android.arch.lifecycle.ViewModel
import ganko.movil.ganko1.data.dao.FarmDao
import ganko.movil.ganko1.data.model.Farm
import ganko.movil.ganko1.data.prefs.UserSession
import ganko.movil.ganko1.net.FarmClient
import ganko.movil.ganko1.utils.applySchedulers
import ganko.movil.ganko1.utils.validateResponse
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Ana Marin on 18/10/2017.
 */
class AddFarmViewModel @Inject constructor(val farmClient: FarmClient,
                                           val farmDao: FarmDao,
                                           val session:UserSession) : ViewModel() {

    fun insertLocalFarm(name:String,location: String, size:Int) = Observable
            .fromCallable { farmDao.insert(Farm(name,location,size,session.userId)) }
            .applySchedulers()

    fun editLocalFarm(farm: Farm, name:String, location: String, size: Int): Observable<Unit>{
        farm.nombre = name
        farm.ubicacion = location
        farm.hectareas = size
        return Observable.fromCallable { farmDao.update(farm) }
                .applySchedulers()
    }


    fun insertRemoteFarm(name:String,location: String, size:Int)
            = farmClient.insertFinca(session.token, Farm(name,location,size,session.userId))
            .flatMap { validateResponse(it) }
            .applySchedulers()



}