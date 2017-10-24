package ganko.movil.ganko1.ui.login.password

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.ActivityPasswordBinding
import ganko.movil.ganko1.ui.login.LoginActivity
import kotlinx.android.synthetic.main.activity_password.*

class PasswordActivity : AppCompatActivity() {

    lateinit var binding: ActivityPasswordBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_password)

        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_back)
        supportActionBar?.setDisplayShowTitleEnabled(false)

    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    fun confirm(v: View){
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }
}
