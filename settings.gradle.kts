rootProject.name = "TheMovie"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    repositories {
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
        google()
        gradlePluginPortal()
        mavenCentral()
    }
}

dependencyResolutionManagement {
    repositories {
        google()
        mavenCentral()
        maven("https://maven.pkg.jetbrains.space/public/p/compose/dev")
    }
}

include(":composeApp")
include(":shared")
include(":shared:core-ui")
include(":shared:core-network")
include(":shared:core-common")
include(":shared:core-localdata")
include(":shared:features:home")
include(":shared:features:details")
include(":shared:features:appcommon")
