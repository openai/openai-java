// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning.jobs

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
import com.openai.core.prepareAsync
import com.openai.models.ErrorObject
import com.openai.models.finetuning.jobs.checkpoints.CheckpointListPageAsync
import com.openai.models.finetuning.jobs.checkpoints.CheckpointListPageResponse
import com.openai.models.finetuning.jobs.checkpoints.CheckpointListParams
import java.util.concurrent.CompletableFuture

class CheckpointServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CheckpointServiceAsync {

    private val withRawResponse: CheckpointServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CheckpointServiceAsync.WithRawResponse = withRawResponse

    override fun list(
        params: CheckpointListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CheckpointListPageAsync> =
        // get /fine_tuning/jobs/{fine_tuning_job_id}/checkpoints
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CheckpointServiceAsync.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val listHandler: Handler<CheckpointListPageResponse> =
            jsonHandler<CheckpointListPageResponse>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: CheckpointListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CheckpointListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("fine_tuning", "jobs", params._pathParam(0), "checkpoints")
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                CheckpointListPageAsync.builder()
                                    .service(CheckpointServiceAsyncImpl(clientOptions))
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }
    }
}
