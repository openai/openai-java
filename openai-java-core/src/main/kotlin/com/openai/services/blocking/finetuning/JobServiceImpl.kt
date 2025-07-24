// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning

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
import com.openai.core.http.json
import com.openai.core.http.parseable
import com.openai.core.prepare
import com.openai.models.finetuning.jobs.FineTuningJob
import com.openai.models.finetuning.jobs.JobCancelParams
import com.openai.models.finetuning.jobs.JobCreateParams
import com.openai.models.finetuning.jobs.JobListEventsPage
import com.openai.models.finetuning.jobs.JobListEventsPageResponse
import com.openai.models.finetuning.jobs.JobListEventsParams
import com.openai.models.finetuning.jobs.JobListPage
import com.openai.models.finetuning.jobs.JobListPageResponse
import com.openai.models.finetuning.jobs.JobListParams
import com.openai.models.finetuning.jobs.JobPauseParams
import com.openai.models.finetuning.jobs.JobResumeParams
import com.openai.models.finetuning.jobs.JobRetrieveParams
import com.openai.services.blocking.finetuning.jobs.CheckpointService
import com.openai.services.blocking.finetuning.jobs.CheckpointServiceImpl
import java.util.function.Consumer
import kotlin.jvm.optionals.getOrNull

class JobServiceImpl internal constructor(private val clientOptions: ClientOptions) : JobService {

    private val withRawResponse: JobService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val checkpoints: CheckpointService by lazy { CheckpointServiceImpl(clientOptions) }

    override fun withRawResponse(): JobService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): JobService =
        JobServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

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

    override fun pause(params: JobPauseParams, requestOptions: RequestOptions): FineTuningJob =
        // post /fine_tuning/jobs/{fine_tuning_job_id}/pause
        withRawResponse().pause(params, requestOptions).parse()

    override fun resume(params: JobResumeParams, requestOptions: RequestOptions): FineTuningJob =
        // post /fine_tuning/jobs/{fine_tuning_job_id}/resume
        withRawResponse().resume(params, requestOptions).parse()

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        JobService.WithRawResponse {

        private val errorHandler: Handler<HttpResponse> =
            errorHandler(errorBodyHandler(clientOptions.jsonMapper))

        private val checkpoints: CheckpointService.WithRawResponse by lazy {
            CheckpointServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): JobService.WithRawResponse =
            JobServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        override fun checkpoints(): CheckpointService.WithRawResponse = checkpoints

        private val createHandler: Handler<FineTuningJob> =
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper)

        override fun create(
            params: JobCreateParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FineTuningJob> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("fine_tuning", "jobs")
                    .body(json(clientOptions.jsonMapper, params._body()))
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
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
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper)

        override fun retrieve(
            params: JobRetrieveParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FineTuningJob> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fineTuningJobId", params.fineTuningJobId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("fine_tuning", "jobs", params._pathParam(0))
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

        private val listHandler: Handler<JobListPageResponse> =
            jsonHandler<JobListPageResponse>(clientOptions.jsonMapper)

        override fun list(
            params: JobListParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<JobListPage> {
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("fine_tuning", "jobs")
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
                        JobListPage.builder()
                            .service(JobServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val cancelHandler: Handler<FineTuningJob> =
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper)

        override fun cancel(
            params: JobCancelParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FineTuningJob> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fineTuningJobId", params.fineTuningJobId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("fine_tuning", "jobs", params._pathParam(0), "cancel")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { cancelHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val listEventsHandler: Handler<JobListEventsPageResponse> =
            jsonHandler<JobListEventsPageResponse>(clientOptions.jsonMapper)

        override fun listEvents(
            params: JobListEventsParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<JobListEventsPage> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fineTuningJobId", params.fineTuningJobId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.GET)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("fine_tuning", "jobs", params._pathParam(0), "events")
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { listEventsHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
                    .let {
                        JobListEventsPage.builder()
                            .service(JobServiceImpl(clientOptions))
                            .params(params)
                            .response(it)
                            .build()
                    }
            }
        }

        private val pauseHandler: Handler<FineTuningJob> =
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper)

        override fun pause(
            params: JobPauseParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FineTuningJob> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fineTuningJobId", params.fineTuningJobId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("fine_tuning", "jobs", params._pathParam(0), "pause")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { pauseHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }

        private val resumeHandler: Handler<FineTuningJob> =
            jsonHandler<FineTuningJob>(clientOptions.jsonMapper)

        override fun resume(
            params: JobResumeParams,
            requestOptions: RequestOptions,
        ): HttpResponseFor<FineTuningJob> {
            // We check here instead of in the params builder because this can be specified
            // positionally or in the params class.
            checkRequired("fineTuningJobId", params.fineTuningJobId().getOrNull())
            val request =
                HttpRequest.builder()
                    .method(HttpMethod.POST)
                    .baseUrl(clientOptions.baseUrl())
                    .addPathSegments("fine_tuning", "jobs", params._pathParam(0), "resume")
                    .apply { params._body().ifPresent { body(json(clientOptions.jsonMapper, it)) } }
                    .build()
                    .prepare(clientOptions, params)
            val requestOptions = requestOptions.applyDefaults(RequestOptions.from(clientOptions))
            val response = clientOptions.httpClient.execute(request, requestOptions)
            return errorHandler.handle(response).parseable {
                response
                    .use { resumeHandler.handle(it) }
                    .also {
                        if (requestOptions.responseValidation!!) {
                            it.validate()
                        }
                    }
            }
        }
    }
}
