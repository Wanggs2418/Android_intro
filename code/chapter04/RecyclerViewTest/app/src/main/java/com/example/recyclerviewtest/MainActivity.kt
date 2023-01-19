package com.example.recyclerviewtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.example.recyclerviewtest.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val fruitList = ArrayList<Fruit>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        初始化水果数据
        initFruits()
//        创建一个 LinearLayout 对象，线性布局
//        val layoutManager = LinearLayoutManager(this)
//        layoutManager.orientation = LinearLayoutManager.HORIZONTAL
//        设置到 RecyclerView 中，即指定 RecyclerView 布局方式
        val layoutManager = StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL)
//        val layoutManager = GridLayoutManager(this,4,1,true)
        binding.recyclerView.layoutManager = layoutManager
//        创建适配器 FruitAdapter 实例，并将数据传入其构造函数中
        val adapter = FruitAdapter(fruitList)
//        嗲用setAdapter()方法完成适配器的设置
        binding.recyclerView.adapter = adapter
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
            fruitList.add(Fruit("草莓测试文本有点长，关于草莓的那些事情。草莓的测试文本书写，到长度了吗？？继续延伸下去",R.drawable.strawberry_pic))
            fruitList.add(Fruit("樱桃",R.drawable.cherry_pic))
            fruitList.add(Fruit("芒果",R.drawable.mango_pic))
        }
    }
}