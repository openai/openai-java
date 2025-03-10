// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.errors.OpenAIError
import com.openai.models.audio.transcriptions.TranscriptionCreateParams
import com.openai.models.audio.transcriptions.TranscriptionCreateResponse
import java.util.concurrent.CompletableFuture

class TranscriptionServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TranscriptionServiceAsync {

    private val withRawResponse: TranscriptionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TranscriptionServiceAsync.WithRawResponse = withRawResponse

    override fun create(
        params: TranscriptionCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<TranscriptionCreateResponse> =
        // post /audio/transcriptions
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TranscriptionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<TranscriptionCreateResponse> =
            jsonHandler<TranscriptionCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: TranscriptionCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TranscriptionCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("audio", "transcriptions")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }
    }
}
