package ganko.movil.ganko1.di.modules

import android.content.Context
import com.google.gson.GsonBuilder
import dagger.Module
import dagger.Provides
import ganko.movil.ganko1.net.FarmClient
import ganko.movil.ganko1.net.LoginClient
import ganko.movil.ganko1.net.ResetPasswordClient
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
    fun provideFarmClient(retrofit: Retrofit): FarmClient =
            retrofit.create(FarmClient::class.java)

    @Provides
    @Singleton
    fun provideLoginClient(retrofit: Retrofit): LoginClient =
            retrofit.create(LoginClient::class.java)

    @Provides
    @Singleton
    fun provideResetPasswordClient(retrofit: Retrofit): ResetPasswordClient =
            retrofit.create(ResetPasswordClient::class.java)

}