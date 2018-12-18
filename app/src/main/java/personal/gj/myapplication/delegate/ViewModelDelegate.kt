package personal.gj.myapplication.delegate

import android.arch.lifecycle.ViewModelProviders
import personal.gj.myapplication.base.BaseActivity
import personal.gj.myapplication.base.BaseFragment
import personal.gj.myapplication.viewmodel.BaseViewModel
import kotlin.reflect.KClass
import kotlin.reflect.KProperty

/**
 *Created by GJ
 *on 2018/12/18 -上午 11:02
 */
class ViewModelDelegate<out T: BaseViewModel>(private val clazz:KClass<T>,private val fromActivity: Boolean){
    private var viewModel:T?=null

    operator fun getValue(thisRef:BaseActivity,property:KProperty<*>)=buildViewModel(activity = thisRef )

    operator fun getValue(thisRef: BaseFragment, property: KProperty<*>) = if (fromActivity)
        buildViewModel(activity = thisRef.activity as? BaseActivity
            ?: throw IllegalStateException("Activity must be as BaseActivity"))
    else buildViewModel(fragment = thisRef)

    private fun buildViewModel(activity: BaseActivity?=null,fragment:BaseFragment?=null):T{
        if(viewModel!=null) return  viewModel!!

        activity?.let {
            viewModel= ViewModelProviders.of(it).get(clazz.java)
        }?:fragment?.let{
            viewModel= ViewModelProviders.of(it).get(clazz.java)
        }?:throw IllegalStateException("Activity and Fragment null!")

        return viewModel!!
    }
}

fun <T : BaseViewModel> BaseActivity.viewModelDelegate(clazz: KClass<T>) = ViewModelDelegate(clazz, true)

// fromActivity默认为true，viewModel生命周期默认跟activity相同 by aaron 2018/7/24
fun <T : BaseViewModel> BaseFragment.viewModelDelegate(clazz: KClass<T>, fromActivity: Boolean = true) = ViewModelDelegate(clazz, fromActivity)