// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads.runs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.beta.threads.runs.steps.RunStep
import com.openai.models.beta.threads.runs.steps.StepListPage
import com.openai.models.beta.threads.runs.steps.StepListParams
import com.openai.models.beta.threads.runs.steps.StepRetrieveParams

class StepServiceImpl internal constructor(private val clientOptions: ClientOptions) : StepService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: StepService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): StepService.WithRawResponse = withRawResponse

    override fun retrieve(params: StepRetrieveParams, requestOptions: RequestOptions): RunStep =
        // get /threads/{thread_id}/runs/{run_id}/steps/{step_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: StepListParams, requestOptions: RequestOptions): StepListPage =
        // get /threads/{thread_id}/runs/{run_id}/steps
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StepService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val retrieveHandler: Handler<RunStep> =
            jsonHandler<RunStep>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: StepRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunStep> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "runs",
                        params._pathParam(1),
                        "steps",
                        params._pathParam(2),
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<StepListPage.Response> =
            jsonHandler<StepListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: StepListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StepListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "runs",
                        params._pathParam(1),
                        "steps",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let { StepListPage.of(StepServiceImpl(clientOptions), params, it) }
            }
        }
    }
}
