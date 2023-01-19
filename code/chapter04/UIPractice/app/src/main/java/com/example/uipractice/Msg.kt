package com.example.uipractice

class Msg(val content: String, val type: Int) {
//    静态类方法
    companion object {
        const val TYPE_RECEIVED = 0
        const val TYPE_SENT = 1
    }
}