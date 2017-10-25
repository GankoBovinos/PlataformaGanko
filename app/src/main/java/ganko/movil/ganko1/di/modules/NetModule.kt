package ganko.movil.ganko1.di.modules

import android.content.Context
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import ganko.movil.ganko1.R
import ganko.movil.ganko1.net.FincaClient
import ganko.movil.ganko1.net.LoginClient
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

/**
 * Created by jlbeltran94 on 19/10/17.
 */
@Module
class NetModule {


    @Provides
    @Singleton
    fun provideRetrofit(context: Context): Retrofit = Retrofit.
            Builder()
            .addConverterFactory(GsonConverterFactory.create(GsonBuilder()
                    .setDateFormat("dd/MM/yyyy")
                    .create()
            ))
            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
            .baseUrl("https://gankotest.herokuapp.com/")
            .build()

    @Provides
    @Singleton
    fun provideFincaClient(retrofit: Retrofit): FincaClient =
            retrofit.create(FincaClient::class.java)

    @Provides
    @Singleton
    fun provideLoginClient(retrofit: Retrofit): LoginClient =
            retrofit.create(LoginClient::class.java)

}