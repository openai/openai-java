// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning.alpha

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.finetuning.alpha.graders.GraderRunParams
import com.openai.models.finetuning.alpha.graders.GraderRunResponse
import com.openai.models.finetuning.alpha.graders.GraderValidateParams
import com.openai.models.finetuning.alpha.graders.GraderValidateResponse
import java.util.function.Consumer

interface GraderService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GraderService

    /** Run a grader. */
    fun run(params: GraderRunParams): GraderRunResponse = run(params, RequestOptions.none())

    /** @see run */
    fun run(
        params: GraderRunParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GraderRunResponse

    /** Validate a grader. */
    fun validate(params: GraderValidateParams): GraderValidateResponse =
        validate(params, RequestOptions.none())

    /** @see validate */
    fun validate(
        params: GraderValidateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): GraderValidateResponse

    /** A view of [GraderService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): GraderService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /fine_tuning/alpha/graders/run`, but is otherwise
         * the same as [GraderService.run].
         */
        @MustBeClosed
        fun run(params: GraderRunParams): HttpResponseFor<GraderRunResponse> =
            run(params, RequestOptions.none())

        /** @see run */
        @MustBeClosed
        fun run(
            params: GraderRunParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GraderRunResponse>

        /**
         * Returns a raw HTTP response for `post /fine_tuning/alpha/graders/validate`, but is
         * otherwise the same as [GraderService.validate].
         */
        @MustBeClosed
        fun validate(params: GraderValidateParams): HttpResponseFor<GraderValidateResponse> =
            validate(params, RequestOptions.none())

        /** @see validate */
        @MustBeClosed
        fun validate(
            params: GraderValidateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<GraderValidateResponse>
    }
}
