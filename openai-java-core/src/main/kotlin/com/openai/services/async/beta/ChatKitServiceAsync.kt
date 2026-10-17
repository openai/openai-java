// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta

import com.openai.core.ClientOptions
import com.openai.services.async.beta.chatkit.SessionServiceAsync
import com.openai.services.async.beta.chatkit.ThreadServiceAsync
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

    fun sessions(): SessionServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun threads(): ThreadServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

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

        fun sessions(): SessionServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun threads(): ThreadServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )
    }
}
