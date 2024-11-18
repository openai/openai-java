// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async.chat

import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.models.ChatCompletion
import com.openai.models.ChatCompletionChunk
import com.openai.models.ChatCompletionCreateParams
import java.util.concurrent.CompletableFuture

interface CompletionServiceAsync {

    /**
     * Creates a model response for the given chat conversation. Learn more in the
     * [text generation](https://platform.openai.com/docs/guides/text-generation),
     * [vision](https://platform.openai.com/docs/guides/vision), and
     * [audio](https://platform.openai.com/docs/guides/audio) guides.
     */
    @JvmOverloads
    fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): CompletableFuture<ChatCompletion>

    /**
     * Creates a model response for the given chat conversation. Learn more in the
     * [text generation](https://platform.openai.com/docs/guides/text-generation),
     * [vision](https://platform.openai.com/docs/guides/vision), and
     * [audio](https://platform.openai.com/docs/guides/audio) guides.
     */
    @JvmOverloads
    fun createStreaming(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none()
    ): AsyncStreamResponse<ChatCompletionChunk>
}
