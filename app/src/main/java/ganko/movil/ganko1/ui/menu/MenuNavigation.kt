package ganko.movil.ganko1.ui.menu

import android.app.FragmentTransaction
import android.support.v4.app.Fragment
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.prefs.UserSession
import ganko.movil.ganko1.di.ActivityScope
import ganko.movil.ganko1.ui.bovines.list.ListBovineFragment
import ganko.movil.ganko1.ui.farm.FarmActivity
import ganko.movil.ganko1.ui.login.LoginActivity
import org.jetbrains.anko.startActivity
import javax.inject.Inject

/**
 * Created by Ana Marin on 26/10/2017.
 */
@ActivityScope
class MenuNavigation @Inject constructor(val activity: MenuActivity, val userSession: UserSession){

    fun navigateToFarm(){
        activity.startActivity<FarmActivity>()
        activity.finish()
    }

    fun navigateToBovines(){
        putFragment(R.id.content_frame, ListBovineFragment.instance())
    }

    fun navigateToFeeding(){

    }

    fun navigateToHealth(){

    }

    fun navigateToManage(){

    }

    fun navigateToMovements(){

    }

    fun navigateToPrairies(){

    }

    fun navigateToVaccination(){

    }

    fun navigateToLogout(){
        userSession.logged = false
        userSession.token = ""

        activity.startActivity<LoginActivity>()
        activity.finish()
    }

    fun navigateToReports(){

    }

    fun putFragment (container: Int, fragment : Fragment){
        val ft = activity.supportFragmentManager.beginTransaction()
        ft.replace(container, fragment )
        ft.commit()
    }

}