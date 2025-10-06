// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.chatkit

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
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
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.beta.chatkit.sessions.SessionCancelParams
import com.openai.models.beta.chatkit.sessions.SessionCreateParams
import com.openai.models.beta.chatkit.threads.ChatSession
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SessionServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SessionService {

    companion object {

        private val DEFAULT_HEADERS =
            Headers.builder().put("OpenAI-Beta", "chatkit_beta=v1").build()
    }

    private val withRawResponse: SessionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SessionService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SessionService =
        SessionServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(params: SessionCreateParams, requestOptions: RequestOptions): ChatSession =
        // post /chatkit/sessions
        withRawResponse().create(params, requestOptions).parse()

    override fun cancel(params: SessionCancelParams, requestOptions: RequestOptions): ChatSession =
        // post /chatkit/sessions/{session_id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SessionService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SessionService.WithRawResponse =
            SessionServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ChatSession> =
            jsonHandler<ChatSession>(clientOptions.jsonMapper)

        override fun create(
            params: SessionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChatSession> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chatkit", "sessions")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
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

        private val cancelHandler: Handler<ChatSession> =
            jsonHandler<ChatSession>(clientOptions.jsonMapper)

        override fun cancel(
            params: SessionCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ChatSession> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("chatkit", "sessions", params._pathParam(0), "cancel")
                    .putAllHeaders(DEFAULT_HEADERS)
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
}
