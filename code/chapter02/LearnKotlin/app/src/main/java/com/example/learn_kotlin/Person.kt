package com.example.learn_kotlin

//构造含参的构造函数
open class Person (val name:String,val age:Int){

    fun eat(){
        println(name + " is eating...,and he is " + age + "years old.")
    }
}

