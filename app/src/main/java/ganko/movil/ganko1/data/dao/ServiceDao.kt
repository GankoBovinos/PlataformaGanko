package ganko.movil.ganko1.data.dao

import android.app.Service
import android.arch.persistence.room.*
import io.reactivex.Flowable

/**
 * Created by jlbeltran94 on 5/12/2017.
 */
@Dao
interface ServiceDao {

    @Insert
    fun insert(service: Service)

    @Update
    fun update(service: Service)

    @Delete
    fun delete(service: Service)

    @Query("SELECT * FROM service WHERE idBovino = :idBovino")
    fun all(id_bovino:String): Flowable<List<Service>>
}