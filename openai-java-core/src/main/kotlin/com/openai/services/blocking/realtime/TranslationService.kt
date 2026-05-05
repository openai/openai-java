// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.realtime

import com.openai.core.ClientOptions
import com.openai.services.blocking.realtime.translations.CallService
import com.openai.services.blocking.realtime.translations.ClientSecretService
import java.util.function.Consumer

interface TranslationService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): TranslationService

    fun clientSecrets(): ClientSecretService

    fun calls(): CallService

    /**
     * A view of [TranslationService] that provides access to raw HTTP responses for each method.
     */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): TranslationService.WithRawResponse

        fun clientSecrets(): ClientSecretService.WithRawResponse

        fun calls(): CallService.WithRawResponse
    }
}
