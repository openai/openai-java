import com.diffplug.gradle.spotless.SpotlessExtension
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
    id("openai.java")
    kotlin("jvm")
}

kotlin {
    jvmToolchain {
        languageVersion.set(JavaLanguageVersion.of(17))
    }
}

configure<SpotlessExtension> {
    kotlin {
        ktfmt().kotlinlangStyle()
        toggleOffOn()
    }
}

tasks.withType<KotlinCompile>().configureEach {
    compilerOptions {
        freeCompilerArgs = listOf(
          "-Xjvm-default=all",
          "-Xjdk-release=1.8",
          // Suppress deprecation warnings because we may still reference and test deprecated members.
          "-Xsuppress-warning=DEPRECATION"
        )
        jvmTarget.set(JvmTarget.JVM_1_8)
    }
}

// Run tests in parallel to some degree.
tasks.withType<Test>().configureEach {
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
    forkEvery = 100
}
