package ganko.movil.ganko1.data.prefs

import android.content.SharedPreferences
import ganko.movil.ganko1.utils.save
import javax.inject.Inject
import javax.inject.Singleton

/**
 * Created by Cristian on 23/10/2017.
 */

@Singleton
class UserSession @Inject constructor(val prefs:SharedPreferences){

    var token:String
        get() = prefs.getString(KEY_TOKEN,"")
        set(value) = prefs.save(KEY_TOKEN to value)

    var logged: Boolean
        get() = prefs.getBoolean(KEY_LOGGED, false)
        set(value) = prefs.save(KEY_LOGGED to value)

    var userId: Int
        get() = prefs.getInt(KEY_LOGGED, 0)
        set(value) = prefs.save(KEY_USERID to value)


    companion object {
        private val KEY_TOKEN = "token"
        private val KEY_LOGGED = "logged"
        private val KEY_USERID = "userId"
    }

}