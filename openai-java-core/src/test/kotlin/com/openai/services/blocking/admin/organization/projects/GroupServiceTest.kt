// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.groups.GroupCreateParams
import com.openai.models.admin.organization.projects.groups.GroupDeleteParams
import com.openai.models.admin.organization.projects.groups.GroupRetrieveParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class GroupServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val groupService = client.admin().organization().projects().groups()

        val projectGroup =
            groupService.create(
                GroupCreateParams.builder()
                    .projectId("project_id")
                    .groupId("group_id")
                    .role("role")
                    .build()
            )

        projectGroup.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val groupService = client.admin().organization().projects().groups()

        val projectGroup =
            groupService.retrieve(
                GroupRetrieveParams.builder()
                    .projectId("project_id")
                    .groupId("group_id")
                    .groupType(GroupRetrieveParams.GroupType.GROUP)
                    .build()
            )

        projectGroup.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val groupService = client.admin().organization().projects().groups()

        val page = groupService.list("project_id")

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
        val groupService = client.admin().organization().projects().groups()

        val group =
            groupService.delete(
                GroupDeleteParams.builder().projectId("project_id").groupId("group_id").build()
            )

        group.validate()
    }
}
