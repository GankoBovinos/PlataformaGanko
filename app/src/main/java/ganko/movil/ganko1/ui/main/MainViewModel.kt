package ganko.movil.ganko1.ui.main

import android.arch.lifecycle.ViewModel
import ganko.movil.ganko1.data.model.Finca
import ganko.movil.ganko1.net.FincaClient
import ganko.movil.ganko1.utils.applySchedulers
import ganko.movil.ganko1.utils.validateResponse
import io.reactivex.Observable
import javax.inject.Inject

/**
 * Created by Ana Marin on 18/10/2017.
 */
class MainViewModel @Inject constructor(val fincaClient: FincaClient): ViewModel(){

    val token: String = "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6OSwiaWF0IjoxNTA4NjkxOTY2fQ.ZC-FBN7_39EXvPVsO1OCeo3EaHeFhFxqs2tw28IdV7s"

    fun getAll(): Observable<List<Finca>> = fincaClient.getAllFincas(token)
            .flatMap{validateResponse(it)}
            .applySchedulers()

}