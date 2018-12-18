package personal.gj.myapplication.network

import okhttp3.OkHttpClient
import personal.gj.myapplication.config.BASE_URL
import personal.gj.myapplication.config.IS_DEBUG
import personal.gj.myapplication.config.NETWORK_TIMEOUT
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

/**
 *Created by GJ
 *on 2018/12/17 -上午 9:37
 */
class RetrofitManager private constructor(){

    private var okHttpClient: OkHttpClient

    private var retrofit: Retrofit
    private var apiService: ApiService

    init {
        val httpLoggingInterceptor = okhttp3.logging.HttpLoggingInterceptor().apply {
            level = okhttp3.logging.HttpLoggingInterceptor.Level.BODY
        }

        okHttpClient = OkHttpClient.Builder().apply {
            writeTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
            readTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
            connectTimeout(NETWORK_TIMEOUT, TimeUnit.MILLISECONDS)
            if (IS_DEBUG) {
                addInterceptor(httpLoggingInterceptor)
            }
//            proxy(Proxy.NO_PROXY)
        }.build()

        retrofit = Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .client(okHttpClient)
            .build()

        apiService = retrofit.create(ApiService::class.java)
    }

    companion object {
        val instance: RetrofitManager by lazy { RetrofitManager() }
    }

    fun apiService(): ApiService = apiService
}