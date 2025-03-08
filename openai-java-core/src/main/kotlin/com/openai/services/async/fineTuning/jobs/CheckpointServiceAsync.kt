// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.fineTuning.jobs

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.FineTuningJobCheckpointListPageAsync
import com.openai.models.FineTuningJobCheckpointListParams
import java.util.concurrent.CompletableFuture

interface CheckpointServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** List checkpoints for a fine-tuning job. */
    fun list(
        params: FineTuningJobCheckpointListParams
    ): CompletableFuture<FineTuningJobCheckpointListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: FineTuningJobCheckpointListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJobCheckpointListPageAsync>

    /**
     * A view of [CheckpointServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}/checkpoints`,
         * but is otherwise the same as [CheckpointServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            params: FineTuningJobCheckpointListParams
        ): CompletableFuture<HttpResponseFor<FineTuningJobCheckpointListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: FineTuningJobCheckpointListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<FineTuningJobCheckpointListPageAsync>>
    }
}
