package top.laoshuzi.rpi.led

import lib.bcm2835.RPI_GPIO_P1_11
import lib.wiring.*
import top.laoshuzi.rpi.bcm2835.common.utils.Log

/**
 * Created by mouse on 2019/6/13.
 */
class WiringPiPwmLedService : PwmLedService {

    private val pin = RPI_GPIO_P1_11.toInt()

    init {
        Log.d("wiringPiSetupGpio")
        wiringPiSetupGpio()
    }

    override fun openLed() {
        Log.d("softPwmCreate($pin,0,100)")
        softPwmCreate(pin, 0, 100)
    }

    override fun closeLed() {
        Log.d("softPwmStop($pin)")
        softPwmStop(pin)
    }

    override fun setLedLight(light: Float) {
        Log.d("softPwmWrite($pin,$light)")
        softPwmWrite(pin, light.toInt())
    }

}
