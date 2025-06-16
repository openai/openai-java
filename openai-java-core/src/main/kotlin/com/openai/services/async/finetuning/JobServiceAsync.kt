// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.finetuning.jobs.FineTuningJob
import com.openai.models.finetuning.jobs.JobCancelParams
import com.openai.models.finetuning.jobs.JobCreateParams
import com.openai.models.finetuning.jobs.JobListEventsPageAsync
import com.openai.models.finetuning.jobs.JobListEventsParams
import com.openai.models.finetuning.jobs.JobListPageAsync
import com.openai.models.finetuning.jobs.JobListParams
import com.openai.models.finetuning.jobs.JobPauseParams
import com.openai.models.finetuning.jobs.JobResumeParams
import com.openai.models.finetuning.jobs.JobRetrieveParams
import com.openai.services.async.finetuning.jobs.CheckpointServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface JobServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): JobServiceAsync

    fun checkpoints(): CheckpointServiceAsync

    /**
     * Creates a fine-tuning job which begins the process of creating a new model from a given
     * dataset.
     *
     * Response includes details of the enqueued job including job status and the name of the
     * fine-tuned models once complete.
     *
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/model-optimization)
     */
    fun create(params: JobCreateParams): CompletableFuture<FineTuningJob> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: JobCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /**
     * Get info about a fine-tuning job.
     *
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/model-optimization)
     */
    fun retrieve(fineTuningJobId: String): CompletableFuture<FineTuningJob> =
        retrieve(fineTuningJobId, JobRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        fineTuningJobId: String,
        params: JobRetrieveParams = JobRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob> =
        retrieve(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(
        fineTuningJobId: String,
        params: JobRetrieveParams = JobRetrieveParams.none(),
    ): CompletableFuture<FineTuningJob> = retrieve(fineTuningJobId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: JobRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /** @see [retrieve] */
    fun retrieve(params: JobRetrieveParams): CompletableFuture<FineTuningJob> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        fineTuningJobId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<FineTuningJob> =
        retrieve(fineTuningJobId, JobRetrieveParams.none(), requestOptions)

    /** List your organization's fine-tuning jobs */
    fun list(): CompletableFuture<JobListPageAsync> = list(JobListParams.none())

    /** @see [list] */
    fun list(
        params: JobListParams = JobListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<JobListPageAsync>

    /** @see [list] */
    fun list(params: JobListParams = JobListParams.none()): CompletableFuture<JobListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<JobListPageAsync> =
        list(JobListParams.none(), requestOptions)

    /** Immediately cancel a fine-tune job. */
    fun cancel(fineTuningJobId: String): CompletableFuture<FineTuningJob> =
        cancel(fineTuningJobId, JobCancelParams.none())

    /** @see [cancel] */
    fun cancel(
        fineTuningJobId: String,
        params: JobCancelParams = JobCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob> =
        cancel(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

    /** @see [cancel] */
    fun cancel(
        fineTuningJobId: String,
        params: JobCancelParams = JobCancelParams.none(),
    ): CompletableFuture<FineTuningJob> = cancel(fineTuningJobId, params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: JobCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /** @see [cancel] */
    fun cancel(params: JobCancelParams): CompletableFuture<FineTuningJob> =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        fineTuningJobId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<FineTuningJob> =
        cancel(fineTuningJobId, JobCancelParams.none(), requestOptions)

    /** Get status updates for a fine-tuning job. */
    fun listEvents(fineTuningJobId: String): CompletableFuture<JobListEventsPageAsync> =
        listEvents(fineTuningJobId, JobListEventsParams.none())

    /** @see [listEvents] */
    fun listEvents(
        fineTuningJobId: String,
        params: JobListEventsParams = JobListEventsParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<JobListEventsPageAsync> =
        listEvents(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

    /** @see [listEvents] */
    fun listEvents(
        fineTuningJobId: String,
        params: JobListEventsParams = JobListEventsParams.none(),
    ): CompletableFuture<JobListEventsPageAsync> =
        listEvents(fineTuningJobId, params, RequestOptions.none())

    /** @see [listEvents] */
    fun listEvents(
        params: JobListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<JobListEventsPageAsync>

    /** @see [listEvents] */
    fun listEvents(params: JobListEventsParams): CompletableFuture<JobListEventsPageAsync> =
        listEvents(params, RequestOptions.none())

    /** @see [listEvents] */
    fun listEvents(
        fineTuningJobId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<JobListEventsPageAsync> =
        listEvents(fineTuningJobId, JobListEventsParams.none(), requestOptions)

    /** Pause a fine-tune job. */
    fun pause(fineTuningJobId: String): CompletableFuture<FineTuningJob> =
        pause(fineTuningJobId, JobPauseParams.none())

    /** @see [pause] */
    fun pause(
        fineTuningJobId: String,
        params: JobPauseParams = JobPauseParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob> =
        pause(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

    /** @see [pause] */
    fun pause(
        fineTuningJobId: String,
        params: JobPauseParams = JobPauseParams.none(),
    ): CompletableFuture<FineTuningJob> = pause(fineTuningJobId, params, RequestOptions.none())

    /** @see [pause] */
    fun pause(
        params: JobPauseParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /** @see [pause] */
    fun pause(params: JobPauseParams): CompletableFuture<FineTuningJob> =
        pause(params, RequestOptions.none())

    /** @see [pause] */
    fun pause(
        fineTuningJobId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<FineTuningJob> =
        pause(fineTuningJobId, JobPauseParams.none(), requestOptions)

    /** Resume a fine-tune job. */
    fun resume(fineTuningJobId: String): CompletableFuture<FineTuningJob> =
        resume(fineTuningJobId, JobResumeParams.none())

    /** @see [resume] */
    fun resume(
        fineTuningJobId: String,
        params: JobResumeParams = JobResumeParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob> =
        resume(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

    /** @see [resume] */
    fun resume(
        fineTuningJobId: String,
        params: JobResumeParams = JobResumeParams.none(),
    ): CompletableFuture<FineTuningJob> = resume(fineTuningJobId, params, RequestOptions.none())

    /** @see [resume] */
    fun resume(
        params: JobResumeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /** @see [resume] */
    fun resume(params: JobResumeParams): CompletableFuture<FineTuningJob> =
        resume(params, RequestOptions.none())

    /** @see [resume] */
    fun resume(
        fineTuningJobId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<FineTuningJob> =
        resume(fineTuningJobId, JobResumeParams.none(), requestOptions)

    /** A view of [JobServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): JobServiceAsync.WithRawResponse

        fun checkpoints(): CheckpointServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs`, but is otherwise the same as
         * [JobServiceAsync.create].
         */
        fun create(params: JobCreateParams): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        fun create(
            params: JobCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}`, but is
         * otherwise the same as [JobServiceAsync.retrieve].
         */
        fun retrieve(fineTuningJobId: String): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            retrieve(fineTuningJobId, JobRetrieveParams.none())

        /** @see [retrieve] */
        fun retrieve(
            fineTuningJobId: String,
            params: JobRetrieveParams = JobRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            retrieve(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

        /** @see [retrieve] */
        fun retrieve(
            fineTuningJobId: String,
            params: JobRetrieveParams = JobRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            retrieve(fineTuningJobId, params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            params: JobRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /** @see [retrieve] */
        fun retrieve(params: JobRetrieveParams): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        fun retrieve(
            fineTuningJobId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            retrieve(fineTuningJobId, JobRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs`, but is otherwise the same as
         * [JobServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<JobListPageAsync>> =
            list(JobListParams.none())

        /** @see [list] */
        fun list(
            params: JobListParams = JobListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<JobListPageAsync>>

        /** @see [list] */
        fun list(
            params: JobListParams = JobListParams.none()
        ): CompletableFuture<HttpResponseFor<JobListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<JobListPageAsync>> =
            list(JobListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs/{fine_tuning_job_id}/cancel`, but
         * is otherwise the same as [JobServiceAsync.cancel].
         */
        fun cancel(fineTuningJobId: String): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            cancel(fineTuningJobId, JobCancelParams.none())

        /** @see [cancel] */
        fun cancel(
            fineTuningJobId: String,
            params: JobCancelParams = JobCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            cancel(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

        /** @see [cancel] */
        fun cancel(
            fineTuningJobId: String,
            params: JobCancelParams = JobCancelParams.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            cancel(fineTuningJobId, params, RequestOptions.none())

        /** @see [cancel] */
        fun cancel(
            params: JobCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /** @see [cancel] */
        fun cancel(params: JobCancelParams): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        fun cancel(
            fineTuningJobId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            cancel(fineTuningJobId, JobCancelParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}/events`, but
         * is otherwise the same as [JobServiceAsync.listEvents].
         */
        fun listEvents(
            fineTuningJobId: String
        ): CompletableFuture<HttpResponseFor<JobListEventsPageAsync>> =
            listEvents(fineTuningJobId, JobListEventsParams.none())

        /** @see [listEvents] */
        fun listEvents(
            fineTuningJobId: String,
            params: JobListEventsParams = JobListEventsParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<JobListEventsPageAsync>> =
            listEvents(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

        /** @see [listEvents] */
        fun listEvents(
            fineTuningJobId: String,
            params: JobListEventsParams = JobListEventsParams.none(),
        ): CompletableFuture<HttpResponseFor<JobListEventsPageAsync>> =
            listEvents(fineTuningJobId, params, RequestOptions.none())

        /** @see [listEvents] */
        fun listEvents(
            params: JobListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<JobListEventsPageAsync>>

        /** @see [listEvents] */
        fun listEvents(
            params: JobListEventsParams
        ): CompletableFuture<HttpResponseFor<JobListEventsPageAsync>> =
            listEvents(params, RequestOptions.none())

        /** @see [listEvents] */
        fun listEvents(
            fineTuningJobId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<JobListEventsPageAsync>> =
            listEvents(fineTuningJobId, JobListEventsParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs/{fine_tuning_job_id}/pause`, but
         * is otherwise the same as [JobServiceAsync.pause].
         */
        fun pause(fineTuningJobId: String): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            pause(fineTuningJobId, JobPauseParams.none())

        /** @see [pause] */
        fun pause(
            fineTuningJobId: String,
            params: JobPauseParams = JobPauseParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            pause(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

        /** @see [pause] */
        fun pause(
            fineTuningJobId: String,
            params: JobPauseParams = JobPauseParams.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            pause(fineTuningJobId, params, RequestOptions.none())

        /** @see [pause] */
        fun pause(
            params: JobPauseParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /** @see [pause] */
        fun pause(params: JobPauseParams): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            pause(params, RequestOptions.none())

        /** @see [pause] */
        fun pause(
            fineTuningJobId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            pause(fineTuningJobId, JobPauseParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs/{fine_tuning_job_id}/resume`, but
         * is otherwise the same as [JobServiceAsync.resume].
         */
        fun resume(fineTuningJobId: String): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            resume(fineTuningJobId, JobResumeParams.none())

        /** @see [resume] */
        fun resume(
            fineTuningJobId: String,
            params: JobResumeParams = JobResumeParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            resume(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

        /** @see [resume] */
        fun resume(
            fineTuningJobId: String,
            params: JobResumeParams = JobResumeParams.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            resume(fineTuningJobId, params, RequestOptions.none())

        /** @see [resume] */
        fun resume(
            params: JobResumeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /** @see [resume] */
        fun resume(params: JobResumeParams): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            resume(params, RequestOptions.none())

        /** @see [resume] */
        fun resume(
            fineTuningJobId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            resume(fineTuningJobId, JobResumeParams.none(), requestOptions)
    }
}
