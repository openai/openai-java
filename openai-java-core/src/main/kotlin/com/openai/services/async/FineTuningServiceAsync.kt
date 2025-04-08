// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.services.async.finetuning.CheckpointServiceAsync
import com.openai.services.async.finetuning.JobServiceAsync

interface FineTuningServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun jobs(): JobServiceAsync

    fun checkpoints(): CheckpointServiceAsync

    /**
     * A view of [FineTuningServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        fun jobs(): JobServiceAsync.WithRawResponse

        fun checkpoints(): CheckpointServiceAsync.WithRawResponse
    }
}
