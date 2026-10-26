// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.audio.SpeechService
import com.openai.services.blocking.audio.TranscriptionService
import com.openai.services.blocking.audio.TranslationService
import com.openai.services.blocking.audio.VoiceConsentService
import com.openai.services.blocking.audio.VoiceService
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

    /** Turn audio into text or text into audio. */
    fun transcriptions(): TranscriptionService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Turn audio into text or text into audio. */
    fun translations(): TranslationService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Turn audio into text or text into audio. */
    fun speech(): SpeechService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Turn audio into text or text into audio. */
    fun voices(): VoiceService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Turn audio into text or text into audio. */
    fun voiceConsents(): VoiceConsentService =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** A view of [AudioService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(modifier: Consumer<ClientOptions.Builder>): AudioService.WithRawResponse

        /** Turn audio into text or text into audio. */
        fun transcriptions(): TranscriptionService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Turn audio into text or text into audio. */
        fun translations(): TranslationService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Turn audio into text or text into audio. */
        fun speech(): SpeechService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Turn audio into text or text into audio. */
        fun voices(): VoiceService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Turn audio into text or text into audio. */
        fun voiceConsents(): VoiceConsentService.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )
    }
}
