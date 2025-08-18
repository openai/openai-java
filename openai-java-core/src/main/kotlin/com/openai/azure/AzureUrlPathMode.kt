package com.openai.azure

/**
 * Configures how the baseURL of [com.openai.core.ClientOptions] is treated for Azure OpenAI endpoints.
 */
enum class AzureUrlPathMode {
    /** Forces the deployment or model name into the path.*/
    LEGACY,
    /** [AzureOpenAIServiceVersion] is optional and the model is part of the request. */
    UNIFIED,
    /** Automatically detects the path mode based on the base URL. This is the default value. */
    AUTO,
}
