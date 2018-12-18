package personal.gj.myapplication.viewmodel

import android.arch.lifecycle.ViewModel
import io.reactivex.disposables.CompositeDisposable

/**
 *Created by GJ
 *on 2018/12/18 -上午 11:03
 */
open class BaseViewModel:ViewModel(){
    protected var compositeDisposable: CompositeDisposable = CompositeDisposable()

    override fun onCleared() {
        cancel()
        super.onCleared()
    }

    protected fun cancel(){
        compositeDisposable.clear()
    }

}