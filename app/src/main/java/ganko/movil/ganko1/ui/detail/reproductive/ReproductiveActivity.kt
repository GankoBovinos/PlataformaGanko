package ganko.movil.ganko1.ui.detail.reproductive

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.ActivityReproductiveBinding
import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.ui.adapters.ReproductiveAdapter
import ganko.movil.ganko1.utils.buildViewModel
import kotlinx.android.synthetic.main.activity_reproductive.*
import javax.inject.Inject

class ReproductiveActivity : AppCompatActivity(), HasSupportFragmentInjector {


    @Inject
    lateinit var injector: DispatchingAndroidInjector<Fragment>
    @Inject
    lateinit var factory: ViewModelProvider.Factory
    @Inject
    lateinit var adapter: ReproductiveAdapter
    lateinit var binding: ActivityReproductiveBinding
    lateinit var adaper: ReproductiveAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_reproductive)
        title = getString(R.string.reproductive)
        pager.adapter = adapter
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back_white)
        tabs.setupWithViewPager(pager)

    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>
            = injector

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}
