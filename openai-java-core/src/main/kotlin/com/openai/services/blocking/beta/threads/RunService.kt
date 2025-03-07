// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.beta.threads

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
import com.openai.core.http.HttpResponseFor
import com.openai.core.http.StreamResponse
import com.openai.models.AssistantStreamEvent
import com.openai.models.BetaThreadRunCancelParams
import com.openai.models.BetaThreadRunCreateParams
import com.openai.models.BetaThreadRunListPage
import com.openai.models.BetaThreadRunListParams
import com.openai.models.BetaThreadRunRetrieveParams
import com.openai.models.BetaThreadRunSubmitToolOutputsParams
import com.openai.models.BetaThreadRunUpdateParams
import com.openai.models.Run
import com.openai.services.blocking.beta.threads.runs.StepService

interface RunService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun steps(): StepService

    /** Create a run. */
    fun create(params: BetaThreadRunCreateParams): Run = create(params, RequestOptions.none())

    /** @see [create] */
    fun create(
        params: BetaThreadRunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /** Create a run. */
    @MustBeClosed
    fun createStreaming(params: BetaThreadRunCreateParams): StreamResponse<AssistantStreamEvent> =
        createStreaming(params, RequestOptions.none())

    /** @see [createStreaming] */
    @MustBeClosed
    fun createStreaming(
        params: BetaThreadRunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<AssistantStreamEvent>

    /** Retrieves a run. */
    fun retrieve(params: BetaThreadRunRetrieveParams): Run = retrieve(params, RequestOptions.none())

    /** @see [retrieve] */
    fun retrieve(
        params: BetaThreadRunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /** Modifies a run. */
    fun update(params: BetaThreadRunUpdateParams): Run = update(params, RequestOptions.none())

    /** @see [update] */
    fun update(
        params: BetaThreadRunUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /** Returns a list of runs belonging to a thread. */
    fun list(params: BetaThreadRunListParams): BetaThreadRunListPage =
        list(params, RequestOptions.none())

    /** @see [list] */
    fun list(
        params: BetaThreadRunListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaThreadRunListPage

    /** Cancels a run that is `in_progress`. */
    fun cancel(params: BetaThreadRunCancelParams): Run = cancel(params, RequestOptions.none())

    /** @see [cancel] */
    fun cancel(
        params: BetaThreadRunCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    fun submitToolOutputs(params: BetaThreadRunSubmitToolOutputsParams): Run =
        submitToolOutputs(params, RequestOptions.none())

    /** @see [submitToolOutputs] */
    fun submitToolOutputs(
        params: BetaThreadRunSubmitToolOutputsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    @MustBeClosed
    fun submitToolOutputsStreaming(
        params: BetaThreadRunSubmitToolOutputsParams
    ): StreamResponse<AssistantStreamEvent> =
        submitToolOutputsStreaming(params, RequestOptions.none())

    /** @see [submitToolOutputsStreaming] */
    @MustBeClosed
    fun submitToolOutputsStreaming(
        params: BetaThreadRunSubmitToolOutputsParams,
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
        fun create(params: BetaThreadRunCreateParams): HttpResponseFor<Run> =
            create(params, RequestOptions.none())

        /** @see [create] */
        @MustBeClosed
        fun create(
            params: BetaThreadRunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunService.createStreaming].
         */
        @MustBeClosed
        fun createStreaming(
            params: BetaThreadRunCreateParams
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>> =
            createStreaming(params, RequestOptions.none())

        /** @see [createStreaming] */
        @MustBeClosed
        fun createStreaming(
            params: BetaThreadRunCreateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs/{run_id}`, but is
         * otherwise the same as [RunService.retrieve].
         */
        @MustBeClosed
        fun retrieve(params: BetaThreadRunRetrieveParams): HttpResponseFor<Run> =
            retrieve(params, RequestOptions.none())

        /** @see [retrieve] */
        @MustBeClosed
        fun retrieve(
            params: BetaThreadRunRetrieveParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs/{run_id}`, but is
         * otherwise the same as [RunService.update].
         */
        @MustBeClosed
        fun update(params: BetaThreadRunUpdateParams): HttpResponseFor<Run> =
            update(params, RequestOptions.none())

        /** @see [update] */
        @MustBeClosed
        fun update(
            params: BetaThreadRunUpdateParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `get /threads/{thread_id}/runs`, but is otherwise the
         * same as [RunService.list].
         */
        @MustBeClosed
        fun list(params: BetaThreadRunListParams): HttpResponseFor<BetaThreadRunListPage> =
            list(params, RequestOptions.none())

        /** @see [list] */
        @MustBeClosed
        fun list(
            params: BetaThreadRunListParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<BetaThreadRunListPage>

        /**
         * Returns a raw HTTP response for `post /threads/{thread_id}/runs/{run_id}/cancel`, but is
         * otherwise the same as [RunService.cancel].
         */
        @MustBeClosed
        fun cancel(params: BetaThreadRunCancelParams): HttpResponseFor<Run> =
            cancel(params, RequestOptions.none())

        /** @see [cancel] */
        @MustBeClosed
        fun cancel(
            params: BetaThreadRunCancelParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `post
         * /threads/{thread_id}/runs/{run_id}/submit_tool_outputs`, but is otherwise the same as
         * [RunService.submitToolOutputs].
         */
        @MustBeClosed
        fun submitToolOutputs(params: BetaThreadRunSubmitToolOutputsParams): HttpResponseFor<Run> =
            submitToolOutputs(params, RequestOptions.none())

        /** @see [submitToolOutputs] */
        @MustBeClosed
        fun submitToolOutputs(
            params: BetaThreadRunSubmitToolOutputsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<Run>

        /**
         * Returns a raw HTTP response for `post
         * /threads/{thread_id}/runs/{run_id}/submit_tool_outputs`, but is otherwise the same as
         * [RunService.submitToolOutputsStreaming].
         */
        @MustBeClosed
        fun submitToolOutputsStreaming(
            params: BetaThreadRunSubmitToolOutputsParams
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>> =
            submitToolOutputsStreaming(params, RequestOptions.none())

        /** @see [submitToolOutputsStreaming] */
        @MustBeClosed
        fun submitToolOutputsStreaming(
            params: BetaThreadRunSubmitToolOutputsParams,
            requestOptions: RequestOptions = RequestOptions.none(),
        ): HttpResponseFor<StreamResponse<AssistantStreamEvent>>
    }
}
