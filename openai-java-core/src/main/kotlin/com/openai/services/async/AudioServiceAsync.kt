// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.services.async.audio.SpeechServiceAsync
import com.openai.services.async.audio.TranscriptionServiceAsync
import com.openai.services.async.audio.TranslationServiceAsync

interface AudioServiceAsync {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun transcriptions(): TranscriptionServiceAsync

    fun translations(): TranslationServiceAsync

    fun speech(): SpeechServiceAsync

    /** A view of [AudioServiceAsync] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun transcriptions(): TranscriptionServiceAsync.WithRawResponse

        fun translations(): TranslationServiceAsync.WithRawResponse

        fun speech(): SpeechServiceAsync.WithRawResponse
    }
}
