package com.openai.gradle

import java.nio.file.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.readText
import kotlin.io.path.writeText
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.junit.jupiter.api.io.TempDir

@EnabledOnOs(OS.LINUX, OS.MAC)
class EnvironmentCheckScriptTest {
    @TempDir lateinit var directory: Path

    @Test
    fun `accepts the configured build JDK`() {
        val result = runCheck(pathJavaVersion = "21")

        assertEquals(0, result.exitCode, result.output)
        assertTrue(result.output.contains("Development environment: JDK 21"), result.output)
    }

    @Test
    fun `accepts canonical Java properties separators`() {
        for (property in listOf("build.jdk : 21  ", "build.jdk 21")) {
            val result = runCheck(pathJavaVersion = "21", buildJdkProperty = property)

            assertEquals(0, result.exitCode, result.output)
        }
    }

    @Test
    fun `rejects a different JDK with recovery instructions`() {
        for (version in listOf("26", "999999999999999999999999999999")) {
            val result = runCheck(pathJavaVersion = version)

            assertEquals(1, result.exitCode)
            assertTrue(result.output.contains("requires JDK 21"), result.output)
            assertTrue(result.output.contains("Gradle would use Java $version"), result.output)
            assertTrue(result.output.contains("export JAVA_HOME=/path/to/jdk-21"), result.output)
            assertTrue(result.output.contains("./scripts/check-env"), result.output)
        }
    }

    @Test
    fun `checks the JAVA_HOME launcher before PATH`() {
        val result = runCheck(pathJavaVersion = "21", javaHomeVersion = "26")

        assertEquals(1, result.exitCode)
        assertTrue(result.output.contains("Gradle would use Java 26"), result.output)
    }

    @Test
    fun `invalid JAVA_HOME does not fall back to PATH`() {
        val result = runCheck(pathJavaVersion = "21", invalidJavaHome = true)

        assertEquals(1, result.exitCode)
        assertTrue(result.output.contains("no usable Java launcher was found"), result.output)
    }

    @Test
    fun `reports an unusable Java launcher`() {
        val result = runCheck(pathJavaVersion = null)

        assertEquals(1, result.exitCode)
        assertTrue(result.output.contains("no usable Java launcher was found"), result.output)
        assertTrue(result.output.contains("./scripts/check-env"), result.output)
    }

    @Test
    fun `rejects a launcher that reports a version but exits unsuccessfully`() {
        val result = runCheck(pathJavaVersion = "21", pathJavaExitCode = 126)

        assertEquals(1, result.exitCode)
        assertTrue(result.output.contains("no usable Java launcher was found"), result.output)
    }

    private fun runCheck(
        pathJavaVersion: String?,
        javaHomeVersion: String? = null,
        pathJavaExitCode: Int = 0,
        buildJdkProperty: String = "build.jdk=21",
        invalidJavaHome: Boolean = false,
    ): Result {
        val root = directory
        val scripts = root.resolve("scripts").createDirectories()
        scripts.resolve("check-env").writeText(Path.of("../scripts/check-env").readText())
        root
            .resolve("gradle")
            .createDirectories()
            .resolve("version-support.properties")
            .writeText("$buildJdkProperty\n")

        val pathBin = root.resolve("path-bin").createDirectories()
        writeJava(pathBin.resolve("java"), pathJavaVersion, pathJavaExitCode)
        val javaHome =
            if (invalidJavaHome) {
                root.resolve("invalid java home").createDirectories()
            } else {
                javaHomeVersion?.let { version ->
                    root.resolve("java home").also { home ->
                        writeJava(
                            home.resolve("bin").createDirectories().resolve("java"),
                            version,
                            0,
                        )
                    }
                }
            }

        val builder = ProcessBuilder("bash", scripts.resolve("check-env").toString())
        builder.directory(root.toFile())
        builder.environment().apply {
            put("PATH", "$pathBin:${get("PATH")}")
            if (javaHome == null) remove("JAVA_HOME") else put("JAVA_HOME", javaHome.toString())
        }
        val process = builder.redirectErrorStream(true).start()
        val output = process.inputStream.bufferedReader().use { it.readText() }
        return Result(process.waitFor(), output)
    }

    private fun writeJava(path: Path, version: String?, exitCode: Int) {
        path.writeText(
            if (version == null) {
                "#!/usr/bin/env bash\nexit $exitCode\n"
            } else {
                "#!/usr/bin/env bash\necho '    java.specification.version = $version' >&2\n" +
                    "exit $exitCode\n"
            }
        )
        assertTrue(path.toFile().setExecutable(true))
    }

    private data class Result(val exitCode: Int, val output: String)
}
