package com.kai.utils.ui

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.Toast

/**
 *
 * @Description TODO
 * @Author HanKaiYang
 * @CreateDate 2019/12/30 11:40
 * @Version 1.0
 */
class ToastView() {
    private lateinit var context: Context
    private lateinit var toast: Toast
    private lateinit var view: View

    companion object{
        private var TOAST_IF = true
        private var LOG_IF = true
    }

    constructor(context: Context) : this(){
        this.context = context
    }

    fun show(){
        toast.show()
    }

     /**
     * @description 自定义布局 需要之前已设置context
     * @author HanKaiYang
     * @createDate 2019/12/30 13:47
     * @version 1.0
     * @param layoutResId : 设置布局文件
     * @return 返回ToastView
     */
    fun initLayout(layoutResId : Int) : ToastView {
        if (TOAST_IF){
            view = LayoutInflater.from(context).inflate(layoutResId,null)
            toast = Toast(context)
            toast.view = view
        }else {
            if (LOG_IF){
                Log.d(this::class.simpleName,"消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。请初始化时加入Content参数或使用setContent()方法")
            }
        }
        return this
    }

    /**
     * @description  自定义布局，显示位置设置,需要之前已设置context
     * @author HanKaiYang
     * @createDate 2019/12/30 13:45
     * @version 1.0
     * @param layoutResId : 设置布局文件
     * @param gravity : Gravity.*****  用这个变量里面的值可以控制显示位置
     * @return 返回ToastView
     */
    fun initLayout(layoutResId: Int,gravity: Int) : ToastView{
        if (TOAST_IF){
            view = LayoutInflater.from(context).inflate(layoutResId,null)
            toast = Toast(context)
            if (gravity != 0){
                toast.setGravity(gravity,0,0)
            }
            toast.view = view
        }else {
            if (LOG_IF){
                Log.d(this::class.simpleName,"消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。请初始化时加入Content参数或使用setContent()方法")
            }
        }
        return this
    }

    /**
     * @description
     * @author HanKaiYang
     * @createDate 2019/12/30 13:51
     * @version 1.0
     * @param layoutResId : 布局文件
     * @param gravity : Gravity.*****  用这个变量里面的值可以控制显示位置
     * @param context : 设置context
     * @return 返回ToastView
     */
    fun initLayout(layoutResId: Int,gravity: Int,context: Context) : ToastView{
        if (TOAST_IF){
            view = LayoutInflater.from(context).inflate(layoutResId,null)
            toast = Toast(context)
            if (gravity != 0){
                toast.setGravity(gravity,0,0)
            }
            toast.view = view
        }else {
            if (LOG_IF){
                Log.d(this::class.simpleName,"消息框错误日志：你没有为 Context 进行赋值 ，却引用了 Toast 导致该功能无法实现。请初始化时加入Content参数或使用setContent()方法")
            }
        }
        return this
    }
}