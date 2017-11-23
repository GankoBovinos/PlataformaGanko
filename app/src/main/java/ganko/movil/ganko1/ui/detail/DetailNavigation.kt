package ganko.movil.ganko1.ui.detail

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Bovine
import ganko.movil.ganko1.di.ActivityScope
import ganko.movil.ganko1.ui.detail.feed.FeedBovineFragment
import ganko.movil.ganko1.ui.detail.health.HealthBovineFragment
import ganko.movil.ganko1.ui.detail.manage.ManageBovineFragment
import ganko.movil.ganko1.ui.detail.meat.MeatBovineFragment
import ganko.movil.ganko1.ui.detail.milk.MilkBovineFragment
import ganko.movil.ganko1.ui.detail.movements.MovementsBovineFragment
import ganko.movil.ganko1.ui.detail.vaccination.VaccinationBovineFragment
import ganko.movil.ganko1.utils.addFragment
import org.jetbrains.anko.startActivity
import javax.inject.Inject

/**
 * Created by Ana Marin on 23/11/2017.
 */
@ActivityScope
class DetailNavigation @Inject constructor(){

    fun navigateToDetail(activity: AppCompatActivity, bovine: Bovine){
        activity.startActivity<DetailBovineActivity>(DetailBovineActivity.EXTRA_CONTENT to DetailBovineActivity.CONTENT_DETAIL)
    }

    fun navigateToMilk(fragment: Fragment, id: Long, addStack: Boolean = true){
        fragment.addFragment(R.id.container, MilkBovineFragment.instance(), addStack)
    }

    fun navigateToMilk(activity: AppCompatActivity, bovine: Bovine){
        activity.startActivity<DetailBovineActivity>(DetailBovineActivity.EXTRA_CONTENT to DetailBovineActivity.CONTENT_MILK)
    }

    fun navigateToFeed(fragment: Fragment, id: Long, addStack: Boolean = true){
        fragment.addFragment(R.id.container, FeedBovineFragment.instance(), addStack)
    }

    fun navigateToFeed(activity: AppCompatActivity, bovine: Bovine){
        activity.startActivity<DetailBovineActivity>(DetailBovineActivity.EXTRA_CONTENT to DetailBovineActivity.CONTENT_FEED)
    }

    fun navigateToHealth(fragment: Fragment, id: Long, addStack: Boolean = true){
        fragment.addFragment(R.id.container, HealthBovineFragment.instance(), addStack)
    }

    fun navigateToHealth(activity: AppCompatActivity, bovine: Bovine){
        activity.startActivity<DetailBovineActivity>(DetailBovineActivity.EXTRA_CONTENT to DetailBovineActivity.CONTENT_HEALTH)
    }

    fun navigateToManage(fragment: Fragment, id: Long, addStack: Boolean = true){
        fragment.addFragment(R.id.container, ManageBovineFragment.instance(), addStack)
    }

    fun navigateToManage(activity: AppCompatActivity, bovine: Bovine){
        activity.startActivity<DetailBovineActivity>(DetailBovineActivity.EXTRA_CONTENT to DetailBovineActivity.CONTENT_MANAGE)
    }

    fun navigateToMeat(fragment: Fragment, id: Long,  addStack: Boolean = true){
        fragment.addFragment(R.id.container, MeatBovineFragment.instance(), addStack)
    }

    fun navigateToMeat(activity: AppCompatActivity, bovine: Bovine){
        activity.startActivity<DetailBovineActivity>(DetailBovineActivity.EXTRA_CONTENT to DetailBovineActivity.CONTENT_MEAT)
    }

    fun navigateToMovements(fragment: Fragment, id: Long, addStack: Boolean = true){
        fragment.addFragment(R.id.container, MovementsBovineFragment.instance(), addStack)
    }

    fun navigateToMovements(activity: AppCompatActivity, bovine: Bovine){
        activity.startActivity<DetailBovineActivity>(DetailBovineActivity.EXTRA_CONTENT to DetailBovineActivity.CONTENT_MOVEMENTS)
    }

    fun navigateToVaccination(fragment: Fragment, id: Long, addStack: Boolean = true){
        fragment.addFragment(R.id.container, VaccinationBovineFragment.instance(), addStack)
    }

    fun navigateToVaccination(activity: AppCompatActivity, bovine: Bovine){
        activity.startActivity<DetailBovineActivity>(DetailBovineActivity.EXTRA_CONTENT to DetailBovineActivity.CONTENT_VACCINATION)
    }
}