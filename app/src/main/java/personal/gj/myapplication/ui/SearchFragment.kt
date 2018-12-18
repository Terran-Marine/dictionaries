package personal.gj.myapplication.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.SearchView
import android.text.TextUtils.isEmpty
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.gson.Gson
import com.orhanobut.logger.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_search.*
import okhttp3.RequestBody
import okhttp3.ResponseBody

import personal.gj.myapplication.R
import personal.gj.myapplication.R.id.searchView
import personal.gj.myapplication.base.BaseFragment
import personal.gj.myapplication.config.YOUDAO_APP_ID
import personal.gj.myapplication.config.YOUDAO_APP_KEY
import personal.gj.myapplication.delegate.viewModelDelegate
import personal.gj.myapplication.network.HttpObserver
import personal.gj.myapplication.network.RetrofitManager
import personal.gj.myapplication.utils.EncryptUtils
import personal.gj.myapplication.utils.showShortToast
import personal.gj.myapplication.viewmodel.MainViewModel
import java.util.*

class SearchFragment : BaseFragment() {

    private val model by viewModelDelegate(MainViewModel::class)

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_search, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        searchView.apply {
            isIconified = false
            onActionViewExpanded()
            setIconifiedByDefault(false)
            setOnQueryTextListener(object : SearchView.OnQueryTextListener {
                override fun onQueryTextSubmit(query: String?): Boolean {
                    //提交按钮的点击事件
                    queryWord(query)



                    return true
                }

                override fun onQueryTextChange(newText: String?): Boolean {
                    //当输入框内容改变的时候回调
                    return true
                }
            })

        }
    }

    private fun queryWord(query: String?) {
        query?.let {
            if (it.trim().isEmpty()) {
                showShortToast("搜索内容不能为空")
                return


            }

            model.getQueryWord(it).observe(this, android.arch.lifecycle.Observer {resource->
                resource?.work(
                    onSuccess = { Logger.i("成功了${resource.data.toString()}") },
                    onError = { Logger.e("失败了") }
                )
            })


//            val salt = System.currentTimeMillis().toString()
//
//
//            RetrofitManager.instance.apiService().queryWord(
//                it,
//                "EN",
//                "zh-CHS",
//                YOUDAO_APP_ID,
//                salt,
//                EncryptUtils.md5("${YOUDAO_APP_ID}${it}${salt}${YOUDAO_APP_KEY}")
//            ).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object : HttpObserver<ResponseBody>() {
//                    override fun onCompleted() {
//
//                    }
//
//                    override fun onSuccess(model: ResponseBody) {
//                        Logger.i(model.string())
//                    }
//
//                    override fun onFail(errorCode: Int, msg: String?) {
//                    }
//
//                })


//            RetrofitManager.instance.apiService().queryWord(
//                it,
//                "en",
//                "zh",
//                "20181217000249471",
//                salt,
//                EncryptUtils.md5("20181217000249471${it}${salt}2y_415RmaAdosFn38kEt")
//            ).subscribeOn(Schedulers.io())
//                .observeOn(AndroidSchedulers.mainThread())
//                .subscribe(object : HttpObserver<ResponseBody>() {
//                    override fun onCompleted() {
//
//                    }
//
//                    override fun onSuccess(model: ResponseBody) {
//                        Logger.i(model.string())
//                    }
//
//                    override fun onFail(errorCode: Int, msg: String?) {
//                    }
//
//                })


        }
    }
}
