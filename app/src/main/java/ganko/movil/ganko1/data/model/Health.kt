package ganko.movil.ganko1.data.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by CristianDev on 24/11/2017.
 */
@Entity
@Parcelize
@SuppressLint("ParcelCreator")
class Health (@PrimaryKey(autoGenerate = true) var localId:Int?,
              var id: Int?,
              var id_bovino: String,
              var fecha:Date,
              var evento:String,
              var diagnostico:String,
              var tratamiento:String,
              var producto:String,
              var valorProducto:Int,
              var valorAtencion:Int,
              var dosis:Int,
              var frecuencia:String,
              var observaciones:String,
              var toSync: Boolean? = false
): Parcelable {
    @Ignore
    constructor(id_bovino: String, fecha: Date, evento: String, diagnostico:String,
                tratamiento: String,producto: String,valorProducto: Int,valorAtencion: Int,dosis: Int,frecuencia: String,observaciones: String): this(null,null,
                id_bovino,fecha,evento,diagnostico,tratamiento,producto,valorProducto,valorAtencion,dosis,frecuencia,observaciones,true)
}