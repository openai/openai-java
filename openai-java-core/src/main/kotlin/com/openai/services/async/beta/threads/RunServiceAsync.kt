// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.AsyncStreamResponse
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.beta.assistants.AssistantStreamEvent
import com.openai.models.beta.threads.runs.Run
import com.openai.models.beta.threads.runs.RunCancelParams
import com.openai.models.beta.threads.runs.RunCreateParams
import com.openai.models.beta.threads.runs.RunListPageAsync
import com.openai.models.beta.threads.runs.RunListParams
import com.openai.models.beta.threads.runs.RunRetrieveParams
import com.openai.models.beta.threads.runs.RunSubmitToolOutputsParams
import com.openai.models.beta.threads.runs.RunUpdateParams
import com.openai.services.async.beta.threads.runs.StepServiceAsync
import java.util.concurrent.CompletableFuture

interface RunServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun steps(): StepServiceAsync

    /** Create a run. */
    fun create(params: RunCreateParams): CompletableFuture<Run> =
        create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /** Create a run. */
    fun createStreaming(params: RunCreateParams): AsyncStreamResponse<AssistantStreamEvent> =
        createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    fun createStreaming(
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<AssistantStreamEvent>

    /** Retrieves a run. */
    fun retrieve(params: RunRetrieveParams): CompletableFuture<Run> =
        retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: RunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /** Modifies a run. */
    fun update(params: RunUpdateParams): CompletableFuture<Run> =
        update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: RunUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /** Returns a list of runs belonging to a thread. */
    fun list(params: RunListParams): CompletableFuture<RunListPageAsync> =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: RunListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunListPageAsync>

    /** Cancels a run that is `in_progress`. */
    fun cancel(params: RunCancelParams): CompletableFuture<Run> =
        cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: RunCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    fun submitToolOutputs(params: RunSubmitToolOutputsParams): CompletableFuture<Run> =
        submitToolOutputs(params, RequestOptions.none())

    /** @see [submitToolOutputs] */
    fun submitToolOutputs(
        params: RunSubmitToolOutputsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    fun submitToolOutputsStreaming(
        params: RunSubmitToolOutputsParams
    ): AsyncStreamResponse<AssistantStreamEvent> =
        submitToolOutputsStreaming(params, RequestOptions.none())

    /** @see [submitToolOutputsStreaming] */
    fun submitToolOutputsStreaming(
        params: RunSubmitToolOutputsParams,
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
        fun create(params: RunCreateParams): CompletableFuture<HttpResponseFor<Run>> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunServiceAsync.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: RunCreateParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            createStreaming(params, RequestOptions.none())

        /** @see [createStreaming] */
        @MustBeClosed
        fun createStreaming(
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}`, but is
         * otherwise the same as [RunServiceAsync.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: RunRetrieveParams): CompletableFuture<HttpResponseFor<Run>> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: RunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs/{run_id}`, but is
         * otherwise the same as [RunServiceAsync.update].
         */
        @MustBeClosed
        fun update(params: RunUpdateParams): CompletableFuture<HttpResponseFor<Run>> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: RunUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunServiceAsync.list].
         */
        @MustBeClosed
        fun list(params: RunListParams): CompletableFuture<HttpResponseFor<RunListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: RunListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunListPageAsync>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs/{run_id}/cancel`, but is
         * otherwise the same as [RunServiceAsync.cancel].
         */
        @MustBeClosed
        fun cancel(params: RunCancelParams): CompletableFuture<HttpResponseFor<Run>> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: RunCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post
         * /threads/{thread_id}/runs/{run_id}/submit_tool_outputs`, but is otherwise the same as
         * [RunServiceAsync.submitToolOutputs].
         */
        @MustBeClosed
        fun submitToolOutputs(
            params: RunSubmitToolOutputsParams
        ): CompletableFuture<HttpResponseFor<Run>> =
            submitToolOutputs(params, RequestOptions.none())

        /** @see [submitToolOutputs] */
        @MustBeClosed
        fun submitToolOutputs(
            params: RunSubmitToolOutputsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post
         * /threads/{thread_id}/runs/{run_id}/submit_tool_outputs`, but is otherwise the same as
         * [RunServiceAsync.submitToolOutputsStreaming].
         */
        @MustBeClosed
        fun submitToolOutputsStreaming(
            params: RunSubmitToolOutputsParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            submitToolOutputsStreaming(params, RequestOptions.none())

        /** @see [submitToolOutputsStreaming] */
        @MustBeClosed
        fun submitToolOutputsStreaming(
            params: RunSubmitToolOutputsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>>
    }
}
