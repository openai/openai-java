// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.videos.VideoCreateParams
import com.openai.models.videos.VideoDownloadContentParams
import com.openai.models.videos.VideoModel
import com.openai.models.videos.VideoRemixParams
import com.openai.models.videos.VideoSeconds
import com.openai.models.videos.VideoSize
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class VideoServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val videoService = client.videos()

        val video =
            videoService.create(
                VideoCreateParams.builder()
                    .prompt("x")
                    .addCharacterId("char_123")
                    .inputReference("some content".byteInputStream())
                    .model(VideoModel.of("string"))
                    .seconds(VideoSeconds._4)
                    .size(VideoSize._720X1280)
                    .build()
            )

        video.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val videoService = client.videos()

        val video = videoService.retrieve("video_123")

        video.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val videoService = client.videos()

        val page = videoService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val videoService = client.videos()

        val video = videoService.delete("video_123")

        video.validate()
    }

    @Test
    fun downloadContent(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
        val videoService = client.videos()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))

        val response =
            videoService.downloadContent(
                VideoDownloadContentParams.builder()
                    .videoId("video_123")
                    .variant(VideoDownloadContentParams.Variant.VIDEO)
                    .build()
            )

        assertThat(response.body()).hasContent("abc")
    }

    @Test
    fun remix() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val videoService = client.videos()

        val video =
            videoService.remix(VideoRemixParams.builder().videoId("video_123").prompt("x").build())

        video.validate()
    }
}
