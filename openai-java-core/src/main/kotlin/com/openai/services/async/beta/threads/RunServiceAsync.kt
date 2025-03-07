// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.AssistantStreamEvent
import com.openai.models.BetaThreadRunCancelParams
import com.openai.models.BetaThreadRunCreateParams
import com.openai.models.BetaThreadRunListPageAsync
import com.openai.models.BetaThreadRunListParams
import com.openai.models.BetaThreadRunRetrieveParams
import com.openai.models.BetaThreadRunSubmitToolOutputsParams
import com.openai.models.BetaThreadRunUpdateParams
import com.openai.models.Run
import com.openai.services.async.beta.threads.runs.StepServiceAsync
import java.util.concurrent.CompletableFuture

interface RunServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun steps(): StepServiceAsync

    /** Create a run. */
    fun create(params: BetaThreadRunCreateParams): CompletableFuture<Run> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BetaThreadRunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /** Create a run. */
    fun createStreaming(
        params: BetaThreadRunCreateParams
    ): AsyncStreamResponse<AssistantStreamEvent> = createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    fun createStreaming(
        params: BetaThreadRunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<AssistantStreamEvent>

    /** Retrieves a run. */
    fun retrieve(params: BetaThreadRunRetrieveParams): CompletableFuture<Run> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaThreadRunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /** Modifies a run. */
    fun update(params: BetaThreadRunUpdateParams): CompletableFuture<Run> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: BetaThreadRunUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /** Returns a list of runs belonging to a thread. */
    fun list(params: BetaThreadRunListParams): CompletableFuture<BetaThreadRunListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: BetaThreadRunListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaThreadRunListPageAsync>

    /** Cancels a run that is `in_progress`. */
    fun cancel(params: BetaThreadRunCancelParams): CompletableFuture<Run> =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: BetaThreadRunCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    fun submitToolOutputs(params: BetaThreadRunSubmitToolOutputsParams): CompletableFuture<Run> =
        submitToolOutputs(params, RequestOptions.none())

    /** @see [submitToolOutputs] */
    fun submitToolOutputs(
        params: BetaThreadRunSubmitToolOutputsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    fun submitToolOutputsStreaming(
        params: BetaThreadRunSubmitToolOutputsParams
    ): AsyncStreamResponse<AssistantStreamEvent> =
        submitToolOutputsStreaming(params, RequestOptions.none())

    /** @see [submitToolOutputsStreaming] */
    fun submitToolOutputsStreaming(
        params: BetaThreadRunSubmitToolOutputsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<AssistantStreamEvent>

    /** A view of [RunServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun steps(): StepServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunServiceAsync.create].
         */
        @MustBeClosed
        fun create(params: BetaThreadRunCreateParams): CompletableFuture<HttpResponseFor<Run>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaThreadRunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunServiceAsync.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: BetaThreadRunCreateParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            createStreaming(params, RequestOptions.none())

        /** @see [createStreaming] */
        @MustBeClosed
        fun createStreaming(
            params: BetaThreadRunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}`, but is
         * otherwise the same as [RunServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: BetaThreadRunRetrieveParams): CompletableFuture<HttpResponseFor<Run>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaThreadRunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs/{run_id}`, but is
         * otherwise the same as [RunServiceAsync.update].
         */
        @MustBeClosed
        fun update(params: BetaThreadRunUpdateParams): CompletableFuture<HttpResponseFor<Run>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: BetaThreadRunUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunServiceAsync.list].
         */
        @MustBeClosed
        fun list(
            params: BetaThreadRunListParams
        ): CompletableFuture<HttpResponseFor<BetaThreadRunListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaThreadRunListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<BetaThreadRunListPageAsync>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs/{run_id}/cancel`, but is
         * otherwise the same as [RunServiceAsync.cancel].
         */
        @MustBeClosed
        fun cancel(params: BetaThreadRunCancelParams): CompletableFuture<HttpResponseFor<Run>> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: BetaThreadRunCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post
         * /threads/{thread_id}/runs/{run_id}/submit_tool_outputs`, but is otherwise the same as
         * [RunServiceAsync.submitToolOutputs].
         */
        @MustBeClosed
        fun submitToolOutputs(
            params: BetaThreadRunSubmitToolOutputsParams
        ): CompletableFuture<HttpResponseFor<Run>> =
            submitToolOutputs(params, RequestOptions.none())

        /** @see [submitToolOutputs] */
        @MustBeClosed
        fun submitToolOutputs(
            params: BetaThreadRunSubmitToolOutputsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post
         * /threads/{thread_id}/runs/{run_id}/submit_tool_outputs`, but is otherwise the same as
         * [RunServiceAsync.submitToolOutputsStreaming].
         */
        @MustBeClosed
        fun submitToolOutputsStreaming(
            params: BetaThreadRunSubmitToolOutputsParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            submitToolOutputsStreaming(params, RequestOptions.none())

        /** @see [submitToolOutputsStreaming] */
        @MustBeClosed
        fun submitToolOutputsStreaming(
            params: BetaThreadRunSubmitToolOutputsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>>
    }
}
