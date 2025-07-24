// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.evals.runs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.evals.runs.outputitems.OutputItemListPageAsync
import com.openai.models.evals.runs.outputitems.OutputItemListParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface OutputItemServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OutputItemServiceAsync

    /** Get an evaluation run output item by ID. */
    fun retrieve(
        outputItemId: String,
        params: OutputItemRetrieveParams,
    ): CompletableFuture<OutputItemRetrieveResponse> =
        retrieve(outputItemId, params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        outputItemId: String,
        params: OutputItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OutputItemRetrieveResponse> =
        retrieve(params.toBuilder().outputItemId(outputItemId).build(), requestOptions)

    /** @see retrieve */
    fun retrieve(params: OutputItemRetrieveParams): CompletableFuture<OutputItemRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    fun retrieve(
        params: OutputItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OutputItemRetrieveResponse>

    /** Get a list of output items for an evaluation run. */
    fun list(
        runId: String,
        params: OutputItemListParams,
    ): CompletableFuture<OutputItemListPageAsync> = list(runId, params, RequestOptions.none())

    /** @see list */
    fun list(
        runId: String,
        params: OutputItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OutputItemListPageAsync> =
        list(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see list */
    fun list(params: OutputItemListParams): CompletableFuture<OutputItemListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        params: OutputItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OutputItemListPageAsync>

    /**
     * A view of [OutputItemServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OutputItemServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /evals/{eval_id}/runs/{run_id}/output_items/{output_item_id}`, but is otherwise the same
         * as [OutputItemServiceAsync.retrieve].
         */
        fun retrieve(
            outputItemId: String,
            params: OutputItemRetrieveParams,
        ): CompletableFuture<HttpResponseFor<OutputItemRetrieveResponse>> =
            retrieve(outputItemId, params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            outputItemId: String,
            params: OutputItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OutputItemRetrieveResponse>> =
            retrieve(params.toBuilder().outputItemId(outputItemId).build(), requestOptions)

        /** @see retrieve */
        fun retrieve(
            params: OutputItemRetrieveParams
        ): CompletableFuture<HttpResponseFor<OutputItemRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        fun retrieve(
            params: OutputItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OutputItemRetrieveResponse>>

        /**
         * Returns a raw HTTP response for `get /evals/{eval_id}/runs/{run_id}/output_items`, but is
         * otherwise the same as [OutputItemServiceAsync.list].
         */
        fun list(
            runId: String,
            params: OutputItemListParams,
        ): CompletableFuture<HttpResponseFor<OutputItemListPageAsync>> =
            list(runId, params, RequestOptions.none())

        /** @see list */
        fun list(
            runId: String,
            params: OutputItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OutputItemListPageAsync>> =
            list(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see list */
        fun list(
            params: OutputItemListParams
        ): CompletableFuture<HttpResponseFor<OutputItemListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            params: OutputItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OutputItemListPageAsync>>
    }
}
