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
import com.openai.models.beta.agents.sessions.turns.Turn
import com.openai.models.beta.agents.sessions.turns.TurnListPage
import com.openai.models.beta.agents.sessions.turns.TurnListPageResponse
import com.openai.models.beta.agents.sessions.turns.TurnListParams
import com.openai.models.beta.agents.sessions.turns.TurnRetrieveParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class TurnServiceImpl internal constructor(private val clientOptions: ClientOptions) : TurnService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "agents=v1").build()
    }

    private val withRawResponse: TurnService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TurnService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): TurnService =
        TurnServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun retrieve(params: TurnRetrieveParams, requestOptions: RequestOptions): Turn =
        // get /agents/sessions/{session_id}/turns/{turn_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: TurnListParams, requestOptions: RequestOptions): TurnListPage =
        // get /agents/sessions/{session_id}/turns
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TurnService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TurnService.WithRawResponse =
            TurnServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<Turn> = jsonHandler<Turn>(clientOptions.jsonMapper)

        override fun retrieve(
            params: TurnRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<Turn> {
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
                        "turns",
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

        private val listHandler: Handler<TurnListPageResponse> =
            jsonHandler<TurnListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: TurnListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TurnListPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("agents", "sessions", params._pathParam(0), "turns")
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
                        TurnListPage.builder()
                            .service(TurnServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
