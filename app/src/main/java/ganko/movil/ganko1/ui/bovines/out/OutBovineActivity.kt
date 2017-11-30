package ganko.movil.ganko1.ui.bovines.out


import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jakewharton.rxbinding2.view.clicks
import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.ActivityOutBovineBinding
import ganko.movil.ganko1.utils.DatePicker
import kotlinx.android.synthetic.main.activity_out_bovine.*


class OutBovineActivity : AppCompatActivity(){

    lateinit var binding: ActivityOutBovineBinding

    var datePicker: DatePicker = DatePicker()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_out_bovine)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle(R.string.retired_bovine)
    }

    override fun onResume() {
        super.onResume()
        datePickerText.clicks()
                .flatMap {datePicker.selected(supportFragmentManager)}
                .subscribe {
                    datePickerText.setText( "${it.first}/${it.second}/${it.third}")
                }
    }

}
