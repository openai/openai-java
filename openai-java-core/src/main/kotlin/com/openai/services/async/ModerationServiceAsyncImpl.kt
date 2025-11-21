// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
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
import com.openai.models.moderations.ModerationCreateParams
import com.openai.models.moderations.ModerationCreateResponse
import com.openai.core.http.CancellationTokenSource
import com.openai.core.withCancellation
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ModerationServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ModerationServiceAsync {

    private val withRawResponse: ModerationServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ModerationServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ModerationServiceAsync =
        ModerationServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ModerationCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ModerationCreateResponse> =
        // post /moderations
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ModerationServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ModerationServiceAsync.WithRawResponse =
            ModerationServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ModerationCreateResponse> =
            jsonHandler<ModerationCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: ModerationCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ModerationCreateResponse>> {
            val cancellationTokenSource = CancellationTokenSource()
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("moderations")
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
