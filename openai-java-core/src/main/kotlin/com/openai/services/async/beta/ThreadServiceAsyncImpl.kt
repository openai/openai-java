// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

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
import com.openai.core.http.Headers
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
import com.openai.models.beta.assistants.AssistantStreamEvent
import com.openai.models.beta.threads.Thread
import com.openai.models.beta.threads.ThreadCreateAndRunParams
import com.openai.models.beta.threads.ThreadCreateParams
import com.openai.models.beta.threads.ThreadDeleteParams
import com.openai.models.beta.threads.ThreadDeleted
import com.openai.models.beta.threads.ThreadRetrieveParams
import com.openai.models.beta.threads.ThreadUpdateParams
import com.openai.models.beta.threads.runs.Run
import com.openai.services.async.beta.threads.MessageServiceAsync
import com.openai.services.async.beta.threads.MessageServiceAsyncImpl
import com.openai.services.async.beta.threads.RunServiceAsync
import com.openai.services.async.beta.threads.RunServiceAsyncImpl
import com.openai.core.http.CancellationTokenSource
import com.openai.core.withCancellation
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

@Deprecated("The Assistants API is deprecated in favor of the Responses API")
class ThreadServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ThreadServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: ThreadServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val runs: RunServiceAsync by lazy { RunServiceAsyncImpl(clientOptions) }

    private val messages: MessageServiceAsync by lazy { MessageServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): ThreadServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ThreadServiceAsync =
        ThreadServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun runs(): RunServiceAsync = runs

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun messages(): MessageServiceAsync = messages

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun create(
        params: ThreadCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Thread> =
        // post /threads
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun retrieve(
        params: ThreadRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Thread> =
        // get /threads/{thread_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun update(
        params: ThreadUpdateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Thread> =
        // post /threads/{thread_id}
        withRawResponse().update(params, requestOptions).thenApply { it.parse() }

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun delete(
        params: ThreadDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ThreadDeleted> =
        // delete /threads/{thread_id}
        withRawResponse().delete(params, requestOptions).thenApply { it.parse() }

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun createAndRun(
        params: ThreadCreateAndRunParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Run> =
        // post /threads/runs
        withRawResponse().createAndRun(params, requestOptions).thenApply { it.parse() }

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun createAndRunStreaming(
        params: ThreadCreateAndRunParams,
        requestOptions: RequestOptions,
    ): AsyncStreamResponse<AssistantStreamEvent> =
        // post /threads/runs
        withRawResponse()
            .createAndRunStreaming(params, requestOptions)
            .thenApply { it.parse() }
            .toAsync(clientOptions.streamHandlerExecutor)

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ThreadServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val runs: RunServiceAsync.WithRawResponse by lazy {
            RunServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val messages: MessageServiceAsync.WithRawResponse by lazy {
            MessageServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ThreadServiceAsync.WithRawResponse =
            ThreadServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun runs(): RunServiceAsync.WithRawResponse = runs

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun messages(): MessageServiceAsync.WithRawResponse = messages

        private val createHandler: Handler<Thread> = jsonHandler<Thread>(clientOptions.jsonMapper)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun create(
            params: ThreadCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Thread>> {
            val cancellationTokenSource = CancellationTokenSource()
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("threads")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val delegate =
                request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(
                            it,
                            requestOptions,
                            cancellationTokenSource.token()
                        ) }
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
        return delegate.withCancellation(cancellationTokenSource)
        }

        private val retrieveHandler: Handler<Thread> = jsonHandler<Thread>(clientOptions.jsonMapper)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun retrieve(
            params: ThreadRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Thread>> {
            val cancellationTokenSource = CancellationTokenSource()
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("threadId", params.threadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("threads", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val delegate =
                request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(
                            it,
                            requestOptions,
                            cancellationTokenSource.token()
                        ) }
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
        return delegate.withCancellation(cancellationTokenSource)
        }

        private val updateHandler: Handler<Thread> = jsonHandler<Thread>(clientOptions.jsonMapper)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun update(
            params: ThreadUpdateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Thread>> {
            val cancellationTokenSource = CancellationTokenSource()
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("threadId", params.threadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("threads", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val delegate =
                request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(
                            it,
                            requestOptions,
                            cancellationTokenSource.token()
                        ) }
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
        return delegate.withCancellation(cancellationTokenSource)
        }

        private val deleteHandler: Handler<ThreadDeleted> =
            jsonHandler<ThreadDeleted>(clientOptions.jsonMapper)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun delete(
            params: ThreadDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ThreadDeleted>> {
            val cancellationTokenSource = CancellationTokenSource()
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("threadId", params.threadId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("threads", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val delegate =
                request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(
                            it,
                            requestOptions,
                            cancellationTokenSource.token()
                        ) }
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
        return delegate.withCancellation(cancellationTokenSource)
        }

        private val createAndRunHandler: Handler<Run> = jsonHandler<Run>(clientOptions.jsonMapper)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun createAndRun(
            params: ThreadCreateAndRunParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Run>> {
            val cancellationTokenSource = CancellationTokenSource()
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("threads", "runs")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val delegate =
                request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(
                            it,
                            requestOptions,
                            cancellationTokenSource.token()
                        ) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createAndRunHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        return delegate.withCancellation(cancellationTokenSource)
        }

        private val createAndRunStreamingHandler: Handler<StreamResponse<AssistantStreamEvent>> =
            sseHandler(clientOptions.jsonMapper)
                .mapJson<AssistantStreamEvent>(includeEventAndData = true)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun createAndRunStreaming(
            params: ThreadCreateAndRunParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> {
            val cancellationTokenSource = CancellationTokenSource()
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("threads", "runs")
                    .putAllHeaders(DEFAULT_HEADERS)
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
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val delegate =
                request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(
                            it,
                            requestOptions,
                            cancellationTokenSource.token()
                        ) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .let { createAndRunStreamingHandler.handle(it) }
                            .let { streamResponse ->
                                if (requestOptions.responseValidation!!) {
                                    streamResponse.map { it.validate() }
                                } else {
                                    streamResponse
                                }
                            }
                    }
                }
        return delegate.withCancellation(cancellationTokenSource)
        }
    }
}
