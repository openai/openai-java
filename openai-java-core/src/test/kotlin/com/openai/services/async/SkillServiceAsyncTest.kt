// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.skills.SkillCreateParams
import com.openai.models.skills.SkillUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SkillServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val skillServiceAsync = client.skills()

        val skillFuture =
            skillServiceAsync.create(
                SkillCreateParams.builder()
                    .filesOfInputStreams(listOf("some content".byteInputStream()))
                    .build()
            )

        val skill = skillFuture.get()
        skill.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val skillServiceAsync = client.skills()

        val skillFuture = skillServiceAsync.retrieve("skill_123")

        val skill = skillFuture.get()
        skill.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val skillServiceAsync = client.skills()

        val skillFuture =
            skillServiceAsync.update(
                SkillUpdateParams.builder()
                    .skillId("skill_123")
                    .defaultVersion("default_version")
                    .build()
            )

        val skill = skillFuture.get()
        skill.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val skillServiceAsync = client.skills()

        val pageFuture = skillServiceAsync.list()

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
        val skillServiceAsync = client.skills()

        val deletedSkillFuture = skillServiceAsync.delete("skill_123")

        val deletedSkill = deletedSkillFuture.get()
        deletedSkill.validate()
    }
}
