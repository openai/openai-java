// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.chat.CompletionServiceAsync
import com.openai.services.async.chat.CompletionServiceAsyncImpl

class ChatServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    ChatServiceAsync {

    private val completions: CompletionServiceAsync by lazy {
        CompletionServiceAsyncImpl(clientOptions)
    }

    override fun completions(): CompletionServiceAsync = completions
}
