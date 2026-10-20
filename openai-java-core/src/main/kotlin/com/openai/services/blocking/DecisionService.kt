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
     * Use this endpoint to quickly answer classification or scoring questions about some input. You
     * can ask multiple questions in one request.
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
