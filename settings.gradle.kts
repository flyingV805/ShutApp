pluginManagement {
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven { url = uri("https://jitpack.io") }
    }
}

rootProject.name = "ShutApp"
include(":app")
include(":core:common")
include(":feature:launch")
include(":feature:login")
include(":core:matrixFlow")
include(":navigation:navigatorApi")
include(":navigation:navigatorImpl")
include(":core:featureApi")
include(":feature:headsup")
include(":core:cleanmvi")
include(":uikit")
include(":feature:home")
include(":feature:notifications")
