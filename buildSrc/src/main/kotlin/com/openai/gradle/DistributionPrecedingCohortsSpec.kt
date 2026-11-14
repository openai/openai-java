package com.openai.gradle

import java.io.Serializable
import org.gradle.api.file.FileTreeElement
import org.gradle.api.specs.Spec

/** Removes sources already compiled by earlier cohorts from the main Kotlin task only. */
class DistributionPrecedingCohortsSpec(private val earlier: List<CoreCompilationShard>) :
    Spec<FileTreeElement>, Serializable {
    override fun isSatisfiedBy(element: FileTreeElement): Boolean =
        !element.isDirectory &&
            CoreCompilationShards.shardFor(element.relativePath.pathString) in earlier
}
