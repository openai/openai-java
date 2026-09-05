@file:JvmName("PrepareRequest")

package com.openai.core

import com.openai.azure.addPathSegmentsForAzure
import com.openai.azure.replaceBearerTokenForAzure
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpRequestBody
import java.io.OutputStream
import java.util.Optional
import java.util.concurrent.CompletableFuture
import java.util.concurrent.atomic.AtomicBoolean
import kotlin.reflect.full.declaredFunctions

@JvmSynthetic
internal fun HttpRequest.prepare(
    clientOptions: ClientOptions,
    params: Params,
    security: SecurityOptions = SecurityOptions.all(),
): HttpRequest =
    toBuilder()
        // Clear the path segments and add them back below after the Azure path segments.
        .pathSegments(listOf())
        .addPathSegmentsForAzure(clientOptions, params.modelNameOrNull())
        .addPathSegments(*pathSegments.toTypedArray())
        .putAllQueryParams(clientOptions.queryParams)
        .replaceAllQueryParams(params._queryParams())
        .putAllHeaders(clientOptions.securityHeaders(security))
        .putAllHeaders(clientOptions.headers)
        .replaceBearerTokenForAzure(clientOptions)
        .replaceAllHeaders(params._headers())
        .build()

@JvmSynthetic
internal fun HttpRequest.prepareAsync(
    clientOptions: ClientOptions,
    params: Params,
    security: SecurityOptions = SecurityOptions.all(),
): CompletableFuture<HttpRequest> {
    // This async version exists to make it easier to add async specific preparation logic in the
    // future.
    val prepared = prepare(clientOptions, params, security)
    val body = prepared.body
    val owned =
        if (body != null && !body.repeatable()) {
            prepared.toBuilder().body(CloseOnceHttpRequestBody(body)).build()
        } else prepared
    return CancellableFuture.wrap(CompletableFuture.completedFuture(owned))
}

private class CloseOnceHttpRequestBody(private val body: HttpRequestBody) : HttpRequestBody {
    private val closed = AtomicBoolean()

    override fun writeTo(outputStream: OutputStream) = body.writeTo(outputStream)

    override fun contentType() = body.contentType()

    override fun contentLength() = body.contentLength()

    override fun repeatable() = body.repeatable()

    override fun close() {
        if (closed.compareAndSet(false, true)) body.close()
    }
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
