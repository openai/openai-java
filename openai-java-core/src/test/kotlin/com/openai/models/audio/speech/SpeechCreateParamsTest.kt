// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.speech

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpeechCreateParamsTest {

    @Test
    fun create() {
        SpeechCreateParams.builder()
            .input("input")
            .model(SpeechModel.TTS_1)
            .voice(SpeechCreateParams.Voice.ALLOY)
            .instructions("instructions")
            .responseFormat(SpeechCreateParams.ResponseFormat.MP3)
            .speed(0.25)
            .build()
    }

    @Test
    fun body() {
        val params =
            SpeechCreateParams.builder()
                .input("input")
                .model(SpeechModel.TTS_1)
                .voice(SpeechCreateParams.Voice.ALLOY)
                .instructions("instructions")
                .responseFormat(SpeechCreateParams.ResponseFormat.MP3)
                .speed(0.25)
                .build()

        val body = params._body()

        assertThat(body.input()).isEqualTo("input")
        assertThat(body.model()).isEqualTo(SpeechModel.TTS_1)
        assertThat(body.voice()).isEqualTo(SpeechCreateParams.Voice.ALLOY)
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.responseFormat()).contains(SpeechCreateParams.ResponseFormat.MP3)
        assertThat(body.speed()).contains(0.25)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            SpeechCreateParams.builder()
                .input("input")
                .model(SpeechModel.TTS_1)
                .voice(SpeechCreateParams.Voice.ALLOY)
                .build()

        val body = params._body()

        assertThat(body.input()).isEqualTo("input")
        assertThat(body.model()).isEqualTo(SpeechModel.TTS_1)
        assertThat(body.voice()).isEqualTo(SpeechCreateParams.Voice.ALLOY)
    }
}
