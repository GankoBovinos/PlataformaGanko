package ganko.movil.ganko1.ui.bovines.list


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*

import ganko.movil.ganko1.R


/**
 * A simple [Fragment] subclass.
 */
class ListBovineFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_list_bovine, container, false)
    }

    override fun onCreateOptionsMenu(menu: Menu?, inflater: MenuInflater?) {
        super.onCreateOptionsMenu(menu, inflater)
    }

}// Required empty public constructor
