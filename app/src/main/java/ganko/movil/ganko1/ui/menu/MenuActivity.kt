package ganko.movil.ganko1.ui.menu

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.content.ContextCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.GridLayoutManager
import android.view.MenuItem
import android.view.View
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ganko.movil.ganko1.R
import ganko.movil.ganko1.ui.adapters.MenuAdapter
import ganko.movil.ganko1.utils.LifeDisposable
import ganko.movil.ganko1.utils.buildViewModel
import kotlinx.android.synthetic.main.activity_menu.*
import javax.inject.Inject

class MenuActivity : AppCompatActivity(), HasSupportFragmentInjector, DrawerLayout.DrawerListener {

    var dis: LifeDisposable = LifeDisposable(this)
    lateinit var toggle: ActionBarDrawerToggle
    var phone: Boolean = true

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
        setContentView(R.layout.a_menu)

        phone = resources.getBoolean(R.bool.phone)

        if (phone) {
            supportActionBar?.setDisplayHomeAsUpEnabled(true)
            toggle = ActionBarDrawerToggle(this, drawer, R.string.open_menu, R.string.close_menu)
            drawer.addDrawerListener(this)
        }

        recycler.adapter = adapter
        adapter.items = menuViewModel.data

        val gridManager: GridLayoutManager = GridLayoutManager(this, 2)
        gridManager.spanSizeLookup = object : GridLayoutManager.SpanSizeLookup(){
            override fun getSpanSize(position: Int): Int = when(menuViewModel.data[position].type){
                MenuViewModel.MenuItem.TYPE_MENU -> 1
                else -> 2
            }
        }
        recycler.layoutManager = gridManager
        clickOnMenu(menuViewModel.content)

    }

    override fun onResume() {
        super.onResume()

        adapter.clickMenu
                .subscribe {
                    if(phone) {
                        drawer.closeDrawers()
                        when (it) {
                            1 -> nav.navigateToFarm()
                            in 2..9 -> clickOnMenu(it)
                            10 -> nav.navigateToLogout()
                        }
                    }else{
                        when (it) {
                            1 -> nav.navigateToFarm()
                            in 2..9 -> clickOnMenu(it)
                            10 -> nav.navigateToLogout()
                        }
                    }
                }
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>
            = injector

    fun clickOnMenu(content: Int){

        menuViewModel.content = content
        val item = menuViewModel.data[content]
        val colorID = menuViewModel.selectedColors[content-2]
        val color = ContextCompat.getColor(this, colorID)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            window.statusBarColor = menuViewModel.getStatusBarColor(color)
        }
        supportActionBar?.setTitle(item.title)
        supportActionBar?.setBackgroundDrawable(ColorDrawable(color))
        adapter.selectItem(content, colorID)

        when(content){
            2-> nav.navigateToBovines()
            3-> nav.navigateToFeeding()
            4-> nav.navigateToManage()
            5-> nav.navigateToMovements()
            6-> nav.navigateToVaccination()
            7-> nav.navigateToHealth()
            8-> nav.navigateToPrairies()
            9-> nav.navigateToReports()
        }

    }

    //region Toggle setup

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
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