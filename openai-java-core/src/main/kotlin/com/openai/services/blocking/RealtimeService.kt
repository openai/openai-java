// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.realtime.CallService
import com.openai.services.blocking.realtime.ClientSecretService
import com.openai.services.blocking.realtime.TranslationService
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

    fun clientSecrets(): ClientSecretService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun calls(): CallService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun translations(): TranslationService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** A view of [RealtimeService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RealtimeService.WithRawResponse

        fun clientSecrets(): ClientSecretService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun calls(): CallService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun translations(): TranslationService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )
    }
}
