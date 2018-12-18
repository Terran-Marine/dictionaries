package personal.gj.myapplication.network

import android.arch.lifecycle.LiveData
import retrofit2.CallAdapter
import retrofit2.CallAdapter.Factory
import retrofit2.Retrofit
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type

/**
 *Created by GJ
 *on 2018/12/18 -下午 3:10
 */
class LiveDataCallAdapterFactory:Factory(){
    override fun get(returnType: Type, annotations: Array<Annotation>, retrofit: Retrofit): CallAdapter<*, *>? {
        if(Factory.getRawType(returnType)!=LiveData::class.java){
            return null
        }

        val liveDataType=Factory.getParameterUpperBound(0,returnType as ParameterizedType)
        val rawLiveDataType =Factory.getRawType(returnType)
        if (rawLiveDataType != ApiResponse::class.java) {
            throw IllegalArgumentException("type must be a resource")
        }
        if (liveDataType !is ParameterizedType) {
            throw IllegalArgumentException("resource must be parameterized")
        }
        val bodyType = Factory.getParameterUpperBound(0, liveDataType)
        return LiveDataCallAdapter<Any>(bodyType)


    }
}