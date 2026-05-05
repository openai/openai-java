// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.realtime.CallService
import com.openai.services.blocking.realtime.ClientSecretService
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

    fun clientSecrets(): ClientSecretService

    fun calls(): CallService

    /** A view of [RealtimeService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RealtimeService.WithRawResponse

        fun clientSecrets(): ClientSecretService.WithRawResponse

        fun calls(): CallService.WithRawResponse
    }
}
