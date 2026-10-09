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
     * Use this endpoint to ask classification or scoring questions about the same input. You’ll get
     * the answers back in the order you asked the questions.
     *
     * For text, you can pass a string. You can also send user messages containing `input_text` and
     * `input_image` parts, with up to 128 images per request. Images can be base64 data URLs or
     * publicly accessible HTTP(S) URLs. File IDs aren’t accepted. Other message roles, function
     * calls, files, audio, and item references aren’t supported.
     *
     * Sometimes a question returns a refusal instead of an answer. The result has type `refusal`
     * and includes the question’s name, or `null` if you didn’t give it one.
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
