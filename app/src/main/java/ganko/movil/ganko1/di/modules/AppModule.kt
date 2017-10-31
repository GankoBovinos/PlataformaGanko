package ganko.movil.ganko1.di.modules

import android.app.Application
import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import dagger.Module
import dagger.Provides
import ganko.movil.ganko1.data.AppDatabase
import ganko.movil.ganko1.data.dao.FarmDao
import javax.inject.Singleton

/**
 * Created by Ana Marin on 18/10/2017.
 */
@Module
class AppModule{

    @Singleton
    @Provides
    fun provideContext(application: Application): Context = application

    @Singleton
    @Provides
    fun provideDatabase(context: Context) : AppDatabase =
            Room.databaseBuilder(context, AppDatabase::class.java, "ganko.db")
                    .build()

    @Singleton
    @Provides
    fun providesFarmDao(appDatabase: AppDatabase): FarmDao =
            appDatabase.farmDao()

    @Singleton
    @Provides
    fun providesPreferences(application: Application):SharedPreferences =
            application.getSharedPreferences("ganko", 0)

}
