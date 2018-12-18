package personal.gj.myapplication.network

import com.google.gson.JsonParseException
import com.orhanobut.logger.Logger
import io.reactivex.observers.DisposableObserver
import personal.gj.myapplication.utils.showShortToast
import retrofit2.HttpException
import java.net.ConnectException
import java.net.SocketTimeoutException
import java.net.UnknownHostException

/**
 *Created by GJ
 *on 2018/12/17 -上午 10:20
 */
abstract class HttpObserver<T>: DisposableObserver<T>(),INetResult<T>{
    override fun onComplete() {
        onCompleted()
    }

    override fun onNext(t: T) {
        onSuccess(t)
    }

    override fun onError(e: Throwable) {
        Logger.e(e,e.message?:"")

        when (e) {
            is SocketTimeoutException -> {
                showShortToast("网络超时")
            }
            is HttpException -> {
                if (e.response() != null && e.response().errorBody() != null) {
                    onFail(e.code(), e.response().errorBody()?.string())
                }
            }
            is JsonParseException -> {
                Logger.e("Json解析错误")
                showShortToast("网络异常")
            }
            is ConnectException -> {
                Logger.e("连接错误")
                showShortToast("网络异常")
            }
            is UnknownHostException -> {
                Logger.e("host异常")
                showShortToast("网络异常")
            }
            else -> {
                Logger.e("未知错误")
                showShortToast("网络异常")
            }
        }
        onCompleted()
    }
}