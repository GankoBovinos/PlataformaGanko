package ganko.movil.ganko1.ui.farm.add

import android.arch.lifecycle.ViewModel
import ganko.movil.ganko1.data.dao.FincaDao
import ganko.movil.ganko1.data.model.Finca
import ganko.movil.ganko1.data.prefs.UserSession
import ganko.movil.ganko1.net.FincaClient
import ganko.movil.ganko1.utils.applySchedulers
import ganko.movil.ganko1.utils.validateResponse
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Ana Marin on 18/10/2017.
 */
class AddFarmViewModel @Inject constructor(val fincaClient: FincaClient,
                                           val fincaDao: FincaDao,
                                           val session:UserSession) : ViewModel() {

    fun insertFincaLocal(finca: Finca) = Observable
            .fromCallable { fincaDao.insert(finca) }
            .applySchedulers()
//            .map { finca }

    fun insertFincaRemote(finca: Finca) = fincaClient.insertFinca(session.token,finca)
            .flatMap { validateResponse(it) }
            .applySchedulers()



}