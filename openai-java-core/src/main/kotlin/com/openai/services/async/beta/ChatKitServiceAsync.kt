// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.core.ClientOptions
import com.openai.services.async.beta.chatkit.SessionServiceAsync
import com.openai.services.async.beta.chatkit.ThreadServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ChatKitServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatKitServiceAsync

    fun sessions(): SessionServiceAsync

    fun threads(): ThreadServiceAsync

    /**
     * A view of [ChatKitServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ChatKitServiceAsync.WithRawResponse

        fun sessions(): SessionServiceAsync.WithRawResponse

        fun threads(): ThreadServiceAsync.WithRawResponse
    }
}
