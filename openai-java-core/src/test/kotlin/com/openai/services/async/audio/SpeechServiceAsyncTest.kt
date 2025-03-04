// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.audio

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.post
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.AudioSpeechCreateParams
import com.openai.models.SpeechModel
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
@WireMockTest
class SpeechServiceAsyncTest {

    @Test
    fun create(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
        val speechServiceAsync = client.audio().speech()
        stubFor(post(anyUrl()).willReturn(ok().withBody("abc")))

        val speechFuture =
            speechServiceAsync.create(
                AudioSpeechCreateParams.builder()
                    .input("input")
                    .model(SpeechModel.TTS_1)
                    .voice(AudioSpeechCreateParams.Voice.ALLOY)
                    .responseFormat(AudioSpeechCreateParams.ResponseFormat.MP3)
                    .speed(0.25)
                    .build()
            )

        val speech = speechFuture.get()
        assertThat(speech.body()).hasContent("abc")
    }
}
