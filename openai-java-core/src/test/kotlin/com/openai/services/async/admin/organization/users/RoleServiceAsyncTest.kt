// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.users

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.users.roles.RoleCreateParams
import com.openai.models.admin.organization.users.roles.RoleDeleteParams
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
        val roleServiceAsync = client.admin().organization().users().roles()

        val roleFuture =
            roleServiceAsync.create(
                RoleCreateParams.builder().userId("user_id").roleId("role_id").build()
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
        val roleServiceAsync = client.admin().organization().users().roles()

        val pageFuture = roleServiceAsync.list("user_id")

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
        val roleServiceAsync = client.admin().organization().users().roles()

        val roleFuture =
            roleServiceAsync.delete(
                RoleDeleteParams.builder().userId("user_id").roleId("role_id").build()
            )

        val role = roleFuture.get()
        role.validate()
    }
}
