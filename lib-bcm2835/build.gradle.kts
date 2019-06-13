plugins {
    kotlin("multiplatform") version "1.3.31"
}

group = "top.laoshuzi.rpi"
version = "1.0-SNAPSHOT"

repositories {
    mavenCentral()
}

kotlin {
    linuxArm32Hfp {
        compilations["main"].apply {
            cinterops {
                create("libbcm2835")
            }
        }
    }
}