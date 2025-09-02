// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.realtime

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
import com.openai.core.prepare
import com.openai.models.realtime.clientsecrets.ClientSecretCreateParams
import com.openai.models.realtime.clientsecrets.ClientSecretCreateResponse
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
    ): ClientSecretCreateResponse =
        // post /realtime/client_secrets
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

        private val createHandler: Handler<ClientSecretCreateResponse> =
            jsonHandler<ClientSecretCreateResponse>(clientOptions.jsonMapper)

        override fun create(
            params: ClientSecretCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<ClientSecretCreateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("realtime", "client_secrets")
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
