package top.laoshuzi.rpi.bcm2835.pio

import top.laoshuzi.rpi.bcm2835.exception.IOException


/**
 * Created by mouse on 2019/6/19.
 */
interface Pwm {

    @Throws(IOException::class)
    fun setEnabled(enable: Boolean)

    @Throws(IOException::class)
    fun setPwmFrequencyHz(freq: Float)

    @Throws(IOException::class)
    fun setPwmDutyCycle(dc: Float)

}