package ganko.movil.ganko1.net

import ganko.movil.ganko1.data.model.LoginResponse
import ganko.movil.ganko1.data.model.UserLogin
import io.reactivex.Observable
import retrofit2.http.Body
import retrofit2.http.POST

/**
 * Created by Cristian on 22/10/2017.
 */
interface LoginClient {

    @POST("user/login")
    fun login(@Body userLogin: UserLogin): Observable<ResponseData<LoginResponse>>
}
