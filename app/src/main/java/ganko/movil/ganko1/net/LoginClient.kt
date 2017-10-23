package ganko.movil.ganko1.net

import ganko.movil.ganko1.data.models.Finca
import ganko.movil.ganko1.data.models.LoginResponse
import ganko.movil.ganko1.data.models.UserLogin
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Cristian on 22/10/2017.
 */
interface LoginClient {

    @POST("users/login")
    fun login(@Body userLogin: UserLogin): Observable<ResponseData<LoginResponse>>
}