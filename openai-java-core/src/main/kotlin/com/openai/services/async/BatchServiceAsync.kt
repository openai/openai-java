// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.Batch
import com.openai.models.BatchCancelParams
import com.openai.models.BatchCreateParams
import com.openai.models.BatchListPageAsync
import com.openai.models.BatchListParams
import com.openai.models.BatchRetrieveParams
import java.util.concurrent.CompletableFuture

interface BatchServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Creates and executes a batch from an uploaded file of requests */
    fun create(params: BatchCreateParams): CompletableFuture<Batch> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BatchCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Batch>

    /** Retrieves a batch. */
    fun retrieve(params: BatchRetrieveParams): CompletableFuture<Batch> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BatchRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Batch>

    /** List your organization's batches. */
    fun list(): CompletableFuture<BatchListPageAsync> = list(BatchListParams.none())

    /** @see [list] */
    fun list(
        params: BatchListParams = BatchListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BatchListPageAsync>

    /** @see [list] */
    fun list(
        params: BatchListParams = BatchListParams.none()
    ): CompletableFuture<BatchListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(requestOptions: RequestOptions): CompletableFuture<BatchListPageAsync> =
        list(BatchListParams.none(), requestOptions)

    /**
     * Cancels an in-progress batch. The batch will be in status `cancelling` for up to 10 minutes,
     * before changing to `cancelled`, where it will have partial results (if any) available in the
     * output file.
     */
    fun cancel(params: BatchCancelParams): CompletableFuture<Batch> =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: BatchCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Batch>

    /** A view of [BatchServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `post /batches`, but is otherwise the same as
         * [BatchServiceAsync.create].
         */
        @MustBeClosed
        fun create(params: BatchCreateParams): CompletableFuture<HttpResponseFor<Batch>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BatchCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Batch>>

        /**
         * Returns a raw HTTP response for `get /batches/{batch_id}`, but is otherwise the same as
         * [BatchServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: BatchRetrieveParams): CompletableFuture<HttpResponseFor<Batch>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BatchRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Batch>>

        /**
         * Returns a raw HTTP response for `get /batches`, but is otherwise the same as
         * [BatchServiceAsync.list].
         */
        @MustBeClosed
        fun list(): CompletableFuture<HttpResponseFor<BatchListPageAsync>> =
            list(BatchListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BatchListParams = BatchListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BatchListPageAsync>>

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BatchListParams = BatchListParams.none()
        ): CompletableFuture<HttpResponseFor<BatchListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<BatchListPageAsync>> =
            list(BatchListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /batches/{batch_id}/cancel`, but is otherwise the
         * same as [BatchServiceAsync.cancel].
         */
        @MustBeClosed
        fun cancel(params: BatchCancelParams): CompletableFuture<HttpResponseFor<Batch>> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: BatchCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Batch>>
    }
}
