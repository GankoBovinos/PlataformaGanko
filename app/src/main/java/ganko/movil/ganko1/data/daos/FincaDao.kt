package ganko.movil.ganko1.data.daos

import android.arch.persistence.room.*
import ganko.movil.ganko1.data.models.Finca
import io.reactivex.Flowable

/**
 * Created by jlbeltran94 on 19/10/17.
 */
@Dao
interface FincaDao {

    @Insert
    fun insert(finca: Finca)

    @Update
    fun update(finca: Finca)

    @Delete
    fun delete(finca: Finca)

    @Query("SELECT * FROM finca")
    fun all(): Flowable<List<Finca>>

}