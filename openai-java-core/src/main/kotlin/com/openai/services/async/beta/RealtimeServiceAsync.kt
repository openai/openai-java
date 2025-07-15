// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta

import com.openai.core.ClientOptions
import com.openai.services.async.beta.realtime.SessionServiceAsync
import com.openai.services.async.beta.realtime.TranscriptionSessionServiceAsync
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

    fun sessions(): SessionServiceAsync

    fun transcriptionSessions(): TranscriptionSessionServiceAsync

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

        fun sessions(): SessionServiceAsync.WithRawResponse

        fun transcriptionSessions(): TranscriptionSessionServiceAsync.WithRawResponse
    }
}
