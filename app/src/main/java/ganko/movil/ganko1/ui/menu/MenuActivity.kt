package ganko.movil.ganko1.ui.menu

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding2.view.clicks
import dagger.android.AndroidInjection

import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.ActivityMenuBinding
import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.ui.adapters.MenuAdapter
import ganko.movil.ganko1.utils.LifeDisposable
import ganko.movil.ganko1.utils.buildViewModel
import kotlinx.android.synthetic.main.activity_menu.*

import javax.inject.Inject

class MenuActivity : AppCompatActivity(), Injectable {

    lateinit var binding: ActivityMenuBinding
    var dis: LifeDisposable = LifeDisposable(this)

    @Inject
    lateinit var nav: MenuNavigation

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    val menuViewModel: MenuViewModel by lazy { buildViewModel(factory, MenuViewModel::class) }

    @Inject
    lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu)
        recycler.adapter = adapter
        adapter.items = menuViewModel.data
    }

    override fun onResume() {
        super.onResume()

        dis add change_farm.clicks()
                .subscribe { nav.navigateToFarm() }

        dis add logout.clicks()
                .subscribe { nav.navigateToLogout() }

    }
}
