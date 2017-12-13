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
 * Created by jlbeltran94 on 29/11/2017.
 */

//@Entity(foreignKeys = [(ForeignKey(entity = Bovine::class,
//        parentColumns = ["localId"],
//        childColumns = ["idBovino"],
//        onDelete = ForeignKey.CASCADE))])
@Entity
@Parcelize
@SuppressLint("ParcelCreator")
class Birth(@PrimaryKey(autoGenerate = true) var localId: Int?,
            var id: Int?,
            @SerializedName("idBovino")
            var idBovino: Int,
            var fecha: Date,
            @SerializedName("dias_vacios")
            var diasVacios: Int,
            @SerializedName("intervalo_partos")
            var intervaloPartos: Int,
            @SerializedName("estado_cria")
            var estadoCria: String,
            @SerializedName("sexo_cria")
            var sexoCria: String,
            var toSync: Boolean?) : Parcelable {

    @Ignore
    constructor(idBovino: Int, fecha: Date, diasVacios: Int, intervaloPartos: Int, estadoCria: String, sexoCria: String) : this(null, null, idBovino, fecha, diasVacios, intervaloPartos, estadoCria, sexoCria, true)
}