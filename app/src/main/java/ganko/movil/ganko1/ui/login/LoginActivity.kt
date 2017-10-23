package ganko.movil.ganko1.ui.login

import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding2.view.clicks
import ganko.movil.ganko1.databinding.ActivityLoginBinding
import ganko.movil.ganko1.R
import ganko.movil.ganko1.data.model.UserLogin
import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.ui.main.MainActivity
import ganko.movil.ganko1.utils.LifeDisposable
import ganko.movil.ganko1.utils.Loader
import ganko.movil.ganko1.utils.subscribeByAction
import ganko.movil.ganko1.utils.text
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.toast
import javax.inject.Inject


class LoginActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var factory:ViewModelProvider.Factory
    lateinit var binding: ActivityLoginBinding
    lateinit var viewModel: LoginViewModel
    val dis: LifeDisposable = LifeDisposable(this)
    val loader:Loader = Loader()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_login)
        viewModel = ViewModelProviders.of(this,factory).get(LoginViewModel::class.java)
//        btnlogin.setOnClickListener { startActivity<MainActivity>() }
        loader.loading.set(true)
        binding.loader = loader

    }

    override fun onResume() {
        super.onResume()


        dis add btnlogin.clicks()

                .flatMap { viewModel.Login(UserLogin(username.text(),password.text())) }
                .subscribeByAction(
                        onNext = {},
                        onHttpError = this::toast,
                        onError = { toast(it.message!!) }
                )
    }
}
