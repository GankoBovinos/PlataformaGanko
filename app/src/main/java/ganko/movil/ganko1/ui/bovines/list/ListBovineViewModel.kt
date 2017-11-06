package ganko.movil.ganko1.ui.bovines.list

import android.arch.lifecycle.ViewModel
import ganko.movil.ganko1.data.dao.BovineDao
import ganko.movil.ganko1.data.model.Bovine
import ganko.movil.ganko1.data.prefs.UserSession
import ganko.movil.ganko1.utils.applySchedulers
import io.reactivex.Flowable
import io.reactivex.Observable
import java.util.*
import javax.inject.Inject

/**
 * Created by Ana Marin on 31/10/2017.
 */

class ListBovineViewModel @Inject constructor(val bovineDao: BovineDao, val userSession: UserSession): ViewModel(){

    fun getAllLocal(): Flowable<List<Bovine>> = bovineDao.getAll(userSession.farmID.toInt()).applySchedulers()

}

