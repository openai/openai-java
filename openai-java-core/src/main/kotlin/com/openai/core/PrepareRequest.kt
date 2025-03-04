@file:JvmName("PrepareRequest")

package com.openai.core

import com.openai.azure.addPathSegmentsForAzure
import com.openai.azure.replaceBearerTokenForAzure
import com.openai.core.http.HttpRequest
import java.util.concurrent.CompletableFuture

@JvmSynthetic
internal fun HttpRequest.prepare(
    clientOptions: ClientOptions,
    params: Params,
    deploymentModel: String?,
): HttpRequest =
    toBuilder()
        // Clear the path segments and add them back below after the Azure path segments.
        .pathSegments(listOf())
        .addPathSegmentsForAzure(clientOptions, deploymentModel)
        .addPathSegments(*pathSegments.toTypedArray())
        .putAllQueryParams(clientOptions.queryParams)
        .replaceAllQueryParams(params._queryParams())
        .putAllHeaders(clientOptions.headers)
        .replaceBearerTokenForAzure(clientOptions)
        .replaceAllHeaders(params._headers())
        .build()

@JvmSynthetic
internal fun HttpRequest.prepareAsync(
    clientOptions: ClientOptions,
    params: Params,
    deploymentModel: String?,
): CompletableFuture<HttpRequest> =
    // This async version exists to make it easier to add async specific preparation logic in the
    // future.
    CompletableFuture.completedFuture(prepare(clientOptions, params, deploymentModel))
