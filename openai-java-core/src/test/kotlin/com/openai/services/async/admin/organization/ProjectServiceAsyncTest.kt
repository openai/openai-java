// File generated from our OpenAPI spec by Stainless.

package com.openai.services.async.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClientAsync
import com.openai.models.admin.organization.projects.ProjectCreateParams
import com.openai.models.admin.organization.projects.ProjectUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ProjectServiceAsyncTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val projectServiceAsync = client.admin().organization().projects()

        val projectFuture =
            projectServiceAsync.create(
                ProjectCreateParams.builder()
                    .name("name")
                    .geography(ProjectCreateParams.Geography.US)
                    .build()
            )

        val project = projectFuture.get()
        project.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val projectServiceAsync = client.admin().organization().projects()

        val projectFuture = projectServiceAsync.retrieve("project_id")

        val project = projectFuture.get()
        project.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val projectServiceAsync = client.admin().organization().projects()

        val projectFuture =
            projectServiceAsync.update(
                ProjectUpdateParams.builder().projectId("project_id").name("name").build()
            )

        val project = projectFuture.get()
        project.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val projectServiceAsync = client.admin().organization().projects()

        val pageFuture = projectServiceAsync.list()

        val page = pageFuture.get()
        page.response().validate()
    }

    @Test
    fun archive() {
        val client =
            OpenAIOkHttpClientAsync.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val projectServiceAsync = client.admin().organization().projects()

        val projectFuture = projectServiceAsync.archive("project_id")

        val project = projectFuture.get()
        project.validate()
    }
}
