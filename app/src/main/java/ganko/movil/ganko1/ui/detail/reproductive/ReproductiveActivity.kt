package ganko.movil.ganko1.ui.detail.reproductive

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.app.Fragment
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector
import ganko.movil.ganko1.R
import javax.inject.Inject

class ReproductiveActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @Inject
    lateinit var injector: DispatchingAndroidInjector<Fragment>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_reproductive)
    }

    override fun supportFragmentInjector(): AndroidInjector<Fragment>
        = injector
}
