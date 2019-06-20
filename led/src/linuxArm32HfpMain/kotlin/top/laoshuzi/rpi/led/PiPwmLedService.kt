package top.laoshuzi.rpi.led

import top.laoshuzi.rpi.bcm2835.pio.PiPwm
import top.laoshuzi.rpi.bcm2835.pio.Pwm

/**
 * Created by mouse on 2019/6/13.
 */
class PiPwmLedService : PiLedService(), PwmLedService {

    private var pwm: Pwm = PiPwm.PWM0.pwm

    init {
        pwm.setPwmFrequencyHz(50f)
    }

    override fun openLed() {
        super.openLed()
        pwm.setEnabled(true)
    }

    override fun closeLed() {
        super.closeLed()
        pwm.setEnabled(false)
    }

    override fun setLedLight(light: Float) {
        pwm.setPwmDutyCycle(light)
    }

}
