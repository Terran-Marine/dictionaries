package personal.gj.myapplication.adapter

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import personal.gj.myapplication.base.BaseFragment

/**
 *Created by GJ
 *on 2018/12/13 -下午 3:43
 */
class MainViewPagerAdapter(var fragments: ArrayList<BaseFragment>, fm: FragmentManager) : FragmentPagerAdapter(fm) {
    override fun getItem(position: Int): Fragment = fragments[position]
    override fun getCount(): Int = fragments.size
}