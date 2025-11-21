// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.realtime.CallServiceAsync
import com.openai.services.async.realtime.ClientSecretServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface RealtimeServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RealtimeServiceAsync

    fun clientSecrets(): ClientSecretServiceAsync

    fun calls(): CallServiceAsync

    /**
     * A view of [RealtimeServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): RealtimeServiceAsync.WithRawResponse

        fun clientSecrets(): ClientSecretServiceAsync.WithRawResponse

        fun calls(): CallServiceAsync.WithRawResponse
    }
}
