plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("kotlin-kapt")
    id("com.google.dagger.hilt.android")
}

// apply(from = "${project.rootDir}/dependencies.gradle.kts")

android {

    namespace = "kz.flyingv.shutapp"
    compileSdk = 34

    defaultConfig {
        applicationId = "kz.flyingv.shutapp"
        minSdk = 24
        targetSdk = 34
        versionCode = 1
        versionName = "1.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        vectorDrawables {
            useSupportLibrary = true
        }
    }

    buildTypes {
        release {
            isMinifyEnabled = true
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures {
        compose = true
    }

    composeOptions {
        kotlinCompilerExtensionVersion = "1.5.1"
    }

    packaging {
        resources {
            excludes += "/META-INF/{AL2.0,LGPL2.1}"
        }
    }

}

dependencies {

    // core
    implementation(libs.ktx.core)
    implementation(libs.ktx.lifecycle)
    implementation(libs.composeActivity)

    //compose
    implementation(platform(libs.composePlatform))
    implementation(libs.compose.ui)
    implementation(libs.compose.graphics)
    implementation(libs.compose.preview)
    implementation(libs.compose.material3)
    implementation(libs.compose.navigation)

    implementation(libs.accompanist.systemuicontroller)

    implementation(project(":navigation:navigatorApi"))
    implementation(project(":navigation:navigatorImpl"))
    implementation(project(":feature:headsup"))
    implementation(project(":feature:notifications"))
    implementation(project(":uikit"))

    //compose debug
    debugImplementation(libs.compose.debug.ui)
    debugImplementation(libs.compose.debug.testManifest)

    //hilt
    implementation(libs.hilt)
    kapt(libs.hilt.compiler)

    //tests
    testImplementation(libs.test.base.junit)
    androidTestImplementation(libs.test.android.junit)
    androidTestImplementation(libs.test.android.espresso)
    androidTestImplementation(platform(libs.test.android.compose.platform))
    androidTestImplementation(libs.test.android.compose.junit)

}