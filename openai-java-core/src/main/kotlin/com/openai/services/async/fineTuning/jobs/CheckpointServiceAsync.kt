// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async.fineTuning.jobs

import com.openai.core.RequestOptions
import com.openai.models.FineTuningJobCheckpointListPageAsync
import com.openai.models.FineTuningJobCheckpointListParams
import java.util.concurrent.CompletableFuture

interface CheckpointServiceAsync {

    /** List checkpoints for a fine-tuning job. */
    @JvmOverloads
    fun list(
        params: FineTuningJobCheckpointListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJobCheckpointListPageAsync>
}
