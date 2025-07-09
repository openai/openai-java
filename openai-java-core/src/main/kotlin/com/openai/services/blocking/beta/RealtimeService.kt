// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta

import com.openai.core.ClientOptions
import com.openai.services.blocking.beta.realtime.SessionService
import com.openai.services.blocking.beta.realtime.TranscriptionSessionService
import java.util.function.Consumer

interface RealtimeService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RealtimeService

    fun sessions(): SessionService

    fun transcriptionSessions(): TranscriptionSessionService

    /** A view of [RealtimeService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RealtimeService.WithRawResponse

        fun sessions(): SessionService.WithRawResponse

        fun transcriptionSessions(): TranscriptionSessionService.WithRawResponse
    }
}
