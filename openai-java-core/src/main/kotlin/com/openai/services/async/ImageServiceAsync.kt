// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.images.ImageCreateVariationParams
import com.openai.models.images.ImageEditParams
import com.openai.models.images.ImageGenerateParams
import com.openai.models.images.ImagesResponse
import java.util.concurrent.CompletableFuture

interface ImageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Creates a variation of a given image. This endpoint only supports `dall-e-2`. */
    fun createVariation(params: ImageCreateVariationParams): CompletableFuture<ImagesResponse> =
        createVariation(params, RequestOptions.none())

    /** @see [createVariation] */
    fun createVariation(
        params: ImageCreateVariationParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ImagesResponse>

    /**
     * Creates an edited or extended image given one or more source images and a prompt. This
     * endpoint only supports `gpt-image-1` and `dall-e-2`.
     */
    fun edit(params: ImageEditParams): CompletableFuture<ImagesResponse> =
        edit(params, RequestOptions.none())

    /** @see [edit] */
    fun edit(
        params: ImageEditParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ImagesResponse>

    /**
     * Creates an image given a prompt.
     * [Learn more](https://platform.openai.com/docs/guides/images).
     */
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
         * Returns a raw HTTP response for `post /images/variations`, but is otherwise the same as
         * [ImageServiceAsync.createVariation].
         */
        @MustBeClosed
        fun createVariation(
            params: ImageCreateVariationParams
        ): CompletableFuture<HttpResponseFor<ImagesResponse>> =
            createVariation(params, RequestOptions.none())

        /** @see [createVariation] */
        @MustBeClosed
        fun createVariation(
            params: ImageCreateVariationParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ImagesResponse>>

        /**
         * Returns a raw HTTP response for `post /images/edits`, but is otherwise the same as
         * [ImageServiceAsync.edit].
         */
        @MustBeClosed
        fun edit(params: ImageEditParams): CompletableFuture<HttpResponseFor<ImagesResponse>> =
            edit(params, RequestOptions.none())

        /** @see [edit] */
        @MustBeClosed
        fun edit(
            params: ImageEditParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ImagesResponse>>

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
