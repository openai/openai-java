// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.blocking.beta.threads.runs

import com.openai.core.RequestOptions
import com.openai.models.BetaThreadRunStepListPage
import com.openai.models.BetaThreadRunStepListParams
import com.openai.models.BetaThreadRunStepRetrieveParams
import com.openai.models.RunStep

interface StepService {

    /** Retrieves a run step. */
    @JvmOverloads
    fun retrieve(
        params: BetaThreadRunStepRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): RunStep

    /** Returns a list of run steps belonging to a run. */
    @JvmOverloads
    fun list(
        params: BetaThreadRunStepListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): BetaThreadRunStepListPage
}
