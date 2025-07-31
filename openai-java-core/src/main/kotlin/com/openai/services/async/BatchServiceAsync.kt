// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.batches.Batch
import com.openai.models.batches.BatchCancelParams
import com.openai.models.batches.BatchCreateParams
import com.openai.models.batches.BatchListPageAsync
import com.openai.models.batches.BatchListParams
import com.openai.models.batches.BatchRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface BatchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): BatchServiceAsync

    /** Creates and executes a batch from an uploaded file of requests */
    fun create(params: BatchCreateParams): CompletableFuture<Batch> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: BatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Batch>

    /** Retrieves a batch. */
    fun retrieve(batchId: String): CompletableFuture<Batch> =
        retrieve(batchId, BatchRetrieveParams.none())

    /** @see retrieve */
    fun retrieve(
        batchId: String,
        params: BatchRetrieveParams = BatchRetrieveParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Batch> =
        retrieve(params.toBuilder().batchId(batchId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(
        batchId: String,
        params: BatchRetrieveParams = BatchRetrieveParams.none(),
    ): CompletableFuture<Batch> = retrieve(batchId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: BatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Batch>

    /** @see retrieve */
    fun retrieve(params: BatchRetrieveParams): CompletableFuture<Batch> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(batchId: String, requestOptions: RequestOptions): CompletableFuture<Batch> =
        retrieve(batchId, BatchRetrieveParams.none(), requestOptions)

    /** List your organization's batches. */
    fun list(): CompletableFuture<BatchListPageAsync> = list(BatchListParams.none())

    /** @see list */
    fun list(
        params: BatchListParams = BatchListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BatchListPageAsync>

    /** @see list */
    fun list(
        params: BatchListParams = BatchListParams.none()
    ): CompletableFuture<BatchListPageAsync> = list(params, RequestOptions.none())

    /** @see list */
    fun list(requestOptions: RequestOptions): CompletableFuture<BatchListPageAsync> =
        list(BatchListParams.none(), requestOptions)

    /**
     * Cancels an in-progress batch. The batch will be in status `cancelling` for up to 10 minutes,
     * before changing to `cancelled`, where it will have partial results (if any) available in the
     * output file.
     */
    fun cancel(batchId: String): CompletableFuture<Batch> =
        cancel(batchId, BatchCancelParams.none())

    /** @see cancel */
    fun cancel(
        batchId: String,
        params: BatchCancelParams = BatchCancelParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Batch> =
        cancel(params.toBuilder().batchId(batchId).build(), requestOptions)

    /** @see cancel */
    fun cancel(
        batchId: String,
        params: BatchCancelParams = BatchCancelParams.none(),
    ): CompletableFuture<Batch> = cancel(batchId, params, RequestOptions.none())

    /** @see cancel */
    fun cancel(
        params: BatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Batch>

    /** @see cancel */
    fun cancel(params: BatchCancelParams): CompletableFuture<Batch> =
        cancel(params, RequestOptions.none())

    /** @see cancel */
    fun cancel(batchId: String, requestOptions: RequestOptions): CompletableFuture<Batch> =
        cancel(batchId, BatchCancelParams.none(), requestOptions)

    /** A view of [BatchServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): BatchServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /batches`, but is otherwise the same as
         * [BatchServiceAsync.create].
         */
        fun create(params: BatchCreateParams): CompletableFuture<HttpResponseFor<Batch>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: BatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Batch>>

        /**
         * Returns a raw HTTP response for `get /batches/{batch_id}`, but is otherwise the same as
         * [BatchServiceAsync.retrieve].
         */
        fun retrieve(batchId: String): CompletableFuture<HttpResponseFor<Batch>> =
            retrieve(batchId, BatchRetrieveParams.none())

        /** @see retrieve */
        fun retrieve(
            batchId: String,
            params: BatchRetrieveParams = BatchRetrieveParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Batch>> =
            retrieve(params.toBuilder().batchId(batchId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            batchId: String,
            params: BatchRetrieveParams = BatchRetrieveParams.none(),
        ): CompletableFuture<HttpResponseFor<Batch>> =
            retrieve(batchId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: BatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Batch>>

        /** @see retrieve */
        fun retrieve(params: BatchRetrieveParams): CompletableFuture<HttpResponseFor<Batch>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            batchId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Batch>> =
            retrieve(batchId, BatchRetrieveParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `get /batches`, but is otherwise the same as
         * [BatchServiceAsync.list].
         */
        fun list(): CompletableFuture<HttpResponseFor<BatchListPageAsync>> =
            list(BatchListParams.none())

        /** @see list */
        fun list(
            params: BatchListParams = BatchListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BatchListPageAsync>>

        /** @see list */
        fun list(
            params: BatchListParams = BatchListParams.none()
        ): CompletableFuture<HttpResponseFor<BatchListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BatchListPageAsync>> =
            list(BatchListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /batches/{batch_id}/cancel`, but is otherwise the
         * same as [BatchServiceAsync.cancel].
         */
        fun cancel(batchId: String): CompletableFuture<HttpResponseFor<Batch>> =
            cancel(batchId, BatchCancelParams.none())

        /** @see cancel */
        fun cancel(
            batchId: String,
            params: BatchCancelParams = BatchCancelParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Batch>> =
            cancel(params.toBuilder().batchId(batchId).build(), requestOptions)

        /** @see cancel */
        fun cancel(
            batchId: String,
            params: BatchCancelParams = BatchCancelParams.none(),
        ): CompletableFuture<HttpResponseFor<Batch>> =
            cancel(batchId, params, RequestOptions.none())

        /** @see cancel */
        fun cancel(
            params: BatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Batch>>

        /** @see cancel */
        fun cancel(params: BatchCancelParams): CompletableFuture<HttpResponseFor<Batch>> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        fun cancel(
            batchId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<Batch>> =
            cancel(batchId, BatchCancelParams.none(), requestOptions)
    }
}
