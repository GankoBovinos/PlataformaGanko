package ganko.movil.ganko1.di

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ganko.movil.ganko1.di.modules.DetailFragment
import ganko.movil.ganko1.di.modules.MenuFragments
import ganko.movil.ganko1.di.modules.ReproductiveFragment
import ganko.movil.ganko1.ui.bovines.add.AddBovineActivity
import ganko.movil.ganko1.ui.bovines.out.OutBovineActivity
import ganko.movil.ganko1.ui.bovines.search.SearchBovineActivity
import ganko.movil.ganko1.ui.detail.DetailBovineActivity
import ganko.movil.ganko1.ui.detail.reproductive.ReproductiveActivity
import ganko.movil.ganko1.ui.farm.add.AddFarmActivity
import ganko.movil.ganko1.ui.login.LoginActivity
import ganko.movil.ganko1.ui.farm.FarmActivity
import ganko.movil.ganko1.ui.login.password.PasswordActivity
import ganko.movil.ganko1.ui.menu.MenuActivity
import javax.inject.Scope

/**
 * Created by Ana Marin on 18/10/2017.
 */
@Module
abstract class ActivityBuilders{

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindFarmActivity(): FarmActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindLoginActivity(): LoginActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindPasswordActivity(): PasswordActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindAddFarmActivity(): AddFarmActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(MenuFragments::class) )
    abstract fun bindMenuActivity(): MenuActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(ReproductiveFragment::class))
    abstract  fun bindReproductiveActivity(): ReproductiveActivity

    @ActivityScope
    @ContributesAndroidInjector(modules = arrayOf(DetailFragment::class))
    abstract fun bindDetailBovineActivity(): DetailBovineActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindAddBovineActivity(): AddBovineActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindOutBovineActivity(): OutBovineActivity

    @ActivityScope
    @ContributesAndroidInjector
    abstract fun bindSearchBovineActivity(): SearchBovineActivity

}