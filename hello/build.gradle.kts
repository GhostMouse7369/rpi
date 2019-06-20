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

    // JVM
//    jvm {
//        compilations["main"].kotlinOptions.jvmTarget = "1.8"
//        compilations["main"].defaultSourceSet {
//            dependencies {
//
//            }
//        }
//    }

    // JS
//    js { }

    // Android
//    android { }

    // Android NDK
//    androidNativeArm32 { }
//    androidNativeArm64 { }

    // iOS
//    iosArm32 { }
//    iosArm64 { }
//    iosX64 { }

    // MacOS
//    macosX64 { }

    // Windows
    mingwX64 {
        binaries.executable {
            entryPoint = "top.laoshuzi.rpi.hello.main"
            linkerOpts = mutableListOf("-LC:/Developer/Libs", "-Lsrc/nativeInterop/c/libs/mingw_x64", "-lhello")
        }
        compilations["main"].apply {
            cinterops {
                create("libhello")
            }
//            val libhello by cinterops.creating {
//                defFile(project.file("src/nativeInterop/cinterop/libhello.def"))
//                packageName("lib.hello")
//                compilerOpts("-Isrc/nativeInterop/c/include")
//                includeDirs(project.file("src/nativeInterop/c/include/"))
//                headers("src/nativeInterop/c/include/hello.h", "src/nativeInterop/c/include/hello2.h")
//            }
            defaultSourceSet {
                dependencies {
                    implementation(Deps.kotlin.stdlib.it)
                    implementation(Deps.kotlinx.coroutines.native)
                    implementation(Deps.kotlinx.serialization_runtime.native)
                }
            }
        }
    }

    // Linux
    linuxArm32Hfp {
        binaries.executable {
            entryPoint = "top.laoshuzi.rpi.hello.main"
            linkerOpts = mutableListOf("-Lsrc/nativeInterop/c/libs/linux_arm32", "-lhello")
        }
        compilations["main"].apply {
            cinterops {
                create("libhello")
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
//    linuxMips32 { }
//    linuxMipsel32 { }
    linuxX64 {
        binaries.executable {
            entryPoint = "top.laoshuzi.rpi.hello.main"
            linkerOpts = mutableListOf("-Lsrc/nativeInterop/c/libs/linux_x64", "-lhello")
        }
        compilations["main"].apply {
            cinterops {
                create("libhello")
            }
            defaultSourceSet {
                dependencies {
                    implementation(Deps.kotlin.stdlib.it)
                    implementation(Deps.kotlinx.coroutines.native)
                    implementation(Deps.kotlinx.serialization_runtime.native)
                }
            }
        }
    }

    // WebAssembly
//    wasm32 { }


}

