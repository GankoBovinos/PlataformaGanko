package ganko.movil.ganko1.ui.detail.meat.list


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.github.mikephil.charting.data.Entry

import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.FragmentMeatBovineBinding
import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.utils.LifeDisposable


/**
 * A simple [Fragment] subclass.
 */
class ListMeatFragment : Fragment(), Injectable {

    var entries: List<Entry> = arrayListOf<Entry>()
    lateinit var binding: FragmentMeatBovineBinding
    val dis : LifeDisposable = LifeDisposable(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_list_meat, container, false)

    }

}// Required empty public constructor
