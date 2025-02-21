// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async.beta.threads.runs

import com.openai.core.RequestOptions
import com.openai.models.BetaThreadRunStepListPageAsync
import com.openai.models.BetaThreadRunStepListParams
import com.openai.models.BetaThreadRunStepRetrieveParams
import com.openai.models.RunStep
import java.util.concurrent.CompletableFuture

interface StepServiceAsync {

    /** Retrieves a run step. */
    @JvmOverloads
    fun retrieve(
        params: BetaThreadRunStepRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<RunStep>

    /** Returns a list of run steps belonging to a run. */
    @JvmOverloads
    fun list(
        params: BetaThreadRunStepListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<BetaThreadRunStepListPageAsync>
}
