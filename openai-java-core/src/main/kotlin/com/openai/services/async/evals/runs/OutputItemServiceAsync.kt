// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.evals.runs

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.evals.runs.outputitems.OutputItemListPageAsync
import com.openai.models.evals.runs.outputitems.OutputItemListParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveResponse
import java.util.concurrent.CompletableFuture

interface OutputItemServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Get an evaluation run output item by ID. */
    fun retrieve(params: OutputItemRetrieveParams): CompletableFuture<OutputItemRetrieveResponse> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: OutputItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<OutputItemRetrieveResponse>

    /** Get a list of output items for an evaluation run. */
    fun list(params: OutputItemListParams): CompletableFuture<OutputItemListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
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
         * Returns a raw HTTP response for `get
         * /evals/{eval_id}/runs/{run_id}/output_items/{output_item_id}`, but is otherwise the same
         * as [OutputItemServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: OutputItemRetrieveParams
        ): CompletableFuture<HttpResponseFor<OutputItemRetrieveResponse>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: OutputItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OutputItemRetrieveResponse>>

        /**
         * Returns a raw HTTP response for `get /evals/{eval_id}/runs/{run_id}/output_items`, but is
         * otherwise the same as [OutputItemServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            params: OutputItemListParams
        ): CompletableFuture<HttpResponseFor<OutputItemListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: OutputItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<OutputItemListPageAsync>>
    }
}
