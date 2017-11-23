package ganko.movil.ganko1.data.model


import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by Asus on 1/11/2017.
 */

@Entity
@Parcelize
@SuppressLint("ParcelCreator")
data class Bovine(@PrimaryKey(autoGenerate = true) var localId:Int?,
                  var id : Int?,
                  var id_bovino: String,
                  var imagen: String?,
                  var name: String?,
                  var fecha: Date,
                  var genero: String,
                  var proposito: String,
                  var peso: Int,
                  var color: String?,
                  var raza: String?,
                  var id_madre: String?,
                  var id_padre: String?,
                  var salida: String?,
                  var lote: String?,
                  var salida_por: String?,
                  var numero_partos: Int?,
                  var parto_fallo: String?,
                  var fecha_salida: Date?,
                  var finca: Int,
                  var usuario: Int,
                  var fecha_compra: Date?,
                  var precio_compra : Int?,
                  var precio_venta : Int?,
                  var toSync : Boolean? = false
): Parcelable {

    @Ignore
    constructor(id_bovino: String, imagen: String?, name: String?, fecha: Date, genero: String, proposito: String,
                peso: Int, color: String?, raza: String?, id_madre: String?, id_padre: String?, salida: String?,
                lote: String?, salida_por: String?, numero_partos: Int?, parto_fallo: String?, fecha_salida: Date?,
                finca: Int, usuario: Int, fecha_compra: Date?, precio_compra: Int?, precio_venta: Int?): this (
            null, null, id_bovino, imagen, name, fecha, genero, proposito, peso, color, raza, id_madre, id_padre, salida, lote,
            salida_por, numero_partos, parto_fallo, fecha_salida, finca, usuario, fecha_compra, precio_compra, precio_venta, true )
}

