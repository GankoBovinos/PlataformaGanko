package ganko.movil.ganko1.ui.detail.feed


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ganko.movil.ganko1.R


/**
 * A simple [Fragment] subclass.
 */
class FeedBovineFragment : Fragment() {


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_feed_bovine, container, false)
    }

    companion object {
        fun instance() = FeedBovineFragment()
    }

}// Required empty public constructor
