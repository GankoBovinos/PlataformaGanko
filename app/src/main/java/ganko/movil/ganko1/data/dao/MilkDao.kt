package ganko.movil.ganko1.data.dao

import android.arch.persistence.room.*
import ganko.movil.ganko1.data.model.Milk
import io.reactivex.Flowable

/**
 * Created by Asus on 1/12/2017.
 */

@Dao
interface MilkDao {

    @Insert
    fun insert (milk: Milk)

    @Update
    fun update (milk: Milk)

    @Delete
    fun delete (milk : Milk)

    @Query("SELECT * FROM milk WHERE id_bovino = :id_bovino")
    fun getAll(id_bovino: Int): Flowable<List<Milk>>



}