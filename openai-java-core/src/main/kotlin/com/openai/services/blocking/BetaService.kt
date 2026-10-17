// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.beta.AgentService
import com.openai.services.blocking.beta.AssistantService
import com.openai.services.blocking.beta.ChatKitService
import com.openai.services.blocking.beta.RealtimeService
import com.openai.services.blocking.beta.ResponseService
import com.openai.services.blocking.beta.ThreadService
import java.util.function.Consumer

interface BetaService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaService

    @Deprecated(
        "Realtime has now launched and is generally available. The old beta API is now deprecated."
    )
    fun realtime(): RealtimeService

    fun agents(): AgentService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Create and manage model responses. */
    fun responses(): ResponseService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun chatkit(): ChatKitService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Build Assistants that can call models and use tools. */
    fun assistants(): AssistantService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Build Assistants that can call models and use tools. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun threads(): ThreadService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** A view of [BetaService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaService.WithRawResponse

        @Deprecated(
            "Realtime has now launched and is generally available. The old beta API is now deprecated."
        )
        fun realtime(): RealtimeService.WithRawResponse

        fun agents(): AgentService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Create and manage model responses. */
        fun responses(): ResponseService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun chatkit(): ChatKitService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Build Assistants that can call models and use tools. */
        fun assistants(): AssistantService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Build Assistants that can call models and use tools. */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun threads(): ThreadService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )
    }
}
