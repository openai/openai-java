// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.services.blocking.graders.GraderModelService

interface GraderService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun graderModels(): GraderModelService

    /** A view of [GraderService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun graderModels(): GraderModelService.WithRawResponse
    }
}
