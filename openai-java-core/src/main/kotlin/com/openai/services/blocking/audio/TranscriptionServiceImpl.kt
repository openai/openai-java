// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.audio

import com.openai.core.ClientOptions
import com.openai.core.MultipartField
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.mapJson
import com.openai.core.handlers.sseHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.core.http.map
import com.openai.core.http.multipartFormData
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.audio.transcriptions.TranscriptionCreateParams
import com.openai.models.audio.transcriptions.TranscriptionCreateResponse
import com.openai.models.audio.transcriptions.TranscriptionStreamEvent

class TranscriptionServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    TranscriptionService {

    private val withRawResponse: TranscriptionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TranscriptionService.WithRawResponse = withRawResponse

    override fun create(
        params: TranscriptionCreateParams,
        requestOptions: RequestOptions,
    ): TranscriptionCreateResponse =
        // post /audio/transcriptions
        withRawResponse().create(params, requestOptions).parse()

    override fun createStreaming(
        params: TranscriptionCreateParams,
        requestOptions: RequestOptions,
    ): StreamResponse<TranscriptionStreamEvent> =
        // post /audio/transcriptions
        withRawResponse().createStreaming(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TranscriptionService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<TranscriptionCreateResponse> =
            jsonHandler<TranscriptionCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: TranscriptionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TranscriptionCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("audio", "transcriptions")
                    .body(multipartFormData(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, deploymentModel = params.model().toString())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val createStreamingHandler: Handler<StreamResponse<TranscriptionStreamEvent>> =
            sseHandler(clientOptions.jsonMapper)
                .mapJson<TranscriptionStreamEvent>()
                .withErrorHandler(errorHandler)

        override fun createStreaming(
            params: TranscriptionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<TranscriptionStreamEvent>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("audio", "transcriptions")
                    .body(
                        multipartFormData(
                            clientOptions.jsonMapper,
                            params._body() + ("stream" to MultipartField.of(true)),
                        )
                    )
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .let { createStreamingHandler.handle(it) }
                    .let { streamResponse ->
                        if (requestOptions.responseValidation!!) {
                            streamResponse.map { it.validate() }
                        } else {
                            streamResponse
                        }
                    }
            }
        }
    }
}
