package ganko.movil.ganko1.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Vaccine
import ganko.movil.ganko1.databinding.TemplateVaccinationBovineBinding
import ganko.movil.ganko1.di.ActivityScope
import ganko.movil.ganko1.utils.inflate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by CristianDev on 24/11/2017.
 */
@ActivityScope
class VaccinationAdapter @Inject constructor(): RecyclerView.Adapter<VaccinationAdapter.VaccineHolder>() {


    val clickDelete = PublishSubject.create<Vaccine>()

    var vaccines: List<Vaccine> = emptyList()
        set(value){
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VaccineHolder
            = VaccineHolder(parent.inflate(R.layout.template_vaccination_bovine))

    override fun onBindViewHolder(holder: VaccineHolder, position: Int) {
        holder.binding.vaccine = vaccines[position]
        holder.binding.clickDelete = clickDelete

    }

    override fun getItemCount(): Int = vaccines.size

    class VaccineHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        val binding: TemplateVaccinationBovineBinding = DataBindingUtil.bind(itemView)

    }


}