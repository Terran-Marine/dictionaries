package personal.gj.myapplication.ui

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v4.view.ViewPager
import kotlinx.android.synthetic.main.activity_main.*
import personal.gj.myapplication.R
import personal.gj.myapplication.adapter.MainViewPagerAdapter

class MainActivity : AppCompatActivity() {

    var fragments = arrayListOf(SearchFragment(), WordBookFragment(), SettingFragment())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
    }

    private fun initView() {
        MainViewPagerAdapter(fragments, this@MainActivity.supportFragmentManager).apply {
            viewPager.adapter = this
        }
        viewPager.addOnPageChangeListener(object : ViewPager.OnPageChangeListener {
            override fun onPageScrollStateChanged(p0: Int) {

            }

            override fun onPageScrolled(p0: Int, p1: Float, p2: Int) {
            }

            override fun onPageSelected(position: Int) {
                navigation.selectedItemId = when (position) {
                    0 -> {
                        R.id.navigation_search
                    }
                    1 -> {
                        R.id.navigation_book
                    }
                    2 -> {
                        R.id.navigation_setting
                    }
                    else -> {
                        0
                    }
                }
            }
        })

        navigation.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.navigation_search -> {
                    viewPager.currentItem = 0
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_book -> {
                    viewPager.currentItem = 1
                    return@setOnNavigationItemSelectedListener true
                }
                R.id.navigation_setting -> {
                    viewPager.currentItem = 2
                    return@setOnNavigationItemSelectedListener true
                }
                else -> {
                    return@setOnNavigationItemSelectedListener false
                }
            }
        }
    }
}
