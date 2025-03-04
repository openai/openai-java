// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

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
    @JvmOverloads
    fun create(
        params: FineTuningJobCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /**
     * Get info about a fine-tuning job.
     *
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
     */
    @JvmOverloads
    fun retrieve(
        params: FineTuningJobRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /** List your organization's fine-tuning jobs */
    @JvmOverloads
    fun list(
        params: FineTuningJobListParams = FineTuningJobListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJobListPageAsync>

    /** List your organization's fine-tuning jobs */
    fun list(requestOptions: RequestOptions): CompletableFuture<FineTuningJobListPageAsync> =
        list(FineTuningJobListParams.none(), requestOptions)

    /** Immediately cancel a fine-tune job. */
    @JvmOverloads
    fun cancel(
        params: FineTuningJobCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /** Get status updates for a fine-tuning job. */
    @JvmOverloads
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
        @JvmOverloads
        @MustBeClosed
        fun create(
            params: FineTuningJobCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}`, but is
         * otherwise the same as [JobServiceAsync.retrieve].
         */
        @JvmOverloads
        @MustBeClosed
        fun retrieve(
            params: FineTuningJobRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs`, but is otherwise the same as
         * [JobServiceAsync.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: FineTuningJobListParams = FineTuningJobListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJobListPageAsync>>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs`, but is otherwise the same as
         * [JobServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<FineTuningJobListPageAsync>> =
            list(FineTuningJobListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs/{fine_tuning_job_id}/cancel`, but
         * is otherwise the same as [JobServiceAsync.cancel].
         */
        @JvmOverloads
        @MustBeClosed
        fun cancel(
            params: FineTuningJobCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJob>>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}/events`, but
         * is otherwise the same as [JobServiceAsync.listEvents].
         */
        @JvmOverloads
        @MustBeClosed
        fun listEvents(
            params: FineTuningJobListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJobListEventsPageAsync>>
    }
}
