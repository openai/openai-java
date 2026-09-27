import com.openai.gradle.CoreCompilationShards
import com.openai.gradle.VersionSupportPolicy
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    id("openai.java")
    kotlin("jvm")
}

repositories {
    mavenCentral()
}

val versionSupportPolicy =
    VersionSupportPolicy.load(rootProject.file("gradle/version-support.properties"))
val versionPolicyProject = CoreCompilationShards.versionPolicyProjectName(project.name)
val runtimeFloor = versionSupportPolicy.runtimeFloor(versionPolicyProject)
val kotlinJvmTarget = if (runtimeFloor == 8) "1.8" else runtimeFloor.toString()

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(versionSupportPolicy.buildJdk))
    }

    compilerOptions {
        freeCompilerArgs = listOf(
            "-Xjvm-default=all",
            "-Xjdk-release=$kotlinJvmTarget",
            // Suppress deprecation warnings because we may still reference and test deprecated members.
            // TODO: Replace with `-Xsuppress-warning=DEPRECATION` once we use Kotlin compiler 2.1.0+.
            "-nowarn",
        )
        jvmTarget.set(JvmTarget.fromTarget(kotlinJvmTarget))
        languageVersion.set(KotlinVersion.KOTLIN_1_8)
        apiVersion.set(KotlinVersion.KOTLIN_1_8)
        coreLibrariesVersion = "1.8.0"
    }
}

tasks.withType<Test>().configureEach {
    systemProperty("junit.jupiter.execution.parallel.enabled", true)
    systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")

    // `SKIP_MOCK_TESTS` affects which tests run so it must be added as input for proper cache invalidation.
    inputs.property("skipMockTests", System.getenv("SKIP_MOCK_TESTS")).optional(true)
}

apply(from = rootProject.file("gradle/kotlin-format.gradle.kts"))
