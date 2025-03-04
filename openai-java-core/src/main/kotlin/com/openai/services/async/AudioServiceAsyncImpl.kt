// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.core.ClientOptions
import com.openai.services.async.audio.SpeechServiceAsync
import com.openai.services.async.audio.SpeechServiceAsyncImpl
import com.openai.services.async.audio.TranscriptionServiceAsync
import com.openai.services.async.audio.TranscriptionServiceAsyncImpl
import com.openai.services.async.audio.TranslationServiceAsync
import com.openai.services.async.audio.TranslationServiceAsyncImpl

class AudioServiceAsyncImpl internal constructor(private val clientOptions: ClientOptions) :
    AudioServiceAsync {

    private val withRawResponse: AudioServiceAsync.WithRawResponse by lazy {
        WithRawResponseImpl(clientOptions)
    }

    private val transcriptions: TranscriptionServiceAsync by lazy {
        TranscriptionServiceAsyncImpl(clientOptions)
    }

    private val translations: TranslationServiceAsync by lazy {
        TranslationServiceAsyncImpl(clientOptions)
    }

    private val speech: SpeechServiceAsync by lazy { SpeechServiceAsyncImpl(clientOptions) }

    override fun withRawResponse(): AudioServiceAsync.WithRawResponse = withRawResponse

    override fun transcriptions(): TranscriptionServiceAsync = transcriptions

    override fun translations(): TranslationServiceAsync = translations

    override fun speech(): SpeechServiceAsync = speech

    class WithRawResponseImpl internal constructor(private val clientOptions: ClientOptions) :
        AudioServiceAsync.WithRawResponse {

        private val transcriptions: TranscriptionServiceAsync.WithRawResponse by lazy {
            TranscriptionServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val translations: TranslationServiceAsync.WithRawResponse by lazy {
            TranslationServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        private val speech: SpeechServiceAsync.WithRawResponse by lazy {
            SpeechServiceAsyncImpl.WithRawResponseImpl(clientOptions)
        }

        override fun transcriptions(): TranscriptionServiceAsync.WithRawResponse = transcriptions

        override fun translations(): TranslationServiceAsync.WithRawResponse = translations

        override fun speech(): SpeechServiceAsync.WithRawResponse = speech
    }
}
