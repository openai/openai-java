// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.finetuning

import com.openai.core.ClientOptions
import java.util.function.Consumer

interface MethodService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): MethodService

    /** A view of [MethodService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): MethodService.WithRawResponse
    }
}
