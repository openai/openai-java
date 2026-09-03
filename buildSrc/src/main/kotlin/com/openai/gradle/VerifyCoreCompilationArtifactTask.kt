package com.openai.gradle

import java.io.File
import java.io.Serializable
import java.util.SortedSet
import java.util.zip.ZipFile
import org.gradle.api.DefaultTask
import org.gradle.api.file.DirectoryProperty
import org.gradle.api.file.FileTreeElement
import org.gradle.api.file.RegularFileProperty
import org.gradle.api.specs.Spec
import org.gradle.api.tasks.InputDirectory
import org.gradle.api.tasks.InputFile
import org.gradle.api.tasks.PathSensitive
import org.gradle.api.tasks.PathSensitivity
import org.gradle.api.tasks.TaskAction
import org.gradle.work.DisableCachingByDefault

@DisableCachingByDefault(because = "Artifact verification produces no outputs")
abstract class VerifyCoreCompilationArtifactTask : DefaultTask() {
    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val classesDirectory: DirectoryProperty

    @get:InputDirectory
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val sourceDirectory: DirectoryProperty

    @get:InputFile
    @get:PathSensitive(PathSensitivity.NAME_ONLY)
    abstract val binaryJar: RegularFileProperty

    @get:InputFile
    @get:PathSensitive(PathSensitivity.NAME_ONLY)
    abstract val sourcesJar: RegularFileProperty

    @get:InputFile
    @get:PathSensitive(PathSensitivity.RELATIVE)
    abstract val publicApiManifest: RegularFileProperty

    @TaskAction
    fun verify() {
        val expectedClasses = relativeFiles(classesDirectory.get().asFile, ".class")
        check(expectedClasses.isNotEmpty()) { "The combined core classes directory is empty." }

        val binaryEntries = zipEntryCounts(binaryJar.get().asFile)
        assertNoDuplicateEntries("core jar", binaryEntries)
        assertSameEntries(
            label = "core class",
            expected = expectedClasses,
            actual = binaryEntries.keys.filterTo(sortedSetOf()) { it.endsWith(".class") },
        )

        val expectedSources =
            relativeFiles(sourceDirectory.get().asFile, ".kt").mapTo(sortedSetOf()) { "main/$it" }
        check(expectedSources.isNotEmpty()) { "The core source directory is empty." }

        val sourceEntries = zipEntryCounts(sourcesJar.get().asFile)
        assertNoDuplicateEntries("core sources jar", sourceEntries)
        assertSameEntries(
            label = "core Kotlin source",
            expected = expectedSources,
            actual = sourceEntries.keys.filterTo(sortedSetOf()) { it.endsWith(".kt") },
        )

        structuredOutputPublicApiClasses(publicApiManifest.get().asFile).forEach { className ->
            val classEntry = "${className.replace('.', '/')}.class"
            check(classEntry in expectedClasses) {
                "Public API class is missing from the combined core classes: $className"
            }
            check(binaryEntries[classEntry] == 1) {
                "Public API class must appear exactly once in the core jar: $className"
            }

            val sourceEntry = "main/${className.substringBefore('$').replace('.', '/')}.kt"
            check(sourceEntries[sourceEntry] == 1) {
                "Public API source must appear exactly once in the core sources jar: $className"
            }
        }
    }

    private fun relativeFiles(root: File, extension: String): SortedSet<String> =
        root
            .walkTopDown()
            .filter { it.isFile && it.name.endsWith(extension) }
            .map { it.relativeTo(root).invariantSeparatorsPath }
            .toCollection(sortedSetOf())

    private fun zipEntryCounts(archive: File): Map<String, Int> =
        ZipFile(archive).use { zip ->
            buildMap {
                val entries = zip.entries()
                while (entries.hasMoreElements()) {
                    val name = entries.nextElement().name
                    put(name, getOrDefault(name, 0) + 1)
                }
            }
        }

    private fun assertNoDuplicateEntries(label: String, entries: Map<String, Int>) {
        val duplicates = entries.filterValues { it > 1 }.keys.sorted()
        check(duplicates.isEmpty()) {
            "$label contains duplicate entries:\n${duplicates.joinToString("\n") { "  $it" }}"
        }
    }

    private fun assertSameEntries(label: String, expected: Set<String>, actual: Set<String>) {
        val missing = expected - actual
        val unexpected = actual - expected
        check(missing.isEmpty() && unexpected.isEmpty()) {
            buildString {
                append("Published $label inventory differs from the canonical directory.")
                if (missing.isNotEmpty()) {
                    append("\nMissing:\n")
                    append(missing.joinToString("\n") { "  $it" })
                }
                if (unexpected.isNotEmpty()) {
                    append("\nUnexpected:\n")
                    append(unexpected.joinToString("\n") { "  $it" })
                }
            }
        }
    }
}

class CoreCompilationStagingOutputSpec(private val stagingDirectory: File) :
    Spec<FileTreeElement>, Serializable {
    override fun isSatisfiedBy(element: FileTreeElement): Boolean =
        element.file.toPath().startsWith(stagingDirectory.toPath())
}

internal fun structuredOutputPublicApiClasses(manifest: File): Set<String> =
    manifest.useLines { lines ->
        lines
            .map(String::trim)
            .filter { it.isNotEmpty() && !it.startsWith('#') }
            .map { it.substringBefore(' ').substringBefore('#') }
            .toCollection(sortedSetOf())
    }
