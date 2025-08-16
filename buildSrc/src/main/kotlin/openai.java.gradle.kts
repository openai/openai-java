import org.gradle.api.tasks.testing.logging.TestExceptionFormat

plugins {
    `java-library`
}

repositories {
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }

    sourceCompatibility = JavaVersion.VERSION_1_8
    targetCompatibility = JavaVersion.VERSION_1_8
}

tasks.withType<JavaCompile>().configureEach {
    options.compilerArgs.add("-Werror")
    options.release.set(8)
}

tasks.named<Jar>("jar") {
    manifest {
        attributes(mapOf(
            "Implementation-Title" to project.name,
            "Implementation-Version" to project.version
        ))
    }
}

tasks.withType<Test>().configureEach {
    useJUnitPlatform()

    // Run tests in parallel to some degree.
    maxParallelForks = (Runtime.getRuntime().availableProcessors() / 2).coerceAtLeast(1)
    forkEvery = 100

    testLogging {
        exceptionFormat = TestExceptionFormat.FULL
    }
}

val palantir by configurations.creating
dependencies {
    palantir("com.palantir.javaformat:palantir-java-format:2.73.0")
}

fun registerPalantir(
    name: String,
    description: String,
) {
    val javaName = "${name}Java"
    tasks.register<JavaExec>(javaName) {
        group = "Verification"
        this.description = description

        classpath = palantir
        mainClass = "com.palantir.javaformat.java.Main"

        // Avoid an `IllegalAccessError` on Java 9+.
        jvmArgs(
            "--add-exports", "jdk.compiler/com.sun.tools.javac.api=ALL-UNNAMED",
            "--add-exports", "jdk.compiler/com.sun.tools.javac.file=ALL-UNNAMED",
            "--add-exports", "jdk.compiler/com.sun.tools.javac.parser=ALL-UNNAMED",
            "--add-exports", "jdk.compiler/com.sun.tools.javac.tree=ALL-UNNAMED",
            "--add-exports", "jdk.compiler/com.sun.tools.javac.util=ALL-UNNAMED",
        )

        // Use paths relative to the current module.
        val argumentFile =
            project.layout.buildDirectory.file("palantir-$name-args.txt").get().asFile
        val lastRunTimeFile =
            project.layout.buildDirectory.file("palantir-$name-last-run.txt").get().asFile

        // Read the time when this task was last executed for this module (if ever).
        val lastRunTime = lastRunTimeFile.takeIf { it.exists() }?.readText()?.toLongOrNull() ?: 0L

        // Use a `fileTree` relative to the module's source directory.
        val javaFiles = project.fileTree("src") { include("**/*.java") }

        // Determine if any files need to be formatted or linted and continue only if there is at least
        // one file.
        onlyIf { javaFiles.any { it.lastModified() > lastRunTime } }

        inputs.files(javaFiles)

        doFirst {
            // Create the argument file and set the preferred formatting style.
            argumentFile.parentFile.mkdirs()
            argumentFile.writeText("--palantir\n")

            if (name == "lint") {
                // For lint, do a dry run, so no files are modified. Set the exit code to 1 (instead of
                // the default 0) if any files need to be formatted, indicating that linting has failed.
                argumentFile.appendText("--dry-run\n")
                argumentFile.appendText("--set-exit-if-changed\n")
            } else {
                // `--dry-run` and `--replace` (for in-place formatting) are mutually exclusive.
                argumentFile.appendText("--replace\n")
            }

            // Write the modified files to the argument file.
            javaFiles.filter { it.lastModified() > lastRunTime }
                .forEach { argumentFile.appendText("${it.absolutePath}\n") }
        }

        doLast {
            // Record the last execution time for later up-to-date checking.
            lastRunTimeFile.writeText(System.currentTimeMillis().toString())
        }

        // Pass the argument file using the @ symbol
        args = listOf("@${argumentFile.absolutePath}")

        outputs.upToDateWhen { javaFiles.none { it.lastModified() > lastRunTime } }
    }

    tasks.named(name) {
        dependsOn(tasks.named(javaName))
    }
}

registerPalantir(name = "format", description = "Formats all Java source files.")
registerPalantir(name = "lint", description = "Verifies all Java source files are formatted.")
