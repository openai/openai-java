// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.chat

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
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
import com.openai.core.http.json
import com.openai.core.http.map
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.errors.OpenAIError
import com.openai.models.chat.completions.ChatCompletion
import com.openai.models.chat.completions.ChatCompletionChunk
import com.openai.models.chat.completions.ChatCompletionCreateParams

class ChatCompletionServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ChatCompletionService {

    private val withRawResponse: ChatCompletionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ChatCompletionService.WithRawResponse = withRawResponse

    override fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions,
    ): ChatCompletion =
        // post /chat/completions
        withRawResponse().create(params, requestOptions).parse()

    override fun createStreaming(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions,
    ): StreamResponse<ChatCompletionChunk> =
        // post /chat/completions
        withRawResponse().createStreaming(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChatCompletionService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val createHandler: Handler<ChatCompletion> =
            jsonHandler<ChatCompletion>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: ChatCompletionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChatCompletion> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("chat", "completions")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
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

        private val createStreamingHandler: Handler<StreamResponse<ChatCompletionChunk>> =
            sseHandler(clientOptions.jsonMapper)
                .mapJson<ChatCompletionChunk>()
                .withErrorHandler(errorHandler)

        override fun createStreaming(
            params: ChatCompletionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<ChatCompletionChunk>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("chat", "completions")
                    .body(
                        json(
                            clientOptions.jsonMapper,
                            params
                                ._body()
                                .toBuilder()
                                .putAdditionalProperty("stream", JsonValue.from(true))
                                .build(),
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
