package com.example.learn_kotlin

//注意接口后面无括号，因为其没有构造函数可调用
class Student(name:String,age:Int) :Person(name,age),Study {
    //接口定义了两个函数，故最终需实现接口中的函数
    override fun readBooks() {
        println(name + "正在读书！")
    }

//    override fun doHomework() {
//        println(name + "正在做作业！")
//    }
}