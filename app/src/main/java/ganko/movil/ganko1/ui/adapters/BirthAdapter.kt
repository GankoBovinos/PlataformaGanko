package ganko.movil.ganko1.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Birth
import ganko.movil.ganko1.databinding.TemplateBirthBinding
import ganko.movil.ganko1.di.FragmentScope
import ganko.movil.ganko1.utils.inflate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 29/11/2017.
 */
@FragmentScope
class BirthAdapter @Inject constructor(): RecyclerView.Adapter<BirthAdapter.BirthHolder>(){

    var births: List<Birth> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    val clickDelete = PublishSubject.create<Birth>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BirthHolder
    = BirthHolder(parent.inflate(R.layout.template_birth))

    override fun onBindViewHolder(holder: BirthHolder, position: Int) {
        holder.binding.birth = births[position]
        holder.binding.clickDelete = clickDelete
    }

    override fun getItemCount(): Int = births.size


    class BirthHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding: TemplateBirthBinding = DataBindingUtil.bind(itemView)
    }

}