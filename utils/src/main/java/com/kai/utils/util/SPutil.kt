package com.kai.utils.util

import android.content.Context
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor

/**
 * @Description TODO
 * @Author HanKaiYang
 * @CreateDate 2020/1/6 11:06
 * @Version 1.0
 */
class SPutil {
    private var context: Context? = null
    private var sp: SharedPreferences? = null
    private var editor: Editor? = null

    constructor() {}
    constructor(context: Context) {
        this.context = context
        sp = context.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        editor = sp?.edit()
    }

    /**
     * @description 设置context
     * @author HanKaiYang
     * @createDate 2020/1/6 10:50
     * @version 1.0
     * @param context : context
     * @return null
     */
    fun context(context: Context): SPutil {
        this.context = context
        sp = context.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        editor = sp?.edit()
        return this
    }

    /**
     * @description 保存数据
     * @author HanKaiYang
     * @createDate 2020/1/6 10:49
     * @version 1.0
     * @param key : 保存数据的键值对
     * @param object : 需要保存的数据
     * @return null
     */
    fun setParem(key: String?, `object`: Any): SPutil {
        val type = `object`.javaClass.simpleName
        if (`object` is String) {
            editor!!.putString(key, `object`)
        } else if (`object` is Int) {
            editor!!.putInt(key, `object`)
        } else if (`object` is Boolean) {
            editor!!.putBoolean(key, `object`)
        } else if (`object` is Float) {
            editor!!.putFloat(key, `object`)
        } else if (`object` is Long) {
            editor!!.putLong(key, `object`)
        } else {
            editor!!.putString(key, "")
        }
        editor!!.commit()
        return this
    }

    /**
     * @description 获取保存的数据
     * @author HanKaiYang
     * @createDate 2020/1/6 10:48
     * @version 1.0
     * @param context : context
     * @param key : 需要取的键值对
     * @param defaultObject : 默认值
     * @return 返回 object 类型 ，需要转换
     */
    fun getParem(
        context: Context,
        key: String?,
        defaultObject: Any?
    ): Any? {
        sp = context.getSharedPreferences(
            FILE_NAME,
            Context.MODE_PRIVATE
        )
        if (defaultObject is String) {
            return sp?.getString(key, defaultObject as String?)
        } else if (defaultObject is Int) {
            return sp?.getInt(key, (defaultObject as Int?)!!)
        } else if (defaultObject is Boolean) {
            return sp?.getBoolean(key, (defaultObject as Boolean?)!!)
        } else if (defaultObject is Float) {
            return sp?.getFloat(key, (defaultObject as Float?)!!)
        } else if (defaultObject is Long) {
            return sp?.getLong(key, (defaultObject as Long?)!!)
        }
        return null
    }

    /**
     * @description 获取保存的数据
     * @author HanKaiYang
     * @createDate 2020/1/6 10:48
     * @version 1.0
     * @param key : 需要取的键值对
     * @param defaultObject : 默认值
     * @return 返回 object 类型 ，需要转换
     */
    fun getParem(key: String?, defaultObject: Any?): Any? {
        if (defaultObject is String) {
            return sp!!.getString(key, defaultObject as String?)
        } else if (defaultObject is Int) {
            return sp!!.getInt(key, (defaultObject as Int?)!!)
        } else if (defaultObject is Boolean) {
            return sp!!.getBoolean(key, (defaultObject as Boolean?)!!)
        } else if (defaultObject is Float) {
            return sp!!.getFloat(key, (defaultObject as Float?)!!)
        } else if (defaultObject is Long) {
            return sp!!.getLong(key, (defaultObject as Long?)!!)
        }
        return null
    }

    companion object {
        private const val FILE_NAME = "share_data"
    }
}