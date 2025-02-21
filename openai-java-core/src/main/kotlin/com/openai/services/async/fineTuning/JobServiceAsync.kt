// File generated from our OpenAPI spec by Stainless.

@file:Suppress("OVERLOADS_INTERFACE") // See https://youtrack.jetbrains.com/issue/KT-36102

package com.openai.services.async.fineTuning

import com.openai.core.RequestOptions
import com.openai.models.FineTuningJob
import com.openai.models.FineTuningJobCancelParams
import com.openai.models.FineTuningJobCreateParams
import com.openai.models.FineTuningJobListEventsPageAsync
import com.openai.models.FineTuningJobListEventsParams
import com.openai.models.FineTuningJobListPageAsync
import com.openai.models.FineTuningJobListParams
import com.openai.models.FineTuningJobRetrieveParams
import com.openai.services.async.fineTuning.jobs.CheckpointServiceAsync
import java.util.concurrent.CompletableFuture

interface JobServiceAsync {

    fun checkpoints(): CheckpointServiceAsync

    /**
     * Creates a fine-tuning job which begins the process of creating a new model from a given
     * dataset.
     *
     * Response includes details of the enqueued job including job status and the name of the
     * fine-tuned models once complete.
     *
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
     */
    @JvmOverloads
    fun create(
        params: FineTuningJobCreateParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /**
     * Get info about a fine-tuning job.
     *
     * [Learn more about fine-tuning](https://platform.openai.com/docs/guides/fine-tuning)
     */
    @JvmOverloads
    fun retrieve(
        params: FineTuningJobRetrieveParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /** List your organization's fine-tuning jobs */
    @JvmOverloads
    fun list(
        params: FineTuningJobListParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJobListPageAsync>

    /** Immediately cancel a fine-tune job. */
    @JvmOverloads
    fun cancel(
        params: FineTuningJobCancelParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJob>

    /** Get status updates for a fine-tuning job. */
    @JvmOverloads
    fun listEvents(
        params: FineTuningJobListEventsParams,
        requestOptions: RequestOptions = RequestOptions.none(),
    ): CompletableFuture<FineTuningJobListEventsPageAsync>
}
