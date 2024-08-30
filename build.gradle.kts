buildscript {
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:7.4.2")
    }
}

plugins {
    kotlin("android") version "1.7.0" apply false
}

fun String.execute(currentWorkingDir: File = file("./")): String {
    val byteOut = java.io.ByteArrayOutputStream()
    exec {
        workingDir = currentWorkingDir
        commandLine = split("\\s".toRegex())
        standardOutput = byteOut
    }
    return String(byteOut.toByteArray()).trim()
}

val verCode by extra(16)
var verName by extra("1.1.1")

val minSdkVer by extra(23)
val targetSdkVer by extra(29)
val compileSdkVer by extra(33)
val ndkVer by extra("25.0.8775105")
val javaVer by extra(JavaVersion.VERSION_11)

tasks.register<Delete>("clean") {
    delete(rootProject.buildDir)
}
