package ganko.movil.ganko1.ui.login

import android.arch.lifecycle.ViewModel
import ganko.movil.ganko1.data.model.LoginResponse
import ganko.movil.ganko1.data.model.UserLogin
import ganko.movil.ganko1.data.prefs.UserSession
import ganko.movil.ganko1.net.LoginClient
import ganko.movil.ganko1.utils.applySchedulers
import ganko.movil.ganko1.utils.validateResponse
import io.reactivex.Observable
import javax.inject.Inject

class LoginViewModel @Inject constructor(val loginClient: LoginClient,
                                         val session:UserSession) : ViewModel() {

    fun Login(userLogin: UserLogin): Observable<String> = loginClient.login(userLogin)
            .flatMap { validateResponse(it) }
            .flatMap { validateState(it) }
            .applySchedulers()

    fun validateState(loginResponse: LoginResponse) = Observable.create<String>{
        if(loginResponse.user.estado == "activo"){
            session.token = loginResponse.token
            session.logged = true
            it.onNext(loginResponse.token)

        }
        else throw Throwable("Usuario Inactivo, Contacte a su Proveedor")
    }

}