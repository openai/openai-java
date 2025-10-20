// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.responses

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
import com.openai.models.responses.inputtokens.InputTokenCountParams
import com.openai.models.responses.inputtokens.InputTokenCountResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

class InputTokenServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    InputTokenServiceAsync {

    private val withRawResponse: InputTokenServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): InputTokenServiceAsync.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): InputTokenServiceAsync =
        InputTokenServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun count(
        params: InputTokenCountParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<InputTokenCountResponse> =
        // post /responses/input_tokens
        withRawResponse().count(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        InputTokenServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InputTokenServiceAsync.WithRawResponse =
            InputTokenServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val countHandler: Handler<InputTokenCountResponse> =
            jsonHandler<InputTokenCountResponse>(clientOptions.jsonMapper)

        override fun count(
            params: InputTokenCountParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InputTokenCountResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("responses", "input_tokens")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { countHandler.handle(it) }
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
