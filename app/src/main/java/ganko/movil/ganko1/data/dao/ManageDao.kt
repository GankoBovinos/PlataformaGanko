package ganko.movil.ganko1.data.dao

import android.arch.persistence.room.*
import ganko.movil.ganko1.data.model.Manage
import io.reactivex.Flowable

/**
 * Created by jlbeltran94 on 5/12/2017.
 */
@Dao
interface ManageDao{

    @Insert
    fun insert(manage:Manage)

    @Update
    fun update(manage: Manage)

    @Delete
    fun delete(manage: Manage)

    @Query("SELECT * FROM manage WHERE idBovino = :idBovino")
    fun all(id_bovino:String):Flowable<List<Manage>>

}