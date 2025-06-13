// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.embeddings.CreateEmbeddingResponse
import com.openai.models.embeddings.EmbeddingCreateParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface EmbeddingServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): EmbeddingServiceAsync

    /** Creates an embedding vector representing the input text. */
    fun create(params: EmbeddingCreateParams): CompletableFuture<CreateEmbeddingResponse> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: EmbeddingCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<CreateEmbeddingResponse>

    /**
     * A view of [EmbeddingServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): EmbeddingServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /embeddings`, but is otherwise the same as
         * [EmbeddingServiceAsync.create].
         */
        fun create(
            params: EmbeddingCreateParams
        ): CompletableFuture<HttpResponseFor<CreateEmbeddingResponse>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        fun create(
            params: EmbeddingCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<CreateEmbeddingResponse>>
    }
}
