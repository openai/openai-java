// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.blocking.beta.agents.sessions

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.ok
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
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
internal class ArtifactServiceTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val artifactService = client.beta().agents().sessions().artifacts()

        val sessionArtifact =
            artifactService.retrieve(
                ArtifactRetrieveParams.builder()
                    .sessionId("session_id")
                    .artifactId("artifact_id")
                    .build()
            )

        sessionArtifact.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val artifactService = client.beta().agents().sessions().artifacts()

        val page = artifactService.list("session_id")

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val artifactService = client.beta().agents().sessions().artifacts()

        val sessionArtifactDeleted =
            artifactService.delete(
                ArtifactDeleteParams.builder()
                    .sessionId("session_id")
                    .artifactId("artifact_id")
                    .build()
            )

        sessionArtifactDeleted.validate()
    }

    @Test
    fun content(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val artifactService = client.beta().agents().sessions().artifacts()
        stubFor(get(anyUrl()).willReturn(ok().withBody("abc")))

        val response =
            artifactService.content(
                ArtifactContentParams.builder()
                    .sessionId("session_id")
                    .artifactId("artifact_id")
                    .build()
            )

        assertThat(response.body()).hasContent("abc")
    }
}
