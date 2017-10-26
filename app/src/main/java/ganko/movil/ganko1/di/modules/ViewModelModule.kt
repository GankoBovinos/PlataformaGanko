package ganko.movil.ganko1.di.modules

import android.arch.lifecycle.ViewModelProvider
import dagger.Binds
import dagger.MapKey
import dagger.Module
import ganko.movil.ganko1.utils.AppViewModelFactory
import android.arch.lifecycle.ViewModel
import dagger.multibindings.IntoMap
import ganko.movil.ganko1.ui.login.LoginViewModel
import ganko.movil.ganko1.ui.farm.MainViewModel
import ganko.movil.ganko1.ui.login.password.PasswordViewModel
import kotlin.reflect.KClass

/**
 * Created by Ana Marin on 18/10/2017.
 */

@Target(AnnotationTarget.FUNCTION)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
internal annotation class ViewModelKey(val value: KClass<out ViewModel>)

@Module
abstract class ViewModelModule{

    @Binds
    abstract fun bindViewModelFactory(factory: AppViewModelFactory): ViewModelProvider.Factory


    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    abstract fun bindMainViewModel(viewModel: MainViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(LoginViewModel::class)
    abstract fun bindLoginViewModel(viewModel: LoginViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(PasswordViewModel::class)
    abstract fun bindPasswordViewModel(viewModel: PasswordViewModel): ViewModel
}