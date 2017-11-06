package ganko.movil.ganko1.data.dao

import android.arch.persistence.room.*
import ganko.movil.ganko1.data.model.Bovine
import io.reactivex.Flowable

/**
 * Created by jlbeltran94 on 3/11/2017.
 */

@Dao
interface BovineDao{

    @Insert
    fun insert(bovine:Bovine)

    @Update
    fun update(bovine: Bovine)

    @Delete
    fun delete(bovine: Bovine)

    @Query("SELECT * FROM bovine WHERE finca = :idFinca")
    fun getAll(idFinca: Int): Flowable<List<Bovine>>
}