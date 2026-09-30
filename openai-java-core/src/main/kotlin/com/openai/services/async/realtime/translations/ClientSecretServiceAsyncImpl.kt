// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.realtime.translations

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
import com.openai.models.realtime.RealtimeTranslationClientSecretCreateResponse
import com.openai.models.realtime.translations.clientsecrets.ClientSecretCreateParams
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
    ): CompletableFuture<RealtimeTranslationClientSecretCreateResponse> =
        // post /realtime/translations/client_secrets
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ClientSecretServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ClientSecretServiceAsync.WithRawResponse =
            ClientSecretServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<RealtimeTranslationClientSecretCreateResponse> =
            jsonHandler<RealtimeTranslationClientSecretCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: ClientSecretCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RealtimeTranslationClientSecretCreateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("realtime", "translations", "client_secrets")
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
