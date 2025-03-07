// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.Batch
import com.openai.models.BatchCancelParams
import com.openai.models.BatchCreateParams
import com.openai.models.BatchListPage
import com.openai.models.BatchListParams
import com.openai.models.BatchRetrieveParams

interface BatchService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Creates and executes a batch from an uploaded file of requests */
    fun create(params: BatchCreateParams): Batch = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Batch

    /** Retrieves a batch. */
    fun retrieve(params: BatchRetrieveParams): Batch = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Batch

    /** List your organization's batches. */
    fun list(): BatchListPage = list(BatchListParams.none())

    /** @see [list] */
    fun list(
        params: BatchListParams = BatchListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BatchListPage

    /** @see [list] */
    fun list(params: BatchListParams = BatchListParams.none()): BatchListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): BatchListPage =
        list(BatchListParams.none(), requestOptions)

    /**
     * Cancels an in-progress batch. The batch will be in status `cancelling` for up to 10 minutes,
     * before changing to `cancelled`, where it will have partial results (if any) available in the
     * output file.
     */
    fun cancel(params: BatchCancelParams): Batch = cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: BatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Batch

    /** A view of [BatchService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /batches`, but is otherwise the same as
         * [BatchService.create].
         */
        @MustBeClosed
        fun create(params: BatchCreateParams): HttpResponseFor<Batch> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Batch>

        /**
         * Returns a raw HTTP response for `get /batches/{batch_id}`, but is otherwise the same as
         * [BatchService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: BatchRetrieveParams): HttpResponseFor<Batch> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Batch>

        /**
         * Returns a raw HTTP response for `get /batches`, but is otherwise the same as
         * [BatchService.list].
         */
        @MustBeClosed fun list(): HttpResponseFor<BatchListPage> = list(BatchListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BatchListParams = BatchListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BatchListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(params: BatchListParams = BatchListParams.none()): HttpResponseFor<BatchListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(requestOptions: RequestOptions): HttpResponseFor<BatchListPage> =
            list(BatchListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /batches/{batch_id}/cancel`, but is otherwise the
         * same as [BatchService.cancel].
         */
        @MustBeClosed
        fun cancel(params: BatchCancelParams): HttpResponseFor<Batch> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: BatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Batch>
    }
}
