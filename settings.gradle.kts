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
    }
}

rootProject.name = "ShutApp"
include(":app")
include(":core:commonImpl")
include(":feature:launch")
include(":feature:login")
include(":core:matrixFlow")
include(":navigation:navigatorApi")
include(":navigation:navigatorImpl")
include(":core:featureApi")
include(":feature:headsup")
include(":core:cleanmvi")
