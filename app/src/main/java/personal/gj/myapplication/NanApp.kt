package personal.gj.myapplication

import android.app.Application
import android.content.Context
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 *Created by GJ
 *on 2018/12/13 -下午 4:24
 */
class NanApp : Application() {

    companion object {
        var application: Context? = null
            private set
    }

    override fun onCreate() {
        super.onCreate()
        initUtils()
        NanApp.application = applicationContext
    }

    private fun initUtils() {
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}