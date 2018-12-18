package personal.gj.myapplication.network

import android.arch.lifecycle.LiveData
import retrofit2.Call
import retrofit2.CallAdapter
import retrofit2.Callback
import retrofit2.Response
import java.lang.reflect.Type
import java.util.concurrent.atomic.AtomicBoolean

/**
 *Created by GJ
 *on 2018/12/18 -下午 3:39
 */
class LiveDataCallAdapter<R>(private val responseType: Type) : CallAdapter<HttpResponse<R>, LiveData<ApiResponse<R>>> {
    override fun adapt(call: Call<HttpResponse<R>>): LiveData<ApiResponse<R>> {
            return object :LiveData<ApiResponse<R>>(){
                private var started = AtomicBoolean(false)
                override fun onActive() {
                    super.onActive()
                    if (started.compareAndSet(false, true)) {
                        call.enqueue(object : Callback<HttpResponse<R>> {
                            override fun onResponse(call: Call<HttpResponse<R>>, response: Response<HttpResponse<R>>) {
                                postValue(ApiResponse.create(response))
                            }

                            override fun onFailure(call: Call<HttpResponse<R>>, throwable: Throwable) {
                                postValue(ApiResponse.create(throwable))
                            }
                        })
                    }
                }
            }
    }

    override fun responseType(): Type = responseType
}