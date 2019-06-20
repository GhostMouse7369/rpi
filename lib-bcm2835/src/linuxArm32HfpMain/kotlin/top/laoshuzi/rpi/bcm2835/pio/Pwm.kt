package top.laoshuzi.rpi.bcm2835.pio

import top.laoshuzi.rpi.bcm2835.exception.IOException


/**
 * Created by mouse on 2019/6/19.
 */
interface Pwm {

    @Throws(IOException::class)
    fun setPwmDutyCycle(var1: Double)

    @Throws(IOException::class)
    fun setPwmFrequencyHz(var1: Double)

    @Throws(IOException::class)
    fun setEnabled(var1: Boolean)

}