package ganko.movil.ganko1.ui.adapters

import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Diagnosis
import ganko.movil.ganko1.databinding.TemplateDiagnosisBinding
import ganko.movil.ganko1.di.FragmentScope
import ganko.movil.ganko1.utils.inflate
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 29/11/2017.
 */
@FragmentScope
class DiagnosisAdapter @Inject constructor() : RecyclerView.Adapter<DiagnosisAdapter.DiagnosisHolder>() {

    var diagnosis: List<Diagnosis> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }
    val clickDelete = PublishSubject.create<Diagnosis>()

    override fun onBindViewHolder(holder: DiagnosisHolder, position: Int) {
        holder.binding.diagnosis = diagnosis[position]
        holder.binding.clickDelete = clickDelete

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiagnosisHolder
        = DiagnosisHolder(parent.inflate(R.layout.template_diagnosis))


    override fun getItemCount(): Int = diagnosis.size


    class DiagnosisHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val binding: TemplateDiagnosisBinding = DataBindingUtil.bind(itemView)

    }

}