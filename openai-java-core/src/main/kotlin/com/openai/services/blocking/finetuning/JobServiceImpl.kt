// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning

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
import com.openai.models.finetuning.jobs.FineTuningJob
import com.openai.models.finetuning.jobs.JobCancelParams
import com.openai.models.finetuning.jobs.JobCreateParams
import com.openai.models.finetuning.jobs.JobListEventsPage
import com.openai.models.finetuning.jobs.JobListEventsParams
import com.openai.models.finetuning.jobs.JobListPage
import com.openai.models.finetuning.jobs.JobListParams
import com.openai.models.finetuning.jobs.JobRetrieveParams
import com.openai.services.blocking.finetuning.jobs.CheckpointService
import com.openai.services.blocking.finetuning.jobs.CheckpointServiceImpl

class JobServiceImpl internal constructor(private val clientOptions: ClientOptions) : JobService {

    private val withRawResponse: JobService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val checkpoints: CheckpointService by lazy { CheckpointServiceImpl(clientOptions) }

    override fun withRawResponse(): JobService.WithRawResponse = withRawResponse

    override fun checkpoints(): CheckpointService = checkpoints

    override fun create(params: JobCreateParams, requestOptions: RequestOptions): FineTuningJob =
        // post /fine_tuning/jobs
        withRawResponse().create(params, requestOptions).parse()

    override fun retrieve(
        params: JobRetrieveParams,
        requestOptions: RequestOptions,
    ): FineTuningJob =
        // get /fine_tuning/jobs/{fine_tuning_job_id}
        withRawResponse().retrieve(params, requestOptions).parse()

    override fun list(params: JobListParams, requestOptions: RequestOptions): JobListPage =
        // get /fine_tuning/jobs
        withRawResponse().list(params, requestOptions).parse()

    override fun cancel(params: JobCancelParams, requestOptions: RequestOptions): FineTuningJob =
        // post /fine_tuning/jobs/{fine_tuning_job_id}/cancel
        withRawResponse().cancel(params, requestOptions).parse()

    override fun listEvents(
        params: JobListEventsParams,
        requestOptions: RequestOptions,
    ): JobListEventsPage =
        // get /fine_tuning/jobs/{fine_tuning_job_id}/events
        withRawResponse().listEvents(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        JobService.WithRawResponse {

        private val errorHandler: Handler<ErrorObject?> = errorHandler(clientOptions.jsonMapper)

        private val checkpoints: CheckpointService.WithRawResponse by lazy {
            CheckpointServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun checkpoints(): CheckpointService.WithRawResponse = checkpoints

        private val createHandler: Handler<FineTuningJob> =
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun create(
            params: JobCreateParams,
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
            params: JobRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FineTuningJob> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("fine_tuning", "jobs", params._pathParam(0))
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

        private val listHandler: Handler<JobListPage.Response> =
            jsonHandler<JobListPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun list(
            params: JobListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<JobListPage> {
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
                    .let { JobListPage.of(JobServiceImpl(clientOptions), params, it) }
            }
        }

        private val cancelHandler: Handler<FineTuningJob> =
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper).withErrorHandler(errorHandler)

        override fun cancel(
            params: JobCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FineTuningJob> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .addPathSegments("fine_tuning", "jobs", params._pathParam(0), "cancel")
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

        private val listEventsHandler: Handler<JobListEventsPage.Response> =
            jsonHandler<JobListEventsPage.Response>(clientOptions.jsonMapper)
                .withErrorHandler(errorHandler)

        override fun listEvents(
            params: JobListEventsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<JobListEventsPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .addPathSegments("fine_tuning", "jobs", params._pathParam(0), "events")
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
                    .let { JobListEventsPage.of(JobServiceImpl(clientOptions), params, it) }
            }
        }
    }
}
