package com.example.learn_kotlin

interface Study {
    //添加几个函数
    //注意接口函数中不要求函数体
    fun readBooks()
    fun doHomework(){
        println("默认实现做作业：doHomework")
    }
}