import org.jetbrains.kotlin.gradle.dsl.JvmTarget
import org.jetbrains.kotlin.gradle.dsl.KotlinVersion

plugins {
    id("openai.java")
    kotlin("jvm")
}

repositories {
    mavenCentral()
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
        )
        jvmTarget.set(JvmTarget.JVM_1_8)
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

val ktfmt by configurations.creating
dependencies {
    ktfmt("com.facebook:ktfmt:0.56")
}

fun registerKtfmt(
    name: String,
    description: String,
) {
    val kotlinName = "${name}Kotlin"
    tasks.register<JavaExec>(kotlinName) {
        group = "Verification"
        this.description = description

        classpath = ktfmt
        mainClass = "com.facebook.ktfmt.cli.Main"

        // Use paths relative to the current module.
        val argumentFile = project.layout.buildDirectory.file("ktfmt-$name-args.txt").get().asFile
        val lastRunTimeFile =
            project.layout.buildDirectory.file("ktfmt-$name-last-run.txt").get().asFile

        // Read the time when this task was last executed for this module (if ever).
        val lastRunTime = lastRunTimeFile.takeIf { it.exists() }?.readText()?.toLongOrNull() ?: 0L

        // Use a `fileTree` relative to the module's source directory.
        val kotlinFiles = project.fileTree("src") { include("**/*.kt") }

        // Determine if any files need to be formatted or linted and continue only if there is at least
        // one file (otherwise Ktfmt will fail).
        onlyIf { kotlinFiles.any { it.lastModified() > lastRunTime } }

        inputs.files(kotlinFiles)

        doFirst {
            // Create the argument file and set the preferred formatting style.
            argumentFile.parentFile.mkdirs()
            argumentFile.writeText("--kotlinlang-style\n")

            if (name == "lint") {
                // For lint, do a dry run, so no files are modified. Set the exit code to 1 (instead of
                // the default 0) if any files need to be formatted, indicating that linting has failed.
                argumentFile.appendText("--dry-run\n")
                argumentFile.appendText("--set-exit-if-changed\n")
            }

            // Write the modified files to the argument file.
            kotlinFiles.filter { it.lastModified() > lastRunTime }
                .forEach { argumentFile.appendText("${it.absolutePath}\n") }
        }

        doLast {
            // Record the last execution time for later up-to-date checking.
            lastRunTimeFile.writeText(System.currentTimeMillis().toString())
        }

        // Pass the argument file using the @ symbol
        args = listOf("@${argumentFile.absolutePath}")

        outputs.upToDateWhen { kotlinFiles.none { it.lastModified() > lastRunTime } }
    }

    tasks.named(name) {
        dependsOn(tasks.named(kotlinName))
    }
}

registerKtfmt(name = "format", description = "Formats all Kotlin source files.")
registerKtfmt(name = "lint", description = "Verifies all Kotlin source files are formatted.")
