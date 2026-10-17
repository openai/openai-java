// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

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

    fun methods(): MethodService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Manage fine-tuning jobs to tailor a model to your specific training data. */
    fun jobs(): JobService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun checkpoints(): CheckpointService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    fun alpha(): AlphaService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

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

        fun methods(): MethodService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Manage fine-tuning jobs to tailor a model to your specific training data. */
        fun jobs(): JobService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun checkpoints(): CheckpointService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        fun alpha(): AlphaService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )
    }
}
