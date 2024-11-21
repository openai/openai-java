// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.azure.addPathSegmentsForAzure
import com.openai.azure.replaceBearerTokenForAzure
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.json
import com.openai.errors.OpenAIError
import com.openai.models.CreateEmbeddingResponse
import com.openai.models.EmbeddingCreateParams
import java.util.concurrent.CompletableFuture

class EmbeddingServiceAsyncImpl
constructor(
    private val clientOptions: ClientOptions,
) : EmbeddingServiceAsync {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<CreateEmbeddingResponse> =
        jsonHandler<CreateEmbeddingResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Creates an embedding vector representing the input text. */
    override fun create(
        params: EmbeddingCreateParams,
        requestOptions: RequestOptions
    ): CompletableFuture<CreateEmbeddingResponse> {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegmentsForAzure(clientOptions, params.model().toString())
                .addPathSegments("embeddings")
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceBearerTokenForAzure(clientOptions)
                .replaceAllHeaders(params.getHeaders())
                .body(json(clientOptions.jsonMapper, params.getBody()))
                .build()
        return clientOptions.httpClient.executeAsync(request, requestOptions).thenApply { response
            ->
            response
                .use { createHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }
}
