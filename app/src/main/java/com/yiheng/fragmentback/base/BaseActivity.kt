package com.yiheng.fragmentback.base

import android.support.v7.app.AppCompatActivity
import com.yiheng.fragmentback.FragmentBackUtil

/**
 * Create on 2018/10/24
 */
open class BaseActivity : AppCompatActivity() {

    override fun onBackPressed() {
        if (!FragmentBackUtil.handleBackPress(this)) {
            super.onBackPressed()
        }
    }

}