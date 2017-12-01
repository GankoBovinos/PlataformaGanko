package ganko.movil.ganko1.ui.bovines.out


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.widget.itemSelections
import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.ActivityOutBovineBinding
import ganko.movil.ganko1.utils.DatePicker
import ganko.movil.ganko1.utils.LifeDisposable
import ganko.movil.ganko1.utils.text
import ganko.movil.ganko1.utils.validateForm
import io.reactivex.rxkotlin.subscribeBy
import kotlinx.android.synthetic.main.activity_out_bovine.*


class OutBovineActivity : AppCompatActivity() {

    lateinit var binding: ActivityOutBovineBinding
    val dis: LifeDisposable = LifeDisposable(this)

    var datePicker: DatePicker = DatePicker()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_out_bovine)
        binding.other = false
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.retired_bovine)
    }

    override fun onResume() {
        super.onResume()
        dis add datePickerText.clicks()
                .flatMap { datePicker.selected(supportFragmentManager) }
                .subscribe {
                    datePickerText.setText("${it.first}/${it.second}/${it.third}")
                }

        dis add cancel_out.clicks()
                .subscribeBy(onNext = { finish() })

        dis add save_out.clicks()
                .flatMap { validateForm(R.string.empty_fields, datePickerText.text()) }
                .subscribeBy(onNext = { finish() })

        dis add out_spinner.itemSelections()
                .subscribe {
                    val selected = out_spinner.selectedItem.toString()
                    binding.other = selected == "Otro"
                }


    }

}
