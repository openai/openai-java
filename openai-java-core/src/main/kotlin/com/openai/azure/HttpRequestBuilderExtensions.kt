package com.openai.azure

import com.openai.core.ClientOptions
import com.openai.core.http.HttpRequest
import com.openai.credential.BearerTokenCredential

@JvmSynthetic
internal fun HttpRequest.Builder.addPathSegmentsForAzure(
    clientOptions: ClientOptions,
    deploymentModel: String?,
): HttpRequest.Builder = apply {
    val urlCategory =
        AzureUrlCategory.categorizeBaseUrl(clientOptions.baseUrl(), clientOptions.azureUrlPathMode)
    if (urlCategory == AzureUrlCategory.AZURE_LEGACY) {
        // Legacy known Azure endpoints are treated the old way.
        addPathSegment("openai")
        deploymentModel?.let { addPathSegments("deployments", it) }
    }
}

@JvmSynthetic
internal fun HttpRequest.Builder.replaceBearerTokenForAzure(
    clientOptions: ClientOptions
): HttpRequest.Builder = apply {
    val urlCategory =
        AzureUrlCategory.categorizeBaseUrl(clientOptions.baseUrl(), clientOptions.azureUrlPathMode)
    if (urlCategory.isAzure() && clientOptions.credential is BearerTokenCredential) {
        replaceHeaders("Authorization", "Bearer ${clientOptions.credential.token()}")
    }
}
