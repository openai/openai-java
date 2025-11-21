// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.realtime

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
import com.openai.models.realtime.clientsecrets.ClientSecretCreateParams
import com.openai.models.realtime.clientsecrets.ClientSecretCreateResponse
import com.openai.core.http.CancellationTokenSource
import com.openai.core.withCancellation
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class ClientSecretServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ClientSecretServiceAsync {

    private val withRawResponse: ClientSecretServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ClientSecretServiceAsync.WithRawResponse = withRawResponse


    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ClientSecretServiceAsync =
        ClientSecretServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ClientSecretCreateParams,
        requestOptions: RequestOptions,
        ClientSecretServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ClientSecretCreateParams,
        requestOptions: RequestOptions,
        params: ClientSecretCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<ClientSecretCreateResponse> =
        // post /realtime/client_secrets
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ClientSecretServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            val cancellationTokenSource = CancellationTokenSource()
            modifier: Consumer<ClientOptions.Builder>
        ): ClientSecretServiceAsync.WithRawResponse =
            ClientSecretServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<ClientSecretCreateResponse> =
            jsonHandler<ClientSecretCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: ClientSecretCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<ClientSecretCreateResponse>> {
            val cancellationTokenSource = CancellationTokenSource()
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("realtime", "client_secrets")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return
                    request
                        .thenComposeAsync {
                            clientOptions.httpClient.executeAsync(
                                it,
                                requestOptions,
                                cancellationTokenSource.token()
                            )
                        }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { createHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }

            .withCancellation(cancellationTokenSource)
                            }
                    }
                }
        }
    }
}
