// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.ProjectCreateParams
import com.openai.models.admin.organization.projects.ProjectUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class ProjectServiceTest {

    @Test
    fun create() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val projectService = client.admin().organization().projects()

        val project =
            projectService.create(
                ProjectCreateParams.builder()
                    .name("name")
                    .externalKeyId("external_key_id")
                    .geography("geography")
                    .build()
            )

        project.validate()
    }

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val projectService = client.admin().organization().projects()

        val project = projectService.retrieve("project_id")

        project.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val projectService = client.admin().organization().projects()

        val project =
            projectService.update(
                ProjectUpdateParams.builder()
                    .projectId("project_id")
                    .externalKeyId("external_key_id")
                    .geography("geography")
                    .name("name")
                    .build()
            )

        project.validate()
    }

    @Test
    fun list() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val projectService = client.admin().organization().projects()

        val page = projectService.list()

        page.response().validate()
    }

    @Test
    fun archive() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val projectService = client.admin().organization().projects()

        val project = projectService.archive("project_id")

        project.validate()
    }
}
