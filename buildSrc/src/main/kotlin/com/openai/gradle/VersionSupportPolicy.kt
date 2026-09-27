package com.openai.gradle

import java.io.File
import java.io.Serializable
import java.util.Properties

enum class ArtifactLifecycle(val propertyValue: String) {
    ACTIVE("active"),
    MAINTENANCE("maintenance"),
    DEPRECATED("deprecated"),
    EOL("eol");

    val isSupported: Boolean
        get() = this != EOL

    companion object {
        fun parse(value: String, property: String): ArtifactLifecycle =
            values().find { it.propertyValue == value }
                ?: error(
                    "$property must be one of ${values().map { it.propertyValue }}, but was '$value'"
                )
    }
}

data class ArtifactSupport(val runtime: Int, val lifecycle: ArtifactLifecycle) : Serializable

data class VersionSupportPolicy(
    val buildJdk: Int,
    val currentLts: Int,
    val supportedLts: List<Int>,
    val currentNonLts: Int,
    val artifacts: Map<String, ArtifactSupport>,
) : Serializable {
    private val supportedArtifacts = artifacts.filterValues { it.lifecycle.isSupported }
    val minimumSupportedRuntime: Int = supportedArtifacts.values.minOf { it.runtime }

    fun runtimeFloor(projectName: String): Int =
        artifacts[projectName]?.runtime ?: minimumSupportedRuntime

    fun runtimeMatrix(mode: String): List<Int> {
        val supportedArtifactFloors = supportedArtifacts.values.map(ArtifactSupport::runtime)
        return when (mode) {
                "pull-request" -> supportedArtifactFloors + currentLts
                "full" -> supportedLts + currentNonLts
                else ->
                    error(
                        "Unknown version support matrix '$mode'; expected 'pull-request' or 'full'"
                    )
            }
            .distinct()
            .sorted()
    }

    companion object {
        private val requiredKeys =
            setOf("build.jdk", "test.current-lts", "test.supported-lts", "test.current-non-lts")
        private val artifactKey = Regex("""artifact\.(.+)\.(runtime|lifecycle)""")

        fun load(file: File): VersionSupportPolicy {
            check(file.isFile) { "Version support policy does not exist: $file" }

            val properties = Properties().apply { file.inputStream().use(::load) }
            val unknownKeys =
                properties.stringPropertyNames().filterNot { key ->
                    key in requiredKeys || artifactKey.matches(key)
                }
            check(unknownKeys.isEmpty()) {
                "Unknown version support properties in $file: ${unknownKeys.sorted()}"
            }

            val missingKeys = requiredKeys.filterNot(properties::containsKey)
            check(missingKeys.isEmpty()) {
                "Missing version support properties in $file: ${missingKeys.sorted()}"
            }

            val artifactNames =
                properties
                    .stringPropertyNames()
                    .mapNotNull { artifactKey.matchEntire(it)?.groupValues?.get(1) }
                    .toSortedSet()
            check(artifactNames.isNotEmpty()) { "No artifact policies declared in $file" }

            val artifacts =
                artifactNames.associateWith { name ->
                    val runtime = properties.requiredInt("artifact.$name.runtime", file)
                    val lifecycleProperty = "artifact.$name.lifecycle"
                    val lifecycle =
                        ArtifactLifecycle.parse(
                            properties.required(lifecycleProperty, file),
                            lifecycleProperty,
                        )
                    ArtifactSupport(runtime = runtime, lifecycle = lifecycle)
                }
            check(artifacts.values.any { it.lifecycle.isSupported }) {
                "At least one artifact in $file must have a supported lifecycle"
            }

            val buildJdk = properties.requiredInt("build.jdk", file)
            val currentLts = properties.requiredInt("test.current-lts", file)
            val supportedLts =
                properties.required("test.supported-lts", file).split(',').map { value ->
                    value.trim().toIntOrNull()
                        ?: error("test.supported-lts contains invalid JVM '$value' in $file")
                }
            val currentNonLts = properties.requiredInt("test.current-non-lts", file)

            check(buildJdk > 0) { "build.jdk must be positive" }
            check(supportedLts.isNotEmpty() && supportedLts.all { it > 0 }) {
                "test.supported-lts must contain positive JVM versions"
            }
            check(supportedLts == supportedLts.distinct().sorted()) {
                "test.supported-lts must contain unique JVMs in ascending order"
            }
            check(currentLts in supportedLts) {
                "test.current-lts ($currentLts) must appear in test.supported-lts"
            }
            check(currentNonLts > currentLts) {
                "test.current-non-lts ($currentNonLts) must be newer than current LTS $currentLts"
            }
            artifacts.forEach { (name, support) ->
                check(support.runtime > 0) { "$name must declare a positive runtime floor" }
                check(support.runtime <= buildJdk) {
                    "$name requires Java ${support.runtime}, newer than build JDK $buildJdk"
                }
                check(!support.lifecycle.isSupported || support.runtime in supportedLts) {
                    "$name has supported runtime floor ${support.runtime}, which is absent from " +
                        "test.supported-lts"
                }
            }

            return VersionSupportPolicy(
                buildJdk = buildJdk,
                currentLts = currentLts,
                supportedLts = supportedLts,
                currentNonLts = currentNonLts,
                artifacts = artifacts,
            )
        }

        private fun Properties.required(key: String, file: File): String =
            getProperty(key)?.trim()?.takeIf(String::isNotEmpty)
                ?: error("Required version support property '$key' is missing or empty in $file")

        private fun Properties.requiredInt(key: String, file: File): Int =
            required(key, file).toIntOrNull()
                ?: error("Version support property '$key' must be an integer in $file")
    }
}
