// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.beta.assistants.AssistantStreamEvent
import com.openai.models.beta.threads.runs.Run
import com.openai.models.beta.threads.runs.RunCancelParams
import com.openai.models.beta.threads.runs.RunCreateParams
import com.openai.models.beta.threads.runs.RunListPage
import com.openai.models.beta.threads.runs.RunListParams
import com.openai.models.beta.threads.runs.RunRetrieveParams
import com.openai.models.beta.threads.runs.RunSubmitToolOutputsParams
import com.openai.models.beta.threads.runs.RunUpdateParams
import com.openai.services.blocking.beta.threads.runs.StepService

interface RunService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun steps(): StepService

    /** Create a run. */
    fun create(params: RunCreateParams): Run = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(params: RunCreateParams, requestOptions: RequestOptions = RequestOptions.none()): Run

    /** Create a run. */
    @MustBeClosed
    fun createStreaming(params: RunCreateParams): StreamResponse<AssistantStreamEvent> =
        createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    @MustBeClosed
    fun createStreaming(
        params: RunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<AssistantStreamEvent>

    /** Retrieves a run. */
    fun retrieve(params: RunRetrieveParams): Run = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: RunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /** Modifies a run. */
    fun update(params: RunUpdateParams): Run = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(params: RunUpdateParams, requestOptions: RequestOptions = RequestOptions.none()): Run

    /** Returns a list of runs belonging to a thread. */
    fun list(params: RunListParams): RunListPage = list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: RunListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunListPage

    /** Cancels a run that is `in_progress`. */
    fun cancel(params: RunCancelParams): Run = cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(params: RunCancelParams, requestOptions: RequestOptions = RequestOptions.none()): Run

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    fun submitToolOutputs(params: RunSubmitToolOutputsParams): Run =
        submitToolOutputs(params, RequestOptions.none())

    /** @see [submitToolOutputs] */
    fun submitToolOutputs(
        params: RunSubmitToolOutputsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    @MustBeClosed
    fun submitToolOutputsStreaming(
        params: RunSubmitToolOutputsParams
    ): StreamResponse<AssistantStreamEvent> =
        submitToolOutputsStreaming(params, RequestOptions.none())

    /** @see [submitToolOutputsStreaming] */
    @MustBeClosed
    fun submitToolOutputsStreaming(
        params: RunSubmitToolOutputsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<AssistantStreamEvent>

    /** A view of [RunService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun steps(): StepService.WithRawResponse

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunService.create].
         */
        @MustBeClosed
        fun create(params: RunCreateParams): HttpResponseFor<Run> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunService.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: RunCreateParams
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>> =
            createStreaming(params, RequestOptions.none())

        /** @see [createStreaming] */
        @MustBeClosed
        fun createStreaming(
            params: RunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}`, but is
         * otherwise the same as [RunService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: RunRetrieveParams): HttpResponseFor<Run> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: RunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs/{run_id}`, but is
         * otherwise the same as [RunService.update].
         */
        @MustBeClosed
        fun update(params: RunUpdateParams): HttpResponseFor<Run> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: RunUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunService.list].
         */
        @MustBeClosed
        fun list(params: RunListParams): HttpResponseFor<RunListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: RunListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<RunListPage>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs/{run_id}/cancel`, but is
         * otherwise the same as [RunService.cancel].
         */
        @MustBeClosed
        fun cancel(params: RunCancelParams): HttpResponseFor<Run> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: RunCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `post
         * /threads/{thread_id}/runs/{run_id}/submit_tool_outputs`, but is otherwise the same as
         * [RunService.submitToolOutputs].
         */
        @MustBeClosed
        fun submitToolOutputs(params: RunSubmitToolOutputsParams): HttpResponseFor<Run> =
            submitToolOutputs(params, RequestOptions.none())

        /** @see [submitToolOutputs] */
        @MustBeClosed
        fun submitToolOutputs(
            params: RunSubmitToolOutputsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `post
         * /threads/{thread_id}/runs/{run_id}/submit_tool_outputs`, but is otherwise the same as
         * [RunService.submitToolOutputsStreaming].
         */
        @MustBeClosed
        fun submitToolOutputsStreaming(
            params: RunSubmitToolOutputsParams
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>> =
            submitToolOutputsStreaming(params, RequestOptions.none())

        /** @see [submitToolOutputsStreaming] */
        @MustBeClosed
        fun submitToolOutputsStreaming(
            params: RunSubmitToolOutputsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>>
    }
}
