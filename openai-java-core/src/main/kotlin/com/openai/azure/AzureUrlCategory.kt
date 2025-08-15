package com.openai.azure

import java.net.URI

/** Represents the category of an Azure URL. */
internal enum class AzureUrlCategory {
    /** Azure host _not_ ending with `/openai/v1`. */
    AZURE_LEGACY,
    /** Azure host ending with `/openai/v1`. */
    AZURE_UNIFIED,
    /** Anything else. */
    NON_AZURE;

    fun isAzure(): Boolean =
        when (this) {
            AZURE_LEGACY,
            AZURE_UNIFIED -> true
            NON_AZURE -> false
        }

    companion object {

        fun categorizeBaseUrl(baseUrl: String, pathMode: AzureUrlPathMode): AzureUrlCategory {
            val trimmedBaseUrl = baseUrl.trim().trimEnd('/')
            val host = URI.create(trimmedBaseUrl).host

            return when (pathMode) {
                AzureUrlPathMode.LEGACY -> AZURE_LEGACY
                AzureUrlPathMode.UNIFIED -> AZURE_UNIFIED
                AzureUrlPathMode.AUTO ->
                    when {
                        host.endsWith(".openai.azure.com", ignoreCase = true) ||
                            // Azure OpenAI resource URL with the OpenAI unified schema.
                            host.endsWith(".services.ai.azure.com", ignoreCase = true) ||
                            // Azure OpenAI resource URL, but with a schema different to the known
                            // ones.
                            host.endsWith(".azure-api.net", ignoreCase = true) ||
                            host.endsWith(".cognitiveservices.azure.com", ignoreCase = true) ->
                            if (trimmedBaseUrl.endsWith("/openai/v1")) AZURE_UNIFIED
                            else AZURE_LEGACY

                        else -> NON_AZURE
                    }
            }
        }
    }
}
