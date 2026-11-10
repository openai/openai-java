package com.openai.gradle

import org.gradle.api.DefaultTask
import org.gradle.api.provider.ListProperty
import org.gradle.api.provider.MapProperty
import org.gradle.api.tasks.Input
import org.gradle.api.tasks.TaskAction

/** Check the actual source-set wiring, independently of compiler task source overrides. */
abstract class VerifyCoreTestSourceSets : DefaultTask() {
    @get:Input abstract val originalSources: ListProperty<String>
    @get:Input abstract val memberships: MapProperty<String, List<String>>

    @TaskAction
    fun verify() {
        val expected = originalSources.get().toSet()
        val counts = memberships.get().values.flatten().groupingBy { it }.eachCount()
        val missing = expected - counts.keys
        val unexpected = counts.keys - expected
        val duplicates = counts.filterValues { it != 1 }.keys
        check(missing.isEmpty() && unexpected.isEmpty() && duplicates.isEmpty()) {
            "Core test source sets must cover every source exactly once: " +
                "missing=${missing.take(10)}, unexpected=${unexpected.take(10)}, " +
                "duplicates=${duplicates.take(10)}"
        }
        logger.lifecycle(
            "Verified {} core Kotlin tests belong to exactly one source set",
            expected.size,
        )
    }
}
