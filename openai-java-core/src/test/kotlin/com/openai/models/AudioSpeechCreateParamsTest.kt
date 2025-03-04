// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import kotlin.test.assertNotNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AudioSpeechCreateParamsTest {

    @Test
    fun create() {
        AudioSpeechCreateParams.builder()
            .input("input")
            .model(SpeechModel.TTS_1)
            .voice(AudioSpeechCreateParams.Voice.ALLOY)
            .responseFormat(AudioSpeechCreateParams.ResponseFormat.MP3)
            .speed(0.25)
            .build()
    }

    @Test
    fun body() {
        val params =
            AudioSpeechCreateParams.builder()
                .input("input")
                .model(SpeechModel.TTS_1)
                .voice(AudioSpeechCreateParams.Voice.ALLOY)
                .responseFormat(AudioSpeechCreateParams.ResponseFormat.MP3)
                .speed(0.25)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.input()).isEqualTo("input")
        assertThat(body.model()).isEqualTo(SpeechModel.TTS_1)
        assertThat(body.voice()).isEqualTo(AudioSpeechCreateParams.Voice.ALLOY)
        assertThat(body.responseFormat()).contains(AudioSpeechCreateParams.ResponseFormat.MP3)
        assertThat(body.speed()).contains(0.25)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            AudioSpeechCreateParams.builder()
                .input("input")
                .model(SpeechModel.TTS_1)
                .voice(AudioSpeechCreateParams.Voice.ALLOY)
                .build()

        val body = params._body()

        assertNotNull(body)
        assertThat(body.input()).isEqualTo("input")
        assertThat(body.model()).isEqualTo(SpeechModel.TTS_1)
        assertThat(body.voice()).isEqualTo(AudioSpeechCreateParams.Voice.ALLOY)
    }
}
