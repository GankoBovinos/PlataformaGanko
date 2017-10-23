package ganko.movil.ganko1.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import ganko.movil.ganko1.R
import ganko.movil.ganko1.ui.adapters.FincaAdapter
import ganko.movil.ganko1.data.models.Finca
import ganko.movil.ganko1.databinding.ActivityMainBinding

import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.utils.buildViewModel
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject


class MainActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var factory: ViewModelProvider.Factory
    val mainViewModel: MainViewModel by lazy { buildViewModel(factory, MainViewModel::class) }
    @Inject
    lateinit var adapter: FincaAdapter
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        recycler.adapter = adapter

        mainViewModel.getAll()
                .subscribeBy(
                        onNext = {
                            adapter.fincas = it
                            if(adapter.fincas.isEmpty()){
                                msgVacio.text = "No hay fincas registradas"
                                msgVacio.visibility = View.VISIBLE
                            }

                        }
                )
    }
}
