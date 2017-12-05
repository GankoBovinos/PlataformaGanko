package ganko.movil.ganko1.data.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by Ana Marin on 5/12/2017.
 */
@Entity
@Parcelize
@SuppressLint("ParcelCreator")
class Meat(@PrimaryKey(autoGenerate = true) var localId:Int?,
           var id: Int?,
           @SerializedName("id_bovino")
           var idBovino: Int?,
           var fecha: Date,
           var peso: Int,
           var gdp: Int,
           var version: Int,
           var toSync: Boolean? = false
): Parcelable {
    @Ignore
    constructor(fecha: Date, peso: Int, gdp: Int, version: Int): this(null,null, null, fecha, peso, gdp, version, true)
}