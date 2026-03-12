// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.videos.VideoCreateParams
import com.openai.models.videos.VideoDownloadContentParams
import com.openai.models.videos.VideoEditParams
import com.openai.models.videos.VideoExtendParams
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
internal class VideoServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val videoServiceAsync = client.videos()

        val videoFuture =
            videoServiceAsync.create(
                VideoCreateParams.builder()
                    .prompt("x")
                    .inputReference(
                        VideoCreateParams.InputReference.builder()
                            .fileId("file-123")
                            .imageUrl("image_url")
                            .build()
                    )
                    .model(VideoModel.SORA_2)
                    .seconds(VideoSeconds._4)
                    .size(VideoSize._720X1280)
                    .build()
            )

        val video = videoFuture.get()
        video.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val videoServiceAsync = client.videos()

        val videoFuture = videoServiceAsync.retrieve("video_123")

        val video = videoFuture.get()
        video.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val videoServiceAsync = client.videos()

        val pageFuture = videoServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val videoServiceAsync = client.videos()

        val videoFuture = videoServiceAsync.delete("video_123")

        val video = videoFuture.get()
        video.validate()
    }

    @Test
    fun downloadContent(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .build()
        val videoServiceAsync = client.videos()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))

        val responseFuture =
            videoServiceAsync.downloadContent(
                VideoDownloadContentParams.builder()
                    .videoId("video_123")
                    .variant(VideoDownloadContentParams.Variant.VIDEO)
                    .build()
            )

        val response = responseFuture.get()
        assertThat(response.body()).hasContent("abc")
    }

    @Test
    fun edit() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val videoServiceAsync = client.videos()

        val videoFuture =
            videoServiceAsync.edit(
                VideoEditParams.builder()
                    .prompt("x")
                    .video(VideoEditParams.Video.builder().id("video_123").build())
                    .build()
            )

        val video = videoFuture.get()
        video.validate()
    }

    @Test
    fun extend() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val videoServiceAsync = client.videos()

        val videoFuture =
            videoServiceAsync.extend(
                VideoExtendParams.builder()
                    .prompt("x")
                    .seconds(VideoSeconds._4)
                    .video(VideoExtendParams.Video.builder().id("video_123").build())
                    .build()
            )

        val video = videoFuture.get()
        video.validate()
    }

    @Test
    fun remix() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val videoServiceAsync = client.videos()

        val videoFuture =
            videoServiceAsync.remix(
                VideoRemixParams.builder().videoId("video_123").prompt("x").build()
            )

        val video = videoFuture.get()
        video.validate()
    }
}
