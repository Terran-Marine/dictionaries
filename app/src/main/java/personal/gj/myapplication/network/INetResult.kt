package personal.gj.myapplication.network

/**
 *Created by GJ
 *on 2018/12/17 -上午 10:20
 */
interface INetResult<T>{
    fun onCompleted()

    fun onSuccess(model:T)

    fun onFail(errorCode :Int,msg:String?)
}