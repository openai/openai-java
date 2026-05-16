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
            .voice(SpeechCreateParams.Voice.UnionMember1.ALLOY)
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
                .model(SpeechModel.TTS_1)
                .voice(SpeechCreateParams.Voice.UnionMember1.ALLOY)
                .instructions("instructions")
                .responseFormat(SpeechCreateParams.ResponseFormat.MP3)
                .speed(0.25)
                .streamFormat(SpeechCreateParams.StreamFormat.SSE)
                .build()

        val body = params._body()

        assertThat(body.input()).isEqualTo("input")
        assertThat(body.model()).isEqualTo(SpeechModel.TTS_1)
        assertThat(body.voice())
            .isEqualTo(
                SpeechCreateParams.Voice.ofUnionMember1(SpeechCreateParams.Voice.UnionMember1.ALLOY)
            )
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
                .model(SpeechModel.TTS_1)
                .voice(SpeechCreateParams.Voice.UnionMember1.ALLOY)
                .build()

        val body = params._body()

        assertThat(body.input()).isEqualTo("input")
        assertThat(body.model()).isEqualTo(SpeechModel.TTS_1)
        assertThat(body.voice())
            .isEqualTo(
                SpeechCreateParams.Voice.ofUnionMember1(SpeechCreateParams.Voice.UnionMember1.ALLOY)
            )
    }

    @Test
    fun voiceKnownValuesIncludeSupportedSpeechVoices() {
        assertThat(SpeechCreateParams.Voice.UnionMember1.FABLE.known())
            .isEqualTo(SpeechCreateParams.Voice.UnionMember1.Known.FABLE)
        assertThat(SpeechCreateParams.Voice.UnionMember1.ONYX.known())
            .isEqualTo(SpeechCreateParams.Voice.UnionMember1.Known.ONYX)
        assertThat(SpeechCreateParams.Voice.UnionMember1.NOVA.known())
            .isEqualTo(SpeechCreateParams.Voice.UnionMember1.Known.NOVA)
    }
}
