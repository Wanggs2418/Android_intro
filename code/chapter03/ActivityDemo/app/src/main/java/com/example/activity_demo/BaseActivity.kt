package com.example.activity_demo

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

//普通的kotlin类，无需注册
open class BaseActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState:Bundle?){
        super.onCreate(savedInstanceState)
//        打印当前实例的类名
        Log.d("当前的活动为",javaClass.simpleName)
        ActivityColletor.addActivity(this)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityColletor.removeActivity(this)
    }
}