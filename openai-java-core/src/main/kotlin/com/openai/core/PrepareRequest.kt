@file:JvmName("PrepareRequest")

package com.openai.core

import com.openai.azure.addPathSegmentsForAzure
import com.openai.azure.replaceBearerTokenForAzure
import com.openai.core.http.HttpRequest
import java.util.Optional
import java.util.concurrent.CompletableFuture
import kotlin.reflect.full.declaredFunctions

@JvmSynthetic
internal fun HttpRequest.prepare(clientOptions: ClientOptions, params: Params): HttpRequest =
    toBuilder()
        // Clear the path segments and add them back below after the Azure path segments.
        .pathSegments(listOf())
        .addPathSegmentsForAzure(clientOptions, params.modelNameOrNull())
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
): CompletableFuture<HttpRequest> =
    // This async version exists to make it easier to add async specific preparation logic in the
    // future.
    CompletableFuture.completedFuture(prepare(clientOptions, params))

@JvmSynthetic
internal fun Params.modelNameOrNull(): String? =
    try {
        this::class
            .declaredFunctions
            .find { it.name == "model" }
            ?.call(this)
            ?.let {
                when (it) {
                    is Optional<*> -> it.orElse(null)?.toString()
                    else -> it.toString()
                }
            }
    } catch (_: Exception) {
        // Return `null` if `model()` takes parameters, is `private`, or other similar issues.
        null
    }
