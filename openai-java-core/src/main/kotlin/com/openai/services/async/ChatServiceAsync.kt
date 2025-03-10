// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.services.async.chat.ChatCompletionServiceAsync

interface ChatServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun completions(): ChatCompletionServiceAsync

    /** A view of [ChatServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun completions(): ChatCompletionServiceAsync.WithRawResponse
    }
}
