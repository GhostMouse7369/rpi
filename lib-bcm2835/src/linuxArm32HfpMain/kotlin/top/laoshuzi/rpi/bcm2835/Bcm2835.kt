package top.laoshuzi.rpi.bcm2835

import lib.bcm2835.*
import top.laoshuzi.rpi.bcm2835.common.exception.IOException
import top.laoshuzi.rpi.bcm2835.common.utils.Log

object Bcm2835 {

    fun init() {
        Log.d("bcm2835_init()")
        if (bcm2835_init() == 0)
            throw IOException("初始化bcm2835失败")
        println("打开bcm2835")
    }

    fun close() {
        Log.d("bcm2835_close()")
        bcm2835_close()
        println("关闭bcm2835")
    }

    fun delay(millis: Long) {
        bcm2835_delay(millis.toUInt())
    }

}

