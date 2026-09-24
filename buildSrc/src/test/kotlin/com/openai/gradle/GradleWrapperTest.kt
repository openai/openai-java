package com.openai.gradle

import java.nio.file.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.exists
import kotlin.io.path.readBytes
import kotlin.io.path.readText
import kotlin.io.path.writeText
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.junit.jupiter.api.io.TempDir

@EnabledOnOs(OS.LINUX, OS.MAC)
class GradleWrapperTest {
    @TempDir lateinit var directory: Path

    @Test
    fun `explicit opt-out wins over local and CI defaults`() {
        for (ci in listOf(null, "false", "true")) {
            for (local in listOf(null, "true", "false")) {
                val expected =
                    when {
                        local == "false" -> listOf("--no-daemon")
                        ci != "true" -> listOf("--daemon")
                        else -> emptyList()
                    }
                val result = runWrapper(ci, local, listOf("help"))

                assertEquals(0, result.exitCode)
                assertEquals(expected + "help", result.arguments, "CI=$ci, LOCAL=$local")
            }
        }
    }

    @Test
    fun `caller arguments remain intact and follow wrapper defaults`() {
        val arguments = listOf("--no-daemon", "-Pmessage=two words", "", "help")

        assertEquals(listOf("--daemon") + arguments, runWrapper(null, null, arguments).arguments)
    }

    @Test
    fun `Gradle exit status is preserved`() {
        assertEquals(23, runWrapper("true", "false", listOf("help"), 23).exitCode)
    }

    @Test
    fun `unsupported Java launcher fails before Gradle starts`() {
        val result = runWrapper(null, null, listOf("lintKotlin"), javaVersion = "26")

        assertEquals(1, result.exitCode)
        assertEquals(emptyList(), result.arguments)
        assertTrue(
            result.output.contains("Gradle 8.12, which cannot run on Java 26"),
            result.output,
        )
        assertTrue(result.output.contains("export JAVA_HOME=/path/to/jdk-21"), result.output)
        assertTrue(result.output.contains("./scripts/lint"), result.output)
    }

    @Test
    fun `non-development Java launcher explains JDK 21 selection`() {
        val result = runWrapper(null, null, listOf("help"), javaVersion = "17")

        assertEquals(1, result.exitCode)
        assertEquals(emptyList(), result.arguments)
        assertTrue(
            result.output.contains("development requires JDK 21 to launch Gradle"),
            result.output,
        )
        assertTrue(result.output.contains("The current launcher is Java 17"), result.output)
    }

    @Test
    fun `unusable compiler explains JDK requirement`() {
        val result = runWrapper(null, null, listOf("help"), javacVersion = null)

        assertEquals(1, result.exitCode)
        assertEquals(emptyList(), result.arguments)
        assertTrue(
            result.output.contains("requires JDK 21, but javac could not be executed"),
            result.output,
        )
        assertTrue(result.output.contains("javac -version"), result.output)
    }

    @Test
    fun `JAVA_HOME launcher is checked before PATH launcher`() {
        val result =
            runWrapper(
                null,
                null,
                listOf("lintKotlin"),
                javaVersion = "21.0.1",
                javaHomeVersion = "26",
            )

        assertEquals(1, result.exitCode)
        assertEquals(emptyList(), result.arguments)
        assertTrue(
            result.output.contains("Gradle 8.12, which cannot run on Java 26"),
            result.output,
        )
    }

    @Test
    fun `JAVA_HOME launcher can pass when PATH launcher is unsupported`() {
        val result =
            runWrapper(null, null, listOf("help"), javaVersion = "26", javaHomeVersion = "21.0.1")

        assertEquals(0, result.exitCode)
        assertEquals(listOf("--daemon", "help"), result.arguments)
    }

    private fun runWrapper(
        ci: String?,
        local: String?,
        arguments: List<String>,
        exitCode: Int = 0,
        javaVersion: String = "21.0.1",
        javacVersion: String? = javaVersion,
        javaHomeVersion: String? = null,
    ): Result {
        val scripts = directory.resolve("scripts").createDirectories()
        scripts.resolve("gradle").writeText(Path.of("../scripts/gradle").readText())
        val capturedArguments = directory.resolve("arguments")
        val bin = directory.resolve("bin").createDirectories()
        val java = bin.resolve("java")
        java.writeText(
            """
            |#!/usr/bin/env bash
            |echo 'openjdk version "$javaVersion"' >&2
            """
                .trimMargin() + "\n"
        )
        assertTrue(java.toFile().setExecutable(true))
        val javac = bin.resolve("javac")
        if (javacVersion == null) {
            javac.writeText(
                """
                |#!/usr/bin/env bash
                |exit 126
                """
                    .trimMargin() + "\n"
            )
            assertTrue(javac.toFile().setExecutable(true))
        } else {
            javac.writeText(
                """
                |#!/usr/bin/env bash
                |echo 'javac $javacVersion'
                """
                    .trimMargin() + "\n"
            )
            assertTrue(javac.toFile().setExecutable(true))
        }
        val javaHome =
            javaHomeVersion?.let {
                val home = directory.resolve("java-home").createDirectories()
                val homeBin = home.resolve("bin").createDirectories()
                homeBin
                    .resolve("java")
                    .writeText(
                        """
                        |#!/usr/bin/env bash
                        |echo 'openjdk version "$it"' >&2
                        """
                            .trimMargin() + "\n"
                    )
                assertTrue(homeBin.resolve("java").toFile().setExecutable(true))
                homeBin
                    .resolve("javac")
                    .writeText(
                        """
                        |#!/usr/bin/env bash
                        |echo 'javac $it'
                        """
                            .trimMargin() + "\n"
                    )
                assertTrue(homeBin.resolve("javac").toFile().setExecutable(true))
                home
            }
        val gradlew = directory.resolve("gradlew")
        gradlew.writeText(
            """
            |#!/usr/bin/env bash
            |printf '%s\0' "${'$'}@" > "${'$'}GRADLE_WRAPPER_TEST_ARGS"
            |exit "${'$'}GRADLE_WRAPPER_TEST_EXIT"
            """
                .trimMargin() + "\n"
        )
        assertTrue(gradlew.toFile().setExecutable(true))

        val builder =
            ProcessBuilder(listOf("bash", scripts.resolve("gradle").toString()) + arguments)
        builder.directory(directory.toFile())
        builder.environment().apply {
            remove("CI")
            remove("OPENAI_JAVA_GRADLE_LOCAL")
            if (ci != null) put("CI", ci)
            if (local != null) put("OPENAI_JAVA_GRADLE_LOCAL", local)
            put("GRADLE_WRAPPER_TEST_ARGS", capturedArguments.toString())
            put("GRADLE_WRAPPER_TEST_EXIT", exitCode.toString())
            put("PATH", "${bin}:${get("PATH")}")
            if (javaHome != null) put("JAVA_HOME", javaHome.toString()) else remove("JAVA_HOME")
        }
        val process = builder.redirectErrorStream(true).start()
        val output = process.inputStream.bufferedReader().use { it.readText() }
        val actualExitCode = process.waitFor()
        if (actualExitCode == exitCode) {
            assertEquals("", output)
        }
        return Result(
            actualExitCode,
            if (capturedArguments.exists()) {
                capturedArguments.readBytes().toString(Charsets.UTF_8).split('\u0000').dropLast(1)
            } else {
                emptyList()
            },
            output,
        )
    }

    private data class Result(val exitCode: Int, val arguments: List<String>, val output: String)
}
