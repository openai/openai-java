// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning.jobs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.finetuning.jobs.checkpoints.CheckpointListPageAsync
import com.openai.models.finetuning.jobs.checkpoints.CheckpointListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface CheckpointServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckpointServiceAsync

    /** List checkpoints for a fine-tuning job. */
    fun list(fineTuningJobId: String): CompletableFuture<CheckpointListPageAsync> =
        list(fineTuningJobId, CheckpointListParams.none())

    /** @see [list] */
    fun list(
        fineTuningJobId: String,
        params: CheckpointListParams = CheckpointListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CheckpointListPageAsync> =
        list(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

    /** @see [list] */
    fun list(
        fineTuningJobId: String,
        params: CheckpointListParams = CheckpointListParams.none(),
    ): CompletableFuture<CheckpointListPageAsync> =
        list(fineTuningJobId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: CheckpointListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CheckpointListPageAsync>

    /** @see [list] */
    fun list(params: CheckpointListParams): CompletableFuture<CheckpointListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        fineTuningJobId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<CheckpointListPageAsync> =
        list(fineTuningJobId, CheckpointListParams.none(), requestOptions)

    /**
     * A view of [CheckpointServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): CheckpointServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}/checkpoints`,
         * but is otherwise the same as [CheckpointServiceAsync.list].
         */
        fun list(
            fineTuningJobId: String
        ): CompletableFuture<HttpResponseFor<CheckpointListPageAsync>> =
            list(fineTuningJobId, CheckpointListParams.none())

        /** @see [list] */
        fun list(
            fineTuningJobId: String,
            params: CheckpointListParams = CheckpointListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CheckpointListPageAsync>> =
            list(params.toBuilder().fineTuningJobId(fineTuningJobId).build(), requestOptions)

        /** @see [list] */
        fun list(
            fineTuningJobId: String,
            params: CheckpointListParams = CheckpointListParams.none(),
        ): CompletableFuture<HttpResponseFor<CheckpointListPageAsync>> =
            list(fineTuningJobId, params, RequestOptions.none())

        /** @see [list] */
        fun list(
            params: CheckpointListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CheckpointListPageAsync>>

        /** @see [list] */
        fun list(
            params: CheckpointListParams
        ): CompletableFuture<HttpResponseFor<CheckpointListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        fun list(
            fineTuningJobId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<CheckpointListPageAsync>> =
            list(fineTuningJobId, CheckpointListParams.none(), requestOptions)
    }
}
