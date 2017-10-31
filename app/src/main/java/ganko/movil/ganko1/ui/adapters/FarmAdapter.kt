package ganko.movil.ganko1.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Farm
import ganko.movil.ganko1.databinding.TemplateFarmBinding
import ganko.movil.ganko1.di.ActivityScope
import ganko.movil.ganko1.utils.inflate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


/**
 * Created by jlbel on 11/10/2017.
 */
@ActivityScope
class FarmAdapter @Inject constructor(): RecyclerView.Adapter<FarmAdapter.FarmHolder>() {

    val clickFarm = PublishSubject.create<Farm>()
    val clickDelete = PublishSubject.create<Farm>()
    val clickEdit = PublishSubject.create<Farm>()

    var farms: List<Farm> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FarmHolder
            = FarmHolder(parent.inflate(R.layout.template_farm))

    override fun onBindViewHolder(holder: FarmHolder, position: Int) {
        holder.binding.farm = farms[position]
        holder.binding.clickFarm = clickFarm
        holder.binding.clickDelete = clickDelete
        holder.binding.clickEdit = clickEdit
    }

    override fun getItemCount(): Int = farms.size

    class FarmHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding: TemplateFarmBinding = DataBindingUtil.bind(itemView)

    }


}