// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.skills.SkillCreateParams
import com.openai.models.skills.SkillUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class SkillServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val skillService = client.skills()

        val skill =
            skillService.create(
                SkillCreateParams.builder()
                    .filesOfInputStreams(listOf("some content".byteInputStream()))
                    .build()
            )

        skill.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val skillService = client.skills()

        val skill = skillService.retrieve("skill_123")

        skill.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val skillService = client.skills()

        val skill =
            skillService.update(
                SkillUpdateParams.builder()
                    .skillId("skill_123")
                    .defaultVersion("default_version")
                    .build()
            )

        skill.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val skillService = client.skills()

        val page = skillService.list()

        page.response().validate()
    }

    @Test
    fun delete() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .build()
        val skillService = client.skills()

        val deletedSkill = skillService.delete("skill_123")

        deletedSkill.validate()
    }
}
