package ganko.movil.ganko1.data.dao

import android.arch.persistence.room.Delete
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import ganko.movil.ganko1.data.model.Meat
import io.reactivex.Flowable

/**
 * Created by Ana Marin on 5/12/2017.
 */
interface MeatDao {
    @Insert
    fun insert(meat: Meat)

    @Update
    fun update(meat: Meat)

    @Delete
    fun delete(meat: Meat)

    @Query("SELECT * FROM meat WHERE id_bovino = :idBovino")
    fun getById(id: Int): Flowable<List<Meat>>
}