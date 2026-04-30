// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects.groups

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.groups.roles.RoleCreateParams
import com.openai.models.admin.organization.projects.groups.roles.RoleDeleteParams
import com.openai.models.admin.organization.projects.groups.roles.RoleListParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class RoleServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val roleService = client.admin().organization().projects().groups().roles()

        val role =
            roleService.create(
                RoleCreateParams.builder()
                    .projectId("project_id")
                    .groupId("group_id")
                    .roleId("role_id")
                    .build()
            )

        role.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val roleService = client.admin().organization().projects().groups().roles()

        val page =
            roleService.list(
                RoleListParams.builder().projectId("project_id").groupId("group_id").build()
            )

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
        val roleService = client.admin().organization().projects().groups().roles()

        val role =
            roleService.delete(
                RoleDeleteParams.builder()
                    .projectId("project_id")
                    .groupId("group_id")
                    .roleId("role_id")
                    .build()
            )

        role.validate()
    }
}
