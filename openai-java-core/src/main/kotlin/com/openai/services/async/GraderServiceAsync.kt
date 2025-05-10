// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.services.async.graders.GraderModelServiceAsync

interface GraderServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun graderModels(): GraderModelServiceAsync

    /**
     * A view of [GraderServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        fun graderModels(): GraderModelServiceAsync.WithRawResponse
    }
}
