// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.services.async.beta.AssistantServiceAsync
import com.openai.services.async.beta.ThreadServiceAsync

interface BetaServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun assistants(): AssistantServiceAsync

    fun threads(): ThreadServiceAsync

    /** A view of [BetaServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun assistants(): AssistantServiceAsync.WithRawResponse

        fun threads(): ThreadServiceAsync.WithRawResponse
    }
}
