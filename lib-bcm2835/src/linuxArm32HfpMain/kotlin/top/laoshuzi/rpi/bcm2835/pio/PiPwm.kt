package top.laoshuzi.rpi.bcm2835.pio

import top.laoshuzi.rpi.bcm2835.pio.impl.Bcm2835Pwm

enum class PiPwm(val pwm: Bcm2835Pwm) {

    PWM0(Bcm2835Pwm());

}