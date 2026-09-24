package com.openai.gradle

import java.nio.file.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.deleteIfExists
import kotlin.io.path.readText
import kotlin.io.path.writeText
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.junit.jupiter.api.io.TempDir

@EnabledOnOs(OS.LINUX)
class JavaFormatScriptTest {
    @TempDir lateinit var directory: Path

    @Test
    fun `installed formatter lint checks without changing Java files`() {
        val scripts = directory.resolve("scripts").createDirectories()
        for (name in listOf("check-env", "java-format", "lint", "format")) {
            val script = scripts.resolve(name)
            script.writeText(Path.of("../scripts/$name").readText())
            assertTrue(script.toFile().setExecutable(true))
        }
        directory
            .resolve("gradle")
            .createDirectories()
            .resolve("version-support.properties")
            .writeText("build.jdk=21\n")

        val gradle = scripts.resolve("gradle")
        gradle.writeText(
            """
            |#!/usr/bin/env bash
            |printf '%s\n' "${'$'}1" >> gradle-invocations
            |[[ "${'$'}1" == lintKotlin || "${'$'}1" == lintJava || "${'$'}1" == formatKotlin ]]
            """
                .trimMargin() + "\n"
        )
        assertTrue(gradle.toFile().setExecutable(true))

        val bin = directory.resolve("bin").createDirectories()
        val formatter = bin.resolve("palantir-java-format")
        formatter.writeText(
            """
            |#!/usr/bin/env bash
            |set -euo pipefail
            |dry_run=false
            |replace=false
            |exit_if_changed=false
            |files=()
            |expanded=()
            |for arg in "${'$'}@"; do
            |    if [[ "${'$'}arg" == @* ]]; then
            |        read -r -a params < "${'$'}{arg#@}"
            |        expanded+=("${'$'}{params[@]}")
            |    else
            |        expanded+=("${'$'}arg")
            |    fi
            |done
            |for arg in "${'$'}{expanded[@]}"; do
            |    case "${'$'}arg" in
            |        --palantir) ;;
            |        --dry-run) dry_run=true ;;
            |        --replace) replace=true ;;
            |        --set-exit-if-changed) exit_if_changed=true ;;
            |        *.java) files+=("${'$'}arg") ;;
            |        *) exit 3 ;;
            |    esac
            |done
            |# Match the pinned formatter's surprising success status for this usage error.
            |if "${'$'}dry_run" && "${'$'}replace"; then exit 0; fi
            |for file in "${'$'}{files[@]}"; do
            |    if ! grep -qx 'class Example {}' "${'$'}file"; then
            |        if "${'$'}dry_run"; then
            |            if "${'$'}exit_if_changed"; then exit 1; fi
            |        elif "${'$'}replace"; then
            |            printf 'class Example {}\n' > "${'$'}file"
            |        else
            |            exit 3
            |        fi
            |    fi
            |done
            """
                .trimMargin() + "\n"
        )
        assertTrue(formatter.toFile().setExecutable(true))
        val java = bin.resolve("java")
        java.writeText(
            "#!/usr/bin/env bash\nprintf '    java.specification.version = 21\\r\\n' >&2\n"
        )
        assertTrue(java.toFile().setExecutable(true))

        val javaFile = directory.resolve("Example.java")
        val unformatted = "class Example{ }\n"
        javaFile.writeText(unformatted)

        val lintBefore = run(scripts.resolve("lint"), bin)
        assertNotEquals(0, lintBefore.exitCode, lintBefore.output)
        assertEquals(unformatted, javaFile.readText())

        directory.resolve("opts").writeText("--dry-run --set-exit-if-changed\n")
        val responseFile = run(scripts.resolve("java-format"), bin, "@opts")
        assertEquals(2, responseFile.exitCode, responseFile.output)
        assertTrue(responseFile.output.contains("Response files are unsupported"))
        assertEquals(unformatted, javaFile.readText())

        val invalid = run(scripts.resolve("java-format"), bin, "--replace", "--dry-run")
        assertNotEquals(0, invalid.exitCode, invalid.output)
        assertEquals(unformatted, javaFile.readText())

        val format = run(scripts.resolve("format"), bin)
        assertEquals(0, format.exitCode, format.output)
        assertEquals("class Example {}\n", javaFile.readText())

        val lintAfter = run(scripts.resolve("lint"), bin)
        assertEquals(0, lintAfter.exitCode, lintAfter.output)

        formatter.deleteIfExists()
        val gradleInvocations = directory.resolve("gradle-invocations")
        gradleInvocations.writeText("")
        val lintWithoutFormatter = run(scripts.resolve("lint"), bin, inheritPath = false)
        assertEquals(0, lintWithoutFormatter.exitCode, lintWithoutFormatter.output)
        assertTrue(lintWithoutFormatter.output.contains("Development environment: JDK 21"))
        assertEquals(listOf("lintKotlin", "lintJava"), gradleInvocations.toFile().readLines())
    }

    private fun run(
        script: Path,
        bin: Path,
        vararg args: String,
        inheritPath: Boolean = true,
    ): Result {
        val builder = ProcessBuilder(listOf("bash", script.toString()) + args)
        builder.directory(directory.toFile()).redirectErrorStream(true)
        val path = builder.environment()["PATH"] ?: ""
        builder.environment()["PATH"] = "$bin:${if (inheritPath) path else "/usr/bin:/bin"}"
        builder.environment().remove("JAVA_HOME")
        val process = builder.start()
        val output = process.inputStream.bufferedReader().use { it.readText() }
        return Result(process.waitFor(), output)
    }

    private data class Result(val exitCode: Int, val output: String)
}
