package ganko.movil.ganko1.ui.login

import android.arch.lifecycle.ViewModel
import ganko.movil.ganko1.data.models.LoginResponse
import ganko.movil.ganko1.data.models.UserLogin
import ganko.movil.ganko1.net.LoginClient
import ganko.movil.ganko1.utils.applySchedulers
import ganko.movil.ganko1.utils.validateResponse
import io.reactivex.Observable
import javax.inject.Inject

class LoginViewModel @Inject constructor(val loginClient: LoginClient) : ViewModel() {

    fun Login(userLogin: UserLogin): Observable<String> = loginClient.login(userLogin)
            .flatMap { validateResponse(it) }
            .flatMap { validateState(it) }

            .applySchedulers()

    fun validateState(loginResponse: LoginResponse) = Observable.create<String>{
        if(loginResponse.user.estado == "activo") it.onNext(loginResponse.token)
        else throw Throwable("Error en validateState")
    }

}