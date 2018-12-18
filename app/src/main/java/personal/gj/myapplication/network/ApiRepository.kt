package personal.gj.myapplication.network

/**
 *Created by GJ
 *on 2018/12/18 -上午 11:41
 */
open class ApiRepository {
    val apiInterface: ApiService = RetrofitManager.instance.apiService()
}