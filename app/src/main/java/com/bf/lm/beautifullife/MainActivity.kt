package com.bf.lm.beautifullife

import android.os.Bundle
import android.support.v4.view.PagerAdapter
import android.support.v7.app.AppCompatActivity
import android.view.View
import android.view.ViewGroup
import com.bf.lm.beautifullife.base.BasePager
import com.bf.lm.beautifullife.pager.EconomicPager
import com.bf.lm.beautifullife.pager.OthersPager
import com.bf.lm.beautifullife.pager.SportPager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    // title数组
    var title_array: Array<String> = arrayOf()
    var pagerList: List<BasePager> = listOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // 初始化视图
        initView()
        // 设置viewpagerAdapter
        vp_container.adapter = MainTabPagerAdapter()
        // 设置viewpager和tabLayout结合
        tl_viewpager_container.setupWithViewPager(vp_container)
    }

    private fun initView() {
        vp_container.adapter = MainTabPagerAdapter()
        // 初始化title
        title_array = arrayOf(resources.getString(R.string.sport),
                resources.getString(R.string.economics),
                resources.getString(R.string.others))
        // 初始化pager集合
        pagerList = listOf(
                SportPager(this),
                EconomicPager(this),
                OthersPager(this)
        )
    }

    /**
     * inner 定义内部类；不加inner - 引用不到外层嵌套类的成员
     */
    inner class MainTabPagerAdapter : PagerAdapter() {
        override fun isViewFromObject(view: View?, `object`: Any?): Boolean {
            return view == `object`
        }

        override fun getCount(): Int {
            return this@MainActivity.title_array.size
        }

        /**
         * 初始化item
         */
        override fun instantiateItem(container: ViewGroup?, position: Int): Any {
            // 实例化View
            var rootView = pagerList[position].rootView
            container?.addView(rootView)
            return rootView
        }

        /**
         * 重写该方法 设置title
         */
        override fun getPageTitle(position: Int): CharSequence {
            return this@MainActivity.title_array[position]
        }

        /**
         * 销毁
         */
        override fun destroyItem(container: ViewGroup?, position: Int, `object`: Any?) {
            container?.removeView(`object` as View?)
        }
    }
}


