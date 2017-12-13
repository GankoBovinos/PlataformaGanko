package ganko.movil.ganko1.data.dao

import android.arch.persistence.room.*
import ganko.movil.ganko1.data.model.Birth
import io.reactivex.Flowable

/**
 * Created by jlbeltran94 on 5/12/2017.
 */
@Dao
interface BirthDao {

    @Insert
    fun insert(birth: Birth)

    @Update
    fun update(birth: Birth)

    @Delete
    fun delete(birth: Birth)

    @Query("SELECT * FROM birth WHERE idBovino = :idBovino")
    fun all(id_bovino: String): Flowable<List<Birth>>
}