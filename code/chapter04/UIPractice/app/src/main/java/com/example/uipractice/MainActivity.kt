package com.example.uipractice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.uipractice.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private val msgList = ArrayList<Msg>()
    private var adapter: MsgAdapter? = null
    private lateinit var  binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
//        初始化交流数据
        initMsg()
//        构建RecycleView:指定一个 LayoutManager和适配器
        val layoutManager = LinearLayoutManager(this)
        binding.recyclerView.layoutManager = layoutManager
        adapter = MsgAdapter(msgList)
        binding.recyclerView.adapter = adapter
//        对点击发送按钮设置响应事件
        binding.send.setOnClickListener(this)
    }

//    响应事件：获取EditText内容
    override fun onClick(v: View?) {
        when (v) {
            binding.send -> {
                val content = binding.inputText.text.toString()
//                字符串不为空，创建一个新的 Msg对象并添加到msgList列表中
                if (content.isNotEmpty()) {
                    val msg = Msg(content, Msg.TYPE_SENT)
                    msgList.add(msg)
//                    有新消息时，调用适配器的方法，刷新RecyclerView的显示
                    adapter?.notifyItemInserted(msgList.size - 1)
//                    RecyclerView 定位到最后一行
                    binding.recyclerView.scrollToPosition(msgList.size - 1)
//                    清空框的内容
                    binding.inputText.setText("")
                }
            }
        }
    }

    private fun initMsg() {
        val msg1 = Msg("交流交流",Msg.TYPE_RECEIVED)
        msgList.add(msg1)
        val msg2 = Msg("嘿嘿，哈哈",Msg.TYPE_SENT)
        msgList.add(msg2)
        val msg3 = Msg("就这吧，哦！",Msg.TYPE_RECEIVED)
        msgList.add(msg3)
    }
}