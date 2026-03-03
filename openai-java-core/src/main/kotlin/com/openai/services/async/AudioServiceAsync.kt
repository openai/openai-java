// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.audio.SpeechServiceAsync
import com.openai.services.async.audio.TranscriptionServiceAsync
import com.openai.services.async.audio.TranslationServiceAsync
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
    fun transcriptions(): TranscriptionServiceAsync

    /** Turn audio into text or text into audio. */
    fun translations(): TranslationServiceAsync

    /** Turn audio into text or text into audio. */
    fun speech(): SpeechServiceAsync

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
        fun transcriptions(): TranscriptionServiceAsync.WithRawResponse

        /** Turn audio into text or text into audio. */
        fun translations(): TranslationServiceAsync.WithRawResponse

        /** Turn audio into text or text into audio. */
        fun speech(): SpeechServiceAsync.WithRawResponse
    }
}
