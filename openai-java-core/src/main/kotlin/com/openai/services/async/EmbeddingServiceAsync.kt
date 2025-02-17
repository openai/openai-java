// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async

import com.openai.core.RequestOptions
import com.openai.models.CreateEmbeddingResponse
import com.openai.models.EmbeddingCreateParams
import java.util.concurrent.CompletableFuture

interface EmbeddingServiceAsync {

    /** Creates an embedding vector representing the input text. */
    @JvmOverloads
    fun create(
        params: EmbeddingCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CreateEmbeddingResponse>
}
