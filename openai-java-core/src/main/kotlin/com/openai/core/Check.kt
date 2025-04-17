@file:JvmName("Check")

package com.openai.core

import com.fasterxml.jackson.core.Version
import com.fasterxml.jackson.core.util.VersionUtil

fun <T : Any> checkRequired(name: String, value: T?): T =
    checkNotNull(value) { "`$name` is required, but was not set" }

@JvmSynthetic
internal fun <T : Any> checkKnown(name: String, value: JsonField<T>): T =
    value.asKnown().orElseThrow {
        IllegalStateException("`$name` is not a known type: ${value.javaClass.simpleName}")
    }

@JvmSynthetic
internal fun <T : Any> checkKnown(name: String, value: MultipartField<T>): T =
    value.value.asKnown().orElseThrow {
        IllegalStateException("`$name` is not a known type: ${value.javaClass.simpleName}")
    }

@JvmSynthetic
internal fun checkLength(name: String, value: String, length: Int): String =
    value.also {
        check(it.length == length) { "`$name` must have length $length, but was ${it.length}" }
    }

@JvmSynthetic
internal fun checkMinLength(name: String, value: String, minLength: Int): String =
    value.also {
        check(it.length >= minLength) {
            if (minLength == 1) "`$name` must be non-empty, but was empty"
            else "`$name` must have at least length $minLength, but was ${it.length}"
        }
    }

@JvmSynthetic
internal fun checkMaxLength(name: String, value: String, maxLength: Int): String =
    value.also {
        check(it.length <= maxLength) {
            "`$name` must have at most length $maxLength, but was ${it.length}"
        }
    }

@JvmSynthetic
internal fun checkJacksonVersionCompatibility() {
    val incompatibleJacksonVersions =
        RUNTIME_JACKSON_VERSIONS.mapNotNull {
            val badVersionReason = BAD_JACKSON_VERSIONS[it.toString()]
            when {
                it.majorVersion != MINIMUM_JACKSON_VERSION.majorVersion ->
                    it to "incompatible major version"
                it.minorVersion < MINIMUM_JACKSON_VERSION.minorVersion ->
                    it to "minor version too low"
                it.minorVersion == MINIMUM_JACKSON_VERSION.minorVersion &&
                    it.patchLevel < MINIMUM_JACKSON_VERSION.patchLevel ->
                    it to "patch version too low"
                badVersionReason != null -> it to badVersionReason
                else -> null
            }
        }
    check(incompatibleJacksonVersions.isEmpty()) {
        """
This SDK requires a minimum Jackson version of $MINIMUM_JACKSON_VERSION, but the following incompatible Jackson versions were detected at runtime:

${incompatibleJacksonVersions.asSequence().map { (version, incompatibilityReason) ->
    "- `${version.toFullString().replace("/", ":")}` ($incompatibilityReason)"
}.joinToString("\n")}

This can happen if you are either:
1. Directly depending on different Jackson versions
2. Depending on some library that depends on different Jackson versions, potentially transitively

Double-check that you are depending on compatible Jackson versions.

See https://www.github.com/openai/openai-java#jackson for more information.
        """
            .trimIndent()
    }
}

private val MINIMUM_JACKSON_VERSION: Version = VersionUtil.parseVersion("2.13.4", null, null)
private val BAD_JACKSON_VERSIONS: Map<String, String> =
    mapOf("2.18.1" to "due to https://github.com/FasterXML/jackson-databind/issues/4639")
private val RUNTIME_JACKSON_VERSIONS: List<Version> =
    listOf(
        com.fasterxml.jackson.core.json.PackageVersion.VERSION,
        com.fasterxml.jackson.databind.cfg.PackageVersion.VERSION,
        com.fasterxml.jackson.datatype.jdk8.PackageVersion.VERSION,
        com.fasterxml.jackson.datatype.jsr310.PackageVersion.VERSION,
        com.fasterxml.jackson.module.kotlin.PackageVersion.VERSION,
    )
