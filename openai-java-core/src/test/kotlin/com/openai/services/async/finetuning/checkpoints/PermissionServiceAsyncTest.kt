// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.services.async.finetuning.checkpoints

import com.github.tomakehurst.wiremock.client.WireMock.anyUrl
import com.github.tomakehurst.wiremock.client.WireMock.findAll
import com.github.tomakehurst.wiremock.client.WireMock.get
import com.github.tomakehurst.wiremock.client.WireMock.getRequestedFor
import com.github.tomakehurst.wiremock.client.WireMock.okJson
import com.github.tomakehurst.wiremock.client.WireMock.reset
import com.github.tomakehurst.wiremock.client.WireMock.stubFor
import com.github.tomakehurst.wiremock.junit5.WireMockRuntimeInfo
import com.github.tomakehurst.wiremock.junit5.WireMockTest
import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.finetuning.checkpoints.permissions.PermissionCreateParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionDeleteParams
import com.openai.models.finetuning.checkpoints.permissions.PermissionRetrieveParams
import java.util.concurrent.atomic.AtomicInteger
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.junit.jupiter.api.parallel.ResourceLock

@ExtendWith(TestServerExtension::class)
@WireMockTest
@ResourceLock("https://github.com/wiremock/wiremock/issues/169")
internal class PermissionServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val permissionServiceAsync = client.fineTuning().checkpoints().permissions()

        val pageFuture =
            permissionServiceAsync.create(
                PermissionCreateParams.builder()
                    .fineTunedModelCheckpoint("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
                    .addProjectId("string")
                    .build()
            )

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val permissionServiceAsync = client.fineTuning().checkpoints().permissions()

        val permissionFuture =
            permissionServiceAsync.retrieve(
                PermissionRetrieveParams.builder()
                    .fineTunedModelCheckpoint("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                    .after("after")
                    .limit(0L)
                    .order(PermissionRetrieveParams.Order.ASCENDING)
                    .projectId("project_id")
                    .build()
            )

        val permission = permissionFuture.get()
        permission.validate()
    }

    @Test
    fun listStopsOnExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(wmRuntimeInfo.httpBaseUrl)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        try {
            // A terminal page can still contain items and a cursor
            stubFor(
                get(anyUrl())
                    .willReturn(
                        okJson(
                            "{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false,\"last_id\":\"item_1\"}"
                        )
                    )
            )
            val page =
                client
                    .fineTuning()
                    .checkpoints()
                    .permissions()
                    .list("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                    .get()
            assertThat(page.items()).hasSize(1)
            assertThat(page.hasNextPage()).isFalse()

            val count = AtomicInteger()
            page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
            assertThat(count.get()).isEqualTo(1)

            assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(1)
        } finally {
            client.close()
        }
    }

    @Test
    fun listContinuesUntilExplicitFalse(wmRuntimeInfo: WireMockRuntimeInfo) {
        // Both explicit true and a missing flag preserve normal cursor traversal.
        for (firstResponse in
            listOf(
                "{\"data\":[{\"id\":\"item_1\"}],\"has_more\":true,\"last_id\":\"item_1\"}",
                "{\"data\":[{\"id\":\"item_1\"}],\"last_id\":\"item_1\"}",
            )) {
            reset()
            val client =
                OpenAIOkHttpClientAsync.builder()
                    .baseUrl(wmRuntimeInfo.httpBaseUrl)
                    .apiKey("My API Key")
                    .adminApiKey("My Admin API Key")
                    .build()
            try {
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("Started")
                        .willReturn(okJson(firstResponse))
                        .willSetStateTo("terminal")
                )
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("terminal")
                        .willReturn(
                            okJson(
                                "{\"data\":[{\"id\":\"item_1\"}],\"has_more\":false,\"last_id\":\"item_1\"}"
                            )
                        )
                        .willSetStateTo("unexpected")
                )
                // Bound a regression to one extra request instead of an infinite loop.
                stubFor(
                    get(anyUrl())
                        .inScenario("pagination")
                        .whenScenarioStateIs("unexpected")
                        .willReturn(okJson("{}"))
                )
                val page =
                    client
                        .fineTuning()
                        .checkpoints()
                        .permissions()
                        .list("ft-AF1WoRqd3aJAHsqc9NY7iL8F")
                        .get()
                assertThat(page.hasNextPage()).isTrue()

                val count = AtomicInteger()
                page.autoPager().subscribe { count.incrementAndGet() }.onCompleteFuture().get()
                assertThat(count.get()).isEqualTo(2)

                assertThat(findAll(getRequestedFor(anyUrl()))).hasSize(2)
            } finally {
                client.close()
            }
        }
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val permissionServiceAsync = client.fineTuning().checkpoints().permissions()

        val pageFuture = permissionServiceAsync.list("ft-AF1WoRqd3aJAHsqc9NY7iL8F")

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
        val permissionServiceAsync = client.fineTuning().checkpoints().permissions()

        val permissionFuture =
            permissionServiceAsync.delete(
                PermissionDeleteParams.builder()
                    .fineTunedModelCheckpoint("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
                    .permissionId("cp_zc4Q7MP6XxulcVzj4MZdwsAB")
                    .build()
            )

        val permission = permissionFuture.get()
        permission.validate()
    }
}
