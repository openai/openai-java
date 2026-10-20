// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.realtime.CallServiceAsync
import com.openai.services.async.realtime.ClientSecretServiceAsync
import com.openai.services.async.realtime.TranslationServiceAsync
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

    fun clientSecrets(): ClientSecretServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun calls(): CallServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun translations(): TranslationServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

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

        fun clientSecrets(): ClientSecretServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun calls(): CallServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun translations(): TranslationServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )
    }
}
