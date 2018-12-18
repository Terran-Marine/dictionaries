package personal.gj.myapplication.base

import android.support.v4.app.FragmentActivity
import android.view.KeyEvent
import io.reactivex.disposables.CompositeDisposable

/**
 *Created by GJ
 *on 2018/12/18 -上午 11:09
 */
abstract class BaseActivity:FragmentActivity(){
    protected var compositeDisposable = CompositeDisposable()

    override fun onDestroy() {
        super.onDestroy()
        compositeDisposable.clear() // 防止内存泄露
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean = if (KeyEvent.KEYCODE_BACK == keyCode) {
        if (supportFragmentManager.backStackEntryCount == 1 || supportFragmentManager.backStackEntryCount ==0) {
            true
        } else {
            try {
                supportFragmentManager.popBackStackImmediate()
            } catch (e: Exception) {
            }
            true
        }
    } else {
        super.onKeyDown(keyCode, event)
    }


}