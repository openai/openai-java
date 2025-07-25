package com.openai.azure

/**
 * Represents the category of an Azure URL based on the endpoint host.
 *
 *  Azure legacy endpoint should be in the format of `https://<region>.openai.azure.com`.
 *  Azure unified endpoint should be in the format of `https://<region>.services.ai.azure.com`.
 *  Azure OpenAI management URLs should be in the format of `https://<region>.azure-api.net`
 *  Other known Azure URLs `https://<region>.cognitiveservices.azure.com`.
 */
enum class AzureUrlCategory {
    AZURE_LEGACY, AZURE_UNIFIED, AZURE_OTHER, NON_AZURE;

    companion object {
        /**
         * Returns whether the given [urlHost] is an Azure endpoint.
         */
        fun isAzureEndpoint(urlHost: String): Boolean =
            categorizeBaseUrl(urlHost) != NON_AZURE

        /**
         * Returns the [AzureUrlCategory] of the given [urlHost] based on its host.
         */
        private fun categorizeBaseUrl(urlHost: String): AzureUrlCategory {
            return when {
                // Azure OpenAI resource URL with the old schema.
                urlHost.endsWith(".openai.azure.com", true) -> AZURE_LEGACY
                // Azure OpenAI resource URL with the OpenAI unified schema.
                urlHost.endsWith(".services.ai.azure.com", true) -> AZURE_UNIFIED
                // Azure OpenAI resource URL, but with a schema different to the known ones.
                urlHost.endsWith(".azure-api.net", true) ||
                        urlHost.endsWith(".cognitiveservices.azure.com", true) -> AZURE_OTHER
                else -> NON_AZURE
            }
        }
    }
}
