// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.fineTuning

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
import com.openai.errors.OpenAIError
import com.openai.models.FineTuningJob
import com.openai.models.FineTuningJobCancelParams
import com.openai.models.FineTuningJobCreateParams
import com.openai.models.FineTuningJobListEventsPageAsync
import com.openai.models.FineTuningJobListEventsParams
import com.openai.models.FineTuningJobListPageAsync
import com.openai.models.FineTuningJobListParams
import com.openai.models.FineTuningJobRetrieveParams
import com.openai.services.async.fineTuning.jobs.CheckpointServiceAsync
import com.openai.services.async.fineTuning.jobs.CheckpointServiceAsyncImpl
import java.util.concurrent.CompletableFuture

class JobServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    JobServiceAsync {

    private val withRawResponse: JobServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val checkpoints: CheckpointServiceAsync by lazy {
        CheckpointServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): JobServiceAsync.WithRawResponse = withRawResponse

    override fun checkpoints(): CheckpointServiceAsync = checkpoints

    override fun create(
        params: FineTuningJobCreateParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FineTuningJob> =
        // post /fine_tuning/jobs
        withRawResponse().create(params, requestOptions).thenApply { it.parse() }

    override fun retrieve(
        params: FineTuningJobRetrieveParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FineTuningJob> =
        // get /fine_tuning/jobs/{fine_tuning_job_id}
        withRawResponse().retrieve(params, requestOptions).thenApply { it.parse() }

    override fun list(
        params: FineTuningJobListParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FineTuningJobListPageAsync> =
        // get /fine_tuning/jobs
        withRawResponse().list(params, requestOptions).thenApply { it.parse() }

    override fun cancel(
        params: FineTuningJobCancelParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FineTuningJob> =
        // post /fine_tuning/jobs/{fine_tuning_job_id}/cancel
        withRawResponse().cancel(params, requestOptions).thenApply { it.parse() }

    override fun listEvents(
        params: FineTuningJobListEventsParams,
        requestOptions: RequestOptions,
    ): CompletableFuture<FineTuningJobListEventsPageAsync> =
        // get /fine_tuning/jobs/{fine_tuning_job_id}/events
        withRawResponse().listEvents(params, requestOptions).thenApply { it.parse() }

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        JobServiceAsync.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val checkpoints: CheckpointServiceAsync.WithRawResponse by lazy {
            CheckpointServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun checkpoints(): CheckpointServiceAsync.WithRawResponse = checkpoints

        private val createHandler: Handler<FineTuningJob> =
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: FineTuningJobCreateParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("fine_tuning", "jobs")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepareAsync(clientOptions, params, params.model().toString())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
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

        private val retrieveHandler: Handler<FineTuningJob> =
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: FineTuningJobRetrieveParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("fine_tuning", "jobs", params.getPathParam(0))
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { retrieveHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listHandler: Handler<FineTuningJobListPageAsync.Response> =
            jsonHandler<FineTuningJobListPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: FineTuningJobListParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FineTuningJobListPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("fine_tuning", "jobs")
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
                                FineTuningJobListPageAsync.of(
                                    JobServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }

        private val cancelHandler: Handler<FineTuningJob> =
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun cancel(
            params: FineTuningJobCancelParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("fine_tuning", "jobs", params.getPathParam(0), "cancel")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { cancelHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                    }
                }
        }

        private val listEventsHandler: Handler<FineTuningJobListEventsPageAsync.Response> =
            jsonHandler<FineTuningJobListEventsPageAsync.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listEvents(
            params: FineTuningJobListEventsParams,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FineTuningJobListEventsPageAsync>> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("fine_tuning", "jobs", params.getPathParam(0), "events")
                    .build()
                    .prepareAsync(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            return request
                .thenComposeAsync { clientOptions.httpClient.executeAsync(it, requestOptions) }
                .thenApply { response ->
                    response.parseable {
                        response
                            .use { listEventsHandler.handle(it) }
                            .also {
                                if (requestOptions.responseValidation!!) {
                                    it.validate()
                                }
                            }
                            .let {
                                FineTuningJobListEventsPageAsync.of(
                                    JobServiceAsyncImpl(clientOptions),
                                    params,
                                    it,
                                )
                            }
                    }
                }
        }
    }
}
