// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning.alpha

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
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.finetuning.alpha.graders.GraderRunParams
import com.openai.models.finetuning.alpha.graders.GraderRunResponse
import com.openai.models.finetuning.alpha.graders.GraderValidateParams
import com.openai.models.finetuning.alpha.graders.GraderValidateResponse
import java.util.function.Consumer

class GraderServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    GraderService {

    private val withRawResponse: GraderService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): GraderService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): GraderService =
        GraderServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun run(params: GraderRunParams, requestOptions: RequestOptions): GraderRunResponse =
        // post /fine_tuning/alpha/graders/run
        withRawResponse().run(params, requestOptions).parse()

    override fun validate(
        params: GraderValidateParams,
        requestOptions: RequestOptions,
    ): GraderValidateResponse =
        // post /fine_tuning/alpha/graders/validate
        withRawResponse().validate(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        GraderService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GraderService.WithRawResponse =
            GraderServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val runHandler: Handler<GraderRunResponse> =
            jsonHandler<GraderRunResponse>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun run(
            params: GraderRunParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<GraderRunResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("fine_tuning", "alpha", "graders", "run")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { runHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
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
        ): HttpResponseFor<GraderValidateResponse> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("fine_tuning", "alpha", "graders", "validate")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
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
