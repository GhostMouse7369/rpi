package top.laoshuzi.rpi.led

import top.laoshuzi.rpi.bcm2835.Bcm2835

/**
 * Created by mouse on 2019/6/13.
 */
fun main(args: Array<String>) {

    println("input[w|b]:")
    when (readLine()!!) {
        "w" -> wiringPiLed()
        "b" -> bcm2835Led()
        else -> throw Exception("input[w|b]")
    }

}

// S:P1-11 V:5v G:Gnd
fun wiringPiLed() {
    val ledService = WiringPiPwmLedService()
    while (true) {
        println("input[0-100]:")
        val light = readLine()?.toInt()!!
        when {
            light <= 0 -> ledService.closeLed()
            light >= 100 -> ledService.openLed()
            else -> ledService.setLedLight(light.toFloat() % 100)
        }
    }
}

// S:P1-12 V:5v G:Gnd
fun bcm2835Led() {
    Bcm2835.init()
    val ledService = PiPwmLedService()
    while (true) {
        println("input[0-100]:")
        val light = readLine()?.toInt()!!
        when {
            light <= 0 -> ledService.closeLed()
            light >= 100 -> ledService.openLed()
            else -> ledService.setLedLight(light.toFloat() % 100)
        }
    }
}
