// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.groups

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.groups.roles.RoleCreateParams
import com.openai.models.admin.organization.groups.roles.RoleDeleteParams
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
        val roleServiceAsync = client.admin().organization().groups().roles()

        val roleFuture =
            roleServiceAsync.create(
                RoleCreateParams.builder().groupId("group_id").roleId("role_id").build()
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
        val roleServiceAsync = client.admin().organization().groups().roles()

        val pageFuture = roleServiceAsync.list("group_id")

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
        val roleServiceAsync = client.admin().organization().groups().roles()

        val roleFuture =
            roleServiceAsync.delete(
                RoleDeleteParams.builder().groupId("group_id").roleId("role_id").build()
            )

        val role = roleFuture.get()
        role.validate()
    }
}
