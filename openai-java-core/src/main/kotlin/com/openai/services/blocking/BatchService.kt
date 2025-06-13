// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.batches.Batch
import com.openai.models.batches.BatchCancelParams
import com.openai.models.batches.BatchCreateParams
import com.openai.models.batches.BatchListPage
import com.openai.models.batches.BatchListParams
import com.openai.models.batches.BatchRetrieveParams
import java.util.function.Consumer

interface BatchService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BatchService

    /** Creates and executes a batch from an uploaded file of requests */
    fun create(params: BatchCreateParams): Batch = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Batch

    /** Retrieves a batch. */
    fun retrieve(batchId: String): Batch = retrieve(batchId, BatchRetrieveParams.none())

    /** @see [retrieve] */
    fun retrieve(
        batchId: String,
        params: BatchRetrieveParams = BatchRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Batch = retrieve(params.toBuilder().batchId(batchId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(batchId: String, params: BatchRetrieveParams = BatchRetrieveParams.none()): Batch =
        retrieve(batchId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Batch

    /** @see [retrieve] */
    fun retrieve(params: BatchRetrieveParams): Batch = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(batchId: String, requestOptions: RequestOptions): Batch =
        retrieve(batchId, BatchRetrieveParams.none(), requestOptions)

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
    fun cancel(batchId: String): Batch = cancel(batchId, BatchCancelParams.none())

    /** @see [cancel] */
    fun cancel(
        batchId: String,
        params: BatchCancelParams = BatchCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Batch = cancel(params.toBuilder().batchId(batchId).build(), requestOptions)

    /** @see [cancel] */
    fun cancel(batchId: String, params: BatchCancelParams = BatchCancelParams.none()): Batch =
        cancel(batchId, params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: BatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Batch

    /** @see [cancel] */
    fun cancel(params: BatchCancelParams): Batch = cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(batchId: String, requestOptions: RequestOptions): Batch =
        cancel(batchId, BatchCancelParams.none(), requestOptions)

    /** A view of [BatchService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): BatchService.WithRawResponse

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
        fun retrieve(batchId: String): HttpResponseFor<Batch> =
            retrieve(batchId, BatchRetrieveParams.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            batchId: String,
            params: BatchRetrieveParams = BatchRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Batch> =
            retrieve(params.toBuilder().batchId(batchId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            batchId: String,
            params: BatchRetrieveParams = BatchRetrieveParams.none(),
        ): HttpResponseFor<Batch> = retrieve(batchId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Batch>

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(params: BatchRetrieveParams): HttpResponseFor<Batch> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(batchId: String, requestOptions: RequestOptions): HttpResponseFor<Batch> =
            retrieve(batchId, BatchRetrieveParams.none(), requestOptions)

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
        fun cancel(batchId: String): HttpResponseFor<Batch> =
            cancel(batchId, BatchCancelParams.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            batchId: String,
            params: BatchCancelParams = BatchCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Batch> =
            cancel(params.toBuilder().batchId(batchId).build(), requestOptions)

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            batchId: String,
            params: BatchCancelParams = BatchCancelParams.none(),
        ): HttpResponseFor<Batch> = cancel(batchId, params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: BatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Batch>

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(params: BatchCancelParams): HttpResponseFor<Batch> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(batchId: String, requestOptions: RequestOptions): HttpResponseFor<Batch> =
            cancel(batchId, BatchCancelParams.none(), requestOptions)
    }
}
