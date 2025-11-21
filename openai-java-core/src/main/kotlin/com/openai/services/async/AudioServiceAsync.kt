// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.audio.SpeechServiceAsync
import com.openai.services.async.audio.TranscriptionServiceAsync
import com.openai.services.async.audio.TranslationServiceAsync
import java.util.concurrent.CompletableFuture
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

    fun transcriptions(): TranscriptionServiceAsync

    fun translations(): TranslationServiceAsync

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

        fun transcriptions(): TranscriptionServiceAsync.WithRawResponse

        fun translations(): TranslationServiceAsync.WithRawResponse

        fun speech(): SpeechServiceAsync.WithRawResponse
    }
}
