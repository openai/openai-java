// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking.chat

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.StreamResponse
import com.openai.models.ChatCompletion
import com.openai.models.ChatCompletionChunk
import com.openai.models.ChatCompletionCreateParams
import com.openai.models.ChatCompletionDeleteParams
import com.openai.models.ChatCompletionDeleted
import com.openai.models.ChatCompletionRetrieveParams
import com.openai.models.ChatCompletionUpdateParams
import com.openai.services.blocking.chat.completions.MessageService

interface CompletionService {

    fun messages(): MessageService

    /**
     * Creates a model response for the given chat conversation. Learn more in the
     * [text generation](https://platform.openai.com/docs/guides/text-generation),
     * [vision](https://platform.openai.com/docs/guides/vision), and
     * [audio](https://platform.openai.com/docs/guides/audio) guides.
     *
     * Parameter support can differ depending on the model used to generate the response,
     * particularly for newer reasoning models. Parameters that are only supported for reasoning
     * models are noted below. For the current state of unsupported parameters in reasoning models,
     * [refer to the reasoning guide](https://platform.openai.com/docs/guides/reasoning).
     */
    @JvmOverloads
    fun create(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletion

    /**
     * Creates a model response for the given chat conversation. Learn more in the
     * [text generation](https://platform.openai.com/docs/guides/text-generation),
     * [vision](https://platform.openai.com/docs/guides/vision), and
     * [audio](https://platform.openai.com/docs/guides/audio) guides.
     *
     * Parameter support can differ depending on the model used to generate the response,
     * particularly for newer reasoning models. Parameters that are only supported for reasoning
     * models are noted below. For the current state of unsupported parameters in reasoning models,
     * [refer to the reasoning guide](https://platform.openai.com/docs/guides/reasoning).
     */
    @JvmOverloads
    @MustBeClosed
    fun createStreaming(
        params: ChatCompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<ChatCompletionChunk>

    /**
     * Get a stored chat completion. Only chat completions that have been created with the `store`
     * parameter set to `true` will be returned.
     */
    @JvmOverloads
    fun retrieve(
        params: ChatCompletionRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletion

    /**
     * Modify a stored chat completion. Only chat completions that have been created with the
     * `store` parameter set to `true` can be modified. Currently, the only supported modification
     * is to update the `metadata` field.
     */
    @JvmOverloads
    fun update(
        params: ChatCompletionUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletion

    /**
     * Delete a stored chat completion. Only chat completions that have been created with the
     * `store` parameter set to `true` can be deleted.
     */
    @JvmOverloads
    fun delete(
        params: ChatCompletionDeleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ChatCompletionDeleted
}
