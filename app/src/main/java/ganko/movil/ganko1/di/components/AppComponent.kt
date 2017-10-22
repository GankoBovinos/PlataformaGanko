package ganko.movil.ganko1.di.components

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule
import ganko.movil.ganko1.App
import ganko.movil.ganko1.di.ActivityBuilders
import ganko.movil.ganko1.di.modules.AppModule
import ganko.movil.ganko1.di.modules.NetModule
import ganko.movil.ganko1.di.modules.ViewModelModule
import javax.inject.Singleton

/**
 * Created by Ana Marin on 18/10/2017.
 */
@Singleton
@Component(modules = arrayOf(
        AndroidInjectionModule::class,
        AppModule::class,
        ActivityBuilders::class,
        NetModule::class,
        ViewModelModule::class
))
interface AppComponent{

    fun inject(app: App)

    @Component.Builder
    interface Builder{
        @BindsInstance
        fun applicacion(application: Application):Builder
        fun build():AppComponent
    }
}