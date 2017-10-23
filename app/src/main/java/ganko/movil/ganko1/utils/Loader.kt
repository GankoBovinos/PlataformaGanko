package ganko.movil.ganko1.utils

import android.databinding.ObservableBoolean
import javax.inject.Inject

/**
 * Created by Ana Marin on 23/10/2017.
 */
class Loader @Inject constructor(){

    var loading: ObservableBoolean = ObservableBoolean(false)
}