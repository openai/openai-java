// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning

import com.openai.core.ClientOptions
import com.openai.services.blocking.finetuning.alpha.GraderService
import java.util.function.Consumer

interface AlphaService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlphaService

    /** Manage fine-tuning jobs to tailor a model to your specific training data. */
    fun graders(): GraderService

    /** A view of [AlphaService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AlphaService.WithRawResponse

        /** Manage fine-tuning jobs to tailor a model to your specific training data. */
        fun graders(): GraderService.WithRawResponse
    }
}
