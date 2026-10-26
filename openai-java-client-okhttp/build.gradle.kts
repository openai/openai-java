import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("openai.kotlin")
    id("openai.wiremock-test")
    id("openai.publish")
}

// Keep multipart cancellation coordination internal across the SDK's owned transport modules.
tasks.withType<KotlinCompile>().configureEach {
    friendPaths.from(project(":openai-java-core").layout.buildDirectory.dir("classes/kotlin/main"))
}

// WireMock tests already require Java 17. Keep the SDK's Java 8 target unchanged.
tasks.named<JavaCompile>("compileTestJava") {
    options.release.set(17)
}
tasks.named<KotlinCompile>("compileTestKotlin") {
    compilerOptions.jvmTarget.set(JvmTarget.JVM_17)
    compilerOptions.freeCompilerArgs.set(
        compilerOptions.freeCompilerArgs.get().map {
            if (it.startsWith("-Xjdk-release=")) "-Xjdk-release=17" else it
        }
    )
}

val jacksonPublishedVersion = libs.versions.jacksonPublished.get()

listOf(configurations.testCompileClasspath, configurations.testRuntimeClasspath).forEach {
    it.configure {
        resolutionStrategy.eachDependency {
            if (
                requested.group == "com.fasterxml.jackson" ||
                    requested.group.startsWith("com.fasterxml.jackson.")
            ) {
                useVersion(jacksonPublishedVersion)
                because("test classpaths must use the SDK's secure published Jackson release")
            }
        }
    }
}

dependencies {
    api(project(":openai-java-core"))

    api("com.squareup.okhttp3:okhttp:4.12.0")

    testImplementation(kotlin("test"))
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation(platform(libs.jackson.bom))
    testImplementation("com.squareup.okhttp3:mockwebserver:4.12.0")
    testImplementation("com.squareup.okhttp3:okhttp-tls:4.12.0")
}
