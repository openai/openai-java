package com.openai.azure

/**
 * For Azure OpenAI endpoints, this enum configures the client to:
 * - [AzureUrlPathMode.LEGACY]: forces the deployment or model name into the path.
 * - [AzureUrlPathMode.UNIFIED]: matches the behaviour of OpenAI, meaning the [AzureOpenAIServiceVersion] is optional and the model is passed in the request object).
 * - [AzureUrlPathMode.AUTO]: automatically detects the path mode based on the base URL. This is the default value.
 */
enum class AzureUrlPathMode {
    LEGACY,
    UNIFIED,
    AUTO
}
