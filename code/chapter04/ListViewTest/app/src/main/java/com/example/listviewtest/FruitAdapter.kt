package com.example.listviewtest

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView

//Activity 实例，ListView子项布局的 id,数据源
class FruitAdapter(activity: Activity, val resourceId: Int, data: List<Fruit> ):ArrayAdapter<Fruit>(activity, resourceId, data){
//    新增的内部类，用于对 ImageView 和 TextView 控件实例进行缓存
    inner class ViewHolder(val fruitImage: ImageView, val fruitName: TextView)

//  在每个子项被滚动到屏幕内时调用
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
//    变量的延迟赋值
        val view: View
        val viewHolder: ViewHolder
        if (convertView == null){
            //      加载传入传入的布局
            view = LayoutInflater.from(context).inflate(resourceId, parent, false)
            val fruitImage: ImageView = view.findViewById(R.id.fruitImage)
            val fruitName: TextView = view.findViewById(R.id.fruitName)
//            缓存数据
            viewHolder = ViewHolder(fruitImage, fruitName)
            view.tag = viewHolder
        } else {
            view = convertView
            viewHolder = view.tag as ViewHolder
    }

//        val view = FriutItemBinding.inflate(LayoutInflater.from(context), this, false)
//        val fruitName:TextView = view.fruitName
//        val fruitImage:ImageView = view.fruitImage
//        获取当前 Fruit 实例
        val fruit = getItem(position)
        if (fruit != null){
            viewHolder.fruitImage.setImageResource(fruit.imageId)
            viewHolder.fruitName.text = fruit.name
        }
        return view
    }
}