package ganko.movil.ganko1.data.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

/**
 * Created by jlbel on 11/10/2017.
 */
@Entity
@Parcelize
@SuppressLint("ParcelCreator")
class Farm(@PrimaryKey(autoGenerate = true) var localId: Int?,
           var id: Int?,
           var nombre: String,
           var ubicacion: String,
           var hectareas: Int,
           var usuario: Int,
           var toSync: Boolean? = false
) : Parcelable {
    @Ignore
    constructor(nombre: String, ubicacion: String, hectareas: Int, usuario: Int) : this(null, null, nombre, ubicacion, hectareas, usuario, true)
}