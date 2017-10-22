package ganko.movil.ganko1.utils

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.EditText
import kotlin.reflect.KClass

/**
 * Created by jlbel on 11/10/2017.
 */
fun EditText.text(): String = text.toString()

fun ViewGroup.inflate(layout: Int) = LayoutInflater.from(context).inflate(layout, this, false)

fun <T: ViewModel> AppCompatActivity.buildViewModel(factory: ViewModelProvider.Factory, kClass: KClass<T>):T
        = ViewModelProviders.of(this, factory).get(kClass.java)