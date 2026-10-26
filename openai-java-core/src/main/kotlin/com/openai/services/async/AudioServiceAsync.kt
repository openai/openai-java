// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.audio.SpeechServiceAsync
import com.openai.services.async.audio.TranscriptionServiceAsync
import com.openai.services.async.audio.TranslationServiceAsync
import com.openai.services.async.audio.VoiceConsentServiceAsync
import com.openai.services.async.audio.VoiceServiceAsync
import java.util.function.Consumer

interface AudioServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    /**
     * Returns a view of this service with the given option modifications applied.
     *
     * The original service is not modified.
     */
    fun withOptions(modifier: Consumer<ClientOptions.Builder>): AudioServiceAsync

    /** Turn audio into text or text into audio. */
    fun transcriptions(): TranscriptionServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Turn audio into text or text into audio. */
    fun translations(): TranslationServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Turn audio into text or text into audio. */
    fun speech(): SpeechServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Turn audio into text or text into audio. */
    fun voices(): VoiceServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** Turn audio into text or text into audio. */
    fun voiceConsents(): VoiceConsentServiceAsync =
        throw UnsupportedOperationException("Subservice is not supported by this implementation")

    /** A view of [AudioServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        /**
         * Returns a view of this service with the given option modifications applied.
         *
         * The original service is not modified.
         */
        fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AudioServiceAsync.WithRawResponse

        /** Turn audio into text or text into audio. */
        fun transcriptions(): TranscriptionServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Turn audio into text or text into audio. */
        fun translations(): TranslationServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Turn audio into text or text into audio. */
        fun speech(): SpeechServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Turn audio into text or text into audio. */
        fun voices(): VoiceServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )

        /** Turn audio into text or text into audio. */
        fun voiceConsents(): VoiceConsentServiceAsync.WithRawResponse =
            throw UnsupportedOperationException(
                "Subservice is not supported by this implementation"
            )
    }
}
