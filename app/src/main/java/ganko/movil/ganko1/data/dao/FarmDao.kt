package ganko.movil.ganko1.data.dao

import android.arch.persistence.room.*
import ganko.movil.ganko1.data.model.Farm
import io.reactivex.Flowable

/**
 * Created by jlbeltran94 on 19/10/17.
 */
@Dao
interface FarmDao {

    @Insert
    fun insert(farm: Farm)

    @Update
    fun update(farm: Farm)

    @Delete
    fun delete(farm: Farm)

    @Query("SELECT * FROM farm")
    fun all(): Flowable<List<Farm>>

}