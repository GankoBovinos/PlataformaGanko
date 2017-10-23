package ganko.movil.ganko1.data.model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

/**
 * Created by jlbel on 11/10/2017.
 */
@Entity
data class Finca(@PrimaryKey var id:Long,
                 var nombre:String,
                 var ubicacion:String,
                 var hectareas:Long
            )