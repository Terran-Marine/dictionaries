package personal.gj.myapplication.network

import com.orhanobut.logger.Logger
import personal.gj.myapplication.utils.showShortToast

/**
 *Created by GJ
 *on 2018/12/18 -下午 1:54
 */
class Resource<T>(private var status: NetworkRequestState, var data: T? = null, var message: String = "") {
    fun work(
        onLoading: () -> Boolean = { false },
        onError: (message: String) -> Unit = { showShortToast(message) },
        onSuccess: () -> Unit
    ) {
        when (status) {
            NetworkRequestState.LOADING -> {
                Logger.i("加载中")
            }
            NetworkRequestState.ERROR -> {
                Logger.i("请求错误")
                onError(message)
            }
            NetworkRequestState.SUCCESS -> {
                Logger.i("请求成功")
                onSuccess()
            }
        }
    }

    fun success(data: T? = null): Resource<T> {
        this.status = NetworkRequestState.SUCCESS
        this.data = data
        return this
    }

    fun error(data: T? = null, message: String): Resource<T>? {
        this.data = data
        this.message = message
        this.status = NetworkRequestState.ERROR
        return this
    }

    fun loading(): Resource<T>? {
        this.status = NetworkRequestState.LOADING
        return this
    }
}