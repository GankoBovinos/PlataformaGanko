package ganko.movil.ganko1.ui.adapters

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import ganko.movil.ganko1.R
import ganko.movil.ganko1.di.ActivityScope
import ganko.movil.ganko1.ui.detail.reproductive.ReproductiveActivity
import ganko.movil.ganko1.ui.detail.reproductive.birth.BirthFragment
import ganko.movil.ganko1.ui.detail.reproductive.diagnosis.DiagnosisFragment
import ganko.movil.ganko1.ui.detail.reproductive.service.ServiceFragment
import ganko.movil.ganko1.ui.detail.reproductive.zeal.ZealFragment
import javax.inject.Inject

/**
 * Created by jlbeltran94 on 9/11/2017.
 */
@ActivityScope
class ReproductiveAdapter @Inject constructor(val activity: ReproductiveActivity) : FragmentStatePagerAdapter(activity.supportFragmentManager) {

    override fun getItem(position: Int): Fragment  = when(position){
        0 -> ZealFragment.instance()
        1 -> ServiceFragment.instance()
        2 -> DiagnosisFragment.instance()
        else -> BirthFragment.instance()
    }

    override fun getCount(): Int = 4

    override fun getPageTitle(position: Int): CharSequence = when(position){
        0 -> activity.getString(R.string.zeal)
        1 -> activity.getString(R.string.service)
        2 -> activity.getString(R.string.diagnosis)
        else -> activity.getString(R.string.birth)
    }
}