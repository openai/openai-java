plugins {
    `kotlin-dsl`
    kotlin("jvm") version "2.1.0"
    id("com.vanniktech.maven.publish") version "0.28.0"
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

dependencies {
    implementation("com.diffplug.spotless:spotless-plugin-gradle:6.25.0")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.23")
    implementation("com.vanniktech:gradle-maven-publish-plugin:0.28.0")
}
