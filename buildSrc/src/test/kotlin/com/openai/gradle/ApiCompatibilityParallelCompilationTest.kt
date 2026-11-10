package com.openai.gradle

import java.nio.file.Path
import kotlin.io.path.createDirectories
import kotlin.io.path.readText
import kotlin.io.path.writeText
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import org.gradle.testkit.runner.GradleRunner
import org.gradle.testkit.runner.TaskOutcome
import org.junit.jupiter.api.io.TempDir

class ApiCompatibilityParallelCompilationTest {
    @TempDir lateinit var directory: Path

    @Test
    fun `both policies compile all groups freshly and a proposed incompatibility fails`() {
        write("settings.gradle", "include('openai-java-core', 'openai-java-client-okhttp')")
        write(
            "gradle.properties",
            "org.gradle.configuration-cache=true\nkotlin.compiler.execution.strategy=in-process\n",
        )
        write(
            "openai-java-core/build.gradle",
            """
            plugins { id 'org.jetbrains.kotlin.jvm' }
            repositories { mavenCentral() }
            java.toolchain.languageVersion.set(JavaLanguageVersion.of(21))
            java.sourceCompatibility = JavaVersion.VERSION_1_8
            java.targetCompatibility = JavaVersion.VERSION_1_8
            kotlin.compilerOptions.jvmTarget.set(org.jetbrains.kotlin.gradle.dsl.JvmTarget.JVM_1_8)
            """
                .trimIndent(),
        )
        write(
            "openai-java-client-okhttp/build.gradle",
            "plugins { id 'java-library' }; java { sourceCompatibility = JavaVersion.VERSION_1_8; targetCompatibility = JavaVersion.VERSION_1_8 }",
        )
        write(
            "openai-java-core/src/main/kotlin/Client.kt",
            "package com.openai; class Client { fun retained() = Unit }",
        )
        val environment = System.getenv().toMutableMap()
        listOf("external", "proposed").forEach { policy ->
            val root = "$policy/src/test/kotlin/com/openai"
            (0..7).forEach { index ->
                write(
                    "$root/models/Model$index.kt",
                    "package com.openai.models; class Model$index { fun check() { com.openai.Client().retained(); com.openai.Support.check() } }",
                )
            }
            write("$root/Support.kt", "package com.openai; object Support { fun check() = Unit }")
            write(
                "$root/services/First.kt",
                "package com.openai.services; class First { fun check() = Second().check() }",
            )
            write(
                "$root/services/Second.kt",
                "package com.openai.services; class Second { fun check() = com.openai.Support.check() }",
            )
            directory.resolve("$policy/fixtures").createDirectories()
            write(
                "$policy/dependencies.txt",
                "# Kotlin's standard library is provided by the plugin.\n",
            )
            val prefix = if (policy == "external") "BASELINE" else "PROPOSED"
            environment[
                if (policy == "external") "GENERATED_TEST_SOURCE_ROOT"
                else "PROPOSED_GENERATED_TEST_SOURCE_ROOT"] = directory.resolve(root).toString()
            environment["${prefix}_FIXTURE_SOURCE_ROOT"] =
                directory.resolve("$policy/fixtures").toString()
            environment["${prefix}_DEPENDENCIES_FILE"] =
                directory.resolve("$policy/dependencies.txt").toString()
        }
        val detector = Path.of("../scripts/detect-breaking-changes").readText()
        val init =
            write(
                "compatibility.gradle",
                detector.substringAfter("<<'GRADLE'\n").substringBefore("\nGRADLE\n"),
            )
        fun runner(vararg tasks: String) =
            GradleRunner.create()
                .withProjectDir(directory.toFile())
                .withPluginClasspath()
                .withEnvironment(environment)
                .withArguments(
                    "--offline",
                    "--max-workers=2",
                    "--init-script",
                    init.toString(),
                    *tasks,
                )
        val external = ":openai-java-core:compileExternalApiCompatibilityKotlin"
        val proposed = ":openai-java-core:compileProposedApiCompatibilityKotlin"
        val first = runner(external).build()
        assertEquals(TaskOutcome.SUCCESS, first.task(external)?.outcome)
        (1..7).forEach {
            assertEquals(
                TaskOutcome.SUCCESS,
                first.task(":api-compatibility-external-$it:compileKotlin")?.outcome,
            )
        }
        val both = runner(external, proposed).build()
        listOf("external", "proposed").forEach { policy ->
            (1..7).forEach {
                assertEquals(
                    TaskOutcome.SUCCESS,
                    both.task(":api-compatibility-$policy-$it:compileKotlin")?.outcome,
                )
            }
        }
        assertEquals(TaskOutcome.SUCCESS, both.task(external)?.outcome)
        assertEquals(TaskOutcome.SUCCESS, both.task(proposed)?.outcome)
        write(
            "proposed/src/test/kotlin/com/openai/models/Model0.kt",
            "package com.openai.models; class Model0 { fun check() = com.openai.Client().missing() }",
        )
        val failed = runner(external, proposed).buildAndFail()
        assertTrue(
            failed.tasks.any {
                it.outcome == TaskOutcome.FAILED && "proposed" in it.path.lowercase()
            }
        )
    }

    private fun write(name: String, text: String): Path =
        directory.resolve(name).also {
            it.parent.createDirectories()
            it.writeText(text)
        }
}
