package ganko.movil.ganko1.utils

import android.app.DatePickerDialog
import android.app.Dialog
import android.os.Bundle
import android.support.v4.app.DialogFragment
import android.support.v4.app.FragmentManager
import java.util.*
import android.widget.Toast
import io.reactivex.subjects.PublishSubject


/**
 * Created by Ana Marin on 27/11/2017.
 */
class DatePicker : DialogFragment() {

    private val selectedDate = PublishSubject.create<Triple<Int, Int, Int>>()
    private val dateSetListener = DatePickerDialog.OnDateSetListener { view, year, month, day ->
        selectedDate.onNext(Triple(day, month, year))
    }

    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {

        val c = Calendar.getInstance()
        val year = c.get(Calendar.YEAR)
        val month = c.get(Calendar.MONTH)
        val day = c.get(Calendar.DAY_OF_MONTH)

        return DatePickerDialog(activity, dateSetListener, year, month, day)
    }

    fun selected(manager:FragmentManager):PublishSubject<Triple<Int, Int, Int>>{
        show(manager, "datepicker")
        return selectedDate
    }
}