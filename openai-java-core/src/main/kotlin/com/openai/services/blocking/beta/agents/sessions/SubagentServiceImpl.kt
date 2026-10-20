// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions

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
import com.openai.core.prepare
import com.openai.models.beta.agents.Subagent
import com.openai.models.beta.agents.sessions.subagents.SubagentListPage
import com.openai.models.beta.agents.sessions.subagents.SubagentListPageResponse
import com.openai.models.beta.agents.sessions.subagents.SubagentListParams
import com.openai.models.beta.agents.sessions.subagents.SubagentRetrieveParams
import com.openai.services.blocking.beta.agents.sessions.subagents.ItemService
import com.openai.services.blocking.beta.agents.sessions.subagents.ItemServiceImpl
import com.openai.services.blocking.beta.agents.sessions.subagents.TurnService
import com.openai.services.blocking.beta.agents.sessions.subagents.TurnServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SubagentServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SubagentService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "agents=v1").build()
    }

    private val withRawResponse: SubagentService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val items: ItemService by lazy { ItemServiceImpl(clientOptions) }

    private val turns: TurnService by lazy { TurnServiceImpl(clientOptions) }

    override fun withRawResponse(): SubagentService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SubagentService =
        SubagentServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun items(): ItemService = items

    override fun turns(): TurnService = turns

    override fun retrieve(
        params: SubagentRetrieveParams,
        requestOptions: RequestOptions,
    ): Subagent =
        // get /agents/sessions/{session_id}/subagents/{subagent_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: SubagentListParams,
        requestOptions: RequestOptions,
    ): SubagentListPage =
        // get /agents/sessions/{session_id}/subagents
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SubagentService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val items: ItemService.WithRawResponse by lazy {
            ItemServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val turns: TurnService.WithRawResponse by lazy {
            TurnServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SubagentService.WithRawResponse =
            SubagentServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun items(): ItemService.WithRawResponse = items

        override fun turns(): TurnService.WithRawResponse = turns

        private val retrieveHandler: Handler<Subagent> =
            jsonHandler<Subagent>(clientOptions.jsonMapper)

        override fun retrieve(
            params: SubagentRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Subagent> {
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
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<SubagentListPageResponse> =
            jsonHandler<SubagentListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: SubagentListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SubagentListPage> {
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
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        SubagentListPage.builder()
                            .service(SubagentServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
