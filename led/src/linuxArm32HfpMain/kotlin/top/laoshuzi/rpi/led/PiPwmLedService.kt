package top.laoshuzi.rpi.led

import top.laoshuzi.rpi.bcm2835.pio.Pwm
import top.laoshuzi.rpi.bcm2835.pio.impl.Bcm2835Pwm

/**
 * Created by mouse on 2019/6/13.
 */
class PiPwmLedService : PiLedService(), PwmLedService {

    private var pwm: Pwm = Bcm2835Pwm()

    init {
        pwm.setPwmFrequencyHz(100f)
    }

    override fun openLed() {
        super.openLed()
        pwm.setEnabled(true)
    }

    override fun closeLed() {
        super.closeLed()
//        pwm.setEnabled(false)
    }

    override fun setLedLight(light: Float) {
        pwm.setPwmDutyCycle(light)
    }

}
