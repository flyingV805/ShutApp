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
include(":feature:loginApi")
include(":core:matrixFlow")
include(":feature:loginImpl")
