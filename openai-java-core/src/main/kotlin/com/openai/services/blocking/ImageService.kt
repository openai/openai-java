// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.images.ImageGenerateParams
import com.openai.models.images.ImagesResponse

interface ImageService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

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
