package com.openai.gradle

import java.nio.file.Path
import javax.tools.ToolProvider
import kotlin.io.path.createDirectories
import kotlin.io.path.readText
import kotlin.io.path.writeText
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import kotlin.test.assertNotEquals
import kotlin.test.assertTrue
import org.junit.jupiter.api.condition.EnabledOnOs
import org.junit.jupiter.api.condition.OS
import org.junit.jupiter.api.io.TempDir

@EnabledOnOs(OS.LINUX, OS.MAC)
class ApiCompatibilityDetectorTest {
    @TempDir lateinit var directory: Path

    @Test
    fun `identical inputs compile once and still check both public API manifests`() {
        val root = prepare("identical")
        assertEquals(0, detect(root).exitCode)
        assertEquals(listOf(BASELINE_TASK), compilationTasks(root))

        write(root, "$POLICY/structured-output-public-api.txt", "com.openai.Example#missing ()V\n")
        val invalidManifest = detect(root)
        assertNotEquals(0, invalidManifest.exitCode)
        assertTrue(invalidManifest.output.contains("proposed structured-output API is missing"))
        assertEquals(listOf(BASELINE_TASK), compilationTasks(root))
    }

    @Test
    fun `different compiler inputs retain both compilations`() {
        val changedInputs =
            listOf(
                "$TEST_ROOT/models/Added.kt",
                "$TEST_ROOT/services/Service.kt",
                "$TEST_ROOT/TestServerExtension.kt",
                "$POLICY/kotlin/Fixture.kt",
                "$POLICY/dependencies.txt",
                "openai-java-core/src/externalApiCompatibility/kotlin/Extra.kt",
                "openai-java-core/src/proposedApiCompatibility/kotlin/Extra.kt",
            )
        changedInputs.forEachIndexed { index, path ->
            val root = prepare("changed-$index", stopAtCompilation = true)
            write(root, path, "// Changed compiler input\n")
            val result = detect(root)
            assertEquals(COMPILATION_REACHED, result.exitCode, "$path: ${result.output}")
            assertEquals(listOf(BASELINE_TASK, PROPOSED_TASK), compilationTasks(root), path)
        }
    }

    @Test
    fun `invalid proposed exclusions fail before compilation`() {
        val root = prepare("invalid-policy")
        write(root, "$POLICY/excluded-generated-tests.txt", "$TEST_ROOT/models/Missing.kt\n")
        val result = detect(root)
        assertNotEquals(0, result.exitCode)
        assertTrue(result.output.contains("proposed compatibility exclusion does not exist"))
        assertFalse(root.resolve("gradle-arguments.txt").toFile().exists())
    }

    private fun prepare(name: String, stopAtCompilation: Boolean = false): Path {
        val root = directory.resolve(name).createDirectories()
        write(
            root,
            "scripts/detect-breaking-changes",
            Path.of("../scripts/detect-breaking-changes").readText(),
        )
        // Task-selection cases stop here; the manifest test also exercises real javap checks.
        val compilationExit = if (stopAtCompilation) COMPILATION_REACHED else 0
        val gradle =
            write(
                root,
                "scripts/gradle",
                "#!/usr/bin/env bash\nprintf '%s\\n' \"${'$'}@\" > gradle-arguments.txt\nexit $compilationExit\n",
            )
        assertTrue(gradle.toFile().setExecutable(true))
        write(root, "$TEST_ROOT/models/Model.kt", "class Model\n")
        write(root, "$TEST_ROOT/services/Service.kt", "class Service\n")
        write(root, "$TEST_ROOT/TestServerExtension.kt", "class TestServerExtension\n")
        write(root, "$POLICY/kotlin/Fixture.kt", "class Fixture\n")
        write(root, "$POLICY/dependencies.txt", "org.jetbrains.kotlin:kotlin-stdlib:1.9.20\n")
        write(root, "$POLICY/excluded-generated-tests.txt", "# No exclusions\n")
        write(root, "$POLICY/structured-output-public-api.txt", "com.openai.Example#call ()V\n")
        val java =
            write(
                root,
                "Example.java",
                "package com.openai; public class Example { public static void call() {} }\n",
            )
        val classes = root.resolve("openai-java-core/build/classes/kotlin/main").createDirectories()
        assertEquals(
            0,
            ToolProvider.getSystemJavaCompiler()
                .run(null, null, null, "-d", classes.toString(), java.toString()),
        )
        assertEquals(0, run(root, "git", "init", "--quiet").exitCode)
        assertEquals(0, run(root, "git", "add", "scripts", "openai-java-core/src").exitCode)
        assertEquals(
            0,
            run(
                    root,
                    "git",
                    "-c",
                    "user.name=Test",
                    "-c",
                    "user.email=test@example.invalid",
                    "-c",
                    "commit.gpgsign=false",
                    "commit",
                    "--quiet",
                    "-m",
                    "Baseline",
                )
                .exitCode,
        )
        return root
    }

    private fun write(root: Path, path: String, text: String): Path =
        root.resolve(path).also {
            it.parent.createDirectories()
            it.writeText(text)
        }

    private fun detect(root: Path): Result =
        run(root, "bash", "scripts/detect-breaking-changes", "HEAD")

    private fun compilationTasks(root: Path): List<String> =
        root.resolve("gradle-arguments.txt").readText().lines().filter { it.startsWith(":") }

    private fun run(root: Path, vararg command: String): Result {
        val process =
            ProcessBuilder(*command).directory(root.toFile()).redirectErrorStream(true).start()
        val output = process.inputStream.bufferedReader().use { it.readText() }
        return Result(process.waitFor(), output)
    }

    private data class Result(val exitCode: Int, val output: String)

    private companion object {
        const val COMPILATION_REACHED = 42
        const val TEST_ROOT = "openai-java-core/src/test/kotlin/com/openai"
        const val POLICY = "openai-java-core/src/apiCompatibility"
        const val BASELINE_TASK = ":openai-java-core:compileExternalApiCompatibilityKotlin"
        const val PROPOSED_TASK = ":openai-java-core:compileProposedApiCompatibilityKotlin"
    }
}
