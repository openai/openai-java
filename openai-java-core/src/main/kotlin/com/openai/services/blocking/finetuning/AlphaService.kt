// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning

import com.openai.services.blocking.finetuning.alpha.GraderService

interface AlphaService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun graders(): GraderService

    /** A view of [AlphaService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun graders(): GraderService.WithRawResponse
    }
}
