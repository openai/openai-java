// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.CreateEmbeddingResponse
import com.openai.models.EmbeddingCreateParams

interface EmbeddingService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Creates an embedding vector representing the input text. */
    fun create(params: EmbeddingCreateParams): CreateEmbeddingResponse =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: EmbeddingCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CreateEmbeddingResponse

    /** A view of [EmbeddingService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /embeddings`, but is otherwise the same as
         * [EmbeddingService.create].
         */
        @MustBeClosed
        fun create(params: EmbeddingCreateParams): HttpResponseFor<CreateEmbeddingResponse> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: EmbeddingCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<CreateEmbeddingResponse>
    }
}
