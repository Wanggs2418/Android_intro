package com.example.learn_kotlin

import kotlin.math.max

fun main(){
    val student = Student("汪洋",19)
    doStudy(student)

}
//接收一个Study类型函数
//调用Study接口的函数，面向接口编程，即多态
fun doStudy(study: Study){
    study.readBooks()
    study.doHomework()
}

//类型匹配,注意此处的 Number 类型是Float,Long,Double等类型的父类
fun checkNumber(num:Number){
    when (num){
        //is 相当于 Java 中的 instanceof
        is Int -> println("number is Int")
        is Double -> println("number is Double")
        else -> println("number not find")
    }
}
fun maxNumber(par1:Int,par2:Int):Int {
    return max(par1,par2)
}