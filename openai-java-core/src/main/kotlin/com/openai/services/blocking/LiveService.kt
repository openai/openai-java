// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.live.LiveCreateParams
import com.openai.models.live.LiveCreateResponse
import com.openai.services.blocking.live.ForkService
import com.openai.services.blocking.live.SessionService
import com.openai.services.blocking.live.SidebandService
import java.util.function.Consumer

interface LiveService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): LiveService

    fun sideband(): SidebandService

    fun forks(): ForkService

    fun sessions(): SessionService

    /**
     * Create a Live WebRTC session. Start with the
     * [Live prompting guide](https://developers.openai.com/api/docs/guides/live-prompting).
     */
    fun create(params: LiveCreateParams): LiveCreateResponse = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: LiveCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): LiveCreateResponse

    /** A view of [LiveService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): LiveService.WithRawResponse

        fun sideband(): SidebandService.WithRawResponse

        fun forks(): ForkService.WithRawResponse

        fun sessions(): SessionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /live/sessions`, but is otherwise the same as
         * [LiveService.create].
         */
        @MustBeClosed
        fun create(params: LiveCreateParams): HttpResponseFor<LiveCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: LiveCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<LiveCreateResponse>
    }
}
