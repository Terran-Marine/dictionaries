package personal.gj.myapplication.base

import android.support.v4.app.Fragment
import io.reactivex.disposables.CompositeDisposable

/**
 *Created by GJ
 *on 2018/12/18 -上午 11:11
 */
abstract class BaseFragment :Fragment(){
    protected var compositeDisposable = CompositeDisposable()

    override fun onDestroyView() {
        super.onDestroyView()
        compositeDisposable.clear() // 防止内存泄露
    }
}