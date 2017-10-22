package ganko.movil.ganko1

import android.app.Activity
import android.app.Application
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import ganko.movil.ganko1.di.AppInjector
import javax.inject.Inject

/**
 * Created by Ana Marin on 18/10/2017.
 */
class App : Application(), HasActivityInjector{

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity>
            = injector



    override fun onCreate() {
        super.onCreate()
        AppInjector.init(this)
    }
}