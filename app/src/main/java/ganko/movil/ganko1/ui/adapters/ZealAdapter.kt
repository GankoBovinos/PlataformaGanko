package ganko.movil.ganko1.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Zeal
import ganko.movil.ganko1.databinding.TemplateZealBinding
import ganko.movil.ganko1.di.FragmentScope
import ganko.movil.ganko1.utils.inflate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 15/11/2017.
 */
@FragmentScope
class ZealAdapter @Inject constructor(): RecyclerView.Adapter<ZealAdapter.ZealHolder>() {

    val clickDelete = PublishSubject.create<Zeal>()

    var zeals: List<Zeal> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: ZealHolder, position: Int) {
        holder.binding.zeal = zeals[position]
        holder.binding.clickDelete = clickDelete
    }

    override fun getItemCount(): Int = zeals.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ZealHolder
        = ZealHolder(parent.inflate(R.layout.template_zeal))

    class ZealHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: TemplateZealBinding = DataBindingUtil.bind(itemView)
    }
}
