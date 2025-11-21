// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.finetuning.AlphaServiceAsync
import com.openai.services.async.finetuning.CheckpointServiceAsync
import com.openai.services.async.finetuning.JobServiceAsync
import com.openai.services.async.finetuning.MethodServiceAsync
import java.util.concurrent.CompletableFuture
import java.util.function.Consumer

interface FineTuningServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): FineTuningServiceAsync

    fun methods(): MethodServiceAsync

    fun jobs(): JobServiceAsync

    fun checkpoints(): CheckpointServiceAsync

    fun alpha(): AlphaServiceAsync

    /**
     * A view of [FineTuningServiceAsync] that provides access to raw HTTP responses for each
     * method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): FineTuningServiceAsync.WithRawResponse

        fun methods(): MethodServiceAsync.WithRawResponse

        fun jobs(): JobServiceAsync.WithRawResponse

        fun checkpoints(): CheckpointServiceAsync.WithRawResponse

        fun alpha(): AlphaServiceAsync.WithRawResponse
    }
}
