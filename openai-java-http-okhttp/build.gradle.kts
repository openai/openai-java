import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("openai.kotlin")
    id("openai.publish")
}

dependencies {
    api(project(":openai-java-runtime"))
    api(libs.okhttp.client) {
        // Maven installs the multiplatform JAR alongside the JVM JAR. Both claim module okio.
        exclude(group = "com.squareup.okio", module = "okio")
    }
    api("com.squareup.okio:okio-jvm:3.6.0")
}
tasks.withType<KotlinCompile>().configureEach {
    friendPaths.from(project(":openai-java-runtime").layout.buildDirectory.dir("classes/kotlin/main"))
}
