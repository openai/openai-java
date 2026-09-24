@file:JvmName("PrepareRequest")

package com.openai.core

import com.openai.azure.addPathSegmentsForAzure
import com.openai.azure.replaceBearerTokenForAzure
import com.openai.core.http.HttpRequest
import com.openai.core.http.closeMultipartOnFailure
import com.openai.errors.InvalidResourceIdException
import java.util.Optional
import java.util.concurrent.CompletableFuture
import kotlin.reflect.full.declaredFunctions

@JvmSynthetic
internal fun HttpRequest.prepare(
    clientOptions: ClientOptions,
    params: Params,
    security: SecurityOptions = SecurityOptions.all(),
): HttpRequest {
    try {
        val routedRequest =
            toBuilder()
                // Include Azure deployment segments before validating the final resource path.
                .pathSegments(listOf())
                .addPathSegmentsForAzure(clientOptions, params.modelNameOrNull())
                .addPathSegments(*pathSegments.toTypedArray())
                .build()
        if (routedRequest.pathSegments.any { it.isEmpty() || it == "." || it == ".." }) {
            // Rejected requests never reach transport, which normally owns body cleanup.
            routedRequest.body.use { throw InvalidResourceIdException() }
        }
        return routedRequest
            .toBuilder()
            .putAllQueryParams(clientOptions.queryParams)
            .replaceAllQueryParams(params._queryParams())
            .putAllHeaders(clientOptions.securityHeaders(security))
            .putAllHeaders(clientOptions.headers)
            .replaceBearerTokenForAzure(clientOptions)
            .replaceAllHeaders(params._headers())
            .build()
    } catch (failure: Throwable) {
        body.closeMultipartOnFailure(failure)
        throw failure
    }
}

@JvmSynthetic
internal fun HttpRequest.prepareAsync(
    clientOptions: ClientOptions,
    params: Params,
    security: SecurityOptions = SecurityOptions.all(),
): CompletableFuture<HttpRequest> =
    try {
        CompletableFuture.completedFuture(prepare(clientOptions, params, security))
    } catch (failure: InvalidResourceIdException) {
        // Deliver the new validation error through the future while preserving the existing
        // synchronous behavior of unrelated preparation failures. Compatible with Java 8.
        CompletableFuture<HttpRequest>().apply { completeExceptionally(failure) }
    }

@JvmSynthetic
internal fun Params.modelNameOrNull(): String? {
    val modelName =
        try {
            this::class.declaredFunctions.find { it.name == "model" }?.call(this)
        } catch (_: Exception) {
            // Use `null` if `model()` takes parameters, is `private`, or other similar issues that
            // prevent it from being called successfully.
            null
        }

    return when (modelName) {
        is Optional<*> -> modelName.orElse(null)?.toString()
        else -> modelName?.toString()
    }
}
