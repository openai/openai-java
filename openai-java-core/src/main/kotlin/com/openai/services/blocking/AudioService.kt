// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.audio.SpeechService
import com.openai.services.blocking.audio.TranscriptionService
import com.openai.services.blocking.audio.TranslationService
import java.util.function.Consumer

interface AudioService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AudioService

    fun transcriptions(): TranscriptionService

    fun translations(): TranslationService

    fun speech(): SpeechService

    /** A view of [AudioService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AudioService.WithRawResponse

        fun transcriptions(): TranscriptionService.WithRawResponse

        fun translations(): TranslationService.WithRawResponse

        fun speech(): SpeechService.WithRawResponse
    }
}
