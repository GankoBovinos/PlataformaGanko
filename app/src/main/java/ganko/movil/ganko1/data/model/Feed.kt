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
 * Created by Asus on 6/12/2017.
 */

@Entity
@Parcelize
@SuppressLint("ParcelCreator")
data class Feed(@PrimaryKey(autoGenerate = true) var localId:Int?,
                var id: Int?,
                @SerializedName("id_bovino")
                var idBovino: Int,
                var proposito: String,
                var fecha: Date,
                var racion: Int,
                var producto: String,
                @SerializedName("valor_kilo")
                var valorKilo: Int,
                var total: Int
                ):Parcelable{
    @Ignore
    constructor(idBovino: Int, proposito: String, fecha: Date, racion: Int, producto: String,
                valorKilo: Int, total: Int) : this ( null, null, idBovino, proposito,
                fecha, racion, producto, valorKilo, total
    )
}