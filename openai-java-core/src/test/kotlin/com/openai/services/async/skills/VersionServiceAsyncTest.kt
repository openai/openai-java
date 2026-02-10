// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.skills

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.skills.versions.VersionCreateParams
import com.openai.models.skills.versions.VersionDeleteParams
import com.openai.models.skills.versions.VersionRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class VersionServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val versionServiceAsync = client.skills().versions()

        val skillVersionFuture =
            versionServiceAsync.create(
                VersionCreateParams.builder()
                    .skillId("skill_123")
                    .default_(true)
                    .filesOfInputStreams(listOf("some content".byteInputStream()))
                    .build()
            )

        val skillVersion = skillVersionFuture.get()
        skillVersion.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val versionServiceAsync = client.skills().versions()

        val skillVersionFuture =
            versionServiceAsync.retrieve(
                VersionRetrieveParams.builder().skillId("skill_123").version("version").build()
            )

        val skillVersion = skillVersionFuture.get()
        skillVersion.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val versionServiceAsync = client.skills().versions()

        val pageFuture = versionServiceAsync.list("skill_123")

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
        val versionServiceAsync = client.skills().versions()

        val deletedSkillVersionFuture =
            versionServiceAsync.delete(
                VersionDeleteParams.builder().skillId("skill_123").version("version").build()
            )

        val deletedSkillVersion = deletedSkillVersionFuture.get()
        deletedSkillVersion.validate()
    }
}
