// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads.runs

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.BetaThreadRunStepListPageAsync
import com.openai.models.BetaThreadRunStepListParams
import com.openai.models.BetaThreadRunStepRetrieveParams
import com.openai.models.RunStep
import java.util.concurrent.CompletableFuture

interface StepServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves a run step. */
    fun retrieve(params: BetaThreadRunStepRetrieveParams): CompletableFuture<RunStep> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaThreadRunStepRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunStep>

    /** Returns a list of run steps belonging to a run. */
    fun list(
        params: BetaThreadRunStepListParams
    ): CompletableFuture<BetaThreadRunStepListPageAsync> = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: BetaThreadRunStepListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaThreadRunStepListPageAsync>

    /** A view of [StepServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}/steps/{step_id}`,
         * but is otherwise the same as [StepServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(
            params: BetaThreadRunStepRetrieveParams
        ): CompletableFuture<HttpResponseFor<RunStep>> = retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaThreadRunStepRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunStep>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}/steps`, but is
         * otherwise the same as [StepServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            params: BetaThreadRunStepListParams
        ): CompletableFuture<HttpResponseFor<BetaThreadRunStepListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaThreadRunStepListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaThreadRunStepListPageAsync>>
    }
}
