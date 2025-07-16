// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.images.ImageCreateVariationParams
import com.openai.models.images.ImageEditParams
import com.openai.models.images.ImageEditStreamEvent
import com.openai.models.images.ImageGenStreamEvent
import com.openai.models.images.ImageGenerateParams
import com.openai.models.images.ImagesResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ImageServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ImageServiceAsync

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
     * Creates an edited or extended image given one or more source images and a prompt. This
     * endpoint only supports `gpt-image-1` and `dall-e-2`.
     */
    fun editStreaming(params: ImageEditParams): AsyncStreamResponse<ImageEditStreamEvent> =
        editStreaming(params, RequestOptions.none())

    /** @see [editStreaming] */
    fun editStreaming(
        params: ImageEditParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<ImageEditStreamEvent>

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

    /**
     * Creates an image given a prompt.
     * [Learn more](https://platform.openai.com/docs/guides/images).
     */
    fun generateStreaming(params: ImageGenerateParams): AsyncStreamResponse<ImageGenStreamEvent> =
        generateStreaming(params, RequestOptions.none())

    /** @see [generateStreaming] */
    fun generateStreaming(
        params: ImageGenerateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<ImageGenStreamEvent>

    /** A view of [ImageServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ImageServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /images/variations`, but is otherwise the same as
         * [ImageServiceAsync.createVariation].
         */
        fun createVariation(
            params: ImageCreateVariationParams
        ): CompletableFuture<HttpResponseFor<ImagesResponse>> =
            createVariation(params, RequestOptions.none())

        /** @see [createVariation] */
        fun createVariation(
            params: ImageCreateVariationParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ImagesResponse>>

        /**
         * Returns a raw HTTP response for `post /images/edits`, but is otherwise the same as
         * [ImageServiceAsync.edit].
         */
        fun edit(params: ImageEditParams): CompletableFuture<HttpResponseFor<ImagesResponse>> =
            edit(params, RequestOptions.none())

        /** @see [edit] */
        fun edit(
            params: ImageEditParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ImagesResponse>>

        /**
         * Returns a raw HTTP response for `post /images/edits`, but is otherwise the same as
         * [ImageServiceAsync.editStreaming].
         */
        @MustBeClosed
        fun editStreaming(
            params: ImageEditParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<ImageEditStreamEvent>>> =
            editStreaming(params, RequestOptions.none())

        /** @see [editStreaming] */
        @MustBeClosed
        fun editStreaming(
            params: ImageEditParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<ImageEditStreamEvent>>>

        /**
         * Returns a raw HTTP response for `post /images/generations`, but is otherwise the same as
         * [ImageServiceAsync.generate].
         */
        fun generate(
            params: ImageGenerateParams
        ): CompletableFuture<HttpResponseFor<ImagesResponse>> =
            generate(params, RequestOptions.none())

        /** @see [generate] */
        fun generate(
            params: ImageGenerateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ImagesResponse>>

        /**
         * Returns a raw HTTP response for `post /images/generations`, but is otherwise the same as
         * [ImageServiceAsync.generateStreaming].
         */
        @MustBeClosed
        fun generateStreaming(
            params: ImageGenerateParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<ImageGenStreamEvent>>> =
            generateStreaming(params, RequestOptions.none())

        /** @see [generateStreaming] */
        @MustBeClosed
        fun generateStreaming(
            params: ImageGenerateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<ImageGenStreamEvent>>>
    }
}
