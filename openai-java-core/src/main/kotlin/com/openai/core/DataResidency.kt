// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.core

/** Selects an OpenAI endpoint for request-scoped data and compute residency. */
enum class DataResidency(
    private val value: String,
    internal val baseUrl: String,
    internal val mutualTlsBaseUrl: String?,
) {

    GLOBAL("global", "https://api.openai.com/v1", "https://mtls.api.openai.com/v1"),
    US("us", "https://us.api.openai.com/v1", null),
    EU("eu", "https://eu.api.openai.com/v1", "https://mtls-eu.api.openai.com/v1"),
    AE("ae", "https://ae.api.openai.com/v1", null);

    fun value(): String = value

    companion object {
        /** Returns the residency matching the lowercase configuration value. */
        @JvmStatic
        fun of(value: String): DataResidency =
            values().firstOrNull { it.value == value }
                ?: throw IllegalArgumentException("Unknown data residency: $value")
    }
}
