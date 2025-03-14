// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.images.ImageGenerateParams
import com.openai.models.images.ImagesResponse
import java.util.concurrent.CompletableFuture

interface ImageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Creates an image given a prompt. */
    fun generate(params: ImageGenerateParams): CompletableFuture<ImagesResponse> =
        generate(params, RequestOptions.none())

    /** @see [generate] */
    fun generate(
        params: ImageGenerateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ImagesResponse>

    /** A view of [ImageServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /images/generations`, but is otherwise the same as
         * [ImageServiceAsync.generate].
         */
        @MustBeClosed
        fun generate(
            params: ImageGenerateParams
        ): CompletableFuture<HttpResponseFor<ImagesResponse>> =
            generate(params, RequestOptions.none())

        /** @see [generate] */
        @MustBeClosed
        fun generate(
            params: ImageGenerateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ImagesResponse>>
    }
}
