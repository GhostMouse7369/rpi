import top.laoshuzi.rpi.Deps

plugins {
    kotlin("multiplatform") version "1.3.31"
}

group = "top.laoshuzi.rpi"
version = "1.0-SNAPSHOT"

repositories {
    jcenter()
    mavenCentral()
    maven("https://kotlin.bintray.com/kotlinx")
}

kotlin {
    sourceSets.commonMain {
        dependencies {
            api(Deps.kotlin.stdlib.common)
            api(Deps.kotlinx.coroutines.common)
            api(Deps.kotlinx.serialization_runtime.common)
        }
    }
    linuxArm32Hfp {
        binaries.executable {
            baseName = "led"
            entryPoint("top.laoshuzi.rpi.led.main")
            linkerOpts = mutableListOf("-Llibs/linux_arm32", "-lbcm2835")
        }
        compilations["main"].apply {
            defaultSourceSet {
                dependencies {
                    implementation(Deps.kotlin.stdlib.it)

                    implementation(project(":lib-bcm2835"))
                }
            }
        }
    }
}