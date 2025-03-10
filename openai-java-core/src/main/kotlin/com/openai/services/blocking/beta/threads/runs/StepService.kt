// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads.runs

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.threads.runs.steps.RunStep
import com.openai.models.beta.threads.runs.steps.StepListPage
import com.openai.models.beta.threads.runs.steps.StepListParams
import com.openai.models.beta.threads.runs.steps.StepRetrieveParams

interface StepService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /** Retrieves a run step. */
    fun retrieve(params: StepRetrieveParams): RunStep = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: StepRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunStep

    /** Returns a list of run steps belonging to a run. */
    fun list(params: StepListParams): StepListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: StepListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StepListPage

    /** A view of [StepService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}/steps/{step_id}`,
         * but is otherwise the same as [StepService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: StepRetrieveParams): HttpResponseFor<RunStep> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: StepRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunStep>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}/steps`, but is
         * otherwise the same as [StepService.list].
         */
        @MustBeClosed
        fun list(params: StepListParams): HttpResponseFor<StepListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: StepListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StepListPage>
    }
}
