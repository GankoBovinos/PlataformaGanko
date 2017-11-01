package ganko.movil.ganko1.ui.farm

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jakewharton.rxbinding2.view.clicks

import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.ActivityFarmBinding
import ganko.movil.ganko1.ui.adapters.FarmAdapter

import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.ui.bovines.add.AddBovineActivity
import ganko.movil.ganko1.ui.farm.add.AddFarmActivity
import ganko.movil.ganko1.utils.Loader
import ganko.movil.ganko1.utils.buildViewModel
import ganko.movil.ganko1.utils.subscribeByAction
import ganko.movil.ganko1.utils.subscribeByShot
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_farm.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject


class FarmActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    val farmViewModel: FarmViewModel by lazy { buildViewModel(factory, FarmViewModel::class) }
    @Inject
    lateinit var adapter: FarmAdapter
    lateinit var binding: ActivityFarmBinding
    val loader: Loader = Loader()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_farm)
        recycler.adapter = adapter
        binding.loader = loader

        fabAdd.clicks()
                .subscribeBy(
                        onNext = {
                            goToAdd()
                        }
                )

        /*adapter.clickFarm.subscribeBy(
                onNext = {
                    goToAddbovine()
                }
        )*/
        adapter.clickDelete
                .flatMap { farmViewModel.deleteRemote(it.id!!) }
                .subscribeByAction(
                onNext = {
                    toast("eliminado")
                    getFincas()
                },
                onHttpError = this::toast,
                onError = {toast(it.message!!)}
        )
    }

    override fun onResume() {
        super.onResume()
        getFincas()
    }

    fun goToAdd(){
        startActivity<AddFarmActivity>()
    }

    fun goToAddbovine(){
        startActivity<AddBovineActivity>()
    }

    fun getFincas(){
        farmViewModel.getAllRemote()
                .subscribeByShot(
                        onNext = {
                            adapter.farms = it
                            if(adapter.farms.isEmpty()){
                                msgVacio.visibility = View.VISIBLE
                            }
                            else{
                                msgVacio.visibility = View.GONE
                            }
                        },
                        onHttpError = {
                            toast(it)
                            //                            if(it == R.string.socket)
//                            mainViewModel.getAllLocal()
//                                    .subscribeBy(
//                                            onNext = {
//                                                adapter.fincas = it
//                                                if(adapter.fincas.isEmpty()){
//                                                    msgVacio.visibility = View.VISIBLE
//                                                    toast(R.string.zero_farms)
//                                                }
//                                            }
//                                    )
//                            else
//                                toast(it)
                        },
                        onError = {toast(it.message!!)}
                )
    }
}
