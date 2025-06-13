// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.finetuning.AlphaService
import com.openai.services.blocking.finetuning.CheckpointService
import com.openai.services.blocking.finetuning.JobService
import com.openai.services.blocking.finetuning.MethodService
import java.util.function.Consumer

interface FineTuningService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FineTuningService

    fun methods(): MethodService

    fun jobs(): JobService

    fun checkpoints(): CheckpointService

    fun alpha(): AlphaService

    /** A view of [FineTuningService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FineTuningService.WithRawResponse

        fun methods(): MethodService.WithRawResponse

        fun jobs(): JobService.WithRawResponse

        fun checkpoints(): CheckpointService.WithRawResponse

        fun alpha(): AlphaService.WithRawResponse
    }
}
