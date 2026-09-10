// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.environments.files

import com.openai.models.beta.agents.HostedEnvironmentFileParam
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileCreateParamsTest {

    @Test
    fun create() {
        FileCreateParams.builder()
            .environmentId("environment_id")
            .hostedEnvironmentFileParam(
                HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build()
            )
            .build()
    }

    @Test
    fun pathParams() {
        val params = FileCreateParams.builder().environmentId("environment_id").build()

        assertThat(params._pathParam(0)).isEqualTo("environment_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            FileCreateParams.builder()
                .environmentId("environment_id")
                .hostedEnvironmentFileParam(
                    HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build()
                )
                .build()

        val body = params._body().getOrNull()

        assertThat(body)
            .isEqualTo(
                HostedEnvironmentFileParam.ofFileId(
                    HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = FileCreateParams.builder().environmentId("environment_id").build()

        val body = params._body().getOrNull()
    }
}
