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
class Fragment1 : BaseFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = layoutInflater.inflate(R.layout.layout_fragment, container, false)
        initView(view)
        return view
    }

    private fun initView(v: View){
        v.tv.text = "fragment 1"
        v.btn.setOnClickListener{

        }
    }

    override fun onBackPressed(): Boolean {
        Toast.makeText(activity?.applicationContext, "fragment 1", Toast.LENGTH_SHORT).show()
        return true
    }

}