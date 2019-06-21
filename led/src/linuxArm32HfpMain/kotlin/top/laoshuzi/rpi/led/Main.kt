package top.laoshuzi.rpi.led

import top.laoshuzi.rpi.bcm2835.Bcm2835

/**
 * Created by mouse on 2019/6/13.
 */
fun main(args: Array<String>) {

    val bcm2835 = Bcm2835.INSTANCE
    val ledService: PwmLedService = PiPwmLedService()


    while (true) {
        println("---->:")
        val light = readLine()?.toInt()!!
        when {
            light <= 0 -> ledService.closeLed()
            light >= 100 -> ledService.openLed()
            else -> ledService.setLedLight(light.toFloat() % 100)
        }
    }

//    bcm2835.close()

}

