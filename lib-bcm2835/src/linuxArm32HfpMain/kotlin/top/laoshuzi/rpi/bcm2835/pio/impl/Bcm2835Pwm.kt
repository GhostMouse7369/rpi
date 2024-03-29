package top.laoshuzi.rpi.bcm2835.pio.impl

import lib.bcm2835.*
import top.laoshuzi.rpi.bcm2835.common.utils.Log
import top.laoshuzi.rpi.bcm2835.pio.Pwm

class Bcm2835Pwm : Pwm {

    private var clockFrequency: Float = 0f
    private var range: Float = 0f

    var channel: UByte = 0.toUByte()
    var markspace: UByte = 1.toUByte()

    init {
        Log.d("bcm2835_gpio_fsel($RPI_BPLUS_GPIO_J8_12, $BCM2835_GPIO_FSEL_ALT5)")
        bcm2835_gpio_fsel(RPI_BPLUS_GPIO_J8_12.toUByte(), BCM2835_GPIO_FSEL_ALT5.toUByte())
        setDivisor(192)
    }

    fun setChannel(channel: Int) {
        this.channel = channel.toUByte()
    }

    fun setMarkspace(markspace: Boolean) {
        this.markspace = if (markspace) 1.toUByte() else 0.toUByte()
    }

    fun setDivisor(divisor: Int) {
        this.clockFrequency = 19200000f / divisor
        Log.d("bcm2835_pwm_set_clock($divisor)")
        bcm2835_pwm_set_clock(divisor.toUInt())
    }

    override fun setEnabled(enable: Boolean) {
        Log.d("bcm2835_pwm_set_mode($channel,$markspace,${if (enable) 1 else 0})")
        bcm2835_pwm_set_mode(this.channel, this.markspace, if (enable) 1.toUByte() else 0.toUByte())
    }

    override fun setPwmFrequencyHz(freq: Float) {
        this.range = clockFrequency / freq

        Log.d("bcm2835_pwm_set_range($channel,$range)")
        bcm2835_pwm_set_range(channel, this.range.toUInt())
    }

    override fun setPwmDutyCycle(dc: Float) {
        var dutyCycle: Float = dc.let {
            when {
                it < 0 -> 0f
                it > 100 -> 100f
                else -> dc
            }
        }
        val data = this.range / 100 * dutyCycle

        Log.d("bcm2835_pwm_set_data($channel,$data)")
        bcm2835_pwm_set_data(channel, data.toUInt())
    }

}