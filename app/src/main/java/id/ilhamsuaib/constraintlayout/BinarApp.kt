package id.ilhamsuaib.constraintlayout

import android.app.Application
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 * Created by @ilhamsuaib on 16/10/18.
 * github.com/ilhamsuaib
 */

class BinarApp : Application() {

    companion object {
        lateinit var apiServices: ApiServices
    }

    override fun onCreate() {
        super.onCreate()

        setupRetrofit()
    }

    private fun setupRetrofit() {
        val retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(getOkHttpClient())
                .build()

        apiServices = retrofit.create(ApiServices::class.java)
    }

    private fun getOkHttpClient(): OkHttpClient {
        val timeOut: Long = 30
        return OkHttpClient.Builder()
                .connectTimeout(timeOut, TimeUnit.SECONDS)
                .writeTimeout(timeOut, TimeUnit.SECONDS)
                .readTimeout(timeOut, TimeUnit.SECONDS)
                .addInterceptor(
                        HttpLoggingInterceptor().apply {
                            level = if (BuildConfig.DEBUG) {
                                HttpLoggingInterceptor.Level.BODY
                            } else {
                                HttpLoggingInterceptor.Level.NONE
                            }
                        }
                )
                .build()
    }
}