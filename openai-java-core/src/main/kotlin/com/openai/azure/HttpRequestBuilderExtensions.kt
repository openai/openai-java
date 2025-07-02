package com.openai.azure

import com.openai.core.ClientOptions
import com.openai.core.http.HttpRequest
import com.openai.core.isAzureEndpoint
import com.openai.core.isAzureUnifiedEndpoint
import com.openai.credential.BearerTokenCredential

@JvmSynthetic
internal fun HttpRequest.Builder.addPathSegmentsForAzure(
    clientOptions: ClientOptions,
    deploymentModel: String?,
): HttpRequest.Builder = apply {
    val baseUrl = clientOptions.baseUrl()
    if (isAzureEndpoint(baseUrl)) {
        addPathSegment("openai")
        // Users can toggle off unified Azure routes using the "unifiedAzureRoutes" option.
        if (clientOptions.unifiedAzureRoutes && isAzureUnifiedEndpoint(baseUrl)) {
            addPathSegment("v1")
        } else {
            // Unknown Azure endpoints and legacy Azure endpoints are treated the old way.
            // We are assuming in this branch that isAzureLegacyEndpoint(baseUrl) would be true for this base URL.
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
