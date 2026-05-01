// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.users.UserCreateParams
import com.openai.models.admin.organization.projects.users.UserDeleteParams
import com.openai.models.admin.organization.projects.users.UserRetrieveParams
import com.openai.models.admin.organization.projects.users.UserUpdateParams
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
        val userService = client.admin().organization().projects().users()

        val projectUser =
            userService.create(
                UserCreateParams.builder()
                    .projectId("project_id")
                    .role("role")
                    .email("email")
                    .userId("user_id")
                    .build()
            )

        projectUser.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val userService = client.admin().organization().projects().users()

        val projectUser =
            userService.retrieve(
                UserRetrieveParams.builder().projectId("project_id").userId("user_id").build()
            )

        projectUser.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val userService = client.admin().organization().projects().users()

        val projectUser =
            userService.update(
                UserUpdateParams.builder()
                    .projectId("project_id")
                    .userId("user_id")
                    .role("role")
                    .build()
            )

        projectUser.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val userService = client.admin().organization().projects().users()

        val page = userService.list("project_id")

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
        val userService = client.admin().organization().projects().users()

        val user =
            userService.delete(
                UserDeleteParams.builder().projectId("project_id").userId("user_id").build()
            )

        user.validate()
    }
}
