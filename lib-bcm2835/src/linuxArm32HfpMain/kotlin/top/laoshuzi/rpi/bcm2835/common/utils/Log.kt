package top.laoshuzi.rpi.bcm2835.common.utils

/**
 * Created by mouse on 2019/6/21.
 */
class Log private constructor() {

    init {
        throw Exception("cannot be instantiated")
    }

    companion object {

        var isDebug = true

        fun d(msg: String) {
            if (isDebug)
                Log.i(msg)
        }

        fun i(msg: String) {
            println(msg)
        }

    }
}
