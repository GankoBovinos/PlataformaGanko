package ganko.movil.ganko1.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import ganko.movil.ganko1.ui.detail.reproductive.ReproductiveActivity

/**
 * Created by jlbeltran94 on 9/11/2017.
 */
class ReproductiveAdapter(activity: ReproductiveActivity, var fragments: List<Fragment>) : FragmentStatePagerAdapter(activity.supportFragmentManager) {

    override fun getItem(position: Int): Fragment  = fragments[position]

    override fun getCount(): Int = fragments.size


    override fun getPageTitle(position: Int): CharSequence = when(position){
        0 -> "Celo"
        1 -> "Servicio"
        2 -> "Diagnostico"
        else -> "Parto"
    }
}