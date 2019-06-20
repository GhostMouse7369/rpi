package top.laoshuzi.rpi.led

import top.laoshuzi.rpi.bcm2835.Bcm2835

/**
 * Created by mouse on 2019/6/13.
 */
fun main(args: Array<String>) {

    val count = args[0].toInt()

    println("led blink")
    val bcm2835 = Bcm2835.INSTANCE

    val ledService: PwmLedService = PiPwmLedService()

    ledService.openLed()
    for (i in 1..count) {
        println("blink[$i]")
        ledService.setLedLight(i.toFloat() % 100)
        bcm2835.delay(100)
    }
    ledService.closeLed()
//    for (i in 1..count) {
//        println("blink[$i]")
//        ledService.closeLed()
//        bcm2835.delay(200)
//        ledService.openLed()
//        bcm2835.delay(1000)
//    }

    println("end")
    bcm2835.close()
}

