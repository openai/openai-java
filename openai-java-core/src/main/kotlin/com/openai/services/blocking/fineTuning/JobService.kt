// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.fineTuning

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.FineTuningJob
import com.openai.models.FineTuningJobCancelParams
import com.openai.models.FineTuningJobCreateParams
import com.openai.models.FineTuningJobListEventsPage
import com.openai.models.FineTuningJobListEventsParams
import com.openai.models.FineTuningJobListPage
import com.openai.models.FineTuningJobListParams
import com.openai.models.FineTuningJobRetrieveParams
import com.openai.services.blocking.fineTuning.jobs.CheckpointService

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
    fun create(params: FineTuningJobCreateParams): FineTuningJob =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: FineTuningJobCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FineTuningJob

    /**
     * Get info about a fine-tuning job.
     *
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
     */
    fun retrieve(params: FineTuningJobRetrieveParams): FineTuningJob =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: FineTuningJobRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FineTuningJob

    /** List your organization's fine-tuning jobs */
    fun list(): FineTuningJobListPage = list(FineTuningJobListParams.none())

    /** @see [list] */
    fun list(
        params: FineTuningJobListParams = FineTuningJobListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FineTuningJobListPage

    /** @see [list] */
    fun list(
        params: FineTuningJobListParams = FineTuningJobListParams.none()
    ): FineTuningJobListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): FineTuningJobListPage =
        list(FineTuningJobListParams.none(), requestOptions)

    /** Immediately cancel a fine-tune job. */
    fun cancel(params: FineTuningJobCancelParams): FineTuningJob =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: FineTuningJobCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FineTuningJob

    /** Get status updates for a fine-tuning job. */
    fun listEvents(params: FineTuningJobListEventsParams): FineTuningJobListEventsPage =
        listEvents(params, RequestOptions.none())

    /** @see [listEvents] */
    fun listEvents(
        params: FineTuningJobListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FineTuningJobListEventsPage

    /** A view of [JobService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun checkpoints(): CheckpointService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs`, but is otherwise the same as
         * [JobService.create].
         */
        @MustBeClosed
        fun create(params: FineTuningJobCreateParams): HttpResponseFor<FineTuningJob> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: FineTuningJobCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FineTuningJob>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}`, but is
         * otherwise the same as [JobService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: FineTuningJobRetrieveParams): HttpResponseFor<FineTuningJob> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: FineTuningJobRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FineTuningJob>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs`, but is otherwise the same as
         * [JobService.list].
         */
        @MustBeClosed
        fun list(): HttpResponseFor<FineTuningJobListPage> = list(FineTuningJobListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: FineTuningJobListParams = FineTuningJobListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FineTuningJobListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: FineTuningJobListParams = FineTuningJobListParams.none()
        ): HttpResponseFor<FineTuningJobListPage> = list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<FineTuningJobListPage> =
            list(FineTuningJobListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /fine_tuning/jobs/{fine_tuning_job_id}/cancel`, but
         * is otherwise the same as [JobService.cancel].
         */
        @MustBeClosed
        fun cancel(params: FineTuningJobCancelParams): HttpResponseFor<FineTuningJob> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: FineTuningJobCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FineTuningJob>

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}/events`, but
         * is otherwise the same as [JobService.listEvents].
         */
        @MustBeClosed
        fun listEvents(
            params: FineTuningJobListEventsParams
        ): HttpResponseFor<FineTuningJobListEventsPage> = listEvents(params, RequestOptions.none())

        /** @see [listEvents] */
        @MustBeClosed
        fun listEvents(
            params: FineTuningJobListEventsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FineTuningJobListEventsPage>
    }
}
