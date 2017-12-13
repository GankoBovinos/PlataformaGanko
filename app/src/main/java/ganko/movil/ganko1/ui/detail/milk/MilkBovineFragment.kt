package ganko.movil.ganko1.ui.detail.milk


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.FragmentListMilkBinding
import ganko.movil.ganko1.ui.adapters.MilkAdapter
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class MilkBovineFragment : Fragment() {


    @Inject
    lateinit var adapter : MilkAdapter
    lateinit var binding : FragmentListMilkBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_milk_bovine, container, false)
        binding.recyclerMilk.adapter = adapter
        return binding.root
    }

    companion object {
        val EXTRA_ID = "id"
        fun instance(idBovine: Int): MilkBovineFragment{
            val fragment = MilkBovineFragment()
            val args = Bundle()
            args.putInt(EXTRA_ID, idBovine)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
