// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async

import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.models.Completion
import com.openai.models.CompletionCreateParams
import java.util.concurrent.CompletableFuture

interface CompletionServiceAsync {

    /** Creates a completion for the provided prompt and parameters. */
    @JvmOverloads
    fun create(
        params: CompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Completion>

    /** Creates a completion for the provided prompt and parameters. */
    @JvmOverloads
    fun createStreaming(
        params: CompletionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<Completion>
}
