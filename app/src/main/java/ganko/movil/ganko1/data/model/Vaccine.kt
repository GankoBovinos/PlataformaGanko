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
class Vaccine(@PrimaryKey(autoGenerate = true) var localId:Int?,
           var id: Int?,
           var id_bovino:String,
           var fecha_vacunacion:Date,
           var nombre_vacuna:String,
           var dosis_vacuna:Int,
           var via_vacuna:String,
           var valor:Int,
           var toSync: Boolean? = false
): Parcelable {
    @Ignore
    constructor(id_bovino: String, fecha_vacunacion: Date, nombre_vacuna: String, dosis_vacuna: Int,
                via_vacuna: String,valor: Int): this(null,null,id_bovino,fecha_vacunacion,nombre_vacuna,dosis_vacuna,
                via_vacuna,valor,true)
}