// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning.alpha

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.finetuning.alpha.graders.GraderRunParams
import com.openai.models.finetuning.alpha.graders.GraderRunResponse
import com.openai.models.finetuning.alpha.graders.GraderValidateParams
import com.openai.models.finetuning.alpha.graders.GraderValidateResponse
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface GraderServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GraderServiceAsync

    /** Run a grader. */
    fun run(params: GraderRunParams): CompletableFuture<GraderRunResponse> =
        run(params, RequestOptions.none())

    /** @see run */
    fun run(
        params: GraderRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GraderRunResponse>

    /** Validate a grader. */
    fun validate(params: GraderValidateParams): CompletableFuture<GraderValidateResponse> =
        validate(params, RequestOptions.none())

    /** @see validate */
    fun validate(
        params: GraderValidateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<GraderValidateResponse>

    /**
     * A view of [GraderServiceAsync] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GraderServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /fine_tuning/alpha/graders/run`, but is otherwise
         * the same as [GraderServiceAsync.run].
         */
        fun run(params: GraderRunParams): CompletableFuture<HttpResponseFor<GraderRunResponse>> =
            run(params, RequestOptions.none())

        /** @see run */
        fun run(
            params: GraderRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GraderRunResponse>>

        /**
         * Returns a raw HTTP response for `post /fine_tuning/alpha/graders/validate`, but is
         * otherwise the same as [GraderServiceAsync.validate].
         */
        fun validate(
            params: GraderValidateParams
        ): CompletableFuture<HttpResponseFor<GraderValidateResponse>> =
            validate(params, RequestOptions.none())

        /** @see validate */
        fun validate(
            params: GraderValidateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<GraderValidateResponse>>
    }
}
