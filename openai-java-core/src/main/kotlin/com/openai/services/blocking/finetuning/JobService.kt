// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.finetuning.jobs.FineTuningJob
import com.openai.models.finetuning.jobs.JobCancelParams
import com.openai.models.finetuning.jobs.JobCreateParams
import com.openai.models.finetuning.jobs.JobListEventsPage
import com.openai.models.finetuning.jobs.JobListEventsParams
import com.openai.models.finetuning.jobs.JobListPage
import com.openai.models.finetuning.jobs.JobListParams
import com.openai.models.finetuning.jobs.JobPauseParams
import com.openai.models.finetuning.jobs.JobResumeParams
import com.openai.models.finetuning.jobs.JobRetrieveParams
import com.openai.services.blocking.finetuning.jobs.CheckpointService

interface JobService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun checkpoints(): CheckpointService

    /**
     * Creates a fine-tuning job which begins the process of creating a new model from a given
     * dataset.
     *
     * Response includes details of the enqueued job including job status and the name of the
     * fine-tuned models once complete.
     *
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
     */
    fun create(params: JobCreateParams): FineTuningJob = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: JobCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FineTuningJob

    /**
     * Get info about a fine-tuning job.
     *
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
     */
    fun retrieve(params: JobRetrieveParams): FineTuningJob = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: JobRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FineTuningJob

    /** List your organization's fine-tuning jobs */
    fun list(): JobListPage = list(JobListParams.none())

    /** @see [list] */
    fun list(
        params: JobListParams = JobListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): JobListPage

    /** @see [list] */
    fun list(params: JobListParams = JobListParams.none()): JobListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): JobListPage =
        list(JobListParams.none(), requestOptions)

    /** Immediately cancel a fine-tune job. */
    fun cancel(params: JobCancelParams): FineTuningJob = cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: JobCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FineTuningJob

    /** Get status updates for a fine-tuning job. */
    fun listEvents(params: JobListEventsParams): JobListEventsPage =
        listEvents(params, RequestOptions.none())

    /** @see [listEvents] */
    fun listEvents(
        params: JobListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): JobListEventsPage

    /** Pause a fine-tune job. */
    fun pause(params: JobPauseParams): FineTuningJob = pause(params, RequestOptions.none())

    /** @see [pause] */
    fun pause(
        params: JobPauseParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FineTuningJob

    /** Resume a fine-tune job. */
    fun resume(params: JobResumeParams): FineTuningJob = resume(params, RequestOptions.none())

    /** @see [resume] */
    fun resume(
        params: JobResumeParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FineTuningJob

    /** A view of [JobService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun checkpoints(): CheckpointService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs`, but is otherwise the same as
         * [JobService.create].
         */
        @MustBeClosed
        fun create(params: JobCreateParams): HttpResponseFor<FineTuningJob> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: JobCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FineTuningJob>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}`, but is
         * otherwise the same as [JobService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: JobRetrieveParams): HttpResponseFor<FineTuningJob> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: JobRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FineTuningJob>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs`, but is otherwise the same as
         * [JobService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<JobListPage> = list(JobListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: JobListParams = JobListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<JobListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(params: JobListParams = JobListParams.none()): HttpResponseFor<JobListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<JobListPage> =
            list(JobListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs/{fine_tuning_job_id}/cancel`, but
         * is otherwise the same as [JobService.cancel].
         */
        @MustBeClosed
        fun cancel(params: JobCancelParams): HttpResponseFor<FineTuningJob> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: JobCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FineTuningJob>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}/events`, but
         * is otherwise the same as [JobService.listEvents].
         */
        @MustBeClosed
        fun listEvents(params: JobListEventsParams): HttpResponseFor<JobListEventsPage> =
            listEvents(params, RequestOptions.none())

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            params: JobListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<JobListEventsPage>

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs/{fine_tuning_job_id}/pause`, but
         * is otherwise the same as [JobService.pause].
         */
        @MustBeClosed
        fun pause(params: JobPauseParams): HttpResponseFor<FineTuningJob> =
            pause(params, RequestOptions.none())

        /** @see [pause] */
        @MustBeClosed
        fun pause(
            params: JobPauseParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FineTuningJob>

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs/{fine_tuning_job_id}/resume`, but
         * is otherwise the same as [JobService.resume].
         */
        @MustBeClosed
        fun resume(params: JobResumeParams): HttpResponseFor<FineTuningJob> =
            resume(params, RequestOptions.none())

        /** @see [resume] */
        @MustBeClosed
        fun resume(
            params: JobResumeParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FineTuningJob>
    }
}
