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
 * Created by jlbeltran94 on 30/11/2017.
 */
//@Entity(foreignKeys = [(ForeignKey(entity = Bovine::class,
//        parentColumns = ["localId"],
//        childColumns = ["idBovino"],
//        onDelete = ForeignKey.CASCADE))])
@Entity
@Parcelize
@SuppressLint("ParcelCreator")
class Manage (@PrimaryKey(autoGenerate = true) var localId:Int?,
              var id: Int?,
              @SerializedName("idBovino")
              var idBovino: String,
              var fecha: Date,
              var evento:String,
              var tratamiento:String,
              var producto:String,
              @SerializedName("valor")
              var valor: Int,
              var observaciones:String,
              @SerializedName("encargado_manejo")
              var encargadoManejo:String,
              var toSync: Boolean? = false
): Parcelable {
    @Ignore
    constructor(idBovino: String, fecha: Date, evento: String,
                tratamiento: String, producto: String, valor: Int, observaciones: String, encargadoManejo: String):
            this(null,null,
            idBovino,fecha,evento,tratamiento,producto,valor,observaciones,encargadoManejo,true)
}