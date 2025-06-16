// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.graders

import com.openai.core.ClientOptions
import java.util.function.Consumer

interface GraderModelService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): GraderModelService

    /**
     * A view of [GraderModelService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): GraderModelService.WithRawResponse
    }
}
