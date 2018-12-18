package personal.gj.myapplication.network

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import android.support.annotation.MainThread

/**
 *Created by GJ
 *on 2018/12/18 -下午 1:46
 *
 */
abstract class NetworkOnlyResource<ResultType, RequestType> @MainThread constructor() {
    private val result = MediatorLiveData<Resource<ResultType>>()

    fun asLiveData(): LiveData<Resource<ResultType>> = result

    protected val liveData: MutableLiveData<RequestType> = MutableLiveData()

    init {
        result.value=Resource(NetworkRequestState.LOADING)
        fetchFromNetwork()
    }

    private lateinit var apiResponse: LiveData<ApiResponse<RequestType>>

    private fun fetchFromNetwork() {
        apiResponse = createCall()
    }

    // 从网络中获取
    @MainThread
    protected abstract fun createCall(): LiveData<ApiResponse<RequestType>>
}