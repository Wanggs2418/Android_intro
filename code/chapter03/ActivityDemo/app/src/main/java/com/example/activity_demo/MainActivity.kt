package com.example.activity_demo

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.activity_demo.databinding.ActivityMainBinding


class MainActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//      实际调用的是 getTaskId()方法
        Log.d("主程序","Task id is $taskId")
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        intent穿梭不同的activity,显示intent明确之处切换的activity
        binding.button1.setOnClickListener {
            SecondActivity.actionStart(this,"传递到第二个活动的数据1","传递到第二个活动的数据2")

        }

    }

//    显示生命周期阶段
    override fun onRestart() {
        super.onRestart()
        Log.d("主程序重启","onResart")
    }

//    菜单选项设置
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.add_item -> Toast.makeText(this,"添加成功",Toast.LENGTH_SHORT).show()
            R.id.remove_item -> Toast.makeText(this, "删除成功", Toast.LENGTH_SHORT).show()
        }
        return true
    }

}