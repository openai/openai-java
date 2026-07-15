// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.invites.InviteCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InviteServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val inviteService = client.admin().organization().invites()

        val invite =
            inviteService.create(
                InviteCreateParams.builder()
                    .email("email")
                    .role(InviteCreateParams.Role.READER)
                    .addProject(
                        InviteCreateParams.Project.builder()
                            .id("id")
                            .role(InviteCreateParams.Project.Role.MEMBER)
                            .build()
                    )
                    .build()
            )

        invite.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val inviteService = client.admin().organization().invites()

        val invite = inviteService.retrieve("invite_id")

        invite.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val inviteService = client.admin().organization().invites()

        val page = inviteService.list()

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
        val inviteService = client.admin().organization().invites()

        val invite = inviteService.delete("invite_id")

        invite.validate()
    }
}
