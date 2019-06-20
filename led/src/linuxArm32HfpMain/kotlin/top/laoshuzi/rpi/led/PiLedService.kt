package top.laoshuzi.rpi.led

import lib.bcm2835.*

/**
 * Created by mouse on 2019/6/13.
 */
open class PiLedService : LedService {

    private val pin = RPI_GPIO_P1_11.toUByte()

    init {
        bcm2835_gpio_fsel(pin, BCM2835_GPIO_FSEL_OUTP.toUByte())
    }

    override fun openLed() {
        bcm2835_gpio_write(pin, LOW)
    }

    override fun closeLed() {
        bcm2835_gpio_write(pin, HIGH)
    }
}
