// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.finetuning

import com.openai.core.ClientOptions
import com.openai.services.async.finetuning.checkpoints.PermissionServiceAsync
import java.util.function.Consumer

interface CheckpointServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): CheckpointServiceAsync

    /** Manage fine-tuning jobs to tailor a model to your specific training data. */
    fun permissions(): PermissionServiceAsync

    /**
     * A view of [CheckpointServiceAsync] that provides access to raw HTTP responses for each
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
        ): CheckpointServiceAsync.WithRawResponse

        /** Manage fine-tuning jobs to tailor a model to your specific training data. */
        fun permissions(): PermissionServiceAsync.WithRawResponse
    }
}
