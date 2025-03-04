// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.services.blocking.audio.SpeechService
import com.openai.services.blocking.audio.TranscriptionService
import com.openai.services.blocking.audio.TranslationService

interface AudioService {

    /**
     * Returns a view of this service that provides access to raw HTTP responses for each method.
     */
    fun withRawResponse(): WithRawResponse

    fun transcriptions(): TranscriptionService

    fun translations(): TranslationService

    fun speech(): SpeechService

    /** A view of [AudioService] that provides access to raw HTTP responses for each method. */
    interface WithRawResponse {

        fun transcriptions(): TranscriptionService.WithRawResponse

        fun translations(): TranslationService.WithRawResponse

        fun speech(): SpeechService.WithRawResponse
    }
}
