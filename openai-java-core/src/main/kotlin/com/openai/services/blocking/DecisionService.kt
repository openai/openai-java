// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.decisions.Decision
import com.openai.models.decisions.DecisionCreateParams
import java.util.function.Consumer

interface DecisionService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): DecisionService

    /**
     * Evaluate ordered classification and scoring questions against shared input. Answers are
     * returned in question order.
     *
     * Supply input as a string or user messages containing text and inline images. Only user
     * messages with `input_text` and `input_image` parts are supported; non-user roles, function
     * calls, files, audio, and item references are not supported. Images require a data URL, not an
     * external URL or file ID. At most 128 images are allowed across the request.
     *
     * Each question can return a refusal instead of a scored answer. A refusal has type `refusal`
     * and the corresponding question name, or null if unnamed.
     */
    fun create(params: DecisionCreateParams): Decision = create(params, RequestOptions.none())

    /** @see create */
    fun create(
        params: DecisionCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Decision

    /** A view of [DecisionService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): DecisionService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /decisions`, but is otherwise the same as
         * [DecisionService.create].
         */
        @MustBeClosed
        fun create(params: DecisionCreateParams): HttpResponseFor<Decision> =
            create(params, RequestOptions.none())

        /** @see create */
        @MustBeClosed
        fun create(
            params: DecisionCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Decision>
    }
}
