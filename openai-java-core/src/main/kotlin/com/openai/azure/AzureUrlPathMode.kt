package com.openai.azure

/**
 * To force the deployment or model named to be part of the URL path for Azure OpenAI requests, use [AzureUrlPathMode.LEGACY].
 * The default is [AzureUrlPathMode.UNIFIED].
 */
enum class AzureUrlPathMode {
    LEGACY,
    UNIFIED;

    companion object {

        /**
         * Classifies the given [baseUrl] into an [AzureUrlPathMode] for outgoing requests
         */
        private fun classifyPath(baseUrl: String): AzureUrlPathMode {
            return when {
                baseUrl.trimEnd('/').endsWith("openai/v1") -> UNIFIED
                else -> LEGACY
            }
        }

        /**
         * Returns whether the given [baseUrl] contains a unified Azure path. Used in outgoing requests.
         */
        @JvmSynthetic
        internal fun isUnifiedPath(baseUrl: String): Boolean = classifyPath(baseUrl) == UNIFIED
    }
}

/**
 * Returns whether the given [AzureUrlPathMode] is in a disabled state.
 */
fun AzureUrlPathMode.isUnifiedPathDisabled(): Boolean = this == AzureUrlPathMode.LEGACY