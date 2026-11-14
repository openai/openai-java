import com.openai.gradle.CoreCompilationDependencies
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("openai.kotlin")
    id("openai.wiremock-test")
    id("openai.publish")
}

// Keep multipart cancellation coordination internal across the SDK's owned transport modules.
tasks.withType<KotlinCompile>().configureEach {
    friendPaths.from(project(":openai-java-runtime").layout.buildDirectory.dir("classes/kotlin/main"))
    friendPaths.from(project(":openai-java-http-okhttp").layout.buildDirectory.dir("classes/kotlin/main"))
    friendPaths.from(project(":openai-java-core").layout.buildDirectory.dir("classes/kotlin/main"))
}

// WireMock tests already require Java 17. Keep the SDK's Java 8 target unchanged.
tasks.named<JavaCompile>("compileTestJava") {
    options.release.set(17)
}
tasks.named<KotlinCompile>("compileTestKotlin") {
    friendPaths.from(project(":openai-java-core").layout.buildDirectory.dir("classes/kotlin/full-only"))
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
                useVersion(CoreCompilationDependencies.publishedJacksonModuleVersion(requested.name, jacksonPublishedVersion))
                because("test classpaths must use the SDK's secure published Jackson release")
            }
        }
    }
}

dependencies {
    api(project(":openai-java-core"))

    api(project(":openai-java-http-okhttp"))

    testImplementation(kotlin("test"))
    testRuntimeOnly("org.junit.platform:junit-platform-launcher")
    testImplementation("org.assertj:assertj-core:3.27.7")
    testImplementation(platform(libs.jackson.bom))
    testImplementation(libs.okhttp.mockwebserver)
    testImplementation(libs.okhttp.tls)
}
