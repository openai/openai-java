// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads.runs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.errors.OpenAIError
import com.openai.models.BetaThreadRunStepListPage
import com.openai.models.BetaThreadRunStepListParams
import com.openai.models.BetaThreadRunStepRetrieveParams
import com.openai.models.RunStep

class StepServiceImpl
constructor(
    private val clientOptions: ClientOptions,
) : StepService {

    private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

    private val retrieveHandler: Handler<RunStep> =
        jsonHandler<RunStep>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

    /** Retrieves a run step. */
    override fun retrieve(
        params: BetaThreadRunStepRetrieveParams,
        requestOptions: RequestOptions
    ): RunStep {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "threads",
                    params.getPathParam(0),
                    "runs",
                    params.getPathParam(1),
                    "steps",
                    params.getPathParam(2)
                )
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { retrieveHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
        }
    }

    private val listHandler: Handler<BetaThreadRunStepListPage.Response> =
        jsonHandler<BetaThreadRunStepListPage.Response>(clientOptions.jsonMapper)
            .withErrorHandler(errorHandler)

    /** Returns a list of run steps belonging to a run. */
    override fun list(
        params: BetaThreadRunStepListParams,
        requestOptions: RequestOptions
    ): BetaThreadRunStepListPage {
        val request =
            HttpRequest.builder()
                .method(HttpMethod.GET)
                .addPathSegments(
                    "threads",
                    params.getPathParam(0),
                    "runs",
                    params.getPathParam(1),
                    "steps"
                )
                .putAllQueryParams(clientOptions.queryParams)
                .replaceAllQueryParams(params.getQueryParams())
                .putAllHeaders(clientOptions.headers)
                .replaceAllHeaders(params.getHeaders())
                .build()
        return clientOptions.httpClient.execute(request, requestOptions).let { response ->
            response
                .use { listHandler.handle(it) }
                .apply {
                    if (requestOptions.responseValidation ?: clientOptions.responseValidation) {
                        validate()
                    }
                }
                .let { BetaThreadRunStepListPage.of(this, params, it) }
        }
    }
}