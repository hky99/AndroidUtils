package com.kai.utils.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.kai.utils.ui.ToastView

/**
 *
 * @Description TODO
 * @Author HanKaiYang
 * @CreateDate 2019/12/30 9:37
 * @Version 1.0
 */
abstract class BaseFragment : Fragment(){
    private val TAG = tag

    lateinit var mView: View

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mView = if (getLayoutResID() != 0){
            inflater.inflate(getLayoutResID(),null)
        }else {
            super.onCreateView(inflater,container,savedInstanceState)!!
        }
        init()
        return mView
    }

    abstract fun getLayoutResID():Int

    abstract fun init()
}