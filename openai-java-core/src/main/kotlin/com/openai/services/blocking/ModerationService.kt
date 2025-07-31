// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.moderations.ModerationCreateParams
import com.openai.models.moderations.ModerationCreateResponse
import java.util.function.Consumer

interface ModerationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): ModerationService

    /**
     * Classifies if text and/or image inputs are potentially harmful. Learn more in the
     * [moderation guide](https://platform.openai.com/docs/guides/moderation).
     */
    fun create(params: ModerationCreateParams): ModerationCreateResponse =
        create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: ModerationCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): ModerationCreateResponse

    /** A view of [ModerationService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): ModerationService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /moderations`, but is otherwise the same as
         * [ModerationService.create].
         */
        @MustBeClosed
        fun create(params: ModerationCreateParams): HttpResponseFor<ModerationCreateResponse> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: ModerationCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<ModerationCreateResponse>
    }
}
