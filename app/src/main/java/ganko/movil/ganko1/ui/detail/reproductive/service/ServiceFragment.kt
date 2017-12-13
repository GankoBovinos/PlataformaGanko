package ganko.movil.ganko1.ui.detail.reproductive.service


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Service
import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.ui.adapters.ServiceAdapter
import kotlinx.android.synthetic.main.fragment_service.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class ServiceFragment : Fragment(), Injectable {


    @Inject
    lateinit var adapter: ServiceAdapter
    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_service, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler.adapter = adapter

    }


    companion object {
        fun instance():ServiceFragment = ServiceFragment()
    }

}// Required empty public constructor
