// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.realtime

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.beta.realtime.sessions.SessionCreateParams
import com.openai.models.beta.realtime.sessions.SessionCreateResponse
import java.util.function.Consumer

class SessionServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    SessionService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: SessionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SessionService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SessionService =
        SessionServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: SessionCreateParams,
        requestOptions: RequestOptions,
    ): SessionCreateResponse =
        // post /realtime/sessions
        withRawResponse().create(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SessionService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SessionService.WithRawResponse =
            SessionServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<SessionCreateResponse> =
            jsonHandler<SessionCreateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun create(
            params: SessionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<SessionCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("realtime", "sessions")
                    .putAllHeaders(DEFAULT_HEADERS)
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
    }
}
