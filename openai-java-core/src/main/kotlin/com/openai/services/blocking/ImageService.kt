// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.ImageCreateVariationParams
import com.openai.models.ImageEditParams
import com.openai.models.ImageGenerateParams
import com.openai.models.ImagesResponse

interface ImageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Creates a variation of a given image. */
    fun createVariation(params: ImageCreateVariationParams): ImagesResponse =
        createVariation(params, RequestOptions.none())

    /** @see [createVariation] */
    fun createVariation(
        params: ImageCreateVariationParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ImagesResponse

    /** Creates an edited or extended image given an original image and a prompt. */
    fun edit(params: ImageEditParams): ImagesResponse = edit(params, RequestOptions.none())

    /** @see [edit] */
    fun edit(
        params: ImageEditParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ImagesResponse

    /** Creates an image given a prompt. */
    fun generate(params: ImageGenerateParams): ImagesResponse =
        generate(params, RequestOptions.none())

    /** @see [generate] */
    fun generate(
        params: ImageGenerateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ImagesResponse

    /** A view of [ImageService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /images/variations`, but is otherwise the same as
         * [ImageService.createVariation].
         */
        @MustBeClosed
        fun createVariation(params: ImageCreateVariationParams): HttpResponseFor<ImagesResponse> =
            createVariation(params, RequestOptions.none())

        /** @see [createVariation] */
        @MustBeClosed
        fun createVariation(
            params: ImageCreateVariationParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ImagesResponse>

        /**
         * Returns a raw HTTP response for `post /images/edits`, but is otherwise the same as
         * [ImageService.edit].
         */
        @MustBeClosed
        fun edit(params: ImageEditParams): HttpResponseFor<ImagesResponse> =
            edit(params, RequestOptions.none())

        /** @see [edit] */
        @MustBeClosed
        fun edit(
            params: ImageEditParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ImagesResponse>

        /**
         * Returns a raw HTTP response for `post /images/generations`, but is otherwise the same as
         * [ImageService.generate].
         */
        @MustBeClosed
        fun generate(params: ImageGenerateParams): HttpResponseFor<ImagesResponse> =
            generate(params, RequestOptions.none())

        /** @see [generate] */
        @MustBeClosed
        fun generate(
            params: ImageGenerateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ImagesResponse>
    }
}
