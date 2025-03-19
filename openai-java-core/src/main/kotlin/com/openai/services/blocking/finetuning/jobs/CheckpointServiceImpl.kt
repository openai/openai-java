// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning.jobs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.handlers.withErrorHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.ErrorObject
import com.openai.models.finetuning.jobs.checkpoints.CheckpointListPage
import com.openai.models.finetuning.jobs.checkpoints.CheckpointListParams

class CheckpointServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    CheckpointService {

    private val withRawResponse: CheckpointService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CheckpointService.WithRawResponse = withRawResponse

    override fun list(
        params: CheckpointListParams,
        requestOptions: RequestOptions,
    ): CheckpointListPage =
        // get /fine_tuning/jobs/{fine_tuning_job_id}/checkpoints
        withRawResponse().list(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CheckpointService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val listHandler: Handler<CheckpointListPage.Response> =
            jsonHandler<CheckpointListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: CheckpointListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckpointListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("fine_tuning", "jobs", params._pathParam(0), "checkpoints")
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
                    .let { CheckpointListPage.of(CheckpointServiceImpl(clientOptions), params, it) }
            }
        }
    }
}
