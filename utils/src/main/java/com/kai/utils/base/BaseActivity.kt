package com.kai.utils.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 *
 * @Description TODO
 * @Author HanKaiYang
 * @CreateDate 2019/12/27 16:25
 * @Version 1.0
 */
abstract class BaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (getLayoutResID() != 0){
            setContentView(getLayoutResID())
        }
        init()
    }

    abstract fun getLayoutResID():Int

    abstract fun init()
}