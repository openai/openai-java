// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermissionCreateParamsTest {

    @Test
    fun create() {
        PermissionCreateParams.builder()
            .fineTunedModelCheckpoint("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
            .addProjectId("string")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            PermissionCreateParams.builder()
                .fineTunedModelCheckpoint("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
                .addProjectId("string")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            PermissionCreateParams.builder()
                .fineTunedModelCheckpoint("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
                .addProjectId("string")
                .build()

        val body = params._body()

        assertThat(body.projectIds()).containsExactly("string")
    }
}
