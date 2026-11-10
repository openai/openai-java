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

    @get:Input abstract val compileClasspaths: MapProperty<String, List<String>>
    @get:Input abstract val fixtureClasses: ListProperty<String>
    @get:Input abstract val fixtureConsumers: ListProperty<String>

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
        val fixture = fixtureClasses.get().toSet()
        check(fixture.isNotEmpty()) { "Shared fixture must declare its class directories" }
        val consumers = fixtureConsumers.get().toSet()
        compileClasspaths.get().forEach { (name, classpath) ->
            val included = classpath.toSet().intersect(fixture)
            check(if (name in consumers) included == fixture else included.isEmpty()) {
                "Unexpected shared-fixture classpath for $name: $included"
            }
        }
        logger.lifecycle(
            "Verified {} core Kotlin tests belong to exactly one source set",
            expected.size,
        )
        logger.lifecycle("Verified shared-fixture classpaths for {} consumers", consumers.size)
    }
}
