package ganko.movil.ganko1.ui.bovines.out

import android.app.DatePickerDialog
import android.app.Dialog
import android.app.DialogFragment
import android.widget.DatePicker
import android.os.Bundle
import java.util.*
import android.widget.Toast




/**
 * Created by Ana Marin on 27/11/2017.
 */
class DatePickerFragment: DialogFragment(){

    override fun onCreateDialog(savedInstanceState: Bundle): Dialog {
        val  CERO: String = "0"
        val  BARRA: String = "/"

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity, dateSetListener, year, month, day)
    }
        val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, day ->
            Toast.makeText(activity, "Fecha Seleccionada " + view.year +
                    " / " + (view.month + 1) +
                    " / " + view.dayOfMonth, Toast.LENGTH_SHORT).show()
        }
}