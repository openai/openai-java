// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.emptyHandler
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
import com.openai.models.beta.responses.BetaCompactedResponse
import com.openai.models.beta.responses.BetaResponse
import com.openai.models.beta.responses.BetaResponseStreamEvent
import com.openai.models.beta.responses.ResponseCancelParams
import com.openai.models.beta.responses.ResponseCompactParams
import com.openai.models.beta.responses.ResponseCreateParams
import com.openai.models.beta.responses.ResponseDeleteParams
import com.openai.models.beta.responses.ResponseRetrieveParams
import com.openai.services.async.beta.responses.InputItemServiceAsync
import com.openai.services.async.beta.responses.InputItemServiceAsyncImpl
import com.openai.services.async.beta.responses.InputTokenServiceAsync
import com.openai.services.async.beta.responses.InputTokenServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class ResponseServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ResponseServiceAsync {

    private val withRawResponse: ResponseServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val inputItems: InputItemServiceAsync by lazy {
        InputItemServiceAsyncImpl(clientOptions)
    }

    private val inputTokens: InputTokenServiceAsync by lazy {
        InputTokenServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): ResponseServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ResponseServiceAsync =
        ResponseServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun inputItems(): InputItemServiceAsync = inputItems

    override fun inputTokens(): InputTokenServiceAsync = inputTokens

    override fun create(
        params: ResponseCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BetaResponse> =
        // post /responses?beta=true
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun createStreaming(
        params: ResponseCreateParams,
        requestOptions: RequestOptions,
    ): AsyncStreamResponse<BetaResponseStreamEvent> =
        // post /responses?beta=true
        withRawResponse()
            .createStreaming(params, requestOptions)
            .thenApply { it.parse() }
            .toAsync(clientOptions.streamHandlerExecutor)

    override fun retrieve(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BetaResponse> =
        // get /responses/{response_id}?beta=true
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun retrieveStreaming(
        params: ResponseRetrieveParams,
        requestOptions: RequestOptions,
    ): AsyncStreamResponse<BetaResponseStreamEvent> =
        // get /responses/{response_id}?beta=true
        withRawResponse()
            .retrieveStreaming(params, requestOptions)
            .thenApply { it.parse() }
            .toAsync(clientOptions.streamHandlerExecutor)

    override fun delete(
        params: ResponseDeleteParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // delete /responses/{response_id}?beta=true
        withRawResponse().delete(params, requestOptions).thenAccept {}

    override fun cancel(
        params: ResponseCancelParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BetaResponse> =
        // post /responses/{response_id}/cancel?beta=true
        withRawResponse().cancel(params, requestOptions).thenApply { it.parse() }

    override fun compact(
        params: ResponseCompactParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<BetaCompactedResponse> =
        // post /responses/compact?beta=true
        withRawResponse().compact(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ResponseServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val inputItems: InputItemServiceAsync.WithRawResponse by lazy {
            InputItemServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val inputTokens: InputTokenServiceAsync.WithRawResponse by lazy {
            InputTokenServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ResponseServiceAsync.WithRawResponse =
            ResponseServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun inputItems(): InputItemServiceAsync.WithRawResponse = inputItems

        override fun inputTokens(): InputTokenServiceAsync.WithRawResponse = inputTokens

        private val createHandler: Handler<BetaResponse> =
            jsonHandler<BetaResponse>(clientOptions.jsonMapper)

        override fun create(
            params: ResponseCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BetaResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses")
                    .putQueryParam("beta", "true")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
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

        private val createStreamingHandler: Handler<StreamResponse<BetaResponseStreamEvent>> =
            sseHandler(clientOptions.jsonMapper).mapJson<BetaResponseStreamEvent>()

        override fun createStreaming(
            params: ResponseCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses")
                    .putQueryParam("beta", "true")
                    .putHeader("Accept", "text/event-stream")
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
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
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

        private val retrieveHandler: Handler<BetaResponse> =
            jsonHandler<BetaResponse>(clientOptions.jsonMapper)

        override fun retrieve(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BetaResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("responseId", params.responseId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses", params._pathParam(0))
                    .putQueryParam("beta", "true")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
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

        private val retrieveStreamingHandler: Handler<StreamResponse<BetaResponseStreamEvent>> =
            sseHandler(clientOptions.jsonMapper).mapJson<BetaResponseStreamEvent>()

        override fun retrieveStreaming(
            params: ResponseRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<StreamResponse<BetaResponseStreamEvent>>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("responseId", params.responseId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses", params._pathParam(0))
                    .putQueryParam("beta", "true")
                    .putQueryParam("stream", "true")
                    .putHeader("Accept", "text/event-stream")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .let { retrieveStreamingHandler.handle(it) }
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

        private val deleteHandler: Handler<Void?> = emptyHandler()

        override fun delete(
            params: ResponseDeleteParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("responseId", params.responseId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses", params._pathParam(0))
                    .putQueryParam("beta", "true")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response.use { deleteHandler.handle(it) }
                    }
                }
        }

        private val cancelHandler: Handler<BetaResponse> =
            jsonHandler<BetaResponse>(clientOptions.jsonMapper)

        override fun cancel(
            params: ResponseCancelParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BetaResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("responseId", params.responseId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses", params._pathParam(0), "cancel")
                    .putQueryParam("beta", "true")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { cancelHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val compactHandler: Handler<BetaCompactedResponse> =
            jsonHandler<BetaCompactedResponse>(clientOptions.jsonMapper)

        override fun compact(
            params: ResponseCompactParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<BetaCompactedResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses", "compact")
                    .putQueryParam("beta", "true")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { compactHandler.handle(it) }
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
