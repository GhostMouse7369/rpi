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
            implementation(Deps.kotlin.stdlib.common)
            implementation(Deps.kotlinx.coroutines.common)
            implementation(Deps.kotlinx.serialization_runtime.common)
            implementation(Deps.ktor.it)
        }
    }

    linuxArm32Hfp {
        binaries.sharedLib {
            baseName = "bcm2835"
            linkerOpts = mutableListOf("-Lsrc/nativeInterop/c/libs/linux_arm32", "-lbcm2835")
        }
        compilations["main"].apply {
            cinterops {
                create("libbcm2835")
            }
            defaultSourceSet {
                dependencies {
                    implementation(Deps.kotlin.stdlib.it)
//                    implementation(Deps.kotlinx.coroutines.native)
//                    implementation(Deps.kotlinx.serialization_runtime.native)
                }
            }
        }
    }
}