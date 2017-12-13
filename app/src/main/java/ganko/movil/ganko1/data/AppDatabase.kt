package ganko.movil.ganko1.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ganko.movil.ganko1.data.dao.BovineDao
import android.arch.persistence.room.TypeConverter
import android.arch.persistence.room.TypeConverters
import ganko.movil.ganko1.data.dao.FarmDao
import ganko.movil.ganko1.data.model.Bovine
import ganko.movil.ganko1.data.model.Farm
import java.util.*

/**
 * Created by Ana Marin on 18/10/2017.
 */

object DateConverter{

    @TypeConverter
    @JvmStatic
    fun dateToLong(date: Date):Long = date.time

    @TypeConverter
    @JvmStatic
    fun longToDate(timestap:Long) = Date(timestap)

}
@Database(entities = [Farm::class, Bovine::class], version = 1)
@TypeConverters(DateConverter::class)
abstract class AppDatabase: RoomDatabase(){

    abstract fun farmDao(): FarmDao
    abstract fun bovineDao(): BovineDao

}