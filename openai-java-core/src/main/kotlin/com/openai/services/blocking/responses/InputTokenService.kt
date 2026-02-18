// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.responses

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.responses.inputtokens.InputTokenCountParams
import com.openai.models.responses.inputtokens.InputTokenCountResponse
import java.util.function.Consumer

interface InputTokenService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): InputTokenService

    /**
     * Returns input token counts of the request.
     *
     * Returns an object with `object` set to `response.input_tokens` and an `input_tokens` count.
     */
    fun count(): InputTokenCountResponse = count(InputTokenCountParams.none())

    /** @see count */
    fun count(
        params: InputTokenCountParams = InputTokenCountParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): InputTokenCountResponse

    /** @see count */
    fun count(
        params: InputTokenCountParams = InputTokenCountParams.none()
    ): InputTokenCountResponse = count(params, RequestOptions.none())

    /** @see count */
    fun count(requestOptions: RequestOptions): InputTokenCountResponse =
        count(InputTokenCountParams.none(), requestOptions)

    /** A view of [InputTokenService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): InputTokenService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /responses/input_tokens`, but is otherwise the same
         * as [InputTokenService.count].
         */
        @MustBeClosed
        fun count(): HttpResponseFor<InputTokenCountResponse> = count(InputTokenCountParams.none())

        /** @see count */
        @MustBeClosed
        fun count(
            params: InputTokenCountParams = InputTokenCountParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<InputTokenCountResponse>

        /** @see count */
        @MustBeClosed
        fun count(
            params: InputTokenCountParams = InputTokenCountParams.none()
        ): HttpResponseFor<InputTokenCountResponse> = count(params, RequestOptions.none())

        /** @see count */
        @MustBeClosed
        fun count(requestOptions: RequestOptions): HttpResponseFor<InputTokenCountResponse> =
            count(InputTokenCountParams.none(), requestOptions)
    }
}
