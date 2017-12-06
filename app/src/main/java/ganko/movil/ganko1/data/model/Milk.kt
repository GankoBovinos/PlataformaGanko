package ganko.movil.ganko1.data.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.sql.Date

/**
 * Created by Asus on 30/11/2017.
 */

@Entity
@Parcelize
@SuppressLint("ParcelCreator")
data class Milk (@PrimaryKey(autoGenerate = true) var localId:Int?,
                 var id : Int?,
                 var id_bovino: Int,
                 var produccion_litro: Float,
                 var fecha: Date,
                 var jornada: String
                ) : Parcelable {
    @Ignore
    constructor(id_bovino: Int, produccion_litro: Float, fecha: Date, jornada: String) : this (
            null, null, id_bovino, produccion_litro, fecha, jornada
    )
}