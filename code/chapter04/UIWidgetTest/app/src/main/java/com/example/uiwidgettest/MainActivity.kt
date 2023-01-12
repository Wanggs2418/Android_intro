package com.example.uiwidgettest

import android.app.Activity
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
                binding.imageView.setImageResource(R.drawable.ic_launcher_background)
                binding.progressBar.progress = binding.progressBar.progress + 10
            }
        }
    }

}