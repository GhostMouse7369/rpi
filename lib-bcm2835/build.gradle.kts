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
        binaries.sharedLib {
            baseName = "bcm2835"
            linkerOpts = mutableListOf("-Lsrc/nativeInterop/c/libs/linux_arm32", "-lbcm2835")
        }
        compilations["main"].apply {
            cinterops {
                create("libbcm2835")
            }
        }
    }
}