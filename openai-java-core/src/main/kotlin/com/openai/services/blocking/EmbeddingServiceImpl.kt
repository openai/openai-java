// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.json
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.CreateEmbeddingResponse
import com.openai.models.EmbeddingCreateParams

class EmbeddingServiceImpl
internal constructor(
    private val clientOptions: ClientOptions,
) : EmbeddingService {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val createHandler: Handler<CreateEmbeddingResponse> =
        jsonHandler<CreateEmbeddingResponse>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Creates an embedding vector representing the input text. */
    override fun create(
        params: EmbeddingCreateParams,
        requestOptions: RequestOptions
    ): CreateEmbeddingResponse {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.POST)
                .addPathSegments("embeddings")
                .body(json(clientOptions.jsonMapper, params._body()))
                .build()
                .prepare(clientOptions, params, params.model().toString())
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
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
