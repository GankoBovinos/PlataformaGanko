package ganko.movil.ganko1.data.dao

import android.arch.persistence.room.*
import ganko.movil.ganko1.data.model.Diagnosis
import io.reactivex.Flowable

/**
 * Created by jlbeltran94 on 5/12/2017.
 */
@Dao
interface DiagnosisDao {

    @Insert
    fun insert(diagnosis: Diagnosis)

    @Update
    fun update(diagnosis: Diagnosis)

    @Delete
    fun delete(diagnosis: Diagnosis)

    @Query("SELECT * FROM diagnosis WHERE idBovino = :idBovino")
    fun all(id_bovino:String): Flowable<List<Diagnosis>>
}