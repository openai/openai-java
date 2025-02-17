// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.chat.CompletionService
import com.openai.services.blocking.chat.CompletionServiceImpl

class ChatServiceImpl internal constructor(private val clientOptions: ClientOptions) : ChatService {

    private val completions: CompletionService by lazy { CompletionServiceImpl(clientOptions) }

    override fun completions(): CompletionService = completions
}
