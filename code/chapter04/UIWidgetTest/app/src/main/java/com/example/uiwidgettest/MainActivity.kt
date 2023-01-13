package com.example.uiwidgettest

import android.app.Activity
import android.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.uiwidgettest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() , View.OnClickListener {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        另一种 button 响应写法
        binding.button.setOnClickListener(this)
    }
//通过按钮获取 EditText 输入的内容
    override fun onClick(v: View?) {
        when (v?.id){
            R.id.button -> {
                val inputText = binding.editText.text.toString()
                Toast.makeText(this,inputText,Toast.LENGTH_SHORT).show()
//                点击后触发更换照片
                binding.imageView.setImageResource(R.drawable.img_02)
                binding.progressBar.progress = binding.progressBar.progress + 10
                AlertDialog.Builder(this).apply {
                    setTitle("这是一个对话窗口")
                    setMessage("传递的信息")
                    setCancelable(false)
                    setPositiveButton("确认"){
                        dialog,which ->
                    }
                    setNegativeButton("取消"){
                        dialog,which ->
                    }
                    show()
                }
            }
        }
    }

}