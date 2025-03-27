// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.responses

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.responses.inputitems.InputItemListPageAsync
import com.openai.models.responses.inputitems.InputItemListParams
import java.util.concurrent.CompletableFuture

interface InputItemServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns a list of input items for a given response. */
    fun list(params: InputItemListParams): CompletableFuture<InputItemListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: InputItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InputItemListPageAsync>

    /**
     * A view of [InputItemServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /responses/{response_id}/input_items`, but is
         * otherwise the same as [InputItemServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            params: InputItemListParams
        ): CompletableFuture<HttpResponseFor<InputItemListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: InputItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InputItemListPageAsync>>
    }
}
