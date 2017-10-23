package ganko.movil.ganko1.ui.main

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import ganko.movil.ganko1.R
import ganko.movil.ganko1.ui.adapters.FincaAdapter
import ganko.movil.ganko1.databinding.ActivityMainBinding

import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.utils.buildViewModel
import ganko.movil.ganko1.utils.subscribeByShot
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.toast
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
                .subscribeByShot(
                        onNext = {
                            adapter.fincas = it
                            if(adapter.fincas.isEmpty()){
                                msgVacio.text = getString(R.string.zero_farms)
                                msgVacio.visibility = View.VISIBLE
                            }
                        },
                        onHttpError = this::toast,
                        onError = {toast(it.message!!)}
                )
    }
}
