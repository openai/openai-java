// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning.alpha

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.ErrorObject
import com.openai.models.finetuning.alpha.graders.GraderRunParams
import com.openai.models.finetuning.alpha.graders.GraderRunResponse
import com.openai.models.finetuning.alpha.graders.GraderValidateParams
import com.openai.models.finetuning.alpha.graders.GraderValidateResponse
import java.util.concurrent.CompletableFuture

class GraderServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    GraderServiceAsync {

    private val withRawResponse: GraderServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GraderServiceAsync.WithRawResponse = withRawResponse

    override fun run(
        params: GraderRunParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GraderRunResponse> =
        // post /fine_tuning/alpha/graders/run
        withRawResponse().run(params, requestOptions).thenApply { it.parse() }

    override fun validate(
        params: GraderValidateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<GraderValidateResponse> =
        // post /fine_tuning/alpha/graders/validate
        withRawResponse().validate(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GraderServiceAsync.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val runHandler: Handler<GraderRunResponse> =
            jsonHandler<GraderRunResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun run(
            params: GraderRunParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GraderRunResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("fine_tuning", "alpha", "graders", "run")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { runHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val validateHandler: Handler<GraderValidateResponse> =
            jsonHandler<GraderValidateResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun validate(
            params: GraderValidateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<GraderValidateResponse>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("fine_tuning", "alpha", "graders", "validate")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { validateHandler.handle(it) }
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
