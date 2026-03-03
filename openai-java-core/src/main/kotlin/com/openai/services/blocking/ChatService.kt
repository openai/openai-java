// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.chat.ChatCompletionService
import java.util.function.Consumer

interface ChatService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatService

    /** Given a list of messages comprising a conversation, the model will return a response. */
    fun completions(): ChatCompletionService

    /** A view of [ChatService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): ChatService.WithRawResponse

        /** Given a list of messages comprising a conversation, the model will return a response. */
        fun completions(): ChatCompletionService.WithRawResponse
    }
}
