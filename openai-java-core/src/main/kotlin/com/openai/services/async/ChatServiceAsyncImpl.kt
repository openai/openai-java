// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.chat.ChatCompletionServiceAsync
import com.openai.services.async.chat.ChatCompletionServiceAsyncImpl

class ChatServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ChatServiceAsync {

    private val withRawResponse: ChatServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val completions: ChatCompletionServiceAsync by lazy {
        ChatCompletionServiceAsyncImpl(clientOptions)
    }

    override fun withRawResponse(): ChatServiceAsync.WithRawResponse = withRawResponse

    override fun completions(): ChatCompletionServiceAsync = completions

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        ChatServiceAsync.WithRawResponse {

        private val completions: ChatCompletionServiceAsync.WithRawResponse by lazy {
            ChatCompletionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun completions(): ChatCompletionServiceAsync.WithRawResponse = completions
    }
}
