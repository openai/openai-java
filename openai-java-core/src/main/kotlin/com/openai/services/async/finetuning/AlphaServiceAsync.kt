// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning

import com.openai.services.async.finetuning.alpha.GraderServiceAsync

interface AlphaServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun graders(): GraderServiceAsync

    /** A view of [AlphaServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun graders(): GraderServiceAsync.WithRawResponse
    }
}
