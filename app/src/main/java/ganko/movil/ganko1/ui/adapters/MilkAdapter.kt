package ganko.movil.ganko1.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Milk
import ganko.movil.ganko1.databinding.ItemMilkBinding
import ganko.movil.ganko1.utils.inflate
import javax.inject.Inject

/**
 * Created by Asus on 30/11/2017.
 */
class MilkAdapter @Inject constructor() : RecyclerView.Adapter<MilkAdapter.MilkHolder>() {

    var milks : List<Milk> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MilkHolder
            = MilkHolder(parent.inflate(R.layout.item_milk))

    override fun onBindViewHolder(holder: MilkHolder, position: Int) {
        holder.binding.milk = milks[position]
    }

    override fun getItemCount(): Int = milks.size


    class MilkHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding : ItemMilkBinding = DataBindingUtil.bind(itemView)
    }
}