// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.responses

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.responses.inputitems.InputItemListPage
import com.openai.models.responses.inputitems.InputItemListParams

interface InputItemService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Returns a list of input items for a given response. */
    fun list(responseId: String): InputItemListPage = list(responseId, InputItemListParams.none())

    /** @see [list] */
    fun list(
        responseId: String,
        params: InputItemListParams = InputItemListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InputItemListPage = list(params.toBuilder().responseId(responseId).build(), requestOptions)

    /** @see [list] */
    fun list(
        responseId: String,
        params: InputItemListParams = InputItemListParams.none(),
    ): InputItemListPage = list(responseId, params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: InputItemListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InputItemListPage

    /** @see [list] */
    fun list(params: InputItemListParams): InputItemListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(responseId: String, requestOptions: RequestOptions): InputItemListPage =
        list(responseId, InputItemListParams.none(), requestOptions)

    /** A view of [InputItemService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /responses/{response_id}/input_items`, but is
         * otherwise the same as [InputItemService.list].
         */
        @MustBeClosed
        fun list(responseId: String): HttpResponseFor<InputItemListPage> =
            list(responseId, InputItemListParams.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            responseId: String,
            params: InputItemListParams = InputItemListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InputItemListPage> =
            list(params.toBuilder().responseId(responseId).build(), requestOptions)

        /** @see [list] */
        @MustBeClosed
        fun list(
            responseId: String,
            params: InputItemListParams = InputItemListParams.none(),
        ): HttpResponseFor<InputItemListPage> = list(responseId, params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: InputItemListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InputItemListPage>

        /** @see [list] */
        @MustBeClosed
        fun list(params: InputItemListParams): HttpResponseFor<InputItemListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            responseId: String,
            requestOptions: RequestOptions,
        ): HttpResponseFor<InputItemListPage> =
            list(responseId, InputItemListParams.none(), requestOptions)
    }
}
