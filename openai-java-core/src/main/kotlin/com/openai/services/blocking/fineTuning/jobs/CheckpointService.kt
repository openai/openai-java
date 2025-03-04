// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking.fineTuning.jobs

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.FineTuningJobCheckpointListPage
import com.openai.models.FineTuningJobCheckpointListParams

interface CheckpointService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** List checkpoints for a fine-tuning job. */
    @JvmOverloads
    fun list(
        params: FineTuningJobCheckpointListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): FineTuningJobCheckpointListPage

    /** A view of [CheckpointService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /fine_tuning/jobs/{fine_tuning_job_id}/checkpoints`,
         * but is otherwise the same as [CheckpointService.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: FineTuningJobCheckpointListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<FineTuningJobCheckpointListPage>
    }
}
