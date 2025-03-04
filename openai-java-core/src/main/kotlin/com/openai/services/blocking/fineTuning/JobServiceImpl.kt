// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.fineTuning

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
import com.openai.errors.OpenAIError
import com.openai.models.FineTuningJob
import com.openai.models.FineTuningJobCancelParams
import com.openai.models.FineTuningJobCreateParams
import com.openai.models.FineTuningJobListEventsPage
import com.openai.models.FineTuningJobListEventsParams
import com.openai.models.FineTuningJobListPage
import com.openai.models.FineTuningJobListParams
import com.openai.models.FineTuningJobRetrieveParams
import com.openai.services.blocking.fineTuning.jobs.CheckpointService
import com.openai.services.blocking.fineTuning.jobs.CheckpointServiceImpl

class JobServiceImpl internal constructor(private val clientOptions: ClientOptions) : JobService {

    private val withRawResponse: JobService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val checkpoints: CheckpointService by lazy { CheckpointServiceImpl(clientOptions) }

    override fun withRawResponse(): JobService.WithRawResponse = withRawResponse

    override fun checkpoints(): CheckpointService = checkpoints

    override fun create(
        params: FineTuningJobCreateParams,
        requestOptions: RequestOptions,
    ): FineTuningJob =
        // post /fine_tuning/jobs
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: FineTuningJobRetrieveParams,
        requestOptions: RequestOptions,
    ): FineTuningJob =
        // get /fine_tuning/jobs/{fine_tuning_job_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(
        params: FineTuningJobListParams,
        requestOptions: RequestOptions,
    ): FineTuningJobListPage =
        // get /fine_tuning/jobs
        withRawResponse().list(params, requestOptions).parse()

    override fun cancel(
        params: FineTuningJobCancelParams,
        requestOptions: RequestOptions,
    ): FineTuningJob =
        // post /fine_tuning/jobs/{fine_tuning_job_id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    override fun listEvents(
        params: FineTuningJobListEventsParams,
        requestOptions: RequestOptions,
    ): FineTuningJobListEventsPage =
        // get /fine_tuning/jobs/{fine_tuning_job_id}/events
        withRawResponse().listEvents(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        JobService.WithRawResponse {

        private val errorHandler: Handler<OpenAIError> = errorHandler(clientOptions.jsonMapper)

        private val checkpoints: CheckpointService.WithRawResponse by lazy {
            CheckpointServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun checkpoints(): CheckpointService.WithRawResponse = checkpoints

        private val createHandler: Handler<FineTuningJob> =
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: FineTuningJobCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FineTuningJob> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("fine_tuning", "jobs")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params, params.model().toString())
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { createHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val retrieveHandler: Handler<FineTuningJob> =
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun retrieve(
            params: FineTuningJobRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FineTuningJob> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("fine_tuning", "jobs", params.getPathParam(0))
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

        private val listHandler: Handler<FineTuningJobListPage.Response> =
            jsonHandler<FineTuningJobListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: FineTuningJobListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FineTuningJobListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("fine_tuning", "jobs")
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
                    .let { FineTuningJobListPage.of(JobServiceImpl(clientOptions), params, it) }
            }
        }

        private val cancelHandler: Handler<FineTuningJob> =
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun cancel(
            params: FineTuningJobCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FineTuningJob> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("fine_tuning", "jobs", params.getPathParam(0), "cancel")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { cancelHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listEventsHandler: Handler<FineTuningJobListEventsPage.Response> =
            jsonHandler<FineTuningJobListEventsPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listEvents(
            params: FineTuningJobListEventsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FineTuningJobListEventsPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("fine_tuning", "jobs", params.getPathParam(0), "events")
                    .build()
                    .prepare(clientOptions, params, deploymentModel = null)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return response.parseable {
                response
                    .use { listEventsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        FineTuningJobListEventsPage.of(JobServiceImpl(clientOptions), params, it)
                    }
            }
        }
    }
}
