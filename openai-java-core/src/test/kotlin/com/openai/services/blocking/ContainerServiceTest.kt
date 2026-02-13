// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.containers.ContainerCreateParams
import com.openai.models.responses.ContainerNetworkPolicyDisabled
import com.openai.models.responses.SkillReference
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ContainerServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val containerService = client.containers()

        val container =
            containerService.create(
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
                    .networkPolicy(ContainerNetworkPolicyDisabled.builder().build())
                    .addSkill(SkillReference.builder().skillId("x").version("version").build())
                    .build()
            )

        container.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val containerService = client.containers()

        val container = containerService.retrieve("container_id")

        container.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val containerService = client.containers()

        val page = containerService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val containerService = client.containers()

        containerService.delete("container_id")
    }
}
