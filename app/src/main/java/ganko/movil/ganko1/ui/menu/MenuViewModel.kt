package ganko.movil.ganko1.ui.menu

import android.arch.lifecycle.ViewModel
import ganko.movil.ganko1.R
import ganko.movil.ganko1.ui.adapters.MenuItem
import javax.inject.Inject

/**
 * Created by Ana Marin on 24/10/2017.
 */
class MenuViewModel @Inject constructor(): ViewModel(){

    val data: List<MenuItem> = listOf(
            MenuItem(R.color.img, R.drawable.ic_back_white, R.string.bovines),
            MenuItem(R.color.img, R.drawable.ic_back_white, R.string.feeding),
            MenuItem(R.color.img, R.drawable.ic_back_white, R.string.manage),
            MenuItem(R.color.img, R.drawable.ic_back_white, R.string.movements),
            MenuItem(R.color.img, R.drawable.ic_back_white, R.string.vaccination),
            MenuItem(R.color.img, R.drawable.ic_back_white, R.string.health),
            MenuItem(R.color.img, R.drawable.ic_back_white, R.string.prairies),
            MenuItem(R.color.img, R.drawable.ic_back_white, R.string.reports)
    )

    val selectedColors: List<Int> = listOf(
            R.color.bovines,
            R.color.feeding,
            R.color.manage,
            R.color.movements,
            R.color.vaccination,
            R.color.health,
            R.color.prairies,
            R.color.reports
    )
}