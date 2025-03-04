package com.openai.azure.credential

import com.openai.credential.Credential

/** A credential that provides an Azure API key. */
class AzureApiKeyCredential private constructor(private var apiKey: String) : Credential {

    init {
        validateApiKey(apiKey)
    }

    companion object {
        @JvmStatic fun create(apiKey: String): Credential = AzureApiKeyCredential(apiKey)

        private fun validateApiKey(apiKey: String) {
            require(apiKey.isNotEmpty()) { "Azure API key cannot be empty." }
        }
    }

    fun apiKey(): String = apiKey

    fun update(apiKey: String) = apply {
        validateApiKey(apiKey)
        this.apiKey = apiKey
    }
}
