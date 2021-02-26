plugins {
    kotlin("multiplatform")
    id("com.android.library")
    id("kotlin-android-extensions")
}

kotlin {
    android()

    sourceSets {
        val commonMain by getting {
            dependencies {
                implementation(project(":domain"))
            }
        }
        val commonTest by getting
        val androidMain by getting
        val androidTest by getting
    }
}

android {
    compileSdkVersion(29)
}
