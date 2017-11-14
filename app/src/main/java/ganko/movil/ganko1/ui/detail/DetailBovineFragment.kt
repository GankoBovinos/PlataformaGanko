package ganko.movil.ganko1.ui.detail


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.FragmentDetailBovineBinding


/**
 * A simple [Fragment] subclass.
 */
class DetailBovineFragment : Fragment() {

    lateinit var binding : FragmentDetailBovineBinding

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_bovine, container, false )
        return binding.root
    }

    companion object {
        fun instance(): DetailBovineFragment = DetailBovineFragment()
    }

}// Required empty public constructor
