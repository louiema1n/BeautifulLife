package com.bf.lm.beautifullife.pager

import android.content.Context
import android.view.View
import com.bf.lm.beautifullife.R
import com.bf.lm.beautifullife.base.BasePager

class OthersPager : BasePager {

    constructor(context: Context) : super(context)

    override fun initView(): View {
        var view = View.inflate(context, R.layout.pager_others, null)
        return view
    }
}