// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.core

/**
 * Selects an OpenAI API endpoint by region.
 *
 * Regional storage and processing depend on project configuration and support for the selected
 * region, model, and API feature. See the
 * [data residency guide](https://developers.openai.com/api/docs/guides/your-data#data-residency).
 */
enum class DataResidency(private val value: String, internal val baseUrl: String) {

    GLOBAL("global", "https://api.openai.com/v1"),
    US("us", "https://us.api.openai.com/v1"),
    EU("eu", "https://eu.api.openai.com/v1"),
    AE("ae", "https://ae.api.openai.com/v1"),
    AU("au", "https://au.api.openai.com/v1"),
    IN("in", "https://in.api.openai.com/v1"),
    JP("jp", "https://jp.api.openai.com/v1");

    fun value(): String = value

    companion object {
        /** Returns the residency matching the lowercase configuration value. */
        @JvmStatic
        fun of(value: String): DataResidency =
            values().firstOrNull { it.value == value }
                ?: throw IllegalArgumentException("Unknown data residency: $value")
    }
}
