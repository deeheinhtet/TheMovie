import org.jetbrains.kotlin.gradle.targets.js.dsl.ExperimentalWasmDsl
import org.jetbrains.kotlin.gradle.targets.js.webpack.KotlinWebpackConfig
import co.touchlab.skie.configuration.EnumInterop
import co.touchlab.skie.configuration.FlowInterop
import co.touchlab.skie.configuration.SealedInterop
import co.touchlab.skie.configuration.SuspendInterop

plugins {
    alias(libs.plugins.kotlinMultiplatform)
    alias(libs.plugins.androidLibrary)
    kotlin("plugin.serialization") version "1.9.22"
    id("co.touchlab.skie") version "0.6.1"
}

kotlin {
    androidTarget {
        compilations.all {
            kotlinOptions {
                jvmTarget = "11"
            }
        }
    }
    jvm()
    listOf(
        iosX64(),
        iosArm64(),
        iosSimulatorArm64()
    ).forEach { iosTarget ->
        iosTarget.binaries.framework {
            baseName = "Shared"
            isStatic = true
            export(project(":shared:core-ui"))
            export(project(":shared:core-network"))
            export(project(":shared:core-common"))
            export(project(":shared:core-localdata"))
            export(project(":shared:features:home"))
            export(project(":shared:features:details"))
        }
    }

    sourceSets {
        commonMain.dependencies {
            //put your multiplatform dependencies here
            implementation(libs.kotlinx.coroutines.core)
            implementation(libs.kotlinx.serialization.json)
            implementation(libs.koin.core)


            api(project(":shared:core-ui"))
            api(project(":shared:core-network"))
            api(project(":shared:core-common"))
            api(project(":shared:core-localdata"))
            api(project(":shared:features:home"))
            api(project(":shared:features:details"))
        }


        commonTest.dependencies {
            implementation(libs.kotlin.test)
            implementation(kotlin("test-common"))
            implementation(kotlin("test-annotations-common"))
        }

    }
}


android {
    namespace = "com.dee.themovie.shared"
    compileSdk = libs.versions.android.compileSdk.get().toInt()
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_11
        targetCompatibility = JavaVersion.VERSION_11
    }
    defaultConfig {
        minSdk = libs.versions.android.minSdk.get().toInt()
    }
}


skie {
    features {
        group {
            EnumInterop.Enabled(true)
            EnumInterop.LegacyCaseName(true)
            SealedInterop.Enabled(true)
            coroutinesInterop.set(true)
            SuspendInterop.Enabled(true)
            FlowInterop.Enabled(true)
        }
    }
}

