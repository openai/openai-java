// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads.runs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.Headers
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.beta.threads.runs.steps.RunStep
import com.openai.models.beta.threads.runs.steps.StepListPage
import com.openai.models.beta.threads.runs.steps.StepListPageResponse
import com.openai.models.beta.threads.runs.steps.StepListParams
import com.openai.models.beta.threads.runs.steps.StepRetrieveParams
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

@Deprecated("The Assistants API is deprecated in favor of the Responses API")
class StepServiceImpl internal constructor(private val clientOptions: ClientOptions) : StepService {

    companion object {

        private val DEFAULT_HEADERS = Headers.builder().put("OpenAI-Beta", "assistants=v2").build()
    }

    private val withRawResponse: StepService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): StepService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): StepService =
        StepServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun retrieve(params: StepRetrieveParams, requestOptions: RequestOptions): RunStep =
        // get /threads/{thread_id}/runs/{run_id}/steps/{step_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    override fun list(params: StepListParams, requestOptions: RequestOptions): StepListPage =
        // get /threads/{thread_id}/runs/{run_id}/steps
        withRawResponse().list(params, requestOptions).parse()

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        StepService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): StepService.WithRawResponse =
            StepServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val retrieveHandler: Handler<RunStep> =
            jsonHandler<RunStep>(clientOptions.jsonMapper)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun retrieve(
            params: StepRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<RunStep> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("stepId", params.stepId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
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
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { retrieveHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listHandler: Handler<StepListPageResponse> =
            jsonHandler<StepListPageResponse>(clientOptions.jsonMapper)

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        override fun list(
            params: StepListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<StepListPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("runId", params.runId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments(
                        "threads",
                        params._pathParam(0),
                        "runs",
                        params._pathParam(1),
                        "steps",
                    )
                    .putAllHeaders(DEFAULT_HEADERS)
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        StepListPage.builder()
                            .service(StepServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }
    }
}
