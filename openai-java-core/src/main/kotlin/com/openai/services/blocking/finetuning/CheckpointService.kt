// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning

import com.openai.services.blocking.finetuning.checkpoints.PermissionService

interface CheckpointService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun permissions(): PermissionService

    /** A view of [CheckpointService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun permissions(): PermissionService.WithRawResponse
    }
}
