package top.laoshuzi.rpi.bcm2835.pio.impl

import lib.bcm2835.*
import top.laoshuzi.rpi.bcm2835.Bcm2835

class PiPwm {


    val bcm2835 = Bcm2835.INSTANCE

    var clockFrequency: Double = 0.0

    var channel: UByte = 0.toUByte()
    var markspace: UByte = 1.toUByte()

    var frequency: UInt = 50.toUInt()

    private var range: Double = 0.0;

    init {
        bcm2835_gpio_fsel(RPI_BPLUS_GPIO_J8_12.toUByte(), BCM2835_GPIO_FSEL_ALT5.toUByte())
        setDivisor(1920)
    }

    fun setChannel(channel: Int) {
        this.channel = channel.toUByte()
    }

    fun setMarkspace(markspace: Boolean) {
        this.markspace = if (markspace) 1.toUByte() else 0.toUByte()
    }

    fun setDivisor(divisor: Int) {
        this.clockFrequency = 19200000.0 / divisor
        bcm2835_pwm_set_clock(divisor.toUInt())
    }

    fun setEnabled(enable: Boolean) {
        bcm2835_pwm_set_mode(this.channel, this.markspace, if (enable) 1.toUByte() else 0.toUByte())
    }

    fun setPwmFrequencyHz(Freq: Double) {
        this.range = clockFrequency / Freq
        bcm2835_pwm_set_range(channel, this.range.toUInt())
    }

    fun setPwmDutyCycle(dc: Double) {
        var data: UInt = dc.let {
            when {
                it < 0 -> 0.toUInt()
                it > range -> frequency.toUInt()
                else -> ((0 + range) / 2).toUInt()
            }
        }
        bcm2835_pwm_set_data(channel, data)
    }


}