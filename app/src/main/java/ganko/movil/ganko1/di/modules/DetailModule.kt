package ganko.movil.ganko1.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ganko.movil.ganko1.di.FragmentScope
import ganko.movil.ganko1.ui.detail.DetailBovineFragment
import ganko.movil.ganko1.ui.detail.feed.FeedBovineFragment
import ganko.movil.ganko1.ui.detail.health.HealthBovineFragment
import ganko.movil.ganko1.ui.detail.manage.ManageBovineFragment
import ganko.movil.ganko1.ui.detail.meat.MeatBovineFragment
import ganko.movil.ganko1.ui.detail.meat.add.AddMeatFragment
import ganko.movil.ganko1.ui.detail.meat.list.ListMeatFragment
import ganko.movil.ganko1.ui.detail.milk.MilkBovineFragment
import ganko.movil.ganko1.ui.detail.milk.add.AddMilkFragment
import ganko.movil.ganko1.ui.detail.movements.MovementsBovineFragment
import ganko.movil.ganko1.ui.detail.vaccination.VaccinationBovineFragment

/**
 * Created by Ana Marin on 1/11/2017.
 */
@Module
abstract class DetailFragment{

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindDetailBovineFragment(): DetailBovineFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindFeedBovineFragment(): FeedBovineFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindHealthBovineFragment(): HealthBovineFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindManageBovineFragment(): ManageBovineFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindMeatBovineFragment(): MeatBovineFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindAddMeatFragment(): AddMeatFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindListMeatFragment(): ListMeatFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindMilkBovineFragment(): MilkBovineFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindAddMilkFragment(): AddMilkFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindMovementsBovineFragment(): MovementsBovineFragment
    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindVaccinationBovineFragment(): VaccinationBovineFragment
}