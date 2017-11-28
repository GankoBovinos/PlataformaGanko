package ganko.movil.ganko1.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Service
import ganko.movil.ganko1.databinding.TemplateServiceBinding
import ganko.movil.ganko1.di.FragmentScope
import ganko.movil.ganko1.utils.inflate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 21/11/2017.
 */
@FragmentScope
class ServiceAdapter @Inject constructor(): RecyclerView.Adapter<ServiceAdapter.ServiceHolder>() {

    val clickDelete = PublishSubject.create<Service>()

    var services: List<Service> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun getItemCount(): Int = services.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ServiceHolder
    = ServiceHolder(parent.inflate(R.layout.template_service))

    override fun onBindViewHolder(holder: ServiceHolder, position: Int) {
        holder.binding.service = services[position]
        holder.binding.clickDelete = clickDelete
    }

    class ServiceHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: TemplateServiceBinding = DataBindingUtil.bind(itemView)

    }
}