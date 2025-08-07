// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads.runs

import com.openai.core.ClientOptions
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.models.beta.threads.runs.steps.RunStep
import com.openai.models.beta.threads.runs.steps.StepListPageAsync
import com.openai.models.beta.threads.runs.steps.StepListParams
import com.openai.models.beta.threads.runs.steps.StepRetrieveParams
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

@Deprecated("The Assistants API is deprecated in favor of the Responses API")
interface StepServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): StepServiceAsync

    /** Retrieves a run step. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(stepId: String, params: StepRetrieveParams): CompletableFuture<RunStep> =
        retrieve(stepId, params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        stepId: String,
        params: StepRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunStep> =
        retrieve(params.toBuilder().stepId(stepId).build(), requestOptions)

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(params: StepRetrieveParams): CompletableFuture<RunStep> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        params: StepRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunStep>

    /** Returns a list of run steps belonging to a run. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(runId: String, params: StepListParams): CompletableFuture<StepListPageAsync> =
        list(runId, params, RequestOptions.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        runId: String,
        params: StepListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StepListPageAsync> =
        list(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(params: StepListParams): CompletableFuture<StepListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        params: StepListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<StepListPageAsync>

    /** A view of [StepServiceAsync] that provides access to raw HTTP responses for each method. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): StepServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}/steps/{step_id}`,
         * but is otherwise the same as [StepServiceAsync.retrieve].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            stepId: String,
            params: StepRetrieveParams,
        ): CompletableFuture<HttpResponseFor<RunStep>> =
            retrieve(stepId, params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            stepId: String,
            params: StepRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunStep>> =
            retrieve(params.toBuilder().stepId(stepId).build(), requestOptions)

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(params: StepRetrieveParams): CompletableFuture<HttpResponseFor<RunStep>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            params: StepRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunStep>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}/steps`, but is
         * otherwise the same as [StepServiceAsync.list].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(
            runId: String,
            params: StepListParams,
        ): CompletableFuture<HttpResponseFor<StepListPageAsync>> =
            list(runId, params, RequestOptions.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(
            runId: String,
            params: StepListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StepListPageAsync>> =
            list(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(params: StepListParams): CompletableFuture<HttpResponseFor<StepListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(
            params: StepListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StepListPageAsync>>
    }
}
