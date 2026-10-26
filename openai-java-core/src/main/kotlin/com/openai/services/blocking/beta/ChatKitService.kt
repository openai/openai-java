// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta

import com.openai.core.ClientOptions
import com.openai.services.blocking.beta.chatkit.SessionService
import com.openai.services.blocking.beta.chatkit.ThreadService
import java.util.function.Consumer

interface ChatKitService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatKitService

    fun sessions(): SessionService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun threads(): ThreadService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** A view of [ChatKitService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatKitService.WithRawResponse

        fun sessions(): SessionService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun threads(): ThreadService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )
    }
}
