package ganko.movil.ganko1.ui.login.password


import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jakewharton.rxbinding2.view.clicks
import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.ActivityPasswordBinding
import ganko.movil.ganko1.di.Injectable
import ganko.movil.ganko1.utils.LifeDisposable
import ganko.movil.ganko1.utils.subscribeByAction
import ganko.movil.ganko1.utils.text
import ganko.movil.ganko1.utils.validateForm
import kotlinx.android.synthetic.main.activity_password.*
import org.jetbrains.anko.toast
import javax.inject.Inject

class PasswordActivity : AppCompatActivity(), Injectable {

    @Inject
    lateinit var factory:ViewModelProvider.Factory

    lateinit var viewModel: PasswordViewModel
    val dis: LifeDisposable = LifeDisposable(this)
    lateinit var binding: ActivityPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_password)
        viewModel = ViewModelProviders.of(this,factory).get(PasswordViewModel::class.java)
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    override fun onResume() {
        super.onResume()

        dis add resetPassBtn.clicks()
                .flatMap { validateForm(R.string.empty_fields,email.text()) }
                .flatMap { viewModel.resetPassword(it[0]) }
                .subscribeByAction(
                        onNext = {
                            toast(it)
                            finish()},
                        onHttpError = this::toast,
                        onError = { toast(it.message!!) }
                )

    }
}
