// File generated from our OpenAPI spec by Stainless.

package com.openai.models.finetuning.checkpoints.permissions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class PermissionDeleteParamsTest {

    @Test
    fun create() {
        PermissionDeleteParams.builder()
            .fineTunedModelCheckpoint("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
            .permissionId("cp_zc4Q7MP6XxulcVzj4MZdwsAB")
            .build()
    }

    @Test
    fun pathParams() {
        val params =
            PermissionDeleteParams.builder()
                .fineTunedModelCheckpoint("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
                .permissionId("cp_zc4Q7MP6XxulcVzj4MZdwsAB")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("ft:gpt-4o-mini-2024-07-18:org:weather:B7R9VjQd")
        assertThat(params._pathParam(1)).isEqualTo("cp_zc4Q7MP6XxulcVzj4MZdwsAB")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
