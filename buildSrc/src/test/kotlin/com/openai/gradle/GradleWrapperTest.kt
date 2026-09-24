package com.openai.gradle

import java.nio.file.Path
import kotlin.io.path.createDirectories
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

    private fun runWrapper(
        ci: String?,
        local: String?,
        arguments: List<String>,
        exitCode: Int = 0,
    ): Result {
        val scripts = directory.resolve("scripts").createDirectories()
        scripts.resolve("gradle").writeText(Path.of("../scripts/gradle").readText())
        val capturedArguments = directory.resolve("arguments")
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
        }
        val process = builder.redirectErrorStream(true).start()
        val output = process.inputStream.bufferedReader().use { it.readText() }
        val actualExitCode = process.waitFor()
        assertEquals("", output)
        return Result(
            actualExitCode,
            capturedArguments.readBytes().toString(Charsets.UTF_8).split('\u0000').dropLast(1),
        )
    }

    private data class Result(val exitCode: Int, val arguments: List<String>)
}
