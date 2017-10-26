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
        MenuItem(R.color.bovines, R.drawable.ic_back_white, R.string.bovines),
            MenuItem(R.color.feeding, R.drawable.ic_back_white, R.string.feeding),
            MenuItem(R.color.manage, R.drawable.ic_back_white, R.string.manage),
            MenuItem(R.color.movements, R.drawable.ic_back_white, R.string.movements),
            MenuItem(R.color.vaccination, R.drawable.ic_back_white, R.string.vaccination),
            MenuItem(R.color.health, R.drawable.ic_back_white, R.string.health),
            MenuItem(R.color.prairies, R.drawable.ic_back_white, R.string.prairies),
            MenuItem(R.color.reports, R.drawable.ic_back_white, R.string.reports)
    )
}