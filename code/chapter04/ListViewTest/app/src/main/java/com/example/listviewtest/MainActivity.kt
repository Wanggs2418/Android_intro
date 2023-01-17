package com.example.listviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import com.example.listviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val fruitList = ArrayList<Fruit>()

//    private val data = listOf("苹果","香蕉","橙子","西瓜","梨","葡萄","菠萝","草莓","樱桃","芒果","苹果","香蕉","橙子","西瓜","梨","葡萄","菠萝","草莓","樱桃","芒果")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        初始化数据
        initFruits()
//        val adapter = ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,data)
        val adapter = FruitAdapter(this, R.layout.friut_item, fruitList)
        binding.listView.adapter = adapter
//        点击事件
        binding.listView.setOnItemClickListener {
            parent, view, position, id ->
            val fruit = fruitList[position]
            Toast.makeText(this, fruit.name, Toast.LENGTH_SHORT).show()
        }
        


    }
    private fun initFruits(){
//        kotlin 标准函数，重复 20 次
        repeat(20){
            fruitList.add(Fruit("苹果",R.drawable.apple_pic))
            fruitList.add(Fruit("香蕉",R.drawable.banana_pic))
            fruitList.add(Fruit("橙子",R.drawable.orange_pic))
            fruitList.add(Fruit("西瓜",R.drawable.watermelon_pic))
            fruitList.add(Fruit("梨",R.drawable.pear_pic))
            fruitList.add(Fruit("葡萄",R.drawable.grape_pic))
            fruitList.add(Fruit("菠萝",R.drawable.pineapple_pic))
            fruitList.add(Fruit("草莓",R.drawable.strawberry_pic))
            fruitList.add(Fruit("樱桃",R.drawable.cherry_pic))
            fruitList.add(Fruit("芒果",R.drawable.mango_pic))
        }
    }
}