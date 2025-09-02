// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.beta.AssistantServiceAsync
import com.openai.services.async.beta.RealtimeServiceAsync
import com.openai.services.async.beta.ThreadServiceAsync
import java.util.function.Consumer

interface BetaServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaServiceAsync

    @Deprecated(
        "Realtime has now launched and is generally available. The old beta API is now deprecated."
    )
    fun realtime(): RealtimeServiceAsync

    fun assistants(): AssistantServiceAsync

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun threads(): ThreadServiceAsync

    /** A view of [BetaServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaServiceAsync.WithRawResponse

        @Deprecated(
            "Realtime has now launched and is generally available. The old beta API is now deprecated."
        )
        fun realtime(): RealtimeServiceAsync.WithRawResponse

        fun assistants(): AssistantServiceAsync.WithRawResponse

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun threads(): ThreadServiceAsync.WithRawResponse
    }
}
