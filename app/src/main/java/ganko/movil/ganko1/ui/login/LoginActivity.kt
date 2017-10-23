package ganko.movil.ganko1.ui.login

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import ganko.movil.ganko1.databinding.ActivityLoginBinding
import android.content.Intent
import android.view.View
import com.jakewharton.rxbinding2.view.clicks
import com.jakewharton.rxbinding2.widget.text
import ganko.movil.ganko1.ui.main.MainActivity
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.models.UserLogin
import ganko.movil.ganko1.ui.password.PasswordActivity
import ganko.movil.ganko1.utils.LifeDisposable
import ganko.movil.ganko1.utils.text
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
import javax.inject.Inject


class LoginActivity : AppCompatActivity() {

    @Inject
    lateinit var factory:ViewModelProvider.Factory
    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel
    val dis: LifeDisposable = LifeDisposable(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this,factory).get(LoginViewModel::class.java)
//        btnlogin.setOnClickListener { startActivity<MainActivity>() }

    }

    override fun onResume() {
        super.onResume()
//        dis add btnlogin.clicks()
//                .flatMap { viewModel.Login(UserLogin(username = username.text(),password = password.text())) }
//                .(startActivity<MainActivity>())
    }
}
