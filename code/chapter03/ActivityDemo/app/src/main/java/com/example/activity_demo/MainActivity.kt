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


class MainActivity:AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        intent穿梭不同的activity,显示intent明确之处切换的activity
        binding.button1.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)
            startActivityForResult(intent,1)
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (requestCode){
            1 -> if (requestCode == RESULT_OK){
                val returnedData = data?.getStringExtra("data_retun")
                Log.d("MainActivity","回溯数据是 $returnedData")
            }
        }
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