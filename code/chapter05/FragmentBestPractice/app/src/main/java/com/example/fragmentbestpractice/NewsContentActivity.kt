package com.example.fragmentbestpractice

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.fragmentbestpractice.databinding.ActivityNewsContentBinding
import com.example.fragmentbestpractice.databinding.NewsContentFragBinding

class NewsContentActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsContentBinding

    companion object {
        fun actionStart(context: Context, title:String, content:String){
            val intent = Intent(context, NewsContentActivity::class.java).apply {
                putExtra("news_title",title)
                putExtra("news_content",content)
            }
            context.startActivity(intent)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_content)
        //    获取先问标题和内容
        val title = intent.getStringExtra("news_title")
        val content = intent.getStringExtra("news_content")
        if (title != null && content != null){
            val fragment = NewsContentFragment()
            //刷新NewsContent界面
            fragment.refresh(title, content)
        }
    }

}