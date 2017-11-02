package ganko.movil.ganko1.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.Ignore
import android.arch.persistence.room.PrimaryKey

/**
 * Created by jlbel on 11/10/2017.
 */
@Entity
class Farm(@PrimaryKey(autoGenerate = true) var _id:Long?,
           var id: Long?,
           var nombre:String,
           var ubicacion:String,
           var hectareas:Int,
           var usuario: Int,
           var toSync: Boolean? = false
            ){
    @Ignore
    constructor(nombre: String, ubicacion: String, hectareas: Int, usuario: Int): this(null,null, nombre, ubicacion, hectareas, usuario, true)
}