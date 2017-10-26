package ganko.movil.ganko1.net

import ganko.movil.ganko1.data.model.ResetPasswordResponse
import ganko.movil.ganko1.data.model.ResetUserEmail
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

interface ResetPasswordClient {

    @POST("user/reset-password")
    fun resetPassword(@Body email : ResetUserEmail): Observable<ResponseData<ResetPasswordResponse>>
}
