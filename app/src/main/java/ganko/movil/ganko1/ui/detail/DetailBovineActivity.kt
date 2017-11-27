package ganko.movil.ganko1.ui.detail

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Bovine
import ganko.movil.ganko1.ui.detail.feed.FeedBovineFragment
import ganko.movil.ganko1.ui.detail.health.HealthBovineFragment
import ganko.movil.ganko1.ui.detail.manage.ManageBovineFragment
import ganko.movil.ganko1.ui.detail.meat.MeatBovineFragment
import ganko.movil.ganko1.ui.detail.milk.MilkBovineFragment
import ganko.movil.ganko1.ui.detail.movements.MovementsBovineFragment
import ganko.movil.ganko1.ui.detail.vaccination.VaccinationBovineFragment
import ganko.movil.ganko1.utils.putFragment
import javax.inject.Inject

class DetailBovineActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var nav: DetailNavigation
    val bovine: Bovine by lazy { intent.extras.getParcelable<Bovine>(EXTRA_BOVINE) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_bovine)

        val content = intent.extras.getInt(EXTRA_CONTENT)
        when (content){
            CONTENT_DETAIL -> putFragment(R.id.container, DetailBovineFragment.instance(bovine))
            CONTENT_FEED -> putFragment(R.id.container, FeedBovineFragment.instance(bovine.localId!!))
            CONTENT_HEALTH -> putFragment(R.id.container, HealthBovineFragment.instance(bovine.localId!!))
            CONTENT_MANAGE -> putFragment(R.id.container, ManageBovineFragment.instance(bovine.localId!!))
            CONTENT_MEAT -> putFragment(R.id.container, MeatBovineFragment.instance(bovine.localId!!))
            CONTENT_MILK -> putFragment(R.id.container, MilkBovineFragment.instance(bovine.localId!!))
            CONTENT_MOVEMENTS -> putFragment(R.id.container, MovementsBovineFragment.instance(bovine.localId!!))
            CONTENT_VACCINATION -> putFragment(R.id.container, VaccinationBovineFragment.instance(bovine.localId!!))
        }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>
        = injector

    companion object {
        val CONTENT_DETAIL = 0
        val CONTENT_MILK = 1
        val CONTENT_MEAT = 2
        val CONTENT_MANAGE = 3
        val CONTENT_FEED = 4
        val CONTENT_VACCINATION = 5
        val CONTENT_MOVEMENTS = 6
        val CONTENT_HEALTH = 7

        val EXTRA_CONTENT = "content"
        val EXTRA_BOVINE = "bovine"
    }
}
