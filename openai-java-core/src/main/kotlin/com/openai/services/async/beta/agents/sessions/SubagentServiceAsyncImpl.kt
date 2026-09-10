// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

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
import com.openai.models.beta.agents.Subagent
import com.openai.models.beta.agents.sessions.subagents.SubagentListPageAsync
import com.openai.models.beta.agents.sessions.subagents.SubagentListPageResponse
import com.openai.models.beta.agents.sessions.subagents.SubagentListParams
import com.openai.models.beta.agents.sessions.subagents.SubagentRetrieveParams
import com.openai.services.async.beta.agents.sessions.subagents.ItemServiceAsync
import com.openai.services.async.beta.agents.sessions.subagents.ItemServiceAsyncImpl
import com.openai.services.async.beta.agents.sessions.subagents.TurnServiceAsync
import com.openai.services.async.beta.agents.sessions.subagents.TurnServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SubagentServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SubagentServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "agents=v1").build()
    }

    private val withRawResponse: SubagentServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val items: ItemServiceAsync by lazy { ItemServiceAsyncImpl(clientOptions) }

    private val turns: TurnServiceAsync by lazy { TurnServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): SubagentServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SubagentServiceAsync =
        SubagentServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun items(): ItemServiceAsync = items

    override fun turns(): TurnServiceAsync = turns

    override fun retrieve(
        params: SubagentRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Subagent> =
        // get /agents/sessions/{session_id}/subagents/{subagent_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: SubagentListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SubagentListPageAsync> =
        // get /agents/sessions/{session_id}/subagents
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SubagentServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val items: ItemServiceAsync.WithRawResponse by lazy {
            ItemServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val turns: TurnServiceAsync.WithRawResponse by lazy {
            TurnServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SubagentServiceAsync.WithRawResponse =
            SubagentServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun items(): ItemServiceAsync.WithRawResponse = items

        override fun turns(): TurnServiceAsync.WithRawResponse = turns

        private val retrieveHandler: Handler<Subagent> =
            jsonHandler<Subagent>(clientOptions.jsonMapper)

        override fun retrieve(
            params: SubagentRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Subagent>> {
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

        private val listHandler: Handler<SubagentListPageResponse> =
            jsonHandler<SubagentListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: SubagentListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SubagentListPageAsync>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "sessions", params._pathParam(0), "subagents")
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
                                SubagentListPageAsync.builder()
                                    .service(SubagentServiceAsyncImpl(clientOptions))
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
