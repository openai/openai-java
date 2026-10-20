// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.beta.AgentServiceAsync
import com.openai.services.async.beta.AssistantServiceAsync
import com.openai.services.async.beta.ChatKitServiceAsync
import com.openai.services.async.beta.ResponseServiceAsync
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

    fun agents(): AgentServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Create and manage model responses. */
    fun responses(): ResponseServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun chatkit(): ChatKitServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Build Assistants that can call models and use tools. */
    fun assistants(): AssistantServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Build Assistants that can call models and use tools. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun threads(): ThreadServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** A view of [BetaServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaServiceAsync.WithRawResponse

        fun agents(): AgentServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Create and manage model responses. */
        fun responses(): ResponseServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun chatkit(): ChatKitServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Build Assistants that can call models and use tools. */
        fun assistants(): AssistantServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Build Assistants that can call models and use tools. */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun threads(): ThreadServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )
    }
}
