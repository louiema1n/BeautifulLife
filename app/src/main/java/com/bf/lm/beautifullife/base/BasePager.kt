package com.bf.lm.beautifullife.base

import android.content.Context
import android.view.View

/**
 * 页面公共组件
 */
abstract class BasePager {

    // 上下文
    var context: Context
    // 视图
    var rootView: View
    // 是否初始化data
    var isInitData = false

    constructor(context: Context) {
        this.context = context
        this.rootView = initView()
    }

    /**
     * 虚方法 - 由子类对象继承来实现
     */
    abstract fun initView(): View

    /**
     * 初始化数据 - 由子类决定是否继承
     */
    open fun initData() {

    }
}