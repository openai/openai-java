plugins {
    id("java")
}

repositories {
    mavenCentral()
}

dependencies {

    implementation(project(":openai-java"))
    implementation(project(mapOf("path" to ":openai-java-core")))
}
