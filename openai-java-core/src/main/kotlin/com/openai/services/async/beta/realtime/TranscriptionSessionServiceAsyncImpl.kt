// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.realtime

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
import com.openai.core.prepareAsync
import com.openai.models.beta.realtime.transcriptionsessions.TranscriptionSession
import com.openai.models.beta.realtime.transcriptionsessions.TranscriptionSessionCreateParams
import com.openai.core.http.CancellationTokenSource
import com.openai.core.withCancellation
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class TranscriptionSessionServiceAsyncImpl
internal constructor(private val clientOptions: ClientOptions) : TranscriptionSessionServiceAsync {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: TranscriptionSessionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): TranscriptionSessionServiceAsync.WithRawResponse =
        withRawResponse

    override fun withOptions(
        modifier: Consumer<ClientOptions.Builder>
    ): TranscriptionSessionServiceAsync =
        TranscriptionSessionServiceAsyncImpl(
            clientOptions.toBuilder().apply(modifier::accept).build()
        )

    override fun create(
        params: TranscriptionSessionCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<TranscriptionSession> =
        // post /realtime/transcription_sessions
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        TranscriptionSessionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TranscriptionSessionServiceAsync.WithRawResponse =
            TranscriptionSessionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<TranscriptionSession> =
            jsonHandler<TranscriptionSession>(clientOptions.jsonMapper)

        override fun create(
            params: TranscriptionSessionCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<TranscriptionSession>> {
            val cancellationTokenSource = CancellationTokenSource()
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("realtime", "transcription_sessions")
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
    }
}
