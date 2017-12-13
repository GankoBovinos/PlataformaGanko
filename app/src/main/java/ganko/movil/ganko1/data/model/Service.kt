package ganko.movil.ganko1.data.model

import android.annotation.SuppressLint
import android.arch.persistence.room.Entity
import android.arch.persistence.room.ForeignKey
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey
import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize
import java.util.*

/**
 * Created by jlbeltran94 on 21/11/2017.
 */
@Entity(foreignKeys = [(ForeignKey(entity = Bovine::class,
                parentColumns = ["localId"],
                childColumns = ["idBovino"],
                onDelete = ForeignKey.CASCADE))])
@SuppressLint("ParcelCreator")
@Parcelize
data class Service(
        @PrimaryKey(autoGenerate = true) var localId:Int?,
        var id:Int?,
        @SerializedName("idBovino")
        var idBovino:Int,
        var fecha: Date,
        @SerializedName("condicion_corporal")
        var condicionCorporal: String,
        @SerializedName("fecha_palpacion")
        var fechaPalpacion: Date,
        var empadre: String,
        @SerializedName("id_pajilla")
        var idPajilla: String?,
        var numAnimal: String?,
        var razaAnimal:String?,
        var procedencia: String?,
        var fechaPosParto: Date,
        var toSync: Boolean? = false
                   ) : Parcelable{

    @Ignore
    constructor(idBovino: Int, fecha: Date, condicionCorporal: String, fechaPalpacion: Date,empadre: String,
                idPajilla: String?,numAnimal: String?,razaAnimal: String?,procedencia: String?,fechaPosParto: Date):this(null, null,idBovino,fecha,condicionCorporal,fechaPalpacion,
            empadre,idPajilla,numAnimal,razaAnimal,procedencia,fechaPosParto,true)

}