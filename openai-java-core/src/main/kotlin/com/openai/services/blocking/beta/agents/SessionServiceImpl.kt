// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents

import com.openai.core.ClientOptions
import com.openai.core.JsonValue
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.mapJson
import com.openai.core.handlers.sseHandler
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
import com.openai.core.prepare
import com.openai.models.beta.agents.AgentSession
import com.openai.models.beta.agents.AgentSessionDeleted
import com.openai.models.beta.agents.AgentSessionEvent
import com.openai.models.beta.agents.AgentSessionStreamParams
import com.openai.models.beta.agents.sessions.SessionCreateParams
import com.openai.models.beta.agents.sessions.SessionDeleteParams
import com.openai.models.beta.agents.sessions.SessionListPage
import com.openai.models.beta.agents.sessions.SessionListPageResponse
import com.openai.models.beta.agents.sessions.SessionListParams
import com.openai.models.beta.agents.sessions.SessionRetrieveParams
import com.openai.models.beta.agents.sessions.SessionUpdateParams
import com.openai.services.beta.agents.AgentSessionStream
import com.openai.services.blocking.beta.agents.sessions.ArtifactService
import com.openai.services.blocking.beta.agents.sessions.ArtifactServiceImpl
import com.openai.services.blocking.beta.agents.sessions.EventService
import com.openai.services.blocking.beta.agents.sessions.EventServiceImpl
import com.openai.services.blocking.beta.agents.sessions.ItemService
import com.openai.services.blocking.beta.agents.sessions.ItemServiceImpl
import com.openai.services.blocking.beta.agents.sessions.SubagentService
import com.openai.services.blocking.beta.agents.sessions.SubagentServiceImpl
import com.openai.services.blocking.beta.agents.sessions.TurnService
import com.openai.services.blocking.beta.agents.sessions.TurnServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SessionServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SessionService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "agents=v1").build()
    }

    private val withRawResponse: SessionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val subagents: SubagentService by lazy { SubagentServiceImpl(clientOptions) }

    private val artifacts: ArtifactService by lazy { ArtifactServiceImpl(clientOptions) }

    private val items: ItemService by lazy { ItemServiceImpl(clientOptions) }

    private val events: EventService by lazy { EventServiceImpl(clientOptions) }

    private val turns: TurnService by lazy { TurnServiceImpl(clientOptions) }

    override fun stream(
        params: AgentSessionStreamParams,
        requestOptions: RequestOptions,
    ): StreamResponse<AgentSessionEvent> =
        AgentSessionStream(this, params, requestOptions, clientOptions.sleeper)

    override fun withRawResponse(): SessionService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SessionService =
        SessionServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun subagents(): SubagentService = subagents

    override fun artifacts(): ArtifactService = artifacts

    override fun items(): ItemService = items

    override fun events(): EventService = events

    override fun turns(): TurnService = turns

    override fun create(params: SessionCreateParams, requestOptions: RequestOptions): AgentSession =
        // post /agents/sessions
        withRawResponse().create(params, requestOptions).parse()

    override fun createStreaming(
        params: SessionCreateParams,
        requestOptions: RequestOptions,
    ): StreamResponse<AgentSessionEvent> =
        // post /agents/sessions
        withRawResponse().createStreaming(params, requestOptions).parse()

    override fun retrieve(
        params: SessionRetrieveParams,
        requestOptions: RequestOptions,
    ): AgentSession =
        // get /agents/sessions/{session_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun update(params: SessionUpdateParams, requestOptions: RequestOptions): AgentSession =
        // post /agents/sessions/{session_id}
        withRawResponse().update(params, requestOptions).parse()

    override fun list(params: SessionListParams, requestOptions: RequestOptions): SessionListPage =
        // get /agents/sessions
        withRawResponse().list(params, requestOptions).parse()

    override fun delete(
        params: SessionDeleteParams,
        requestOptions: RequestOptions,
    ): AgentSessionDeleted =
        // delete /agents/sessions/{session_id}
        withRawResponse().delete(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SessionService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val subagents: SubagentService.WithRawResponse by lazy {
            SubagentServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val artifacts: ArtifactService.WithRawResponse by lazy {
            ArtifactServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val items: ItemService.WithRawResponse by lazy {
            ItemServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val events: EventService.WithRawResponse by lazy {
            EventServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val turns: TurnService.WithRawResponse by lazy {
            TurnServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SessionService.WithRawResponse =
            SessionServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun subagents(): SubagentService.WithRawResponse = subagents

        override fun artifacts(): ArtifactService.WithRawResponse = artifacts

        override fun items(): ItemService.WithRawResponse = items

        override fun events(): EventService.WithRawResponse = events

        override fun turns(): TurnService.WithRawResponse = turns

        private val createHandler: Handler<AgentSession> =
            jsonHandler<AgentSession>(clientOptions.jsonMapper)

        override fun create(
            params: SessionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentSession> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "sessions")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
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
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val createStreamingHandler: Handler<StreamResponse<AgentSessionEvent>> =
            sseHandler(clientOptions.jsonMapper).mapJson<AgentSessionEvent>()

        override fun createStreaming(
            params: SessionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StreamResponse<AgentSessionEvent>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "sessions")
                    .putAllHeaders(DEFAULT_HEADERS)
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
                    .prepare(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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

        private val retrieveHandler: Handler<AgentSession> =
            jsonHandler<AgentSession>(clientOptions.jsonMapper)

        override fun retrieve(
            params: SessionRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentSession> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "sessions", params._pathParam(0))
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

        private val updateHandler: Handler<AgentSession> =
            jsonHandler<AgentSession>(clientOptions.jsonMapper)

        override fun update(
            params: SessionUpdateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentSession> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "sessions", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
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
                    .use { updateHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<SessionListPageResponse> =
            jsonHandler<SessionListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: SessionListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SessionListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "sessions")
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
                        SessionListPage.builder()
                            .service(SessionServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val deleteHandler: Handler<AgentSessionDeleted> =
            jsonHandler<AgentSessionDeleted>(clientOptions.jsonMapper)

        override fun delete(
            params: SessionDeleteParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<AgentSessionDeleted> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.DELETE)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "sessions", params._pathParam(0))
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
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
