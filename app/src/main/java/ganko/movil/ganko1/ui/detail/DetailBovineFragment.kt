package ganko.movil.ganko1.ui.detail


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jakewharton.rxbinding2.view.clicks
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Bovine
import ganko.movil.ganko1.databinding.FragmentDetailBovineBinding
import ganko.movil.ganko1.utils.LifeDisposable
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.fragment_detail_bovine.*

/**
 * A simple [Fragment] subclass.
 */
class DetailBovineFragment : Fragment() {

    lateinit var binding: FragmentDetailBovineBinding
    val dis: LifeDisposable = LifeDisposable(this)

    var bovine: Bovine? = null
        set(value) {
            field = value
            binding.bovine = bovine
        }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_detail_bovine, container, false)
        bovine = arguments.getParcelable<Bovine>(EXTRA_BOVINE)
        bovine?.id = arguments.getInt(ID_BOVINE)
        return binding.root
    }

    override fun onResume() {
        super.onResume()

    }

    companion object {
        val ID_BOVINE = "id"
        val EXTRA_BOVINE = "bovine"
        fun instance(bovine: Bovine): DetailBovineFragment {
            val fragment = DetailBovineFragment()
            val args = Bundle()
            args.putParcelable(EXTRA_BOVINE, bovine)
            fragment.arguments = args
            return fragment
        }
    }

}// Required empty public constructor
