package ganko.movil.ganko1.data

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import ganko.movil.ganko1.data.dao.FincaDao
import ganko.movil.ganko1.data.model.Finca

/**
 * Created by Ana Marin on 18/10/2017.
 */
@Database(entities = arrayOf(Finca::class), version = 1)
abstract class AppDatabase: RoomDatabase(){

    abstract fun fincaDao(): FincaDao

}