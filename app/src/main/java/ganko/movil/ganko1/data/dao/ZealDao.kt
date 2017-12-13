package ganko.movil.ganko1.data.dao

import android.arch.persistence.room.*
import ganko.movil.ganko1.data.model.Zeal
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 5/12/2017.
 */
@Dao
interface ZealDao {

    @Insert
    fun insert(zeal: Zeal)

    @Update
    fun update(zeal: Zeal)

    @Delete
    fun delete(zeal: Zeal)

    @Query("SELECT * From zeal WHERE idBovino = :idBovino")
    fun all(id_bovino: String):Flowable<List<Zeal>>
}