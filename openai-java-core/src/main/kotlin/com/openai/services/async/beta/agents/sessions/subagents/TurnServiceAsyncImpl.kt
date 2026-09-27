// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions.subagents

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.beta.agents.sessions.subagents.turns.TurnListPageAsync
import com.openai.models.beta.agents.sessions.subagents.turns.TurnListPageResponse
import com.openai.models.beta.agents.sessions.subagents.turns.TurnListParams
import com.openai.models.beta.agents.sessions.subagents.turns.TurnRetrieveParams
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.services.async.beta.agents.sessions.subagents.turns.ItemServiceAsync
import com.openai.services.async.beta.agents.sessions.subagents.turns.ItemServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class TurnServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    TurnServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "agents=v1").build()
    }

    private val withRawResponse: TurnServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val items: ItemServiceAsync by lazy { ItemServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): TurnServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TurnServiceAsync =
        TurnServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun items(): ItemServiceAsync = items

    override fun retrieve(
        params: TurnRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Turn> =
        // get /agents/sessions/{session_id}/subagents/{subagent_id}/turns/{turn_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: TurnListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<TurnListPageAsync> =
        // get /agents/sessions/{session_id}/subagents/{subagent_id}/turns
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TurnServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val items: ItemServiceAsync.WithRawResponse by lazy {
            ItemServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TurnServiceAsync.WithRawResponse =
            TurnServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun items(): ItemServiceAsync.WithRawResponse = items

        private val retrieveHandler: Handler<Turn> = jsonHandler<Turn>(clientOptions.jsonMapper)

        override fun retrieve(
            params: TurnRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Turn>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("turnId", params.turnId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "agents",
                        "sessions",
                        params._pathParam(0),
                        "subagents",
                        params._pathParam(1),
                        "turns",
                        params._pathParam(2),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
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

        private val listHandler: Handler<TurnListPageResponse> =
            jsonHandler<TurnListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: TurnListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TurnListPageAsync>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("subagentId", params.subagentId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "agents",
                        "sessions",
                        params._pathParam(0),
                        "subagents",
                        params._pathParam(1),
                        "turns",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
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
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                TurnListPageAsync.builder()
                                    .service(TurnServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }
    }
}
