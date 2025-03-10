// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.chat.ChatCompletionService
import com.openai.services.blocking.chat.ChatCompletionServiceImpl

class ChatServiceImpl internal constructor(private val clientOptions: ClientOptions) : ChatService {

    private val withRawResponse: ChatService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val completions: ChatCompletionService by lazy {
        ChatCompletionServiceImpl(clientOptions)
    }

    override fun withRawResponse(): ChatService.WithRawResponse = withRawResponse

    override fun completions(): ChatCompletionService = completions

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChatService.WithRawResponse {

        private val completions: ChatCompletionService.WithRawResponse by lazy {
            ChatCompletionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun completions(): ChatCompletionService.WithRawResponse = completions
    }
}
