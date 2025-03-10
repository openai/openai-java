// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads.runs

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.threads.runs.steps.RunStep
import com.openai.models.beta.threads.runs.steps.StepListPageAsync
import com.openai.models.beta.threads.runs.steps.StepListParams
import com.openai.models.beta.threads.runs.steps.StepRetrieveParams
import java.util.concurrent.CompletableFuture

interface StepServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves a run step. */
    fun retrieve(params: StepRetrieveParams): CompletableFuture<RunStep> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: StepRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunStep>

    /** Returns a list of run steps belonging to a run. */
    fun list(params: StepListParams): CompletableFuture<StepListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: StepListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StepListPageAsync>

    /** A view of [StepServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}/steps/{step_id}`,
         * but is otherwise the same as [StepServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: StepRetrieveParams): CompletableFuture<HttpResponseFor<RunStep>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: StepRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunStep>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}/steps`, but is
         * otherwise the same as [StepServiceAsync.list].
         */
        @MustBeClosed
        fun list(params: StepListParams): CompletableFuture<HttpResponseFor<StepListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: StepListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StepListPageAsync>>
    }
}
