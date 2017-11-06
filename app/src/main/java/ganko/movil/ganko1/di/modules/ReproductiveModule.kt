package ganko.movil.ganko1.di.modules

import dagger.Module
import dagger.android.ContributesAndroidInjector
import ganko.movil.ganko1.di.FragmentScope
import ganko.movil.ganko1.ui.detail.reproductive.birth.BirthFragment
import ganko.movil.ganko1.ui.detail.reproductive.diagnosis.DiagnosisFragment
import ganko.movil.ganko1.ui.detail.reproductive.service.ServiceFragment
import ganko.movil.ganko1.ui.detail.reproductive.zeal.ZealFragment

/**
 * Created by Ana Marin on 1/11/2017.
 */
@Module
abstract class ReproductiveFragment{

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindBirthFragment(): BirthFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindDiagnosisFragment(): DiagnosisFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindServiceFragment(): ServiceFragment

    @FragmentScope
    @ContributesAndroidInjector
    abstract fun bindZealFragment(): ZealFragment
}