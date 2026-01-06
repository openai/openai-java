// File generated from our OpenAPI spec by Stainless.

package com.openai.models.audio.speech

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SpeechCreateParamsTest {

    @Test
    fun create() {
        SpeechCreateParams.builder()
            .input("input")
            .model(SpeechModel.of("string"))
            .voice(SpeechCreateParams.Voice.ASH)
            .instructions("instructions")
            .responseFormat(SpeechCreateParams.ResponseFormat.MP3)
            .speed(0.25)
            .streamFormat(SpeechCreateParams.StreamFormat.SSE)
            .build()
    }

    @Test
    fun body() {
        val params =
            SpeechCreateParams.builder()
                .input("input")
                .model(SpeechModel.of("string"))
                .voice(SpeechCreateParams.Voice.ASH)
                .instructions("instructions")
                .responseFormat(SpeechCreateParams.ResponseFormat.MP3)
                .speed(0.25)
                .streamFormat(SpeechCreateParams.StreamFormat.SSE)
                .build()

        val body = params._body()

        assertThat(body.input()).isEqualTo("input")
        assertThat(body.model()).isEqualTo(SpeechModel.of("string"))
        assertThat(body.voice()).isEqualTo(SpeechCreateParams.Voice.ASH)
        assertThat(body.instructions()).contains("instructions")
        assertThat(body.responseFormat()).contains(SpeechCreateParams.ResponseFormat.MP3)
        assertThat(body.speed()).contains(0.25)
        assertThat(body.streamFormat()).contains(SpeechCreateParams.StreamFormat.SSE)
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            SpeechCreateParams.builder()
                .input("input")
                .model(SpeechModel.of("string"))
                .voice(SpeechCreateParams.Voice.ASH)
                .build()

        val body = params._body()

        assertThat(body.input()).isEqualTo("input")
        assertThat(body.model()).isEqualTo(SpeechModel.of("string"))
        assertThat(body.voice()).isEqualTo(SpeechCreateParams.Voice.ASH)
    }
}
