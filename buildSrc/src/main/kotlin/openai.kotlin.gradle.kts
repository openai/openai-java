import com.diffplug.gradle.spotless.SpotlessExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    id("openai.java")
    kotlin("jvm")
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }

    compilerOptions {
        freeCompilerArgs = listOf(
            "-Xjvm-default=all",
            "-Xjdk-release=1.8",
            // Suppress deprecation warnings because we may still reference and test deprecated members.
            // TODO: Replace with `-Xsuppress-warning=DEPRECATION` once we use Kotlin compiler 2.1.0+.
            "-nowarn",
            // Use as many threads as there are CPU cores on the machine for compilation.
            "-Xbackend-threads=0",
        )
        jvmTarget.set(JvmTarget.JVM_1_8)
        languageVersion.set(KotlinVersion.KOTLIN_1_8)
        apiVersion.set(KotlinVersion.KOTLIN_1_8)
        coreLibrariesVersion = "1.8.0"
    }
}

configure<SpotlessExtension> {
    kotlin {
        ktfmt().kotlinlangStyle()
        toggleOffOn()
    }
}

tasks.withType<Test>().configureEach {
    systemProperty("junit.jupiter.execution.parallel.enabled", true)
    systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")
}
