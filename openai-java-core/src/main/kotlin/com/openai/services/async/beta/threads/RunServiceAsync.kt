// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.beta.threads

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.ClientOptions
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
import java.util.function.Consumer

@Deprecated("The Assistants API is deprecated in favor of the Responses API")
interface RunServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): RunServiceAsync

    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun steps(): StepServiceAsync

    /** Create a run. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(threadId: String, params: RunCreateParams): CompletableFuture<Run> =
        create(threadId, params, RequestOptions.none())

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(
        threadId: String,
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run> =
        create(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(params: RunCreateParams): CompletableFuture<Run> =
        create(params, RequestOptions.none())

    /** @see create */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun create(
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /** Create a run. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun createStreaming(
        threadId: String,
        params: RunCreateParams,
    ): AsyncStreamResponse<AssistantStreamEvent> =
        createStreaming(threadId, params, RequestOptions.none())

    /** @see createStreaming */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun createStreaming(
        threadId: String,
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<AssistantStreamEvent> =
        createStreaming(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see createStreaming */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun createStreaming(params: RunCreateParams): AsyncStreamResponse<AssistantStreamEvent> =
        createStreaming(params, RequestOptions.none())

    /** @see createStreaming */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun createStreaming(
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<AssistantStreamEvent>

    /** Retrieves a run. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(runId: String, params: RunRetrieveParams): CompletableFuture<Run> =
        retrieve(runId, params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        runId: String,
        params: RunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run> = retrieve(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(params: RunRetrieveParams): CompletableFuture<Run> =
        retrieve(params, RequestOptions.none())

    /** @see retrieve */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun retrieve(
        params: RunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /** Modifies a run. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(runId: String, params: RunUpdateParams): CompletableFuture<Run> =
        update(runId, params, RequestOptions.none())

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(
        runId: String,
        params: RunUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run> = update(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(params: RunUpdateParams): CompletableFuture<Run> =
        update(params, RequestOptions.none())

    /** @see update */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun update(
        params: RunUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /** Returns a list of runs belonging to a thread. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(threadId: String): CompletableFuture<RunListPageAsync> =
        list(threadId, RunListParams.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        threadId: String,
        params: RunListParams = RunListParams.none(),
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunListPageAsync> =
        list(params.toBuilder().threadId(threadId).build(), requestOptions)

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        threadId: String,
        params: RunListParams = RunListParams.none(),
    ): CompletableFuture<RunListPageAsync> = list(threadId, params, RequestOptions.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        params: RunListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunListPageAsync>

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(params: RunListParams): CompletableFuture<RunListPageAsync> =
        list(params, RequestOptions.none())

    /** @see list */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun list(
        threadId: String,
        requestOptions: RequestOptions,
    ): CompletableFuture<RunListPageAsync> = list(threadId, RunListParams.none(), requestOptions)

    /** Cancels a run that is `in_progress`. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun cancel(runId: String, params: RunCancelParams): CompletableFuture<Run> =
        cancel(runId, params, RequestOptions.none())

    /** @see cancel */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun cancel(
        runId: String,
        params: RunCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run> = cancel(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see cancel */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun cancel(params: RunCancelParams): CompletableFuture<Run> =
        cancel(params, RequestOptions.none())

    /** @see cancel */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun cancel(
        params: RunCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun submitToolOutputs(
        runId: String,
        params: RunSubmitToolOutputsParams,
    ): CompletableFuture<Run> = submitToolOutputs(runId, params, RequestOptions.none())

    /** @see submitToolOutputs */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun submitToolOutputs(
        runId: String,
        params: RunSubmitToolOutputsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run> =
        submitToolOutputs(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see submitToolOutputs */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun submitToolOutputs(params: RunSubmitToolOutputsParams): CompletableFuture<Run> =
        submitToolOutputs(params, RequestOptions.none())

    /** @see submitToolOutputs */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun submitToolOutputs(
        params: RunSubmitToolOutputsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<Run>

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun submitToolOutputsStreaming(
        runId: String,
        params: RunSubmitToolOutputsParams,
    ): AsyncStreamResponse<AssistantStreamEvent> =
        submitToolOutputsStreaming(runId, params, RequestOptions.none())

    /** @see submitToolOutputsStreaming */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun submitToolOutputsStreaming(
        runId: String,
        params: RunSubmitToolOutputsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<AssistantStreamEvent> =
        submitToolOutputsStreaming(params.toBuilder().runId(runId).build(), requestOptions)

    /** @see submitToolOutputsStreaming */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun submitToolOutputsStreaming(
        params: RunSubmitToolOutputsParams
    ): AsyncStreamResponse<AssistantStreamEvent> =
        submitToolOutputsStreaming(params, RequestOptions.none())

    /** @see submitToolOutputsStreaming */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    fun submitToolOutputsStreaming(
        params: RunSubmitToolOutputsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): AsyncStreamResponse<AssistantStreamEvent>

    /** A view of [RunServiceAsync] that provides access to raw HTTP responses for each method. */
    @Deprecated("The Assistants API is deprecated in favor of the Responses API")
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): RunServiceAsync.WithRawResponse

        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun steps(): StepServiceAsync.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunServiceAsync.create].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun create(
            threadId: String,
            params: RunCreateParams,
        ): CompletableFuture<HttpResponseFor<Run>> = create(threadId, params, RequestOptions.none())

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun create(
            threadId: String,
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>> =
            create(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun create(params: RunCreateParams): CompletableFuture<HttpResponseFor<Run>> =
            create(params, RequestOptions.none())

        /** @see create */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunServiceAsync.createStreaming].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun createStreaming(
            threadId: String,
            params: RunCreateParams,
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            createStreaming(threadId, params, RequestOptions.none())

        /** @see createStreaming */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun createStreaming(
            threadId: String,
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            createStreaming(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see createStreaming */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun createStreaming(
            params: RunCreateParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            createStreaming(params, RequestOptions.none())

        /** @see createStreaming */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun createStreaming(
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}`, but is
         * otherwise the same as [RunServiceAsync.retrieve].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            runId: String,
            params: RunRetrieveParams,
        ): CompletableFuture<HttpResponseFor<Run>> = retrieve(runId, params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            runId: String,
            params: RunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>> =
            retrieve(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(params: RunRetrieveParams): CompletableFuture<HttpResponseFor<Run>> =
            retrieve(params, RequestOptions.none())

        /** @see retrieve */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun retrieve(
            params: RunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs/{run_id}`, but is
         * otherwise the same as [RunServiceAsync.update].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(
            runId: String,
            params: RunUpdateParams,
        ): CompletableFuture<HttpResponseFor<Run>> = update(runId, params, RequestOptions.none())

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(
            runId: String,
            params: RunUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>> =
            update(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(params: RunUpdateParams): CompletableFuture<HttpResponseFor<Run>> =
            update(params, RequestOptions.none())

        /** @see update */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun update(
            params: RunUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunServiceAsync.list].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(threadId: String): CompletableFuture<HttpResponseFor<RunListPageAsync>> =
            list(threadId, RunListParams.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(
            threadId: String,
            params: RunListParams = RunListParams.none(),
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunListPageAsync>> =
            list(params.toBuilder().threadId(threadId).build(), requestOptions)

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(
            threadId: String,
            params: RunListParams = RunListParams.none(),
        ): CompletableFuture<HttpResponseFor<RunListPageAsync>> =
            list(threadId, params, RequestOptions.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(
            params: RunListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<RunListPageAsync>>

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(params: RunListParams): CompletableFuture<HttpResponseFor<RunListPageAsync>> =
            list(params, RequestOptions.none())

        /** @see list */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun list(
            threadId: String,
            requestOptions: RequestOptions,
        ): CompletableFuture<HttpResponseFor<RunListPageAsync>> =
            list(threadId, RunListParams.none(), requestOptions)

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs/{run_id}/cancel`, but is
         * otherwise the same as [RunServiceAsync.cancel].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun cancel(
            runId: String,
            params: RunCancelParams,
        ): CompletableFuture<HttpResponseFor<Run>> = cancel(runId, params, RequestOptions.none())

        /** @see cancel */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun cancel(
            runId: String,
            params: RunCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>> =
            cancel(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see cancel */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun cancel(params: RunCancelParams): CompletableFuture<HttpResponseFor<Run>> =
            cancel(params, RequestOptions.none())

        /** @see cancel */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun cancel(
            params: RunCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post
         * /threads/{thread_id}/runs/{run_id}/submit_tool_outputs`, but is otherwise the same as
         * [RunServiceAsync.submitToolOutputs].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun submitToolOutputs(
            runId: String,
            params: RunSubmitToolOutputsParams,
        ): CompletableFuture<HttpResponseFor<Run>> =
            submitToolOutputs(runId, params, RequestOptions.none())

        /** @see submitToolOutputs */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun submitToolOutputs(
            runId: String,
            params: RunSubmitToolOutputsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>> =
            submitToolOutputs(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see submitToolOutputs */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun submitToolOutputs(
            params: RunSubmitToolOutputsParams
        ): CompletableFuture<HttpResponseFor<Run>> =
            submitToolOutputs(params, RequestOptions.none())

        /** @see submitToolOutputs */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        fun submitToolOutputs(
            params: RunSubmitToolOutputsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<Run>>

        /**
         * Returns a raw HTTP response for `post
         * /threads/{thread_id}/runs/{run_id}/submit_tool_outputs`, but is otherwise the same as
         * [RunServiceAsync.submitToolOutputsStreaming].
         */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun submitToolOutputsStreaming(
            runId: String,
            params: RunSubmitToolOutputsParams,
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            submitToolOutputsStreaming(runId, params, RequestOptions.none())

        /** @see submitToolOutputsStreaming */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun submitToolOutputsStreaming(
            runId: String,
            params: RunSubmitToolOutputsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            submitToolOutputsStreaming(params.toBuilder().runId(runId).build(), requestOptions)

        /** @see submitToolOutputsStreaming */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun submitToolOutputsStreaming(
            params: RunSubmitToolOutputsParams
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>> =
            submitToolOutputsStreaming(params, RequestOptions.none())

        /** @see submitToolOutputsStreaming */
        @Deprecated("The Assistants API is deprecated in favor of the Responses API")
        @MustBeClosed
        fun submitToolOutputsStreaming(
            params: RunSubmitToolOutputsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): CompletableFuture<HttpResponseFor<StreamResponse<AssistantStreamEvent>>>
    }
}
