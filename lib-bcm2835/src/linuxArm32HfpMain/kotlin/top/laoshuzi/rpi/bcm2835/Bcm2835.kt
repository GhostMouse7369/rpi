package top.laoshuzi.rpi.bcm2835

import lib.bcm2835.*

enum class Bcm2835 {
    INSTANCE;

    init {
        println("初始化bcm2835...")
        if (bcm2835_init() == 0) {
            println("初始化bcm2835失败")
        }else{
            println("初始化bcm2835成功")
        }

    }

    fun close(){
        println("关闭bcm2835")
    }

}