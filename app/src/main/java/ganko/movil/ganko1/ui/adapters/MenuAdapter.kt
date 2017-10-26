package ganko.movil.ganko1.ui.adapters

import android.databinding.DataBindingUtil
import android.support.constraint.R.id.parent
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Finca
import ganko.movil.ganko1.databinding.TemplateMenuBinding
import ganko.movil.ganko1.di.ActivityScope
import ganko.movil.ganko1.utils.inflate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by Ana Marin on 26/10/2017.
 */
@ActivityScope
class MenuAdapter @Inject constructor(): RecyclerView.Adapter<MenuAdapter.MenuHolder>(){

    val clickMenu = PublishSubject.create<MenuItem>()


    var items: List<MenuItem> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onBindViewHolder(holder: MenuHolder, position: Int){
        holder.binding.item = items[position]
        holder.binding.clickMenuItem = clickMenu
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MenuHolder
        = MenuHolder(parent.inflate(R.layout.template_menu))


    override fun getItemCount(): Int = items.size

    class MenuHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding: TemplateMenuBinding = DataBindingUtil.bind(itemView)

    }
}

data class MenuItem(val color: Int, val icon: Int, val title: Int)