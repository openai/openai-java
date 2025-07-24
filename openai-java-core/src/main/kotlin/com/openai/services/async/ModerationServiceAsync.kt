// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.moderations.ModerationCreateParams
import com.openai.models.moderations.ModerationCreateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface ModerationServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ModerationServiceAsync

    /**
     * Classifies if text and/or image inputs are potentially harmful. Learn more in the
     * [moderation guide](https://platform.openai.com/docs/guides/moderation).
     */
    fun create(params: ModerationCreateParams): CompletableFuture<ModerationCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ModerationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<ModerationCreateResponse>

    /**
     * A view of [ModerationServiceAsync] that provides access to raw HTTP responses for each
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
        ): ModerationServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /moderations`, but is otherwise the same as
         * [ModerationServiceAsync.create].
         */
        fun create(
            params: ModerationCreateParams
        ): CompletableFuture<HttpResponseFor<ModerationCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: ModerationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<ModerationCreateResponse>>
    }
}
