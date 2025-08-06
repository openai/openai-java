package com.openai.azure

/**
 * To force the deployment or model named to be part of the URL path for Azure OpenAI requests, use
 * [AzureUrlPathMode.LEGACY]. The default is [AzureUrlPathMode.UNIFIED].
 */
enum class AzureUrlPathMode {
    LEGACY,
    UNIFIED,
}
