package ganko.movil.ganko1.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Manage
import ganko.movil.ganko1.databinding.TemplateManageBovineBinding
import ganko.movil.ganko1.di.FragmentScope
import ganko.movil.ganko1.utils.inflate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 30/11/2017.
 */
@FragmentScope
class ManageBovineAdapter @Inject constructor(): RecyclerView.Adapter<ManageBovineAdapter.ManageHolder>(){

    var events: List<Manage> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
    }
    val clickDelete = PublishSubject.create<Manage>()

    override fun getItemCount(): Int = events.size

    override fun onBindViewHolder(holder: ManageHolder, position: Int) {
        holder.binding.clickDelete = clickDelete
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ManageHolder =
            ManageHolder(parent.inflate(R.layout.template_manage_bovine))


    class ManageHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding: TemplateManageBovineBinding = DataBindingUtil.bind(itemView)
    }

}