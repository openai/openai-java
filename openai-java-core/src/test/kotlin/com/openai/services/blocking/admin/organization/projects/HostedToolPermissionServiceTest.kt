// File generated from our OpenAPI spec by Stainless.

package com.openai.services.blocking.admin.organization.projects

import com.openai.TestServerExtension
import com.openai.client.okhttp.OpenAIOkHttpClient
import com.openai.models.admin.organization.projects.hostedtoolpermissions.HostedToolPermissionUpdateParams
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith

@ExtendWith(TestServerExtension::class)
internal class HostedToolPermissionServiceTest {

    @Test
    fun retrieve() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val hostedToolPermissionService =
            client.admin().organization().projects().hostedToolPermissions()

        val projectHostedToolPermissions = hostedToolPermissionService.retrieve("project_id")

        projectHostedToolPermissions.validate()
    }

    @Test
    fun update() {
        val client =
            OpenAIOkHttpClient.builder()
                .baseUrl(TestServerExtension.BASE_URL)
                .apiKey("My API Key")
                .adminApiKey("My Admin API Key")
                .build()
        val hostedToolPermissionService =
            client.admin().organization().projects().hostedToolPermissions()

        val projectHostedToolPermissions =
            hostedToolPermissionService.update(
                HostedToolPermissionUpdateParams.builder()
                    .projectId("project_id")
                    .codeInterpreter(
                        HostedToolPermissionUpdateParams.CodeInterpreter.builder()
                            .enabled(true)
                            .build()
                    )
                    .fileSearch(
                        HostedToolPermissionUpdateParams.FileSearch.builder().enabled(true).build()
                    )
                    .imageGeneration(
                        HostedToolPermissionUpdateParams.ImageGeneration.builder()
                            .enabled(true)
                            .build()
                    )
                    .mcp(HostedToolPermissionUpdateParams.Mcp.builder().enabled(true).build())
                    .webSearch(
                        HostedToolPermissionUpdateParams.WebSearch.builder().enabled(true).build()
                    )
                    .build()
            )

        projectHostedToolPermissions.validate()
    }
}
