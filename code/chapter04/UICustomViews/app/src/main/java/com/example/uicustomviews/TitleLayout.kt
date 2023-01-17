package com.example.uicustomviews

import android.app.Activity
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.Toast
import com.example.uicustomviews.databinding.ActivityMainBinding
import com.example.uicustomviews.databinding.TitleBinding

//自定义控件
class TitleLayout (context: Context,attrs:AttributeSet):LinearLayout(context,attrs) {
    private lateinit var binding: TitleBinding
    init {
//        LayoutInflater.from(context).inflate(R.layout.title,this)
        binding = TitleBinding.inflate(LayoutInflater.from(context), this, true)
//        为返回按钮注册点击事件
//        context参数实际上是一个 Activity 实例，在返回按钮的点击事件里，使用关键字 as 先转换为 Activity 类型再销毁
        binding.titleBack.setOnClickListener {
            val activity = context as Activity
            activity.finish()
        }
//        为编辑按钮注册事件
        binding.titleEdit.setOnClickListener {
            Toast.makeText(context,"编辑",Toast.LENGTH_SHORT).show()
        }

    }
}