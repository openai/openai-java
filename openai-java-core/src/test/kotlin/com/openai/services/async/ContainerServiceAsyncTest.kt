// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.containers.ContainerCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContainerServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val containerServiceAsync = client.containers()

        val containerFuture =
            containerServiceAsync.create(
                ContainerCreateParams.builder()
                    .name("name")
                    .expiresAfter(
                        ContainerCreateParams.ExpiresAfter.builder()
                            .anchor(ContainerCreateParams.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                            .minutes(0L)
                            .build()
                    )
                    .addFileId("string")
                    .memoryLimit(ContainerCreateParams.MemoryLimit._1G)
                    .build()
            )

        val container = containerFuture.get()
        container.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val containerServiceAsync = client.containers()

        val containerFuture = containerServiceAsync.retrieve("container_id")

        val container = containerFuture.get()
        container.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val containerServiceAsync = client.containers()

        val pageFuture = containerServiceAsync.list()

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
        val containerServiceAsync = client.containers()

        val future = containerServiceAsync.delete("container_id")

        val response = future.get()
    }
}
