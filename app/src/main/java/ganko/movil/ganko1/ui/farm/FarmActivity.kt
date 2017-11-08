package ganko.movil.ganko1.ui.farm

import android.arch.lifecycle.ViewModelProvider
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.jakewharton.rxbinding2.view.clicks

import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.Farm
import ganko.movil.ganko1.databinding.ActivityFarmBinding
import ganko.movil.ganko1.ui.adapters.FarmAdapter

import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.ui.bovines.add.AddBovineActivity
import ganko.movil.ganko1.ui.farm.add.AddFarmActivity
import ganko.movil.ganko1.ui.menu.MenuActivity
import ganko.movil.ganko1.utils.*
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
    val dis: LifeDisposable = LifeDisposable(this)
    val loader: Loader = Loader()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_farm)
        recycler.adapter = adapter
        binding.loader = loader
        swipe.setOnRefreshListener { getFincas() }
    }

    override fun onResume() {
        super.onResume()
        dis add  fabAdd.clicks()
                .subscribeBy(
                        onNext = {
                            goToAdd()
                        }
                )

        dis add adapter.clickFarm.subscribeBy(
                onNext = {
                    //goToAddbovine()
                    goToMenu()
                }
        )
//        adapter.clickDelete
//                .flatMap { farmViewModel.deleteRemote(it.id!!) }
//                .subscribeByAction(
//                onNext = {
//                    toast("eliminado")
//                    getFincas()
//                },
//                onHttpError = this::toast,
//                onError = {toast(it.message!!)}
//        )

        dis add adapter.clickEdit.subscribeBy(
                onNext = {
                    goToEdit(it)
                }
        )

        dis add adapter.clickDelete
                .flatMap { farmViewModel.deleteLocal(it) }
                .subscribeBy(
                        onNext = {
                            toast("eliminado")
                        }
                )
        getFincas()

    }

    fun goToAdd(){
        startActivity<AddFarmActivity>()
    }

    fun goToEdit(farm:Farm){
        startActivity<AddFarmActivity>("farm" to farm)
    }

    fun goToAddbovine(){
        startActivity<AddBovineActivity>()
    }

    fun goToMenu(){
        startActivity<MenuActivity>()
    }

//    fun getFincas(){
//        farmViewModel.getAllRemote()
//                .subscribeByShot(
//                        onNext = {
//                            adapter.farms = it
//                            if(adapter.farms.isEmpty()){
//                                msgVacio.visibility = View.VISIBLE
//                            }
//                            else{
//                                msgVacio.visibility = View.GONE
//                            }
//                        },
//                        onHttpError = { toast(it) },
//                        onError = {toast(it.message!!)}
//                )
//    }
    fun getFincas(){
    dis add farmViewModel.getAllLocal()
            .subscribeBy(
                    onNext = {
                        adapter.farms = it
                        swipe.isRefreshing = false
                        if(adapter.farms.isEmpty()){
                            msgVacio.visibility = View.VISIBLE
                        }
                        else{
                            msgVacio.visibility = View.GONE
                        }
                    }
            )
    }
}
