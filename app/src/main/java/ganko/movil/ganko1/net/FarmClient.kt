package ganko.movil.ganko1.net

import ganko.movil.ganko1.data.model.Farm
import ganko.movil.ganko1.data.model.FarmResponse
import io.reactivex.Observable
import retrofit2.http.*

/**
 * Created by jlbeltran94 on 19/10/17.
 */
interface FarmClient {

    @GET("finca/get-fincas/")
    fun getAllFincas(@Header("Authorization") token:String): Observable<ResponseData<List<Farm>>>

    @POST("finca/add-finca/")
    fun insertFinca(
            @Header("Authorization") token: String,
            @Body farm: Farm): Observable<ResponseData<FarmResponse>>

    @DELETE("finca/delete-finca/{id}")
    fun deleteFinca(
            @Header("Authorization") token: String,
            @Path("id") id:Long): Observable<ResponseData<FarmResponse>>

}