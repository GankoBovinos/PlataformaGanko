package ganko.movil.ganko1.ui.login

import android.arch.lifecycle.ViewModel
import ganko.movil.ganko1.data.models.UserLogin
import ganko.movil.ganko1.net.FincaClient
import ganko.movil.ganko1.net.ResponseData
import ganko.movil.ganko1.utils.applySchedulers
import io.reactivex.Observable
import io.reactivex.internal.operators.observable.ObservableFromCallable
import javax.inject.Inject

class LoginViewModel @Inject constructor(val fincaClient: FincaClient) : ViewModel(){

//    fun Login(userLogin: UserLogin):Observable<Unit> =
//            ObservableFromCallable{fincaClient.login(userLogin)}
//                    .applySchedulers()



}