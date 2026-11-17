package com.openai.gradle

import java.io.File
import java.io.Serializable
import org.gradle.api.file.FileTreeElement
import org.gradle.api.specs.Spec

/** Independent generated tests share only the compiled server fixture. */
class CoreTestCompilationLayout(sources: Collection<File>) {
    private val generated =
        sources.filter {
            it.extension == "kt" &&
                it.useLines { lines ->
                    lines
                        .firstOrNull()
                        ?.startsWith("// File generated from our OpenAPI spec by Castiron.") == true
                }
        }
    val models =
        partition(generated.filter { "/com/openai/models/" in it.invariantSeparatorsPath }, 8)
    val services =
        partition(
            generated.filter {
                "/com/openai/services/" in it.invariantSeparatorsPath &&
                    !it.readText().contains("ContractCases")
            },
            2,
        )
    val fixture =
        sources.single { it.invariantSeparatorsPath.endsWith("/com/openai/TestServerExtension.kt") }
    val moved = (models.flatten() + services.flatten() + fixture).toSet()

    private fun partition(files: List<File>, limit: Int): List<List<File>> {
        if (files.isEmpty()) return emptyList()
        val groups = List(minOf(limit, files.size)) { mutableListOf<File>() }
        val sizes = LongArray(groups.size)
        files
            .sortedWith(
                compareByDescending<File> { it.length() }.thenBy { it.invariantSeparatorsPath }
            )
            .forEach { file ->
                val index = sizes.indices.minBy { sizes[it] }
                groups[index].add(file)
                sizes[index] += file.length()
            }
        return groups
    }
}

class ClaimedCoreTestSourceSpec(
    private val files: Set<File>,
    private val includeDirectories: Boolean = false,
) : Spec<FileTreeElement>, Serializable {
    override fun isSatisfiedBy(element: FileTreeElement): Boolean =
        (includeDirectories && element.isDirectory) || element.file in files
}
