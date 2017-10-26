package ganko.movil.ganko1.net

import ganko.movil.ganko1.data.model.Finca
import ganko.movil.ganko1.data.model.FincaResponse
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by jlbeltran94 on 19/10/17.
 */
interface FincaClient {

    @GET("finca/get-fincas/")
    fun getAllFincas(@Header("Authorization") token:String): Observable<ResponseData<List<Finca>>>

    @POST("finca/add-finca/")
    fun insertFinca(
            @Header("Authorization") token: String,
            @Body finca: Finca): Observable<ResponseData<FincaResponse>>

    @DELETE("finca/delete-finca/{id}")
    fun deleteFinca(
            @Header("Authorization") token: String,
            @Path("id") id:Long): Observable<ResponseData<FincaResponse>>

}