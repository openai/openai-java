// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.SecurityOptions
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
import com.openai.models.live.LiveCreateParams
import com.openai.models.live.LiveCreateResponse
import com.openai.services.async.live.ForkServiceAsync
import com.openai.services.async.live.ForkServiceAsyncImpl
import com.openai.services.async.live.SessionServiceAsync
import com.openai.services.async.live.SessionServiceAsyncImpl
import com.openai.services.async.live.SidebandServiceAsync
import com.openai.services.async.live.SidebandServiceAsyncImpl
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class LiveServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    LiveServiceAsync {

    private val withRawResponse: LiveServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val sideband: SidebandServiceAsync by lazy { SidebandServiceAsyncImpl(clientOptions) }

    private val forks: ForkServiceAsync by lazy { ForkServiceAsyncImpl(clientOptions) }

    private val sessions: SessionServiceAsync by lazy { SessionServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): LiveServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): LiveServiceAsync =
        LiveServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun sideband(): SidebandServiceAsync = sideband

    override fun forks(): ForkServiceAsync = forks

    override fun sessions(): SessionServiceAsync = sessions

    override fun create(
        params: LiveCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<LiveCreateResponse> =
        // post /live/sessions
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        LiveServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val sideband: SidebandServiceAsync.WithRawResponse by lazy {
            SidebandServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val forks: ForkServiceAsync.WithRawResponse by lazy {
            ForkServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val sessions: SessionServiceAsync.WithRawResponse by lazy {
            SessionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): LiveServiceAsync.WithRawResponse =
            LiveServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun sideband(): SidebandServiceAsync.WithRawResponse = sideband

        override fun forks(): ForkServiceAsync.WithRawResponse = forks

        override fun sessions(): SessionServiceAsync.WithRawResponse = sessions

        private val createHandler: Handler<LiveCreateResponse> =
            jsonHandler<LiveCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: LiveCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<LiveCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("live", "sessions")
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
}
