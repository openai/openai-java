// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.audio.SpeechService
import com.openai.services.blocking.audio.SpeechServiceImpl
import com.openai.services.blocking.audio.TranscriptionService
import com.openai.services.blocking.audio.TranscriptionServiceImpl
import com.openai.services.blocking.audio.TranslationService
import com.openai.services.blocking.audio.TranslationServiceImpl

class AudioServiceImpl internal constructor(private val clientOptions: ClientOptions) :
    AudioService {

    private val withRawResponse: AudioService.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val transcriptions: TranscriptionService by lazy {
        TranscriptionServiceImpl(clientOptions)
    }

    private val translations: TranslationService by lazy { TranslationServiceImpl(clientOptions) }

    private val speech: SpeechService by lazy { SpeechServiceImpl(clientOptions) }

    override fun withRawResponse(): AudioService.WithRawResponse = withRawResponse

    override fun transcriptions(): TranscriptionService = transcriptions

    override fun translations(): TranslationService = translations

    override fun speech(): SpeechService = speech

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AudioService.WithRawResponse {

        private val transcriptions: TranscriptionService.WithRawResponse by lazy {
            TranscriptionServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val translations: TranslationService.WithRawResponse by lazy {
            TranslationServiceImpl.WithRawResponseImpl(clientOptions)
        }

        private val speech: SpeechService.WithRawResponse by lazy {
            SpeechServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun transcriptions(): TranscriptionService.WithRawResponse = transcriptions

        override fun translations(): TranslationService.WithRawResponse = translations

        override fun speech(): SpeechService.WithRawResponse = speech
    }
}
