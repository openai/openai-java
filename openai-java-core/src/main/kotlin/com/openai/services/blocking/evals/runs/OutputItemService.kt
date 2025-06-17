// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.evals.runs

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.evals.runs.outputitems.OutputItemListPage
import com.openai.models.evals.runs.outputitems.OutputItemListParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveParams
import com.openai.models.evals.runs.outputitems.OutputItemRetrieveResponse
import java.util.function.Consumer

interface OutputItemService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): OutputItemService

    /** Get an evaluation run output item by ID. */
    fun retrieve(
        outputItemId: String,
        params: OutputItemRetrieveParams,
    ): OutputItemRetrieveResponse = retrieve(outputItemId, params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        outputItemId: String,
        params: OutputItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OutputItemRetrieveResponse =
        retrieve(params.toBuilder().outputItemId(outputItemId).build(), requestOptions)

    /** @see [retrieve] */
    fun retrieve(params: OutputItemRetrieveParams): OutputItemRetrieveResponse =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: OutputItemRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OutputItemRetrieveResponse

    /** Get a list of output items for an evaluation run. */
    fun list(runId: String, params: OutputItemListParams): OutputItemListPage =
        list(runId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        runId: String,
        params: OutputItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OutputItemListPage = list(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see [list] */
    fun list(params: OutputItemListParams): OutputItemListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: OutputItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): OutputItemListPage

    /** A view of [OutputItemService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): OutputItemService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get
         * /evals/{eval_id}/runs/{run_id}/output_items/{output_item_id}`, but is otherwise the same
         * as [OutputItemService.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            outputItemId: String,
            params: OutputItemRetrieveParams,
        ): HttpResponseFor<OutputItemRetrieveResponse> =
            retrieve(outputItemId, params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            outputItemId: String,
            params: OutputItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OutputItemRetrieveResponse> =
            retrieve(params.toBuilder().outputItemId(outputItemId).build(), requestOptions)

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: OutputItemRetrieveParams
        ): HttpResponseFor<OutputItemRetrieveResponse> = retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: OutputItemRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OutputItemRetrieveResponse>

        /**
         * Returns a raw HTTP response for `get /evals/{eval_id}/runs/{run_id}/output_items`, but is
         * otherwise the same as [OutputItemService.list].
         */
        @MustBeClosed
        fun list(runId: String, params: OutputItemListParams): HttpResponseFor<OutputItemListPage> =
            list(runId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            runId: String,
            params: OutputItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OutputItemListPage> =
            list(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(params: OutputItemListParams): HttpResponseFor<OutputItemListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: OutputItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<OutputItemListPage>
    }
}
