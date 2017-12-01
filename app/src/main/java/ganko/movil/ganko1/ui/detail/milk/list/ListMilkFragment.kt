package ganko.movil.ganko1.ui.detail.milk.list


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Milk
import ganko.movil.ganko1.databinding.FragmentListMilkBinding
import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.ui.adapters.MilkAdapter
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class ListMilkFragment : Fragment(), Injectable {

    @Inject
    lateinit var adapter : MilkAdapter
    lateinit var binding : FragmentListMilkBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_milk, container, false)
        binding.recyclerMilk.adapter = adapter
        return binding.root
    }

    companion object {
        fun instance(milk:Milk) : ListMilkFragment = ListMilkFragment()
    }

}// Required empty public constructor
