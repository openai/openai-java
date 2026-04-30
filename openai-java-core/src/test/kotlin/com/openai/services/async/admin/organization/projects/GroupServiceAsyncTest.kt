// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.groups.GroupCreateParams
import com.openai.models.admin.organization.projects.groups.GroupDeleteParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GroupServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val groupServiceAsync = client.admin().organization().projects().groups()

        val projectGroupFuture =
            groupServiceAsync.create(
                GroupCreateParams.builder()
                    .projectId("project_id")
                    .groupId("group_id")
                    .role("role")
                    .build()
            )

        val projectGroup = projectGroupFuture.get()
        projectGroup.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val groupServiceAsync = client.admin().organization().projects().groups()

        val pageFuture = groupServiceAsync.list("project_id")

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
        val groupServiceAsync = client.admin().organization().projects().groups()

        val groupFuture =
            groupServiceAsync.delete(
                GroupDeleteParams.builder().projectId("project_id").groupId("group_id").build()
            )

        val group = groupFuture.get()
        group.validate()
    }
}
