package ganko.movil.ganko1.ui.bovines.list


import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.*

import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Bovine
import ganko.movil.ganko1.databinding.FragmentListBovineBinding
import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.ui.adapters.BovineAdapter
import ganko.movil.ganko1.utils.LifeDisposable
import ganko.movil.ganko1.utils.buildViewModel
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.subjects.PublishSubject
import javax.inject.Inject


/**
 * A simple [Fragment] subclass.
 */
class ListBovineFragment : Fragment(), Injectable {

    @Inject
    lateinit var adapter : BovineAdapter
    lateinit var binding : FragmentListBovineBinding

    val phone = resources.getBoolean(R.bool.phone)
    val land = resources.getBoolean(R.bool.land)


    @Inject
    lateinit var factory: ViewModelProvider.Factory
    val listBovineViewModel: ListBovineViewModel by lazy { buildViewModel(factory, ListBovineViewModel::class) }
    val dis : LifeDisposable = LifeDisposable(this)

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_list_bovine, container, false)
        binding.recyclerBovine.adapter = adapter
        return binding.root
    }

    override fun onResume() {
        super.onResume()
        getBovines()
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        super.onCreateOptionsMenu(menu, inflater)
        inflater.inflate(R.menu.menu_bovine, menu)

    }

    private fun getBovines(){
        dis add listBovineViewModel.getAllLocal()
                .subscribeBy(
                        onNext = {
                            adapter.bovines = it
                            if(adapter.bovines.isNotEmpty()  && land && !phone){
                                bovineSelected().onNext(adapter.bovines[0])
                            }
                        }
                )
    }

    fun bovineSelected():PublishSubject<Bovine> = adapter.clickBovine

    companion object {

        fun instance(bovine: Bovine): ListBovineFragment = ListBovineFragment()

    }


}// Required empty public constructor
