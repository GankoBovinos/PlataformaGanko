package ganko.movil.ganko1.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ganko.movil.ganko1.di.FragmentScope
import ganko.movil.ganko1.ui.bovines.BovineFragment
import ganko.movil.ganko1.ui.bovines.list.ListBovineFragment

/**
 * Created by Ana Marin on 1/11/2017.
 */
@Module
abstract class MenuFragments{

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun binBovineFragment(): BovineFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun binListBovineFragment(): ListBovineFragment
}