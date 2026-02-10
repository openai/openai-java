// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.skills

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.skills.versions.VersionCreateParams
import com.openai.models.skills.versions.VersionDeleteParams
import com.openai.models.skills.versions.VersionRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class VersionServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val versionService = client.skills().versions()

        val skillVersion =
            versionService.create(
                VersionCreateParams.builder()
                    .skillId("skill_123")
                    .default_(true)
                    .filesOfInputStreams(listOf("some content".byteInputStream()))
                    .build()
            )

        skillVersion.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val versionService = client.skills().versions()

        val skillVersion =
            versionService.retrieve(
                VersionRetrieveParams.builder().skillId("skill_123").version("version").build()
            )

        skillVersion.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val versionService = client.skills().versions()

        val page = versionService.list("skill_123")

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val versionService = client.skills().versions()

        val deletedSkillVersion =
            versionService.delete(
                VersionDeleteParams.builder().skillId("skill_123").version("version").build()
            )

        deletedSkillVersion.validate()
    }
}
