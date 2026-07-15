// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.users.UserCreateParams
import com.openai.models.admin.organization.projects.users.UserDeleteParams
import com.openai.models.admin.organization.projects.users.UserRetrieveParams
import com.openai.models.admin.organization.projects.users.UserUpdateParams
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
        val userServiceAsync = client.admin().organization().projects().users()

        val projectUserFuture =
            userServiceAsync.create(
                UserCreateParams.builder()
                    .projectId("project_id")
                    .role("role")
                    .email("email")
                    .userId("user_id")
                    .build()
            )

        val projectUser = projectUserFuture.get()
        projectUser.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val userServiceAsync = client.admin().organization().projects().users()

        val projectUserFuture =
            userServiceAsync.retrieve(
                UserRetrieveParams.builder().projectId("project_id").userId("user_id").build()
            )

        val projectUser = projectUserFuture.get()
        projectUser.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val userServiceAsync = client.admin().organization().projects().users()

        val projectUserFuture =
            userServiceAsync.update(
                UserUpdateParams.builder()
                    .projectId("project_id")
                    .userId("user_id")
                    .role("role")
                    .build()
            )

        val projectUser = projectUserFuture.get()
        projectUser.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val userServiceAsync = client.admin().organization().projects().users()

        val pageFuture = userServiceAsync.list("project_id")

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
        val userServiceAsync = client.admin().organization().projects().users()

        val userFuture =
            userServiceAsync.delete(
                UserDeleteParams.builder().projectId("project_id").userId("user_id").build()
            )

        val user = userFuture.get()
        user.validate()
    }
}
