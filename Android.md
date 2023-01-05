# Android

参考教程：https://www.runoob.com/w3cnote/android-tutorial-intro.html

Android 官网：https://developer.android.google.cn/index.html

中文网站：https://www.androiddevtools.cn/index.html

## 第 1 章 基础

### 1.1 历史

2003 年 10 月，Andy Rubin 创建 Android 公司，05 年 8 月被谷歌收购，同年 9 月，谷歌推出首个 Android 系统，即 Android 1.0 系统，而 Android 系统的命名都是以点心来命名的。

### 1.2 Android 系统架构

**1.Linux 内核层**

- Android 系统基于 Linux 内核，为 Android 设备的各种硬件提供底层驱动
- 如显示驱动，蓝牙驱动，电源管理等

**2.系统运行库**

- Libraries(库) + Android Runtime(Android运行时)
- 通过 C/C++ 库来为 Android 系统提供主要的特性支持
- 如 SQLite 库提供数据库支持，Webkit 提供浏览器内核的支持等

**3.应用框架层**

- Application Framework(应用程序框架层) 
- 提供构建应用程序时用到的各种 API，不必关心底层的实现

**4.应用层**

- Application(应用程序层) 
- 所有的手机应用程序都属于这一层

<img src="image/11.jpg" style="zoom: 67%;" />

### 1.3 Android 系统开发特色

**1.四大组件**

- 活动(Activity)：应用中看到的所有东西都放在活动中
- 服务(Service)：后台默默执行，即使退出应用，服务仍继续
- 广播接收器(Broadcast Receiver)：允许应用接受来自各处的广播消息，电话、短信等
- 内容提供器(Content Provider)：支持应用程序间共享数据

**2.丰富的控件**

系统自带丰富的控件效果，也可以定制属于自己的控件

**3.SQLite 数据库**

轻量级、运算速度快的嵌入式关系型数据库，支持 SQL 语法，可通过 API 进行操作

**4.强大的多媒体**

Anroid 系统提供丰富的多媒体服务，如音乐、录音、拍照、视频等，都可以在程序中通过代码控制

**5.地理位置定位**

Android 手机都内置有 GPS，结合地图功能，基于位置的服务(LBS，Location Based Services) 领域前景广阔



### 1.4 术语解释

- **Gradle：**是一个开源的项目自动化构建工具，建立在 Apache Ant 和 Apache Maven概念的基础上，并引入了基于Groovy的特定邻域语言（DSL），主要用于自动化地进行软件构建、测试、发布、部署、软件打包的项目
- **AVD：** (android virtual machine):安卓虚拟设备,就是安卓的模拟器
- **ADT：** (android development tools)安卓开发工具
- **SDK：**(software development kit)软件开发工具包,就是安卓系统,平台架构等的工具集合,如adb.exe
- **adb：**安卓调试桥,在sdk的platform-tools目录下,功能很多,命令行必备
- **DDMS：**(dalvik debug monitor service)安卓调试工具
- **AAPT：**(android asset packing tool),安卓资源打包工具

### 1.5 目录介绍

**1.目录切换**

<img src="image/15.jpg" style="zoom:67%;" />

显示的目录并不是真实的目录结构，而是被 Android Studio 转换过的，从而使得项目结构简介，便于开发，但对新人不友好，故需从  `Android` 选项切换到 `Project` 选项。

**2.Project 目录介绍**

<img src="image/14.jpg" style="zoom:67%;" />

- .gradle 和 .idea：放置的是 Android Studio 自动生成的文件，不用关心
- **app：**项目中的代码、资源等内容都是放置在这个目录下的，后面的开发工作也基本是在这个目录下进行  
- **gradle：**包含 gradle wrapper 的配置文件，不需要提前将 gardle 配置好，AS 默认启用
- .gitignore：将指定的目录或文件排除在版本控制之外的  
- build.gradle ：gradle 构建脚本，通常这个文件中的内容是不需要修改
- gradle.properties： 全局的 gradle 配置文件，此处配置的属性将会影响到项目中所有的 gradle 编译脚本  
- gradlew 和 gradlew.bat：在命令行界面中执行 gardle 命令，前者 Mac 或 Linux 中用，后者用于 Windows
- local.properties： 用于指定本机中的 Android SDK 路径，通常自动生成，无需修改
- settings.gradle：指定项目中所有引入的模块，通常模块引入是自动完成的

**3.app 目录介绍**

<img src="image/16.jpg" style="zoom: 80%;" />

- build：包含编译时自动生成的文件，无需关心
- libs：放置第三方的 jar 包，从而 jar 包自动添加到项目的构建路径中
- androidTest：编写 Android Test 测试用例，对项目进行一些自动化的测试
- **java：**放置 java/Kotlin 代码处，系统自动生成一个 MainActivity 文件
- **res：**项目中使用到的所有图片、布局、字符串等资源都要存放在这个目录下。当然这个目录下还有很多子目录，图片放在 drawable 目录下，布局放在 layout 目录下，字符串放在 values 目录下等
- **AndroidManifest.xml ：**整个Android项目的配置文件，程序中定义的所有四大组件都需要在这个文件里注
  册，另外还可以在这个文件中给应用程序添加权限声明  
- test：编写 Unit Test 测试用例，项目自动化测试的一种方式
- build.gradle ： app 模块的 gradle 构建脚本，指定很多项目构建相关的配置
- proguard-rules.pro：指定项目代码的混淆规则，将代码打包成安装包文件后，如果不希望代码被别人破解，通常会将代码进行混淆，从而让破解者难以阅读

- **gradle-wrapper.properties：**显示 gradle 的下载地址以及当前项目使用到的版本号，很多时候，导入项目不成功可能这个版本号不匹配而导致的


**4.res 目录介绍**

<img src="image/17.jpg" style="zoom:80%;" />

- drawable 用来放图片
- mipmap 用来放应用图标
- values 用来放字符串、样式、颜色等
- layout 用来放布局文件

### 1.6 首个项目分析

Android 程序设计讲究的是**逻辑**和**视图**分离，不建议直接在活动中直接编写界面。一般是在布局文件中编写界面，而后在活动中引来。

定义了一个应用程序的字符串后，引用方式如下：

- **代码中：**通过 R.string.app_name 获得字符串的引用
- **XML中：**通过 @string/app_name 获得字符串的应用

不同于 Eclipse，AS 采用 Gradle 来创建项目，摒弃了传统基于 XML (如 Ant 和 Maven)的各种繁琐设置。

AS 项目共有 3 种依赖方式：

- 本地依赖：对本地的 jar 包或目录添加依赖关系
- 库依赖：对项目中的库模块添加依赖关系
- 远程依赖：对 jcenter 仓库的开源项目添加依赖

### 1.7 日志工具的使用

日志的工具类为 Log(android.util.log)，此类有 5 种方法来打印日志：

- `Log.v()`：级别 verbose(冗长的)，用于打印琐碎、意义最小的日志信息，日志级别中最低的一种
- `Log.d()`：级别 debug，打印调试信息
- `Log.i()`：级别 info，打印比较重要的数据，用于分析用户行为的数据
- `Log.w()`：级别 warn，打印一些警告信息，提示该地方可能存在潜在的风险
- `Log.e()`：级别 error，打印程序中的错误信息

**为什么不用 println()**

特别不建议用 `System.out.println()` 或 `println()` 来打印日志，唯一的方便就是输入 `sout` 自动生成。但缺点很多，日志开关不可控、日志无级别区分、不能添加日志标签等。

Log 配合 Logcat 使用十分强大，其中 Logcat 可以添加 3 种过滤器：

![](image/18.jpg)

- Show only selected application ：只显示当前选中程序的日志
- Firebase：为 google 提供的一个开发者工具和基础框架平台
- No Filters：相当于没有过滤器
- Edit Filter Configurdation：进行过滤器的配置和创建

## 第 2 章 Kotlin简介

### 2.1 Java 和 Kotlin

**Java运行机制**

编译语言一般分为两类

- 编译型语言：将编写的代码一次性编译成二进制文件，而后直接执行，如 C 和 C++
- 解释性语言：带有解释器，一行行读取代码，实时将源码解释为二进制数据后执行，效率差些，如 Python、JavaScript等

**准确来讲，Java 是解释性语言。**Java 代码是先编译再运行，但编译后生成的是一种特殊的 class 文件，此文件只有 Java 虚拟机才能识别，此时 Java 虚拟机充当的角色就是解释器，最终将 class 文件解释成计算机可识别的二进制数据后再执行。

Java 虚拟机不关心 class 文件是从 Java 编译来的，还是从 Kotlin 编译来的，只要符合 class 文件，都能识别，这也是 Kotlin 的工作原理。

**出色的 Kotlin**

- 语法更简洁，同样的功能的实现，代码量远低于 Java 开发的代码量
- 语法更高级，增加了现代高级语言的语法特性，同时安全性也更高
- **与 Java 100%兼容**，可直接调用 Java 编写的代码，也可以使用 Java 第三方开源库
- 相当于 Java 的现代加强版本

### 2.2 变量和函数

**变量**

kotlin 定义的变量前只有两种关键字：val 和 var，满足要求是尽量优先使用 val，这样的程序更健壮。

- val(value)：声明一个不可变的变量，对应 Java 中的 final。
- var(variable)：可变的变量，初始赋值后可重新赋值。

每一行不用加分号，对于变量的类型，kotlin 拥有出色的类型推导机制，可根据赋予值的不同，自动判断变量的类型。当然，如果对一个变量延迟赋值的话，kotlin 则无法自动推导它的类型，则此时需要显示声明类型：

```kotlin
val a1 = 10
val a2 = '10'
val a3:Int = 10
```

kotlin 抛弃了 Java 基本数据类型，全部使用对象数据类型，在 Java 中 int 为关键字，而在 kotlin 中 Int 为一个类，拥有自己的方法和继承结构。

**函数**

Java 创建的方法：

<img src="image/19.jpg" style="zoom: 80%;" />

`main` 函数为程序入口函数，程序都是从 `main` 函数处开始执行。

fun 函数名(参数名：参数类型，参数名：参数类型，...)：返回值的数据类型{

​	函数体

}

```kotlin
fun kotlin_fun(param1:Int,param2:String):Float{
    return 3.1415926
}
//对于函数只有一行代码时候,可直接将其写到尾部
fun maxNumber(num1:Int,num2:Int):Int = max(num1,num2)
//进一步简化，因为max()返回的是 Int 类型
fun maxNumber(num1:Int,num2:Int) = max(num1,num2)

```

### 2.3 程序的逻辑控制

**if 语句**

与 java 的 if 语句几乎没有区别，对 maxNumber() 函数改写：

```kotlin
fun maxNumber(num1:Int,num2:Int):Int {
    var value = 0
    if (num1 >num2){
        value = num1
    }else{
        value = num2
    }
    return value
}
```

kotlin 中 if 语句的额外功能是，它可以有返回值。如下 if 语句使用每个条件的最后一行代码作为返回值，并将其赋给 value 变量。

```kotlin
fun maxNumber(num1:Int,num2:Int):Int {
    var value = if (num1 > num2){
         num1
    }else{
         num2
    }
    return value
}
//进一步简化
fun maxNumber(num1:Int,num2:Int):Int {
    return if (num1 > num2){
         num1
    }else{
         num2
    }
}
//最终版
fun maxNumber(num1:Int,num2:Int) = if (num1 > num2) num1 else num2
```

**when 语句**

kotlin 中的 when 类似 Java 中 switch 语句，但其特性更强。

```kotlin
//字符串精确匹配
fun getScore(name:String) = when (name){
    "Tom" -> 86
    "Jim" -> 56
    else -> 0
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
```

适用于一些特殊情况的 when 不带参数的写法：

```kotlin
//Kotlin 判断字符串或对象是否相等可直接使用 ==
//而 Java 则需要使用 equals() 方法
fun getScore(name:String) = when {
    //所有以 “Tom” 开头的名字都是 60
    name.startsWith("Tom") -> 60
    name == "Jim" -> 100
    else -> 0
}
```

**循环语句**

while 语句和 Java 一样，差别在于 for 语句，以 for-in 循环为主导：

```kotlin
//Kotlin 独有的区间形式,表示[0,10]的闭区间，.. 为创建区间的关键字
val range = 0..10
//双端闭区间
fun test01(){
    for (i in 0..10){
        println(i)
    }
}
```

更为常用的是单端闭区间，0 until 10 即为 [0，10)，默认情况是在区间范围内递增 1。

```kotlin
fun main(){
    for (i in 0 until 10 step 2){
        println(i)
    }
}
```

降序区间，downTo 关键字：

```kotlin
//[10,1]降序区间
fun main(){
    for (i in 10 downTo 1){
        println(i)
    }
}
```

### 2.4 面向对象

对象的实例化是：`val p = Person()`，没有 Java 中的 `new` 关键字。

**继承：**Student 类可继承 Person 类，从而自动拥有 Person 类中的属性和方法，同时 Student 还可以定义自己独有的属性和方法。

Kotlin 类继承需满足两点

**对于 Java 高效编程：一个类如果不是为继承而设计，就应主动加上 final 声明，禁止被继承**

- 确保类本身可以被继承，加 open 关键字，这与 Java 不同。Kotlin 中任何一个非抽象类默认都是不可以被继承的，相当于给类声明了 final 关键字，与 var 和 val 相似，类最好都是不可变的。如果允许继承，则无法预知子类如何实现，可能存在风险
- 让 Student 类继承 Person 类，Java 继承的关键字是 extends，而 Kotlin 中继承的写法为冒号，但要注意类 Person 后面加的括号

```kotlin
open class Person {
    var name = ""
    fun eat(){
        println(name + " is eating...,and he is " + age + "years old.")
    }
}
//继承,注意类后面加的括号()
class Student:Person(){
    var sno = ""
    var gradle = 0
}
```



