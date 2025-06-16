// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.graders.GraderModelService
import java.util.function.Consumer

interface GraderService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GraderService

    fun graderModels(): GraderModelService

    /** A view of [GraderService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): GraderService.WithRawResponse

        fun graderModels(): GraderModelService.WithRawResponse
    }
}
