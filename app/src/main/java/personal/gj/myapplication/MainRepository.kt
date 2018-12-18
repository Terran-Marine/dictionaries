package personal.gj.myapplication

import android.arch.lifecycle.LiveData
import personal.gj.myapplication.bean.WordDetailsBean
import personal.gj.myapplication.config.YOUDAO_APP_ID
import personal.gj.myapplication.config.YOUDAO_APP_KEY
import personal.gj.myapplication.network.ApiRepository
import personal.gj.myapplication.network.ApiResponse
import personal.gj.myapplication.network.NetworkOnlyResource
import personal.gj.myapplication.network.Resource
import personal.gj.myapplication.utils.EncryptUtils

/**
 *Created by GJ
 *on 2018/12/18 -上午 11:42
 */
class MainRepository :ApiRepository(){

    fun queryWord(query: String):LiveData<Resource<WordDetailsBean>>{
        val salt = System.currentTimeMillis().toString()
        return object : NetworkOnlyResource<WordDetailsBean,WordDetailsBean>(){
            override fun createCall(): LiveData<ApiResponse<WordDetailsBean>> {
                return apiInterface.queryWord(q=query,
                    from = "EN",
                    to="zh-CHS",
                    appKey = YOUDAO_APP_ID,
                    salt = salt,sign =  EncryptUtils.md5("${YOUDAO_APP_ID}${query}${salt}$YOUDAO_APP_KEY"))
            }
        }.asLiveData()

    }






}