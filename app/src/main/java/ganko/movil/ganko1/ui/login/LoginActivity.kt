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
import ganko.movil.ganko1.ui.farm.FarmActivity
import ganko.movil.ganko1.ui.login.password.PasswordActivity
import ganko.movil.ganko1.utils.*
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.startActivity
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
        loader.loading.set(false)
        binding.loader = loader

    }

    override fun onResume() {
        super.onResume()


        dis add btnlogin.clicks()
                .flatMap { validateForm(R.string.empty_fields,username.text(),password.text()) }
                .flatMap { viewModel.Login(UserLogin(it[0],it[1])) }
                .subscribeByAction(
                        onNext = {startActivity<FarmActivity>()},
                        onHttpError = this::toast,
                        onError = { toast(it.message!!) }
                )

        dis add olvido_pass.clicks()
                .subscribe{startActivity<PasswordActivity>()}
    }
}
