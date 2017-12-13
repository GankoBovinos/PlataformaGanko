package ganko.movil.ganko1.data.dao

import android.arch.persistence.room.*
import ganko.movil.ganko1.data.model.Feed
import io.reactivex.Flowable

/**
 * Created by Asus on 6/12/2017.
 */

@Dao
interface FeedDao {

    @Insert
    fun insert (feed: Feed)

    @Update
    fun update (feed: Feed)

    @Delete
    fun delete (feed: Feed)

    @Query("SELECT * FROM feed WHERE id_bovino = id_bovino")
    fun getAll (id_bovino: Int) : Flowable<List<Feed>>

}