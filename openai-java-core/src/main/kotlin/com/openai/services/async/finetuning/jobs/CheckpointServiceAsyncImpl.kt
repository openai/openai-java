// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning.jobs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.checkRequired
import com.openai.core.handlers.errorBodyHandler
import com.openai.core.handlers.errorHandler
import com.openai.core.handlers.jsonHandler
import com.openai.core.http.HttpMethod
import com.openai.core.http.HttpRequest
import com.openai.core.http.HttpResponse
import com.openai.core.http.HttpResponse.Handler
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.parseable
import com.openai.core.prepareAsync
import com.openai.models.finetuning.jobs.checkpoints.CheckpointListPageAsync
import com.openai.models.finetuning.jobs.checkpoints.CheckpointListPageResponse
import com.openai.models.finetuning.jobs.checkpoints.CheckpointListParams
import com.openai.core.http.CancellationTokenSource
import com.openai.core.withCancellation
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class CheckpointServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    CheckpointServiceAsync {

    private val withRawResponse: CheckpointServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    override fun withRawResponse(): CheckpointServiceAsync.WithRawResponse = withRawResponse


    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckpointServiceAsync =
        CheckpointServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: CheckpointListParams,
        requestOptions: RequestOptions,
        CheckpointServiceAsyncImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    override fun list(
        params: CheckpointListParams,
        requestOptions: RequestOptions,
        params: CheckpointListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<CheckpointListPageAsync> =
        // get /fine_tuning/jobs/{fine_tuning_job_id}/checkpoints
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        CheckpointServiceAsync.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        override fun withOptions(
            val cancellationTokenSource = CancellationTokenSource()
            modifier: Consumer<ClientOptions.Builder>
        ): CheckpointServiceAsync.WithRawResponse =
            CheckpointServiceAsyncImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        private val listHandler: Handler<CheckpointListPageResponse> =
            jsonHandler<CheckpointListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: CheckpointListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CheckpointListPageAsync>> {
            val cancellationTokenSource = CancellationTokenSource()
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fineTuningJobId", params.fineTuningJobId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("fine_tuning", "jobs", params._pathParam(0), "checkpoints")
                    .build()
                    .prepareAsync(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return
                    request
                        .thenComposeAsync {
                            clientOptions.httpClient.executeAsync(
                                it,
                                requestOptions,
                                cancellationTokenSource.token()
                            )
                        }
                .thenApply { response ->
                    errorHandler.handle(response).parseable {
                        response
                            .use { listHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }

            .withCancellation(cancellationTokenSource)
                            }
                            .let {
                                CheckpointListPageAsync.builder()
                                    .service(CheckpointServiceAsyncImpl(clientOptions))
                                    .streamHandlerExecutor(clientOptions.streamHandlerExecutor)
                                    .params(params)
                                    .response(it)
                                    .build()
                            }
                    }
                }
        }
    }
}
