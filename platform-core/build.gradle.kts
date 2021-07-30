plugins {
    id("com.android.library")
    kotlin("multiplatform")
    kotlin("plugin.serialization")
    id("tz.co.asoft.library")
    id("io.codearte.nexus-staging")
    signing
}

kotlin {
    android { library() }
    jvm { library() }
    js(IR) { library() }

    val targetGroups = mapOf(
        "macos" to listOf(
            macosX64()
        ),
        "ios" to listOf(
            iosArm64(),
            iosArm32(),
            iosX64()
        ),
        "watchos" to listOf(
            watchosArm32(),
            watchosArm64(),
            watchosX86(),
        ),
        "tvos" to listOf(
            tvosArm64(),
            tvosX64()
        ),
        "linux" to listOf(
            linuxArm64(),
            linuxArm32Hfp(),
            linuxX64()
        )
    )

    sourceSets {
        val commonMain by getting {
            dependencies {
                api(kotlinx("serialization-core", vers.kotlinx.serialization))
            }
        }

        val commonTest by getting {
            dependencies {
                api(kotlinx("serialization-json", vers.kotlinx.serialization))
                implementation(kotlin("test"))
            }
        }

        val jsMain by getting {
            dependencies {
                api(npm("platform", vers.npm.platform))
            }
        }

        for ((platform, targets) in targetGroups) {
            val intermediate = create("${platform}Main") {
                dependsOn(commonMain)
            }
            for (target in targets) {
                val main by target.compilations
                main.defaultSourceSet.dependsOn(intermediate)
            }
        }
    }
}


aSoftOSSLibrary(
    version = vers.platform,
    description = "A Kotlin Multiplatform Library for detecting Platforms"
)