package ganko.movil.ganko1.ui.menu

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.os.PersistableBundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.view.MenuItem
import android.view.View
import com.jakewharton.rxbinding2.view.clicks
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.prefs.UserSession
import ganko.movil.ganko1.databinding.ActivityMenuBinding
import ganko.movil.ganko1.ui.adapters.MenuAdapter
import ganko.movil.ganko1.utils.LifeDisposable
import ganko.movil.ganko1.utils.buildViewModel
import kotlinx.android.synthetic.main.activity_menu.*
import javax.inject.Inject

class MenuActivity : AppCompatActivity(), HasSupportFragmentInjector, DrawerLayout.DrawerListener {

    lateinit var binding: ActivityMenuBinding
    var dis: LifeDisposable = LifeDisposable(this)
    lateinit var toggle: ActionBarDrawerToggle
    var content: Int = 0


    @Inject
    lateinit var nav: MenuNavigation

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Fragment>

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    val menuViewModel: MenuViewModel by lazy { buildViewModel(factory, MenuViewModel::class) }

    @Inject
    lateinit var adapter: MenuAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_menu)

        toggle = ActionBarDrawerToggle(this, drawer, R.string.open_menu, R.string.close_menu)
        drawer.addDrawerListener(this)
        recycler.adapter = adapter
        adapter.items = menuViewModel.data
    }

    override fun onResume() {
        super.onResume()

        dis add changeFarm.clicks()
                .subscribe { nav.navigateToFarm() }

        dis add logout.clicks()
                .subscribe { nav.navigateToLogout() }

        adapter.clickMenu
                .subscribe {
                    clickOnMenu(it)
                }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>
            = injector

    fun clickOnMenu(content: Int){

        val item = menuViewModel.data[content]
        val color = menuViewModel.selectedColors[content]
        supportActionBar?.setTitle(item.title)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(ContextCompat.getColor(this, color)))
        adapter.selectItem(content, color)

        when(content){
            0-> nav.navigateToBovines()
            1-> nav.navigateToFeeding()
            2-> nav.navigateToManage()
            3-> nav.navigateToMovements()
            4-> nav.navigateToVaccination()
            5-> nav.navigateToHealth()
            6-> nav.navigateToPrairies()
            7-> nav.navigateToReports()
        }

    }

    //region Toggle setup

    override fun onPostCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onPostCreate(savedInstanceState, persistentState)
        toggle.syncState()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        if(toggle.onOptionsItemSelected(item))
            return true

        return super.onOptionsItemSelected(item)
    }

    override fun onDrawerStateChanged(newState: Int) {
        toggle.onDrawerStateChanged(newState)
    }

    override fun onDrawerSlide(drawerView: View?, slideOffset: Float) {
        toggle.onDrawerSlide(drawerView, slideOffset)
    }

    override fun onDrawerClosed(drawerView: View?) {
        toggle.onDrawerClosed(drawerView)
    }

    override fun onDrawerOpened(drawerView: View?) {
        toggle.onDrawerOpened(drawerView)
    }
    //endregion
}
