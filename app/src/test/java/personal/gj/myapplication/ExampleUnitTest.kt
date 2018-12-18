package personal.gj.myapplication

import com.orhanobut.logger.Logger
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import okhttp3.ResponseBody
import org.junit.Test

import personal.gj.myapplication.config.YOUDAO_APP_ID
import personal.gj.myapplication.config.YOUDAO_APP_KEY
import personal.gj.myapplication.network.HttpObserver
import personal.gj.myapplication.network.RetrofitManager
import personal.gj.myapplication.utils.EncryptUtils
import java.nio.charset.StandardCharsets

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {
    @Test
    fun addition_isCorrect() {

        val salt = System.currentTimeMillis().toString()

        println("开始")



        RetrofitManager.instance.apiService().queryWord(
            q = "good",
            from = "EN",
            to = "zh_CHS",
            sign = EncryptUtils.md5(YOUDAO_APP_ID + "good" + salt + YOUDAO_APP_KEY),
            appKey = YOUDAO_APP_ID,
            salt = salt
        )
            .subscribe(object : HttpObserver<ResponseBody>() {
                override fun onCompleted() {
                    println("完成")
                }

                override fun onSuccess(model: ResponseBody) {
                    println(model.string())
                }

                override fun onFail(errorCode: Int, msg: String?) {
                    println("错误")
                }
            })

    }
}
