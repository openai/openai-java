// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.responses

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.responses.inputitems.InputItemListPageAsync
import com.openai.models.responses.inputitems.InputItemListParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface InputItemServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InputItemServiceAsync

    /** Returns a list of input items for a given response. */
    fun list(responseId: String): CompletableFuture<InputItemListPageAsync> =
        list(responseId, InputItemListParams.none())

    /** @see list */
    fun list(
        responseId: String,
        params: InputItemListParams = InputItemListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InputItemListPageAsync> =
        list(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see list */
    fun list(
        responseId: String,
        params: InputItemListParams = InputItemListParams.none(),
    ): CompletableFuture<InputItemListPageAsync> = list(responseId, params, RequestOptions.none())

    /** @see list */
    fun list(
        params: InputItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InputItemListPageAsync>

    /** @see list */
    fun list(params: InputItemListParams): CompletableFuture<InputItemListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    fun list(
        responseId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<InputItemListPageAsync> =
        list(responseId, InputItemListParams.none(), requestOptions)

    /**
     * A view of [InputItemServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InputItemServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /responses/{response_id}/input_items`, but is
         * otherwise the same as [InputItemServiceAsync.list].
         */
        fun list(responseId: String): CompletableFuture<HttpResponseFor<InputItemListPageAsync>> =
            list(responseId, InputItemListParams.none())

        /** @see list */
        fun list(
            responseId: String,
            params: InputItemListParams = InputItemListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InputItemListPageAsync>> =
            list(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see list */
        fun list(
            responseId: String,
            params: InputItemListParams = InputItemListParams.none(),
        ): CompletableFuture<HttpResponseFor<InputItemListPageAsync>> =
            list(responseId, params, RequestOptions.none())

        /** @see list */
        fun list(
            params: InputItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InputItemListPageAsync>>

        /** @see list */
        fun list(
            params: InputItemListParams
        ): CompletableFuture<HttpResponseFor<InputItemListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        fun list(
            responseId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<InputItemListPageAsync>> =
            list(responseId, InputItemListParams.none(), requestOptions)
    }
}
