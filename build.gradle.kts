// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.1" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    id("com.google.dagger.hilt.android") version "2.48" apply false
}

buildscript {
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.0.3") // Ensure this matches your Android Gradle Plugin version
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.5.21") // Use the appropriate Kotlin version
        classpath("com.google.dagger:hilt-android-gradle-plugin:2.38.1") // Add this line for Hilt
    }
}