package ganko.movil.ganko1.ui.menu

import ganko.movil.ganko1.di.ActivityScope
import ganko.movil.ganko1.ui.farm.FarmActivity
import ganko.movil.ganko1.ui.login.LoginActivity
import org.jetbrains.anko.startActivity
import javax.inject.Inject

/**
 * Created by Ana Marin on 26/10/2017.
 */
@ActivityScope
class MenuNavigation @Inject constructor(val activity: MenuActivity){

    fun navigateToFarm(){
        activity.startActivity<FarmActivity>()
        activity.finish()
    }

    fun navigateToBovines(){

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
        activity.startActivity<LoginActivity>()
        activity.finish()
    }

    fun navigateToReports(){

    }
}