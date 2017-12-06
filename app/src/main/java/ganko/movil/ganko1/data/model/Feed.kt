package ganko.movil.ganko1.data.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
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
                var id_bovino: Int,
                var proposito: String,
                var fecha: Date,
                var racion: Int,
                var producto: String,
                var valor_kilo: Int,
                var total: Int
                ):Parcelable{
    @Ignore
    constructor(id_bovino: Int, proposito: String, fecha: Date, racion: Int, producto: String,
                valor_kilo: Int, total: Int) : this ( null, null, id_bovino, proposito,
                fecha, racion, producto, valor_kilo, total
    )
}