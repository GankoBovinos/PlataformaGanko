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

    fun insertLocalFarm(farm: Farm) = Observable
            .fromCallable { farmDao.insert(farm) }
            .applySchedulers()
//            .map { finca }

    fun insertRemoteFarm(farm: Farm) = farmClient.insertFinca(session.token,farm)
            .flatMap { validateResponse(it) }
            .applySchedulers()



}