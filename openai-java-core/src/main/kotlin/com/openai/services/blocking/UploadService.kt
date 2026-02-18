// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.uploads.Upload
import com.openai.models.uploads.UploadCancelParams
import com.openai.models.uploads.UploadCompleteParams
import com.openai.models.uploads.UploadCreateParams
import com.openai.services.blocking.uploads.PartService
import java.util.function.Consumer

interface UploadService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): UploadService

    fun parts(): PartService

    /**
     * Creates an intermediate
     * [Upload](https://platform.openai.com/docs/api-reference/uploads/object) object that you can
     * add [Parts](https://platform.openai.com/docs/api-reference/uploads/part-object) to.
     * Currently, an Upload can accept at most 8 GB in total and expires after an hour after you
     * create it.
     *
     * Once you complete the Upload, we will create a
     * [File](https://platform.openai.com/docs/api-reference/files/object) object that contains all
     * the parts you uploaded. This File is usable in the rest of our platform as a regular File
     * object.
     *
     * For certain `purpose` values, the correct `mime_type` must be specified. Please refer to
     * documentation for the
     * [supported MIME types for your use case](https://platform.openai.com/docs/assistants/tools/file-search#supported-files).
     *
     * For guidance on the proper filename extensions for each purpose, please follow the
     * documentation on
     * [creating a File](https://platform.openai.com/docs/api-reference/files/create).
     *
     * Returns the Upload object with status `pending`.
     */
    fun create(params: UploadCreateParams): Upload = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: UploadCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Upload

    /**
     * Cancels the Upload. No Parts may be added after an Upload is cancelled.
     *
     * Returns the Upload object with status `cancelled`.
     */
    fun cancel(uploadId: String): Upload = cancel(uploadId, UploadCancelParams.none())

    /** @see cancel */
    fun cancel(
        uploadId: String,
        params: UploadCancelParams = UploadCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Upload = cancel(params.toBuilder().uploadId(uploadId).build(), requestOptions)

    /** @see cancel */
    fun cancel(uploadId: String, params: UploadCancelParams = UploadCancelParams.none()): Upload =
        cancel(uploadId, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: UploadCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Upload

    /** @see cancel */
    fun cancel(params: UploadCancelParams): Upload = cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(uploadId: String, requestOptions: RequestOptions): Upload =
        cancel(uploadId, UploadCancelParams.none(), requestOptions)

    /**
     * Completes the [Upload](https://platform.openai.com/docs/api-reference/uploads/object).
     *
     * Within the returned Upload object, there is a nested
     * [File](https://platform.openai.com/docs/api-reference/files/object) object that is ready to
     * use in the rest of the platform.
     *
     * You can specify the order of the Parts by passing in an ordered list of the Part IDs.
     *
     * The number of bytes uploaded upon completion must match the number of bytes initially
     * specified when creating the Upload object. No Parts may be added after an Upload is
     * completed. Returns the Upload object with status `completed`, including an additional `file`
     * property containing the created usable File object.
     */
    fun complete(uploadId: String, params: UploadCompleteParams): Upload =
        complete(uploadId, params, RequestOptions.none())

    /** @see complete */
    fun complete(
        uploadId: String,
        params: UploadCompleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Upload = complete(params.toBuilder().uploadId(uploadId).build(), requestOptions)

    /** @see complete */
    fun complete(params: UploadCompleteParams): Upload = complete(params, RequestOptions.none())

    /** @see complete */
    fun complete(
        params: UploadCompleteParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Upload

    /** A view of [UploadService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): UploadService.WithRawResponse

        fun parts(): PartService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /uploads`, but is otherwise the same as
         * [UploadService.create].
         */
        @MustBeClosed
        fun create(params: UploadCreateParams): HttpResponseFor<Upload> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: UploadCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Upload>

        /**
         * Returns a raw HTTP response for `post /uploads/{upload_id}/cancel`, but is otherwise the
         * same as [UploadService.cancel].
         */
        @MustBeClosed
        fun cancel(uploadId: String): HttpResponseFor<Upload> =
            cancel(uploadId, UploadCancelParams.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            uploadId: String,
            params: UploadCancelParams = UploadCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Upload> =
            cancel(params.toBuilder().uploadId(uploadId).build(), requestOptions)

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            uploadId: String,
            params: UploadCancelParams = UploadCancelParams.none(),
        ): HttpResponseFor<Upload> = cancel(uploadId, params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(
            params: UploadCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Upload>

        /** @see cancel */
        @MustBeClosed
        fun cancel(params: UploadCancelParams): HttpResponseFor<Upload> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        @MustBeClosed
        fun cancel(uploadId: String, requestOptions: RequestOptions): HttpResponseFor<Upload> =
            cancel(uploadId, UploadCancelParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /uploads/{upload_id}/complete`, but is otherwise
         * the same as [UploadService.complete].
         */
        @MustBeClosed
        fun complete(uploadId: String, params: UploadCompleteParams): HttpResponseFor<Upload> =
            complete(uploadId, params, RequestOptions.none())

        /** @see complete */
        @MustBeClosed
        fun complete(
            uploadId: String,
            params: UploadCompleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Upload> =
            complete(params.toBuilder().uploadId(uploadId).build(), requestOptions)

        /** @see complete */
        @MustBeClosed
        fun complete(params: UploadCompleteParams): HttpResponseFor<Upload> =
            complete(params, RequestOptions.none())

        /** @see complete */
        @MustBeClosed
        fun complete(
            params: UploadCompleteParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Upload>
    }
}
