package top.laoshuzi.rpi.led

/**
 * Created by mouse on 2019/6/13.
 */
interface PwmLedService : LedService {

    fun setLedLight(light: Float)

}