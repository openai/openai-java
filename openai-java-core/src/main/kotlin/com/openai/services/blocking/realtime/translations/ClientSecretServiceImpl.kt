// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.realtime.translations

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
import com.openai.core.prepare
import com.openai.models.realtime.RealtimeTranslationClientSecretCreateResponse
import com.openai.models.realtime.translations.clientsecrets.ClientSecretCreateParams
import java.util.function.Consumer

class ClientSecretServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    ClientSecretService {

    private val withRawResponse: ClientSecretService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): ClientSecretService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): ClientSecretService =
        ClientSecretServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun create(
        params: ClientSecretCreateParams,
        requestOptions: RequestOptions,
    ): RealtimeTranslationClientSecretCreateResponse =
        // post /realtime/translations/client_secrets
        withRawResponse().create(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ClientSecretService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ClientSecretService.WithRawResponse =
            ClientSecretServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val createHandler: Handler<RealtimeTranslationClientSecretCreateResponse> =
            jsonHandler<RealtimeTranslationClientSecretCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: ClientSecretCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RealtimeTranslationClientSecretCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("realtime", "translations", "client_secrets")
                    .body(json(clientOptions.jsonMapper, params._body()))
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
