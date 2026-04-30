// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.roles.RoleCreateParams
import com.openai.models.admin.organization.roles.RoleUpdateParams
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
        val roleService = client.admin().organization().roles()

        val role =
            roleService.create(
                RoleCreateParams.builder()
                    .addPermission("string")
                    .roleName("role_name")
                    .description("description")
                    .build()
            )

        role.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val roleService = client.admin().organization().roles()

        val role =
            roleService.update(
                RoleUpdateParams.builder()
                    .roleId("role_id")
                    .description("description")
                    .addPermission("string")
                    .roleName("role_name")
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
        val roleService = client.admin().organization().roles()

        val page = roleService.list()

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
        val roleService = client.admin().organization().roles()

        val role = roleService.delete("role_id")

        role.validate()
    }
}
