// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    repositories {
        mavenCentral()
    }
    dependencies {
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.8.20")
    }
}

plugins {
    id("com.android.application") version "8.1.0" apply false
    id("org.jetbrains.kotlin.android") version "1.8.0" apply false
    id ("com.android.library") version "8.0.2" apply false
}

fun getMapApiKey(): String {
    val properties = java.util.Properties()
    project.file("local.properties").inputStream().let { properties.load(it) }
    return properties.getProperty("MAPKIT_API_KEY", "")
}

val mapKitApiKey by extra(getMapApiKey())
