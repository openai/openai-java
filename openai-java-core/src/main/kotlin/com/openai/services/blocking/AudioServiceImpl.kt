// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking

import com.openai.core.ClientOptions
import com.openai.services.blocking.audio.SpeechService
import com.openai.services.blocking.audio.SpeechServiceImpl
import com.openai.services.blocking.audio.TranscriptionService
import com.openai.services.blocking.audio.TranscriptionServiceImpl
import com.openai.services.blocking.audio.TranslationService
import com.openai.services.blocking.audio.TranslationServiceImpl
import com.openai.services.blocking.audio.VoiceService
import com.openai.services.blocking.audio.VoiceServiceImpl
import java.util.function.Consumer

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

    private val voices: VoiceService by lazy { VoiceServiceImpl(clientOptions) }

    override fun withRawResponse(): AudioService.WithRawResponse = withRawResponse

    override fun withOptions(modifier: Consumer<ClientOptions.Builder>): AudioService =
        AudioServiceImpl(clientOptions.toBuilder().apply(modifier::accept).build())

    /** Turn audio into text or text into audio. */
    override fun transcriptions(): TranscriptionService = transcriptions

    /** Turn audio into text or text into audio. */
    override fun translations(): TranslationService = translations

    /** Turn audio into text or text into audio. */
    override fun speech(): SpeechService = speech

    /** Turn audio into text or text into audio. */
    override fun voices(): VoiceService = voices

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

        private val voices: VoiceService.WithRawResponse by lazy {
            VoiceServiceImpl.WithRawResponseImpl(clientOptions)
        }

        override fun withOptions(
            modifier: Consumer<ClientOptions.Builder>
        ): AudioService.WithRawResponse =
            AudioServiceImpl.WithRawResponseImpl(
                clientOptions.toBuilder().apply(modifier::accept).build()
            )

        /** Turn audio into text or text into audio. */
        override fun transcriptions(): TranscriptionService.WithRawResponse = transcriptions

        /** Turn audio into text or text into audio. */
        override fun translations(): TranslationService.WithRawResponse = translations

        /** Turn audio into text or text into audio. */
        override fun speech(): SpeechService.WithRawResponse = speech

        /** Turn audio into text or text into audio. */
        override fun voices(): VoiceService.WithRawResponse = voices
    }
}
