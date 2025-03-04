// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking.beta.threads.runs

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.BetaThreadRunStepListPage
import com.openai.models.BetaThreadRunStepListParams
import com.openai.models.BetaThreadRunStepRetrieveParams
import com.openai.models.RunStep

interface StepService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves a run step. */
    @JvmOverloads
    fun retrieve(
        params: BetaThreadRunStepRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunStep

    /** Returns a list of run steps belonging to a run. */
    @JvmOverloads
    fun list(
        params: BetaThreadRunStepListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaThreadRunStepListPage

    /** A view of [StepService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}/steps/{step_id}`,
         * but is otherwise the same as [StepService.retrieve].
         */
        @JvmOverloads
        @MustBeClosed
        fun retrieve(
            params: BetaThreadRunStepRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunStep>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}/steps`, but is
         * otherwise the same as [StepService.list].
         */
        @JvmOverloads
        @MustBeClosed
        fun list(
            params: BetaThreadRunStepListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaThreadRunStepListPage>
    }
}
