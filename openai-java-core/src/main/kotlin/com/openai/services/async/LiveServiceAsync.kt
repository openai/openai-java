// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.live.LiveCreateParams
import com.openai.models.live.LiveCreateResponse
import com.openai.services.async.live.ForkServiceAsync
import com.openai.services.async.live.SessionServiceAsync
import com.openai.services.async.live.SidebandServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface LiveServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): LiveServiceAsync

    fun sideband(): SidebandServiceAsync

    fun forks(): ForkServiceAsync

    fun sessions(): SessionServiceAsync

    /**
     * Create a Live WebRTC session. Start with the
     * [Live prompting guide](https://developers.openai.com/api/docs/guides/live-prompting).
     */
    fun create(params: LiveCreateParams): CompletableFuture<LiveCreateResponse> =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: LiveCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<LiveCreateResponse>

    /** A view of [LiveServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): LiveServiceAsync.WithRawResponse

        fun sideband(): SidebandServiceAsync.WithRawResponse

        fun forks(): ForkServiceAsync.WithRawResponse

        fun sessions(): SessionServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /live/sessions`, but is otherwise the same as
         * [LiveServiceAsync.create].
         */
        fun create(
            params: LiveCreateParams
        ): CompletableFuture<HttpResponseFor<LiveCreateResponse>> =
            create(params, RequestOptions.none())

        /** @see create */
        fun create(
            params: LiveCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<LiveCreateResponse>>
    }
}
