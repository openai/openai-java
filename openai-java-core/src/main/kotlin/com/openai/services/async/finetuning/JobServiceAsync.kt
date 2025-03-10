// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.finetuning.jobs.FineTuningJob
import com.openai.models.finetuning.jobs.JobCancelParams
import com.openai.models.finetuning.jobs.JobCreateParams
import com.openai.models.finetuning.jobs.JobListEventsPageAsync
import com.openai.models.finetuning.jobs.JobListEventsParams
import com.openai.models.finetuning.jobs.JobListPageAsync
import com.openai.models.finetuning.jobs.JobListParams
import com.openai.models.finetuning.jobs.JobRetrieveParams
import com.openai.services.async.finetuning.jobs.CheckpointServiceAsync
import java.util.concurrent.CompletableFuture

interface JobServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun checkpoints(): CheckpointServiceAsync

    /**
     * Creates a fine-tuning job which begins the process of creating a new model from a given
     * dataset.
     *
     * Response includes details of the enqueued job including job status and the name of the
     * fine-tuned models once complete.
     *
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
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
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
     */
    fun retrieve(params: JobRetrieveParams): CompletableFuture<FineTuningJob> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: JobRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

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
    fun cancel(params: JobCancelParams): CompletableFuture<FineTuningJob> =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: JobCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /** Get status updates for a fine-tuning job. */
    fun listEvents(params: JobListEventsParams): CompletableFuture<JobListEventsPageAsync> =
        listEvents(params, RequestOptions.none())

    /** @see [listEvents] */
    fun listEvents(
        params: JobListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<JobListEventsPageAsync>

    /** A view of [JobServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun checkpoints(): CheckpointServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs`, but is otherwise the same as
         * [JobServiceAsync.create].
         */
        @MustBeClosed
        fun create(params: JobCreateParams): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: JobCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}`, but is
         * otherwise the same as [JobServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: JobRetrieveParams): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: JobRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs`, but is otherwise the same as
         * [JobServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<JobListPageAsync>> =
            list(JobListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: JobListParams = JobListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<JobListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: JobListParams = JobListParams.none()
        ): CompletableFuture<HttpResponseFor<JobListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<JobListPageAsync>> =
            list(JobListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs/{fine_tuning_job_id}/cancel`, but
         * is otherwise the same as [JobServiceAsync.cancel].
         */
        @MustBeClosed
        fun cancel(params: JobCancelParams): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: JobCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}/events`, but
         * is otherwise the same as [JobServiceAsync.listEvents].
         */
        @MustBeClosed
        fun listEvents(
            params: JobListEventsParams
        ): CompletableFuture<HttpResponseFor<JobListEventsPageAsync>> =
            listEvents(params, RequestOptions.none())

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            params: JobListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<JobListEventsPageAsync>>
    }
}
