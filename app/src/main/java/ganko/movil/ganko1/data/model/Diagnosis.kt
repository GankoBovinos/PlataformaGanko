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
class Diagnosis(@PrimaryKey(autoGenerate = true) var localId:Int?,
                var id:Int?,
                @SerializedName("id_bovino")
                var idBovino:Int,
                var fecha:Date,
                @SerializedName("confirmacion_monta")
                var confirmacionMonta:Boolean,
                var novedad:String,
                var toSync:Boolean? = false) : Parcelable {

    @Ignore
    constructor(idBovino: Int, fecha: Date, confirmacionMonta: Boolean, novedad: String):this(null,null, idBovino,fecha, confirmacionMonta,novedad,true)
}