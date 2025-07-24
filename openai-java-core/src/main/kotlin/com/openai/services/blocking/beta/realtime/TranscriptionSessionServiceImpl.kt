// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.realtime

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
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
import com.openai.models.beta.realtime.transcriptionsessions.TranscriptionSession
import com.openai.models.beta.realtime.transcriptionsessions.TranscriptionSessionCreateParams
import java.util.function.Consumer

class TranscriptionSessionServiceImpl
internal constructor(private val clientOptions: ClientOptions) : TranscriptionSessionService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: TranscriptionSessionService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TranscriptionSessionService.WithRawResponse = withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): TranscriptionSessionService =
        TranscriptionSessionServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: TranscriptionSessionCreateParams,
        requestOptions: RequestOptions,
    ): TranscriptionSession =
        // post /realtime/transcription_sessions
        withRawResponse().create(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TranscriptionSessionService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TranscriptionSessionService.WithRawResponse =
            TranscriptionSessionServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<TranscriptionSession> =
            jsonHandler<TranscriptionSession>(clientOptions.jsonMapper)

        override fun create(
            params: TranscriptionSessionCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<TranscriptionSession> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("realtime", "transcription_sessions")
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
    }
}
