// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.safety.AlertService
import com.openai.services.blocking.safety.CaseService
import java.util.function.Consumer

interface SafetyService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): SafetyService

    fun alerts(): AlertService

    fun cases(): CaseService

    /** A view of [SafetyService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): SafetyService.WithRawResponse

        fun alerts(): AlertService.WithRawResponse

        fun cases(): CaseService.WithRawResponse
    }
}
