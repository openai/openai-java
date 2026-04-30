// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.users

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.users.roles.RoleCreateParams
import com.openai.models.admin.organization.users.roles.RoleDeleteParams
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
        val roleService = client.admin().organization().users().roles()

        val role =
            roleService.create(
                RoleCreateParams.builder().userId("user_id").roleId("role_id").build()
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
        val roleService = client.admin().organization().users().roles()

        val page = roleService.list("user_id")

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
        val roleService = client.admin().organization().users().roles()

        val role =
            roleService.delete(
                RoleDeleteParams.builder().userId("user_id").roleId("role_id").build()
            )

        role.validate()
    }
}
