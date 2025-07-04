// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.audio

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.audio.speech.SpeechCreateParams
import com.openai.models.audio.speech.SpeechModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class SpeechServiceTest {

    @Test
    fun create(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
        val speechService = client.audio().speech()
        stubFor(post(anyUrl()).willReturn(ok().withBody("abc")))

        val speech =
            speechService.create(
                SpeechCreateParams.builder()
                    .input("input")
                    .model(SpeechModel.TTS_1)
                    .voice(SpeechCreateParams.Voice.ALLOY)
                    .instructions("instructions")
                    .responseFormat(SpeechCreateParams.ResponseFormat.MP3)
                    .speed(0.25)
                    .streamFormat(SpeechCreateParams.StreamFormat.SSE)
                    .build()
            )

        assertThat(speech.body()).hasContent("abc")
    }
}
