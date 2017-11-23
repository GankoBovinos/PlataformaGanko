package ganko.movil.ganko1.ui.detail

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ganko.movil.ganko1.R
import javax.inject.Inject

class DetailBovineActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_bovine)
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
    }
}
