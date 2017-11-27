package ganko.movil.ganko1.ui.bovines.out

import android.app.DialogFragment
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.ActivityOutBovineBinding
import kotlinx.android.synthetic.main.activity_out_bovine.*


class OutBovineActivity : AppCompatActivity(), View.OnClickListener {

    lateinit var binding: ActivityOutBovineBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_out_bovine)

        date_picker_out_text.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when(view.getId()){
            R.id.date_picker_out_text -> getDate()
        }
    }

    fun getDate(){
        var fragment: DialogFragment = DatePickerFragment()
        //fragment.show(supportFragmentManager, "datePicker")
    }


}
