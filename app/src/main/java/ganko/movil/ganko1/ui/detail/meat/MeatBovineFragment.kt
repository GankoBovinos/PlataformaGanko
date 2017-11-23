package ganko.movil.ganko1.ui.detail.meat


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ganko.movil.ganko1.R
import ganko.movil.ganko1.ui.detail.DetailBovineFragment
import ganko.movil.ganko1.ui.detail.DetailBovineFragment.Companion.ID_BOVINE


/**
 * A simple [Fragment] subclass.
 */
class MeatBovineFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_meat_bovine, container, false)
    }

    companion object {
        var id = DetailBovineFragment.ID_BOVINE
        fun instance(id_bovine: Int): MeatBovineFragment{
            val fragment = MeatBovineFragment()
            val args = Bundle()
            args.putInt(ID_BOVINE, id_bovine)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
