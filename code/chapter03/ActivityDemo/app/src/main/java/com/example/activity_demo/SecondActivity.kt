package com.example.activity_demo

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.activity_demo.databinding.ActivitySecondBinding

class SecondActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("第二个程序","Task id is $taskId")
        var binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.button2.setOnClickListener{
            val intent = Intent(this, ThirdActivity::class.java)
            startActivity(intent)
        }
    }
    companion object {
        fun actionStart(context: Context,data1:String,data2:String){
//            apply()函数简写代码
            val intent = Intent(context,SecondActivity::class.java).apply {
                putExtra("param1",data1)
                putExtra("param2",data2)
            }
            context.startActivity(intent)

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d("二程序销毁","onDestory")
    }

    override fun onBackPressed() {
        val intent = Intent()
        intent.putExtra("data_return","按返回键返回")
        setResult(RESULT_OK,intent)
        finish()
    }
}