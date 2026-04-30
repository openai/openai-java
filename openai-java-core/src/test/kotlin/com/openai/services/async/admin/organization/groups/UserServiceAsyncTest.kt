// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.groups

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.groups.users.UserCreateParams
import com.openai.models.admin.organization.groups.users.UserDeleteParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UserServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val userServiceAsync = client.admin().organization().groups().users()

        val userFuture =
            userServiceAsync.create(
                UserCreateParams.builder().groupId("group_id").userId("user_id").build()
            )

        val user = userFuture.get()
        user.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val userServiceAsync = client.admin().organization().groups().users()

        val pageFuture = userServiceAsync.list("group_id")

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
        val userServiceAsync = client.admin().organization().groups().users()

        val userFuture =
            userServiceAsync.delete(
                UserDeleteParams.builder().groupId("group_id").userId("user_id").build()
            )

        val user = userFuture.get()
        user.validate()
    }
}
