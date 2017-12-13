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
 * Created by jlbeltran94 on 15/11/2017.
 */
//@Entity(foreignKeys = [(ForeignKey(entity = Bovine::class,
//        parentColumns = ["localId"],
//        childColumns = ["idBovino"],
//        onDelete = ForeignKey.CASCADE))])
@Entity
@Parcelize
@SuppressLint("ParcelCreator")
class Zeal(@PrimaryKey(autoGenerate = true) var localId: Int?,
           var id: Int?,
           @SerializedName("idBovino")
           var idBovino:Int,
           @SerializedName("fecha_proximo_celo")
           var fechaProximoCelo: Date,
           @SerializedName("fecha_celo")
           var fechaCelo: Date,
           var toSync:Boolean? = false) : Parcelable {

    @Ignore
    constructor(idBovino:Int, fechaCelo: Date, fechaProximoCelo: Date): this(null, null, idBovino, fechaProximoCelo, fechaCelo,true)
}