package ganko.movil.ganko1.ui.farm

import android.arch.lifecycle.ViewModel
import ganko.movil.ganko1.data.dao.FincaDao
import ganko.movil.ganko1.data.model.Finca
import ganko.movil.ganko1.net.FincaClient
import ganko.movil.ganko1.utils.applySchedulers
import ganko.movil.ganko1.utils.validateResponse
import io.reactivex.Flowable
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Ana Marin on 18/10/2017.
 */
class MainViewModel @Inject constructor(val fincaClient: FincaClient, val fincaDao: FincaDao): ViewModel(){

    val token: String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MzEsImlhdCI6MTUwODkxMjQ2OH0.7-sn50TPMvGwoUvT-9vthrdgp6U_3L9u6-K2IsxzXWk"

    fun getAllRemote(): Observable<List<Finca>> = fincaClient.getAllFincas(token)
            .flatMap{validateResponse(it)}
            .applySchedulers()

    fun getAllLocal(): Flowable<List<Finca>> = fincaDao.all().applySchedulers()

}