// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning

import com.openai.services.async.finetuning.checkpoints.PermissionServiceAsync

interface CheckpointServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun permissions(): PermissionServiceAsync

    /**
     * A view of [CheckpointServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        fun permissions(): PermissionServiceAsync.WithRawResponse
    }
}
