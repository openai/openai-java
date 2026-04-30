// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.groups

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.groups.users.UserCreateParams
import com.openai.models.admin.organization.groups.users.UserDeleteParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class UserServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val userService = client.admin().organization().groups().users()

        val user =
            userService.create(
                UserCreateParams.builder().groupId("group_id").userId("user_id").build()
            )

        user.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val userService = client.admin().organization().groups().users()

        val page = userService.list("group_id")

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
        val userService = client.admin().organization().groups().users()

        val user =
            userService.delete(
                UserDeleteParams.builder().groupId("group_id").userId("user_id").build()
            )

        user.validate()
    }
}
