package com.openai.azure

import com.openai.core.ClientOptions
import com.openai.core.http.HttpRequest
import com.openai.core.isAzureEndpoint
import com.openai.core.isAzureUnifiedEndpointPath
import com.openai.credential.BearerTokenCredential

@JvmSynthetic
internal fun HttpRequest.Builder.addPathSegmentsForAzure(
    clientOptions: ClientOptions,
    deploymentModel: String?,
): HttpRequest.Builder = apply {
    val baseUrl = clientOptions.baseUrl()
    if (isAzureEndpoint(baseUrl)) {
        // Users can toggle off unified Azure routes using the "azureLegacyPaths" option.
        // Endpoints are assumed to be provided with `/openai/v1` in their path already.
        if (clientOptions.azureLegacyPaths || !isAzureUnifiedEndpointPath(baseUrl)) {
            // Legacy known Azure endpoints are treated the old way.
            addPathSegment("openai")
            deploymentModel?.let { addPathSegments("deployments", it) }
        }
    }
}

@JvmSynthetic
internal fun HttpRequest.Builder.replaceBearerTokenForAzure(
    clientOptions: ClientOptions
): HttpRequest.Builder = apply {
    if (
        isAzureEndpoint(clientOptions.baseUrl()) &&
            clientOptions.credential is BearerTokenCredential
    ) {
        replaceHeaders("Authorization", "Bearer ${clientOptions.credential.token()}")
    }
}
