// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.invites.InviteCreateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class InviteServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val inviteServiceAsync = client.admin().organization().invites()

        val inviteFuture =
            inviteServiceAsync.create(
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

        val invite = inviteFuture.get()
        invite.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val inviteServiceAsync = client.admin().organization().invites()

        val inviteFuture = inviteServiceAsync.retrieve("invite_id")

        val invite = inviteFuture.get()
        invite.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val inviteServiceAsync = client.admin().organization().invites()

        val pageFuture = inviteServiceAsync.list()

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
        val inviteServiceAsync = client.admin().organization().invites()

        val inviteFuture = inviteServiceAsync.delete("invite_id")

        val invite = inviteFuture.get()
        invite.validate()
    }
}
