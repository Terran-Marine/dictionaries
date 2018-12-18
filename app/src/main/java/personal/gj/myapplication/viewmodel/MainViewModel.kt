package personal.gj.myapplication.viewmodel

import android.arch.lifecycle.LiveData
import personal.gj.myapplication.MainRepository
import personal.gj.myapplication.bean.WordDetailsBean
import personal.gj.myapplication.network.Resource

/**
 *Created by GJ
 *on 2018/12/18 -上午 11:41
 */
class MainViewModel(var repository: MainRepository =MainRepository()):BaseViewModel(){
    fun getQueryWord(query: String): LiveData<Resource<WordDetailsBean>> =repository.queryWord(query)
}