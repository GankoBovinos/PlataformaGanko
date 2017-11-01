package ganko.movil.ganko1.ui.bovines.add

import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding2.view.clicks
import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.ActivityAddBovineBinding
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_add_bovine.*

class AddBovineActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddBovineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_bovine)
        binding.state = 0

        back_bovine_button.clicks()
                .subscribeBy (
                        onNext = {minusState()}
                )
        next_bovine_button.clicks()
                .subscribeBy ( onNext = {plusState()} )
        add_bovine_button.clicks()
                .subscribeBy(onNext = {fin()})


    }

    fun minusState(){
        binding.state -= 1
    }

    fun plusState(){
        binding.state += 1
    }
    fun fin(){
        finish()
    }
}
