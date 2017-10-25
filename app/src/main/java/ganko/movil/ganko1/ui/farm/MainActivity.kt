package ganko.movil.ganko1.ui.farm

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jakewharton.rxbinding2.view.clicks

import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Finca
import ganko.movil.ganko1.ui.adapters.FincaAdapter
import ganko.movil.ganko1.databinding.ActivityMainBinding

import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.ui.farm.add.AddFarmActivity
import ganko.movil.ganko1.ui.inventory.add.AddBovineActivity
import ganko.movil.ganko1.utils.Loader
import ganko.movil.ganko1.utils.buildViewModel
import ganko.movil.ganko1.utils.subscribeByShot
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast
import javax.inject.Inject


class MainActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    val mainViewModel: MainViewModel by lazy { buildViewModel(factory, MainViewModel::class) }
    @Inject
    lateinit var adapter: FincaAdapter
    lateinit var binding: ActivityMainBinding
    val loader: Loader = Loader()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        recycler.adapter = adapter
        binding.loader = loader

        fabAdd.clicks()
                .subscribeBy(
                        onNext = {
                            goToAdd()
                        }
                )
    }

    override fun onResume() {
        super.onResume()
        mainViewModel.getAllRemote()
                .subscribeByShot(
                        onNext = {
                            adapter.fincas = it
                            if(adapter.fincas.isEmpty()){
                                msgVacio.visibility = View.VISIBLE
                            }
                        },
                        onHttpError = {
                            //                            if(it == R.string.socket)
                            mainViewModel.getAllLocal()
                                    .subscribeBy(
                                            onNext = {
                                                adapter.fincas = it
                                                if(adapter.fincas.isEmpty()){
                                                    msgVacio.visibility = View.VISIBLE
                                                    toast(R.string.zero_farms)
                                                }
                                            }
                                    )
//                            else
//                                toast(it)
                        },
                        onError = {toast(it.message!!)}
                )
    }

    fun goToAdd(){
        startActivity<AddFarmActivity>()
    }
}
