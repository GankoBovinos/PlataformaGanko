package ganko.movil.ganko1.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.content.SharedPreferences
import android.databinding.BindingAdapter
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import io.reactivex.Observable
import org.jetbrains.anko.toast
import java.text.SimpleDateFormat
import java.util.*
import kotlin.reflect.KClass

/**
 * Created by jlbel on 11/10/2017.
 */
fun EditText.text(): String = text.toString()

fun ViewGroup.inflate(layout: Int) = LayoutInflater.from(context).inflate(layout, this, false)

fun <T : ViewModel> AppCompatActivity.buildViewModel(factory: ViewModelProvider.Factory, kClass: KClass<T>): T
        = ViewModelProviders.of(this, factory).get(kClass.java)

fun <T : ViewModel> Fragment.buildViewModel(factory: ViewModelProvider.Factory, kClass: KClass<T>): T
        = ViewModelProviders.of(this, factory).get(kClass.java)

fun SharedPreferences.save(vararg data: Pair<String, Any>) {
    val editor = edit()
    data.forEach { (key, value) ->
        when (value) {
            is String -> editor.putString(key, value)
            is Int -> editor.putInt(key, value)
            is Boolean -> editor.putBoolean(key, value)
            is Long -> editor.putLong(key, value)
        }

    }
    editor.apply()
}

fun AppCompatActivity.validateForm(message: Int,
                                   vararg fields: String): Observable<List<String>>
        = Observable.create<List<String>> {
    if (fields.contains("")) toast(message)
    else it.onNext(fields.toList())
    it.onComplete()
}

fun AppCompatActivity.putFragment(container: Int, fragment: Fragment) {
    supportFragmentManager.beginTransaction()
            .replace(container, fragment)
            .commit()
}


fun Fragment.putFragment(container: Int, fragment: Fragment) {
    childFragmentManager.beginTransaction()
            .replace(container, fragment)
            .commit()
}

fun AppCompatActivity.addFragment(container: Int, fragment: Fragment, backStack:Boolean = true) {
    val transaction = supportFragmentManager.beginTransaction()
            .add(container, fragment)
    if (backStack) transaction.addToBackStack(null)
    transaction.commit()
}


fun Fragment.addFragment(container: Int, fragment: Fragment, backStack: Boolean = true) {
    val transaction = childFragmentManager.beginTransaction()
            .add(container, fragment)
    if (backStack) transaction.addToBackStack(null)
    transaction.commit()
}


@BindingAdapter("app:dateFormat")
fun applyFormat(textView: TextView, date: Date){
    val format = SimpleDateFormat("dd/MM/yyyy", Locale.getDefault())
    textView.text = format.format(date)
}

