package ganko.movil.ganko1.ui.AddFarm

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import ganko.movil.ganko1.R
import ganko.movil.ganko1.databinding.ActivityAddFarmBinding
import ganko.movil.ganko1.ui.main.MainActivity

class AddFarmActivity : AppCompatActivity() {

    lateinit var binding: ActivityAddFarmBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_add_farm)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setTitle("Agregar finca")
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }

    fun confirm(v: View){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}
