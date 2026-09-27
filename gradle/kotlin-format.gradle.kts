// Use the self-contained CLI variant in both the root project and SDK modules.
val ktfmt by configurations.creating {
    attributes {
        attribute(Usage.USAGE_ATTRIBUTE, objects.named(Usage.JAVA_RUNTIME))
        attribute(Bundling.BUNDLING_ATTRIBUTE, objects.named(Bundling.SHADOWED))
    }
}
dependencies {
    ktfmt("com.facebook:ktfmt:0.61")
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
        val sourceDirectory = if (project == rootProject) "buildSrc/src" else "src"
        val kotlinFiles = project.fileTree(sourceDirectory) { include("**/*.kt") }

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

    tasks.matching { it.name == name }.configureEach {
        dependsOn(tasks.named(kotlinName))
    }
}

registerKtfmt(name = "format", description = "Formats all Kotlin source files.")
registerKtfmt(name = "lint", description = "Verifies all Kotlin source files are formatted.")
