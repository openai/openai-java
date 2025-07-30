// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads.runs

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.threads.runs.steps.RunStep
import com.openai.models.beta.threads.runs.steps.StepListPage
import com.openai.models.beta.threads.runs.steps.StepListParams
import com.openai.models.beta.threads.runs.steps.StepRetrieveParams
import java.util.function.Consumer

@Deprecated("The Assistants API is deprecated in favor of the Responses API")
interface StepService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StepService

    /** Retrieves a run step. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(stepId: String, params: StepRetrieveParams): RunStep =
        retrieve(stepId, params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        stepId: String,
        params: StepRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunStep = retrieve(params.toBuilder().stepId(stepId).build(), requestOptions)

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(params: StepRetrieveParams): RunStep = retrieve(params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        params: StepRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunStep

    /** Returns a list of run steps belonging to a run. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(runId: String, params: StepListParams): StepListPage =
        list(runId, params, RequestOptions.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        runId: String,
        params: StepListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StepListPage = list(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(params: StepListParams): StepListPage = list(params, RequestOptions.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        params: StepListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StepListPage

    /** A view of [StepService] that provides access to raw HTTP responses for each method. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): StepService.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}/steps/{step_id}`,
         * but is otherwise the same as [StepService.retrieve].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(stepId: String, params: StepRetrieveParams): HttpResponseFor<RunStep> =
            retrieve(stepId, params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(
            stepId: String,
            params: StepRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunStep> =
            retrieve(params.toBuilder().stepId(stepId).build(), requestOptions)

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(params: StepRetrieveParams): HttpResponseFor<RunStep> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun retrieve(
            params: StepRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunStep>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}/steps`, but is
         * otherwise the same as [StepService.list].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun list(runId: String, params: StepListParams): HttpResponseFor<StepListPage> =
            list(runId, params, RequestOptions.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun list(
            runId: String,
            params: StepListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StepListPage> =
            list(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun list(params: StepListParams): HttpResponseFor<StepListPage> =
            list(params, RequestOptions.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun list(
            params: StepListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StepListPage>
    }
}
