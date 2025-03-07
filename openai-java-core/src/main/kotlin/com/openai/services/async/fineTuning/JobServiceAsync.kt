// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.fineTuning

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.FineTuningJob
import com.openai.models.FineTuningJobCancelParams
import com.openai.models.FineTuningJobCreateParams
import com.openai.models.FineTuningJobListEventsPageAsync
import com.openai.models.FineTuningJobListEventsParams
import com.openai.models.FineTuningJobListPageAsync
import com.openai.models.FineTuningJobListParams
import com.openai.models.FineTuningJobRetrieveParams
import com.openai.services.async.fineTuning.jobs.CheckpointServiceAsync
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
    fun create(params: FineTuningJobCreateParams): CompletableFuture<FineTuningJob> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: FineTuningJobCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /**
     * Get info about a fine-tuning job.
     *
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
     */
    fun retrieve(params: FineTuningJobRetrieveParams): CompletableFuture<FineTuningJob> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: FineTuningJobRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /** List your organization's fine-tuning jobs */
    fun list(): CompletableFuture<FineTuningJobListPageAsync> = list(FineTuningJobListParams.none())

    /** @see [list] */
    fun list(
        params: FineTuningJobListParams = FineTuningJobListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJobListPageAsync>

    /** @see [list] */
    fun list(
        params: FineTuningJobListParams = FineTuningJobListParams.none()
    ): CompletableFuture<FineTuningJobListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<FineTuningJobListPageAsync> =
        list(FineTuningJobListParams.none(), requestOptions)

    /** Immediately cancel a fine-tune job. */
    fun cancel(params: FineTuningJobCancelParams): CompletableFuture<FineTuningJob> =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: FineTuningJobCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /** Get status updates for a fine-tuning job. */
    fun listEvents(
        params: FineTuningJobListEventsParams
    ): CompletableFuture<FineTuningJobListEventsPageAsync> =
        listEvents(params, RequestOptions.none())

    /** @see [listEvents] */
    fun listEvents(
        params: FineTuningJobListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJobListEventsPageAsync>

    /** A view of [JobServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun checkpoints(): CheckpointServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs`, but is otherwise the same as
         * [JobServiceAsync.create].
         */
        @MustBeClosed
        fun create(
            params: FineTuningJobCreateParams
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> = create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: FineTuningJobCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}`, but is
         * otherwise the same as [JobServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: FineTuningJobRetrieveParams
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: FineTuningJobRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs`, but is otherwise the same as
         * [JobServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<FineTuningJobListPageAsync>> =
            list(FineTuningJobListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: FineTuningJobListParams = FineTuningJobListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJobListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: FineTuningJobListParams = FineTuningJobListParams.none()
        ): CompletableFuture<HttpResponseFor<FineTuningJobListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<FineTuningJobListPageAsync>> =
            list(FineTuningJobListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs/{fine_tuning_job_id}/cancel`, but
         * is otherwise the same as [JobServiceAsync.cancel].
         */
        @MustBeClosed
        fun cancel(
            params: FineTuningJobCancelParams
        ): CompletableFuture<HttpResponseFor<FineTuningJob>> = cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: FineTuningJobCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}/events`, but
         * is otherwise the same as [JobServiceAsync.listEvents].
         */
        @MustBeClosed
        fun listEvents(
            params: FineTuningJobListEventsParams
        ): CompletableFuture<HttpResponseFor<FineTuningJobListEventsPageAsync>> =
            listEvents(params, RequestOptions.none())

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            params: FineTuningJobListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJobListEventsPageAsync>>
    }
}
