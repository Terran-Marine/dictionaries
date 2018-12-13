package personal.gj.myapplication

import android.app.Application
import com.orhanobut.logger.AndroidLogAdapter
import com.orhanobut.logger.Logger

/**
 *Created by GJ
 *on 2018/12/13 -下午 4:24
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        initUtils()

    }

    private fun initUtils() {
        Logger.addLogAdapter(AndroidLogAdapter())
    }
}