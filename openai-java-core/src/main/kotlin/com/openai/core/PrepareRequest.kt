@file:JvmName("PrepareRequest")

package com.openai.core

import com.openai.core.http.HttpRequest
import java.util.concurrent.CompletableFuture

@JvmSynthetic
internal fun HttpRequest.prepare(
    clientOptions: ClientOptions,
    params: Params,
    security: SecurityOptions = SecurityOptions.all(),
): HttpRequest =
    toBuilder()
        .putAllQueryParams(clientOptions.queryParams)
        .replaceAllQueryParams(params._queryParams())
        .putAllHeaders(clientOptions.securityHeaders(security))
        .putAllHeaders(clientOptions.headers)
        .replaceAllHeaders(params._headers())
        .build()

@JvmSynthetic
internal fun HttpRequest.prepareAsync(
    clientOptions: ClientOptions,
    params: Params,
    security: SecurityOptions = SecurityOptions.all(),
): CompletableFuture<HttpRequest> =
    // This async version exists to make it easier to add async specific preparation logic in the
    // future.
    CompletableFuture.completedFuture(prepare(clientOptions, params, security))
