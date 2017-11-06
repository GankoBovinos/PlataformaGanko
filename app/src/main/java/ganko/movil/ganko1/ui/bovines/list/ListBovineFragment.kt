package ganko.movil.ganko1.ui.bovines.list


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*

import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.FragmentListBovineBinding
import ganko.movil.ganko1.ui.adapters.BovineAdapter
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class ListBovineFragment : Fragment() {

    @Inject
    lateinit var adapter : BovineAdapter
    lateinit var binding : FragmentListBovineBinding


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_bovine, container, false)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bovine, menu)
    }

    companion object {
        fun instance(): ListBovineFragment = ListBovineFragment()
    }

}// Required empty public constructor
