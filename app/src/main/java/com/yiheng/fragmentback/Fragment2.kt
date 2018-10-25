package com.yiheng.fragmentback

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.yiheng.fragmentback.base.BaseFragment
import kotlinx.android.synthetic.main.layout_fragment.view.*

/**
 * Create on 2018/10/24
 */
class Fragment2 : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.layout_fragment, container, false)
        view.tv.text = "fragment 2"
        return view
    }

    override fun onBackPressed(): Boolean {
        Toast.makeText(activity?.applicationContext, "fragment 2", Toast.LENGTH_SHORT).show()
        return true
    }
}