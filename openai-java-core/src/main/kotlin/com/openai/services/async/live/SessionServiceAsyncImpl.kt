// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.live

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.emptyHandler
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.live.sessions.SessionAcceptParams
import com.openai.models.live.sessions.SessionDownloadRecordingParams
import com.openai.models.live.sessions.SessionForkParams
import com.openai.models.live.sessions.SessionForkResponse
import com.openai.models.live.sessions.SessionHangupParams
import com.openai.models.live.sessions.SessionReferParams
import com.openai.models.live.sessions.SessionRejectParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class SessionServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    SessionServiceAsync {

    private val withRawResponse: SessionServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): SessionServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): SessionServiceAsync =
        SessionServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun accept(
        params: SessionAcceptParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // post /live/sessions/{session_id}/accept
        withRawResponse().accept(params, requestOptions).thenAccept {}

    override fun downloadRecording(
        params: SessionDownloadRecordingParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<HttpResponse> =
        // get /live/sessions/{session_id}/content
        withRawResponse().downloadRecording(params, requestOptions)

    override fun fork(
        params: SessionForkParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<SessionForkResponse> =
        // post /live/sessions/{session_id}/fork
        withRawResponse().fork(params, requestOptions).thenApply { it.parse() }

    override fun hangup(
        params: SessionHangupParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // post /live/sessions/{session_id}/hangup
        withRawResponse().hangup(params, requestOptions).thenAccept {}

    override fun refer(
        params: SessionReferParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // post /live/sessions/{session_id}/refer
        withRawResponse().refer(params, requestOptions).thenAccept {}

    override fun reject(
        params: SessionRejectParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<Void?> =
        // post /live/sessions/{session_id}/reject
        withRawResponse().reject(params, requestOptions).thenAccept {}

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        SessionServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): SessionServiceAsync.WithRawResponse =
            SessionServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val acceptHandler: Handler<Void?> = emptyHandler()

        override fun accept(
            params: SessionAcceptParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("live", "sessions", params._pathParam(0), "accept")
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
                        response.use { acceptHandler.handle(it) }
                    }
                }
        }

        override fun downloadRecording(
            params: SessionDownloadRecordingParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("live", "sessions", params._pathParam(0), "content")
                    .putHeader("Accept", "application/binary")
                    .build()
                    .prepareAsync(
                        clientOptions,
                        params,
                        SecurityOptions.builder().bearerAuth(true).build(),
                    )
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response -> errorHandler.handle(response) }
        }

        private val forkHandler: Handler<SessionForkResponse> =
            jsonHandler<SessionForkResponse>(clientOptions.jsonMapper)

        override fun fork(
            params: SessionForkParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<SessionForkResponse>> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("live", "sessions", params._pathParam(0), "fork")
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
                            .use { forkHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val hangupHandler: Handler<Void?> = emptyHandler()

        override fun hangup(
            params: SessionHangupParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("live", "sessions", params._pathParam(0), "hangup")
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
                        response.use { hangupHandler.handle(it) }
                    }
                }
        }

        private val referHandler: Handler<Void?> = emptyHandler()

        override fun refer(
            params: SessionReferParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("live", "sessions", params._pathParam(0), "refer")
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
                        response.use { referHandler.handle(it) }
                    }
                }
        }

        private val rejectHandler: Handler<Void?> = emptyHandler()

        override fun reject(
            params: SessionRejectParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponse> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("sessionId", params.sessionId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("live", "sessions", params._pathParam(0), "reject")
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
                        response.use { rejectHandler.handle(it) }
                    }
                }
        }
    }
}
