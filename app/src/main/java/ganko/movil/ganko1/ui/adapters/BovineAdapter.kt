package ganko.movil.ganko1.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Bovine
import ganko.movil.ganko1.databinding.ItemBovineBinding
import ganko.movil.ganko1.di.FragmentScope
import ganko.movil.ganko1.utils.inflate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by Asus on 2/11/2017.
 */

@FragmentScope
class BovineAdapter @Inject constructor() : RecyclerView.Adapter<BovineAdapter.BovineHolder>() {

    val clickBovine = PublishSubject.create<Bovine>()

    var bovines: List<Bovine> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BovineHolder
            = BovineHolder(parent.inflate(R.layout.item_bovine))

    override fun onBindViewHolder(holder: BovineHolder, position: Int) {
        holder.binding.bovine = bovines[position]
        holder.binding.clickBovine = clickBovine
    }

    override fun getItemCount(): Int = bovines.size


    class BovineHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding: ItemBovineBinding = DataBindingUtil.bind(itemView)
    }
}
