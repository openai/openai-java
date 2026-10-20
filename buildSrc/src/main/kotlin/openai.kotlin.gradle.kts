import com.openai.gradle.CoreCompilationShards
import com.openai.gradle.VersionSupportPolicy
import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

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

// Kotlin fingerprints friend paths by name, not by class content. Its default includes the
// versioned main JAR, so a release alone invalidates every test compilation. The compiler already
// fingerprints the test compile classpath; use the stable main classes for internal visibility.
// In core this is the canonical aggregate, including its internal compilation shards.
tasks.named<KotlinCompile>("compileTestKotlin") {
    friendPaths.setFrom(sourceSets.main.map { it.output.classesDirs })
}

tasks.withType<Test>().configureEach {
    systemProperty("junit.jupiter.execution.parallel.enabled", true)
    systemProperty("junit.jupiter.execution.parallel.mode.default", "concurrent")

    // `SKIP_MOCK_TESTS` affects which tests run so it must be added as input for proper cache invalidation.
    inputs.property("skipMockTests", System.getenv("SKIP_MOCK_TESTS")).optional(true)
}

apply(from = rootProject.file("gradle/kotlin-format.gradle.kts"))
