// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.beta.agents.sessions

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.beta.agents.sessions.artifacts.ArtifactContentParams
import com.openai.models.beta.agents.sessions.artifacts.ArtifactDeleteParams
import com.openai.models.beta.agents.sessions.artifacts.ArtifactRetrieveParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class ArtifactServiceAsyncTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val artifactServiceAsync = client.beta().agents().sessions().artifacts()

        val sessionArtifactFuture =
            artifactServiceAsync.retrieve(
                ArtifactRetrieveParams.builder()
                    .sessionId("session_id")
                    .artifactId("artifact_id")
                    .build()
            )

        val sessionArtifact = sessionArtifactFuture.get()
        sessionArtifact.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val artifactServiceAsync = client.beta().agents().sessions().artifacts()

        val pageFuture = artifactServiceAsync.list("session_id")

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val artifactServiceAsync = client.beta().agents().sessions().artifacts()

        val sessionArtifactDeletedFuture =
            artifactServiceAsync.delete(
                ArtifactDeleteParams.builder()
                    .sessionId("session_id")
                    .artifactId("artifact_id")
                    .build()
            )

        val sessionArtifactDeleted = sessionArtifactDeletedFuture.get()
        sessionArtifactDeleted.validate()
    }

    @Test
    fun content(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val artifactServiceAsync = client.beta().agents().sessions().artifacts()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))

        val responseFuture =
            artifactServiceAsync.content(
                ArtifactContentParams.builder()
                    .sessionId("session_id")
                    .artifactId("artifact_id")
                    .build()
            )

        val response = responseFuture.get()
        assertThat(response.body()).hasContent("abc")
    }
}
