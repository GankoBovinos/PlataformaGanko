package ganko.movil.ganko1.ui.detail.reproductive.zeal


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Zeal
import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.ui.adapters.ZealAdapter
import kotlinx.android.synthetic.main.fragment_zeal.*
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class ZealFragment : Fragment(), Injectable {

    @Inject
    lateinit var adapter: ZealAdapter
    val list: List<Zeal> = listOf(Zeal("20 de Noviembre de 2017"), Zeal("19 de Noviembre de 2017"))

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.fragment_zeal, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        recycler.adapter = adapter
        adapter.zeals = list
    }

    companion object {
        fun instance(): ZealFragment = ZealFragment()
    }

}// Required empty public constructor
