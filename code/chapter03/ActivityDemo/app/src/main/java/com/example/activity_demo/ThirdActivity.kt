package com.example.activity_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.util.Log
import com.example.activity_demo.databinding.ActivityThirdBinding

class ThirdActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("第三个程序","Task id is $taskId")
        val binding = ActivityThirdBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        通过点击按钮可直接退出程序
        binding.button3.setOnClickListener {
            ActivityColletor.finshAll()
//            杀掉当前进程
            android.os.Process.killProcess(android.os.Process.myPid())
        }
    }
}