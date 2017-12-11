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
 * Created by Asus on 1/11/2017.
 */

@Entity
@Parcelize
@SuppressLint("ParcelCreator")
data class Bovine(@PrimaryKey(autoGenerate = true) var localId:Int?,
                  var id : Int?,
                  @SerializedName("id_bovino")
                  var idBovino: String,
                  var imagen: String?,
                  var nombre: String?,
                  @SerializedName("fecha_nacimiento")
                  var fechaNacimiento: Date,
                  @SerializedName("fecha_nacimiento")
                  var fechaIngreso: Date?,
                  var genero: String,
                  var proposito: String,
                  var peso: Int,
                  var color: String?,
                  var raza: String?,
                  @SerializedName("id_madre")
                  var idMadre: String?,
                  @SerializedName("id_padre")
                  var idPadre: String?,
                  var pradera: String?,
                  @SerializedName("salida_por")
                  var salidaPor: String?,
                  @SerializedName("numero_partos")
                  var numeroPartos: Int?,
                  @SerializedName("parto_fallo")
                  var partoFallo: String?,
                  @SerializedName("fecha_salida")
                  var fechaSalida: Date?,
                  @SerializedName("precio_compra")
                  var precioCompra: Int?,
                  @SerializedName("precio_venta")
                  var precioVenta : Int?,
                  var finca: Int,
                  var usuario: Int,
                  var toSync : Boolean? = false
): Parcelable {

    @Ignore
    constructor(idBovino: String, imagen: String?, nombre: String?, fechaNacimiento: Date, fechaIngreso: Date?,
                genero: String, proposito: String, peso: Int, color: String?, raza: String?, idMadre: String?,
                idPadre: String?, pradera: String?, salidaPor: String?, numeroPartos: Int?, partoFallo: String?,
                fechaSalida: Date?, precioCompra: Int?, precioVenta: Int?, finca: Int, usuario: Int): this (
            null, null, idBovino, imagen, nombre, fechaNacimiento, fechaIngreso, genero, proposito,
            peso, color, raza, idMadre, idPadre, pradera, salidaPor, numeroPartos, partoFallo, fechaSalida,
            precioCompra, precioVenta, finca, usuario, true )
}

