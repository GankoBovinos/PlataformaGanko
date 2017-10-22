package ganko.movil.ganko1.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.models.Finca
import ganko.movil.ganko1.databinding.TemplateFincaBinding
import ganko.movil.ganko1.di.ActivityScope
import ganko.movil.ganko1.utils.inflate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


/**
 * Created by jlbel on 11/10/2017.
 */
@ActivityScope
class FincaAdapter @Inject constructor(): RecyclerView.Adapter<FincaAdapter.FincaHolder>() {

    val clickFinca = PublishSubject.create<Finca>()
    val clickDelete = PublishSubject.create<Finca>()
    val clickEdit = PublishSubject.create<Finca>()

    var fincas: List<Finca> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FincaHolder
            = FincaHolder(parent.inflate(R.layout.template_finca))

    override fun onBindViewHolder(holder: FincaHolder, position: Int) {
        holder.binding.finca = fincas[position]
        holder.binding.clickFinca = clickFinca
        holder.binding.clickDelete = clickDelete
        holder.binding.clickEdit = clickEdit
    }

    override fun getItemCount(): Int = fincas.size

    class FincaHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding: TemplateFincaBinding = DataBindingUtil.bind(itemView)

    }


}