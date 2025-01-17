import com.diffplug.gradle.spotless.SpotlessExtension
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
    kotlinOptions {
        freeCompilerArgs = listOf(
          "-Xjvm-default=all",
          "-Xjdk-release=1.8",
          // Suppress deprecation warnings because we may still reference and test deprecated members.
          "-Xsuppress-warning=DEPRECATION"
        )
        jvmTarget = "1.8"
    }
}
