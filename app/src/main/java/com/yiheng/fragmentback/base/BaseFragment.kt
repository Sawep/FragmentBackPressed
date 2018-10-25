package com.yiheng.fragmentback.base

import android.app.Activity
import android.content.Context
import android.support.v4.app.Fragment
import com.yiheng.fragmentback.FragBackListener
import com.yiheng.fragmentback.FragmentBackUtil

/**
 * Create on 2018/10/24
 */
open class BaseFragment : Fragment(), FragBackListener {

    private var mActivity: Activity?= null

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        mActivity = context as Activity?
    }

    override fun onBackPressed(): Boolean {
        return FragmentBackUtil.handleBackPress(this)
    }


}