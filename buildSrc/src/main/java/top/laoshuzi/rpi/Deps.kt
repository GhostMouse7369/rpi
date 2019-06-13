package top.laoshuzi.rpi

/**
 * Created by mouse on 2019/6/13.
 */
public object Deps {

    public object KotlinStdlib {
        public const val base = "org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}"
        public const val common = "org.jetbrains.kotlin:kotlin-stdlib-common:${Versions.kotlin}"
        public const val jdk7 = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        public const val jdk8 = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.kotlin}"
        public const val js = "org.jetbrains.kotlin:kotlin-stdlib-js:${Versions.kotlin}"
    }

    public object KotlinxCoroutines {
        public const val base = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.kotlinx_coroutines}"
        public const val common = "org.jetbrains.kotlinx:kotlinx-coroutines-core-common:${Versions.kotlinx_coroutines}"
        public const val native = "org.jetbrains.kotlinx:kotlinx-coroutines-core-native:${Versions.kotlinx_coroutines}"
        public const val js = "org.jetbrains.kotlinx:kotlinx-coroutines-core-js:${Versions.kotlinx_coroutines}"
        public const val android = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.kotlinx_coroutines}"
    }

    public object KotlinxSerializationRuntime {
        public const val base = "org.jetbrains.kotlinx:kotlinx-serialization-runtime:${Versions.kotlinx_serialization_runtime}"
        public const val common = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-common:${Versions.kotlinx_serialization_runtime}"
        public const val native = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-native:${Versions.kotlinx_serialization_runtime}"
        public const val js = "org.jetbrains.kotlinx:kotlinx-serialization-runtime-js:${Versions.kotlinx_serialization_runtime}"
    }

    public object Ktor {
        public const val common = "io.ktor:ktor-client-core:${Versions.ktor}"
        public const val native = "io.ktor:ktor-client-curl:${Versions.ktor}"
        public const val js = "io.ktor:ktor-client-js:${Versions.ktor}"
        public const val android = "io.ktor:ktor-client-android:${Versions.ktor}"
        public const val ios = "io.ktor:ktor-client-ios:${Versions.ktor}"
    }
}