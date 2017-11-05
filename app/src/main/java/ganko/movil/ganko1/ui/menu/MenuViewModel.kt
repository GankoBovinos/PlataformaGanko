package ganko.movil.ganko1.ui.menu

import android.arch.lifecycle.ViewModel
import android.graphics.Color
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.prefs.UserSession
import javax.inject.Inject

/**
 * Created by Ana Marin on 24/10/2017.
 */
class MenuViewModel @Inject constructor(session:UserSession): ViewModel(){

    var content: Int = 2

    val data: List<MenuItem> = listOf(
            MenuItem(MenuItem.TYPE_TITLE, titleText = session.farm ),
            MenuItem(MenuItem.TYPE_BUTTON, icon = R.drawable.ic_back_white, title = R.string.change_farm ),
            MenuItem(MenuItem.TYPE_MENU, R.color.img, R.drawable.ic_back_white, R.string.bovines),
            MenuItem(MenuItem.TYPE_MENU, R.color.img, R.drawable.ic_back_white, R.string.feeding),
            MenuItem(MenuItem.TYPE_MENU, R.color.img, R.drawable.ic_back_white, R.string.manage),
            MenuItem(MenuItem.TYPE_MENU, R.color.img, R.drawable.ic_back_white, R.string.movements),
            MenuItem(MenuItem.TYPE_MENU, R.color.img, R.drawable.ic_back_white, R.string.vaccination),
            MenuItem(MenuItem.TYPE_MENU, R.color.img, R.drawable.ic_back_white, R.string.health),
            MenuItem(MenuItem.TYPE_MENU, R.color.img, R.drawable.ic_back_white, R.string.prairies),
            MenuItem(MenuItem.TYPE_MENU, R.color.img, R.drawable.ic_back_white, R.string.reports),
            MenuItem(MenuItem.TYPE_BUTTON, icon = R.drawable.ic_logout, title = R.string.logout)

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

    fun getStatusBarColor(color: Int): Int{
        var red = Color.red(color) - 45
        var green = Color.green(color) - 45
        var blue = Color.blue(color) - 45

        red = if (red >= 0) red else 0
        blue = if (blue >= 0) blue else 0
        green = if (green >= 0) green else 0

        return Color.rgb(red, green, blue)
    }

    class MenuItem( val type: Int, var color: Int = 0, val icon: Int = 0, val title: Int = 0,
                    val titleText: String? = null){

        companion object {
            val TYPE_TITLE: Int = 0
            val TYPE_BUTTON: Int = 1
            val TYPE_MENU: Int = 2
        }
    }
}

