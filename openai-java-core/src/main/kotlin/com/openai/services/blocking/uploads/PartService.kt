// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.uploads

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.UploadPart
import com.openai.models.UploadPartCreateParams

interface PartService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Adds a [Part](https://platform.openai.com/docs/api-reference/uploads/part-object) to an
     * [Upload](https://platform.openai.com/docs/api-reference/uploads/object) object. A Part
     * represents a chunk of bytes from the file you are trying to upload.
     *
     * Each Part can be at most 64 MB, and you can add Parts until you hit the Upload maximum of 8
     * GB.
     *
     * It is possible to add multiple Parts in parallel. You can decide the intended order of the
     * Parts when you
     * [complete the Upload](https://platform.openai.com/docs/api-reference/uploads/complete).
     */
    fun create(params: UploadPartCreateParams): UploadPart = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: UploadPartCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): UploadPart

    /** A view of [PartService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /uploads/{upload_id}/parts`, but is otherwise the
         * same as [PartService.create].
         */
        @MustBeClosed
        fun create(params: UploadPartCreateParams): HttpResponseFor<UploadPart> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: UploadPartCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<UploadPart>
    }
}
