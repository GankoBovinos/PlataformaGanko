package ganko.movil.ganko1.ui.bovines


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import ganko.movil.ganko1.R
import ganko.movil.ganko1.ui.bovines.list.ListBovineFragment
import ganko.movil.ganko1.ui.detail.DetailBovineActivity
import ganko.movil.ganko1.ui.detail.DetailBovineFragment
import ganko.movil.ganko1.ui.menu.MenuNavigation
import ganko.movil.ganko1.utils.putFragment
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class BovineFragment : Fragment() {

    @Inject
    lateinit var menuNavigation: MenuNavigation

    val phone: Boolean = resources.getBoolean(R.bool.phone)
    val land: Boolean = resources.getBoolean(R.bool.land)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        // Inflate the layout for this fragment
        return inflater!!.inflate(R.layout.f_bovine, container, false)
    }

    override fun onResume() {
        super.onResume()
        val listBovine: ListBovineFragment = childFragmentManager.findFragmentById(R.id.list_bonive) as ListBovineFragment
        listBovine.bovineSelected()
                .subscribe {
                    if (!phone && land) {
                        putFragment(R.id.container, DetailBovineFragment.instance(it))
                    } else {
                        menuNavigation.navigateToDetail(it)
                    }
                }

    }

    companion object {
        fun instance() = BovineFragment()
    }

}// Required empty public constructor
