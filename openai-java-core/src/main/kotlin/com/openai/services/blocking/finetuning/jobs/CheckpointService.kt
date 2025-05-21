// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning.jobs

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.finetuning.jobs.checkpoints.CheckpointListPage
import com.openai.models.finetuning.jobs.checkpoints.CheckpointListParams

interface CheckpointService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** List checkpoints for a fine-tuning job. */
    fun list(fineTuningJobId: String): CheckpointListPage =
        list(fineTuningJobId, CheckpointListParams.none())

    /** @see [list] */
    fun list(
        fineTuningJobId: String,
        params: CheckpointListParams = CheckpointListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CheckpointListPage =
        list(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

    /** @see [list] */
    fun list(
        fineTuningJobId: String,
        params: CheckpointListParams = CheckpointListParams.none(),
    ): CheckpointListPage = list(fineTuningJobId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: CheckpointListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CheckpointListPage

    /** @see [list] */
    fun list(params: CheckpointListParams): CheckpointListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(fineTuningJobId: String, requestOptions: RequestOptions): CheckpointListPage =
        list(fineTuningJobId, CheckpointListParams.none(), requestOptions)

    /** A view of [CheckpointService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}/checkpoints`,
         * but is otherwise the same as [CheckpointService.list].
         */
        @MustBeClosed
        fun list(fineTuningJobId: String): HttpResponseFor<CheckpointListPage> =
            list(fineTuningJobId, CheckpointListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            fineTuningJobId: String,
            params: CheckpointListParams = CheckpointListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CheckpointListPage> =
            list(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            fineTuningJobId: String,
            params: CheckpointListParams = CheckpointListParams.none(),
        ): HttpResponseFor<CheckpointListPage> =
            list(fineTuningJobId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: CheckpointListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CheckpointListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(params: CheckpointListParams): HttpResponseFor<CheckpointListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            fineTuningJobId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<CheckpointListPage> =
            list(fineTuningJobId, CheckpointListParams.none(), requestOptions)
    }
}
