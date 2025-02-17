// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking.beta.threads

import com.google.errorprone.annotations.MustBeClosed
import com.openai.core.RequestOptions
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

    fun steps(): StepService

    /** Create a run. */
    @JvmOverloads
    fun create(
        params: BetaThreadRunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /** Create a run. */
    @JvmOverloads
    @MustBeClosed
    fun createStreaming(
        params: BetaThreadRunCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<AssistantStreamEvent>

    /** Retrieves a run. */
    @JvmOverloads
    fun retrieve(
        params: BetaThreadRunRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /** Modifies a run. */
    @JvmOverloads
    fun update(
        params: BetaThreadRunUpdateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /** Returns a list of runs belonging to a thread. */
    @JvmOverloads
    fun list(
        params: BetaThreadRunListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaThreadRunListPage

    /** Cancels a run that is `in_progress`. */
    @JvmOverloads
    fun cancel(
        params: BetaThreadRunCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    @JvmOverloads
    fun submitToolOutputs(
        params: BetaThreadRunSubmitToolOutputsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): Run

    /**
     * When a run has the `status: "requires_action"` and `required_action.type` is
     * `submit_tool_outputs`, this endpoint can be used to submit the outputs from the tool calls
     * once they're all completed. All outputs must be submitted in a single request.
     */
    @JvmOverloads
    @MustBeClosed
    fun submitToolOutputsStreaming(
        params: BetaThreadRunSubmitToolOutputsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): StreamResponse<AssistantStreamEvent>
}
