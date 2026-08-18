package com.openai.azure

import java.net.URI

/** Represents a recognized provider origin and the Azure URL routing category, when applicable. */
internal enum class AzureUrlCategory(val providerName: String?) {
    /** Azure host _not_ ending with `/openai/v1`. */
    AZURE_LEGACY("Azure"),
    /** Azure host ending with `/openai/v1`. */
    AZURE_UNIFIED("Azure"),
    /** Canonical Amazon Bedrock endpoint. */
    BEDROCK("Amazon Bedrock"),
    /** OpenAI or a caller-owned custom gateway. */
    NON_AZURE(null);

    fun isAzure(): Boolean =
        when (this) {
            AZURE_LEGACY,
            AZURE_UNIFIED -> true
            BEDROCK,
            NON_AZURE -> false
        }

    companion object {

        private val AWS_REGION_PATTERN = Regex("^[a-z]{2,8}(?:-[a-z0-9]+)+-\\d+$")
        private val BEDROCK_RUNTIME_DNS_SUFFIXES =
            setOf(
                "amazonaws.com",
                "api.aws",
                "amazonaws.com.cn",
                "api.amazonwebservices.com.cn",
                "amazonaws.eu",
                "api.amazonwebservices.eu",
                "c2s.ic.gov",
                "sc2s.sgov.gov",
                "cloud.adc-e.uk",
                "csp.hci.ic.gov",
            )

        fun categorizeBaseUrl(baseUrl: String, pathMode: AzureUrlPathMode): AzureUrlCategory {
            val trimmedBaseUrl = baseUrl.trim().trimEnd('/')
            val host = URI.create(trimmedBaseUrl).host.removeSuffix(".").lowercase()

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

                        isCanonicalBedrockHost(host) -> BEDROCK

                        else -> NON_AZURE
                    }
            }
        }

        private fun isCanonicalBedrockHost(host: String): Boolean {
            val parts = host.split('.', limit = 3)
            if (parts.size != 3 || !AWS_REGION_PATTERN.matches(parts[1])) {
                return false
            }

            return when (parts[0]) {
                "bedrock-mantle" -> parts[2] == "api.aws"
                "bedrock-runtime",
                "bedrock-runtime-fips" -> parts[2] in BEDROCK_RUNTIME_DNS_SUFFIXES
                else -> false
            }
        }
    }
}
