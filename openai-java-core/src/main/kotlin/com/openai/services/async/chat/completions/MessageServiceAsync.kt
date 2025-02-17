// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async.chat.completions

import com.openai.core.RequestOptions
import com.openai.models.ChatCompletionMessageListPageAsync
import com.openai.models.ChatCompletionMessageListParams
import java.util.concurrent.CompletableFuture

interface MessageServiceAsync {

    /**
     * Get the messages in a stored chat completion. Only chat completions that have been created
     * with the `store` parameter set to `true` will be returned.
     */
    @JvmOverloads
    fun list(
        params: ChatCompletionMessageListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ChatCompletionMessageListPageAsync>
}
