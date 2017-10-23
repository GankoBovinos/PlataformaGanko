package ganko.movil.ganko1.net

import ganko.movil.ganko1.data.model.Finca
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Header

/**
 * Created by jlbeltran94 on 19/10/17.
 */
interface FincaClient {

    @GET("get-fincas/")
    fun getAllFincas(@Header("Authorization") token:String): Observable<ResponseData<List<Finca>>>

}