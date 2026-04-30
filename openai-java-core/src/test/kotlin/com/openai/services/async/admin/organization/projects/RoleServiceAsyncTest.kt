// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.roles.RoleCreateParams
import com.openai.models.admin.organization.projects.roles.RoleDeleteParams
import com.openai.models.admin.organization.projects.roles.RoleUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class RoleServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val roleServiceAsync = client.admin().organization().projects().roles()

        val roleFuture =
            roleServiceAsync.create(
                RoleCreateParams.builder()
                    .projectId("project_id")
                    .addPermission("string")
                    .roleName("role_name")
                    .description("description")
                    .build()
            )

        val role = roleFuture.get()
        role.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val roleServiceAsync = client.admin().organization().projects().roles()

        val roleFuture =
            roleServiceAsync.update(
                RoleUpdateParams.builder()
                    .projectId("project_id")
                    .roleId("role_id")
                    .description("description")
                    .addPermission("string")
                    .roleName("role_name")
                    .build()
            )

        val role = roleFuture.get()
        role.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val roleServiceAsync = client.admin().organization().projects().roles()

        val pageFuture = roleServiceAsync.list("project_id")

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
        val roleServiceAsync = client.admin().organization().projects().roles()

        val roleFuture =
            roleServiceAsync.delete(
                RoleDeleteParams.builder().projectId("project_id").roleId("role_id").build()
            )

        val role = roleFuture.get()
        role.validate()
    }
}
