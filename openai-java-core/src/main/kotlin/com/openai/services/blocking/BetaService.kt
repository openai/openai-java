// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.beta.AssistantService
import com.openai.services.blocking.beta.ChatKitService
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

    fun chatkit(): ChatKitService

    /** Build Assistants that can call models and use tools. */
    fun assistants(): AssistantService

    /** Build Assistants that can call models and use tools. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun threads(): ThreadService

    /** A view of [BetaService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BetaService.WithRawResponse

        fun chatkit(): ChatKitService.WithRawResponse

        /** Build Assistants that can call models and use tools. */
        fun assistants(): AssistantService.WithRawResponse

        /** Build Assistants that can call models and use tools. */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun threads(): ThreadService.WithRawResponse
    }
}
