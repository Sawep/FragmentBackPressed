package com.yiheng.fragmentback

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentActivity
import android.support.v4.app.FragmentManager

/**
 * Create on 2018/10/24
 */
object FragmentBackUtil {

    /**
     * 将back事件分发给 FragmentManager 中管理的子Fragment，如果该 FragmentManager 中的所有Fragment都
     * 没有处理back事件，则尝试 FragmentManager.popBackStack()
     *
     * @return 如果处理了back键则返回 <b>true</b>
     * @see #handleBackPress(Fragment)
     * @see #handleBackPress(FragmentActivity)
     */
    private fun handleBackPress(fgManager: FragmentManager): Boolean {
        val fragments = fgManager.fragments

        if (fragments.size == 0) {
            return false
        }

        for (i in fragments.size - 1 downTo 0) {
            val child = fragments[i]

            if (isHandle(child)) {
                return true
            }
        }

        if (fgManager.backStackEntryCount > 0) {
            fgManager.popBackStack()
            return true
        }
        return false
    }

    fun handleBackPress(fragment: Fragment): Boolean{
        return handleBackPress(fragment.childFragmentManager)
    }

    fun handleBackPress(fragmentActivity: FragmentActivity): Boolean{
        return handleBackPress(fragmentActivity.supportFragmentManager)
    }

    /**
     * 判断Fragment是否处理了Back键
     *
     * @return 如果处理了back键则返回 true
     */
    private fun isHandle(fragment: Fragment): Boolean {
        return fragment.isVisible
                && fragment.userVisibleHint
                && fragment is FragBackListener
                && fragment.onBackPressed()
    }

}