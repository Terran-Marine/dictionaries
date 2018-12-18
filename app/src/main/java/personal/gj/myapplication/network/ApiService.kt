package personal.gj.myapplication.network

import android.arch.lifecycle.LiveData
import io.reactivex.Observable
import okhttp3.RequestBody
import okhttp3.ResponseBody
import personal.gj.myapplication.bean.WordDetailsBean
import retrofit2.http.*

/**
 *Created by GJ
 *on 2018/12/17 -上午 9:45
 */
interface ApiService{


    /**
     * @param q 要翻译的文本
     * @param from 源语言
     * @param to 目标语言
     * @param appKey 应用申请的key
     * @param salt 随机数
     * @param sign 签名，通过md5(appkey+q+salt)生成    appKey+q+salt的MD5值
     * */
    @GET("api")
    fun queryWord(@Query("q")q:String,
                  @Query("from")from:String,
                  @Query("to")to:String,
                  @Query("appKey")appKey:String,
                  @Query("salt")salt:String,
                  @Query("sign")sign:String
               ): LiveData<ApiResponse<WordDetailsBean>>

//    @GET("http://api.fanyi.baidu.com/api/trans/vip/translate")
//    fun queryWord(@Query("q")q:String,
//                  @Query("from")from:String,
//                  @Query("to")to:String,
//                  @Query("appid")appid:String,
//                  @Query("salt")salt:String,
//                  @Query("sign")sign:String
//                  ): Observable<ResponseBody>



}