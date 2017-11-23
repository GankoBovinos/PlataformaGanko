package ganko.movil.ganko1.ui.detail

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import ganko.movil.ganko1.R
import ganko.movil.ganko1.di.ActivityScope
import ganko.movil.ganko1.ui.detail.feed.FeedBovineFragment
import ganko.movil.ganko1.ui.detail.milk.MilkBovineFragment
import ganko.movil.ganko1.utils.addFragment
import org.jetbrains.anko.startActivity
import javax.inject.Inject

/**
 * Created by Ana Marin on 23/11/2017.
 */
@ActivityScope
class DetailNavigation @Inject constructor(){

    fun navigateToDetail(activity: AppCompatActivity){
        activity.startActivity<DetailBovineActivity>(DetailBovineActivity.EXTRA_CONTENT to DetailBovineActivity.CONTENT_DETAIL)
    }

    fun navigateToMilk(fragment: Fragment){
        fragment.addFragment(R.id.container, MilkBovineFragment.instance())
    }

    fun navigateToMilk(activity: AppCompatActivity){
        activity.startActivity<DetailBovineActivity>(DetailBovineActivity.EXTRA_CONTENT to DetailBovineActivity.CONTENT_MILK)
    }

    fun navigateToFeed(fragment: Fragment){
        fragment.addFragment(R.id.container, FeedBovineFragment.instance())
    }

    fun navigateToFeed(activity: AppCompatActivity){
        activity.startActivity<DetailBovineActivity>(DetailBovineActivity.EXTRA_CONTENT to DetailBovineActivity.CONTENT_FEED)
    }
}