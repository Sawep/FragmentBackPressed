package com.yiheng.fragmentback

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentTransaction
import android.view.View
import com.yiheng.fragmentback.base.BaseActivity
import com.yiheng.fragmentback.base.BaseFragment
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(), View.OnClickListener {

    private lateinit var fgManager: FragmentManager
    private lateinit var transaction: FragmentTransaction

    private lateinit var curFrag: BaseFragment

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fgManager = supportFragmentManager
        transaction = fgManager.beginTransaction()
        transaction.add(R.id.fl, Fragment1())
        transaction.commit()

        rb1.setOnClickListener(this)
        rb2.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.rb1 -> {
                curFrag = Fragment1()
                addFragment(curFrag, "fragment1")
            }

            R.id.rb2 -> {
                curFrag = Fragment2()
                addFragment(Fragment2(), "fragment2")
            }
        }
    }

    private fun addFragment(fragment: Fragment, tag: String){
        // 开启事务
        transaction = fgManager.beginTransaction()
        // 执行事务,添加Fragment
        transaction.add(R.id.fl, fragment, tag)
        // 添加到回退栈,并定义标记
        transaction.addToBackStack(tag)
        // 提交事务
        transaction.commit()
    }

}
