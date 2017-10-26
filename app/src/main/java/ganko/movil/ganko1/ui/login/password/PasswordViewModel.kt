package ganko.movil.ganko1.ui.login.password

import android.arch.lifecycle.ViewModel
import ganko.movil.ganko1.data.model.ResetPasswordResponse
import ganko.movil.ganko1.data.model.ResetUserEmail
import ganko.movil.ganko1.net.ResetPasswordClient
import ganko.movil.ganko1.utils.applySchedulers
import ganko.movil.ganko1.utils.validateResponse
import io.reactivex.Observable
import javax.inject.Inject

class PasswordViewModel @Inject constructor(val resetPasswordClient : ResetPasswordClient) : ViewModel(){

    fun resetPassword(email:String) : Observable<String> = resetPasswordClient.resetPassword(ResetUserEmail(email))
            .flatMap { validateResponse(it) }
            .flatMap { validateState(it) }
            .applySchedulers()

    fun validateState(resetPasswordResponse: ResetPasswordResponse) = Observable.create<String>{
        if(resetPasswordResponse.estado == "activo"){
            it.onNext("Correo enviado a "+resetPasswordResponse.email)
        }
        else throw Throwable("Usuario Inactivo, Contacte a su Proveedor")
    }

}
