// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.chat

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.mapJson
import com.openai.core.handlers.sseHandler
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.core.http.json
import com.openai.core.http.map
import com.openai.core.http.parseable
import com.openai.core.http.toAsync
import com.openai.core.prepareAsync
import com.openai.models.chat.completions.ChatCompletion
import com.openai.models.chat.completions.ChatCompletionChunk
import com.openai.models.chat.completions.ChatCompletionCreateParams
import com.openai.models.chat.completions.ChatCompletionDeleteParams
import com.openai.models.chat.completions.ChatCompletionDeleted
import com.openai.models.chat.completions.ChatCompletionListPageAsync
import com.openai.models.chat.completions.ChatCompletionListPageResponse
import com.openai.models.chat.completions.ChatCompletionListParams
import com.openai.models.chat.completions.ChatCompletionRetrieveParams
import com.openai.models.chat.completions.ChatCompletionUpdateParams
import com.openai.services.async.chat.completions.MessageServiceAsync
import com.openai.services.async.chat.completions.MessageServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ChatCompletionServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : ChatCompletionServiceAsync {

    private val withRawResponse: ChatCompletionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val messages: MessageServiceAsync by lazy { MessageServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): ChatCompletionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): ChatCompletionServiceAsync =
        ChatCompletionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun messages(): MessageServiceAsync = messages

    override fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChatCompletion> =
        // post /chat/completions
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun createStreaming(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions,
    ): AsyncStreamResponse<ChatCompletionChunk> =
        // post /chat/completions
        withRawResponse()
            .createStreaming(params, requestOptions)
            .thenApply { it.parse() }
            .toAsync(clientOptions.streamHandlerExecutor)

    override fun retrieve(
        params: ChatCompletionRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChatCompletion> =
        // get /chat/completions/{completion_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun update(
        params: ChatCompletionUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChatCompletion> =
        // post /chat/completions/{completion_id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: ChatCompletionListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChatCompletionListPageAsync> =
        // get /chat/completions
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun delete(
        params: ChatCompletionDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ChatCompletionDeleted> =
        // delete /chat/completions/{completion_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChatCompletionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val messages: MessageServiceAsync.WithRawResponse by lazy {
            MessageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ChatCompletionServiceAsync.WithRawResponse =
            ChatCompletionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun messages(): MessageServiceAsync.WithRawResponse = messages

        private val createHandler: Handler<ChatCompletion> =
            jsonHandler<ChatCompletion>(clientOptions.jsonMapper)

        override fun create(
            params: ChatCompletionCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chat", "completions")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, params.model().toString())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val createStreamingHandler: Handler<StreamResponse<ChatCompletionChunk>> =
            sseHandler(clientOptions.jsonMapper).mapJson<ChatCompletionChunk>()

        override fun createStreaming(
            params: ChatCompletionCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StreamResponse<ChatCompletionChunk>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
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
                    .prepareAsync(clientOptions, params, params.model().toString())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
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

        private val retrieveHandler: Handler<ChatCompletion> =
            jsonHandler<ChatCompletion>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ChatCompletionRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("completionId", params.completionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chat", "completions", params._pathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params, null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val updateHandler: Handler<ChatCompletion> =
            jsonHandler<ChatCompletion>(clientOptions.jsonMapper)

        override fun update(
            params: ChatCompletionUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChatCompletion>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("completionId", params.completionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chat", "completions", params._pathParam(0))
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { updateHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<ChatCompletionListPageResponse> =
            jsonHandler<ChatCompletionListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: ChatCompletionListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChatCompletionListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chat", "completions")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        deploymentModel = params.model().map { it.toString() }.getOrNull(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                ChatCompletionListPageAsync.builder()
                                    .service(ChatCompletionServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }

        private val deleteHandler: Handler<ChatCompletionDeleted> =
            jsonHandler<ChatCompletionDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: ChatCompletionDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ChatCompletionDeleted>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("completionId", params.completionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chat", "completions", params._pathParam(0))
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params, null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { deleteHandler.handle(it) }
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
