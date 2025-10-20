// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.responses

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.responses.inputtokens.InputTokenCountParams
import com.openai.models.responses.inputtokens.InputTokenCountResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface InputTokenServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InputTokenServiceAsync

    /** Get input token counts */
    fun count(): CompletableFuture<InputTokenCountResponse> = count(InputTokenCountParams.none())

    /** @see count */
    fun count(
        params: InputTokenCountParams = InputTokenCountParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<InputTokenCountResponse>

    /** @see count */
    fun count(
        params: InputTokenCountParams = InputTokenCountParams.none()
    ): CompletableFuture<InputTokenCountResponse> = count(params, RequestOptions.none())

    /** @see count */
    fun count(requestOptions: RequestOptions): CompletableFuture<InputTokenCountResponse> =
        count(InputTokenCountParams.none(), requestOptions)

    /**
     * A view of [InputTokenServiceAsync] that provides access to raw HTTP responses for each
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
        ): InputTokenServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /responses/input_tokens`, but is otherwise the same
         * as [InputTokenServiceAsync.count].
         */
        fun count(): CompletableFuture<HttpResponseFor<InputTokenCountResponse>> =
            count(InputTokenCountParams.none())

        /** @see count */
        fun count(
            params: InputTokenCountParams = InputTokenCountParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<InputTokenCountResponse>>

        /** @see count */
        fun count(
            params: InputTokenCountParams = InputTokenCountParams.none()
        ): CompletableFuture<HttpResponseFor<InputTokenCountResponse>> =
            count(params, RequestOptions.none())

        /** @see count */
        fun count(
            requestOptions: RequestOptions
        ): CompletableFuture<HttpResponseFor<InputTokenCountResponse>> =
            count(InputTokenCountParams.none(), requestOptions)
    }
}
