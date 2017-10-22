package ganko.movil.ganko1.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ganko.movil.ganko1.ui.AddFarm.AddFarmActivity
import ganko.movil.ganko1.ui.login.LoginActivity
import ganko.movil.ganko1.ui.main.MainActivity
import ganko.movil.ganko1.ui.password.PasswordActivity
import javax.inject.Scope

/**
 * Created by Ana Marin on 18/10/2017.
 */
@Retention(AnnotationRetention.RUNTIME)
@Scope
annotation class ActivityScope

@Module
abstract class ActivityBuilders{

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindMainActivity(): MainActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindLoginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindPasswordActivity(): PasswordActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindAddFarmActivity(): AddFarmActivity

}