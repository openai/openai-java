// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.hostedtoolpermissions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class HostedToolPermissionUpdateParamsTest {

    @Test
    fun create() {
        HostedToolPermissionUpdateParams.builder()
            .projectId("project_id")
            .codeInterpreter(
                HostedToolPermissionUpdateParams.CodeInterpreter.builder().enabled(true).build()
            )
            .fileSearch(HostedToolPermissionUpdateParams.FileSearch.builder().enabled(true).build())
            .imageGeneration(
                HostedToolPermissionUpdateParams.ImageGeneration.builder().enabled(true).build()
            )
            .mcp(HostedToolPermissionUpdateParams.Mcp.builder().enabled(true).build())
            .webSearch(HostedToolPermissionUpdateParams.WebSearch.builder().enabled(true).build())
            .build()
    }

    @Test
    fun pathParams() {
        val params = HostedToolPermissionUpdateParams.builder().projectId("project_id").build()

        assertThat(params._pathParam(0)).isEqualTo("project_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            HostedToolPermissionUpdateParams.builder()
                .projectId("project_id")
                .codeInterpreter(
                    HostedToolPermissionUpdateParams.CodeInterpreter.builder().enabled(true).build()
                )
                .fileSearch(
                    HostedToolPermissionUpdateParams.FileSearch.builder().enabled(true).build()
                )
                .imageGeneration(
                    HostedToolPermissionUpdateParams.ImageGeneration.builder().enabled(true).build()
                )
                .mcp(HostedToolPermissionUpdateParams.Mcp.builder().enabled(true).build())
                .webSearch(
                    HostedToolPermissionUpdateParams.WebSearch.builder().enabled(true).build()
                )
                .build()

        val body = params._body()

        assertThat(body.codeInterpreter())
            .contains(
                HostedToolPermissionUpdateParams.CodeInterpreter.builder().enabled(true).build()
            )
        assertThat(body.fileSearch())
            .contains(HostedToolPermissionUpdateParams.FileSearch.builder().enabled(true).build())
        assertThat(body.imageGeneration())
            .contains(
                HostedToolPermissionUpdateParams.ImageGeneration.builder().enabled(true).build()
            )
        assertThat(body.mcp())
            .contains(HostedToolPermissionUpdateParams.Mcp.builder().enabled(true).build())
        assertThat(body.webSearch())
            .contains(HostedToolPermissionUpdateParams.WebSearch.builder().enabled(true).build())
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = HostedToolPermissionUpdateParams.builder().projectId("project_id").build()

        val body = params._body()
    }
}
