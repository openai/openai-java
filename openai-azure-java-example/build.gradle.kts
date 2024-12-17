plugins {
    `java-library`
}

repositories {
    gradlePluginPortal()
}

dependencies {
    api(project(":openai-java-client-okhttp"))
    api("com.azure:azure-identity:1.14.0")
}
