package ganko.movil.ganko1.data.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
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
                 @SerializedName("id_bovino")
                 var idBovino: Int,
                 @SerializedName("produccion_litro")
                 var produccionLitro: Float,
                 var fecha: Date,
                 var jornada: String
                ) : Parcelable {
    @Ignore
    constructor(idBovino: Int, produccionLitro: Float, fecha: Date, jornada: String) : this (
            null, null, idBovino, produccionLitro, fecha, jornada
    )
}