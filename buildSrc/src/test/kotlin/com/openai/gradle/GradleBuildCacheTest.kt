package com.openai.gradle

import java.nio.file.Files
import java.nio.file.Path
import kotlin.io.path.readText
import kotlin.io.path.writeText
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertFalse
import org.junit.jupiter.api.io.TempDir

class GradleBuildCacheTest {
    @TempDir lateinit var temporaryDirectory: Path

    @Test
    fun `collector exports only current build keys and fails on missing entries`() {
        val key = "0123456789abcdef0123456789abcdef"
        for (entryPresent in listOf(true, false)) {
            val root = temporaryDirectory.resolve(entryPresent.toString())
            val scripts = root.resolve("scripts")
            Files.createDirectories(scripts)
            Files.copy(Path.of("../scripts/collect-gradle-build-cache"), scripts.resolve("collect"))
            val gradle = scripts.resolve("gradle")
            gradle.writeText(
                """
                |#!/usr/bin/env bash
                |printf '%s\n' "${'$'}@" > arguments
                |printf '%s\n' "Build cache key for task ':fixture:shadowJar' is $key"
                |printf '%s\n' "Build cache key for task ':fixture:compileKotlin' is $key"
                """
                    .trimMargin() + "\n"
            )
            check(gradle.toFile().setExecutable(true))
            val gradleHome = root.resolve("gradle-home")
            val cache = gradleHome.resolve("caches/build-cache-1")
            Files.createDirectories(cache)
            cache.resolve("unrelated-history").writeText("old compilation")
            if (entryPresent) cache.resolve(key).writeText("current output")
            val destination = root.resolve("selected")
            val builder =
                ProcessBuilder(
                        "bash",
                        scripts.resolve("collect").toString(),
                        destination.toString(),
                    )
                    .redirectErrorStream(true)
            builder.environment()["GRADLE_USER_HOME"] = gradleHome.toString()
            val process = builder.start()
            val output = process.inputStream.bufferedReader().use { it.readText() }
            assertEquals(if (entryPresent) 0 else 1, process.waitFor(), output)
            assertEquals(
                listOf(
                    "build",
                    "testClasses",
                    "verifyVersionSupportPolicy",
                    "-x",
                    "test",
                    "-x",
                    ":openai-java-core:testJacksonCompatibility",
                    "--info",
                ),
                root.resolve("arguments").readText().trim().lines(),
            )
            assertFalse(Files.exists(destination.resolve("unrelated-history")))
            if (entryPresent) {
                assertEquals("current output", destination.resolve(key).readText())
                assertEquals(1, destination.toFile().listFiles()!!.size)
            }
        }
    }
}
