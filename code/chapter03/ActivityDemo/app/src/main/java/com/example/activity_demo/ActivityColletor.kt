package com.example.activity_demo

import android.app.Activity

//管理 Activity 便于随时退出，单例 ActivityCollector 作为 Activity 的集合
object ActivityColletor {
    private val activities = ArrayList<Activity>()
//    自定义方法:添加
    fun addActivity(activity: Activity){
        activities.add(activity)
    }
//    移除
    fun removeActivity(activity: Activity){
        activities.remove(activity)
    }
//    销毁
    fun finshAll(){
        for (activity in activities){
            if (!activity.isFinishing){
                activity.finish()
            }
        }
        activities.clear()
    }
}