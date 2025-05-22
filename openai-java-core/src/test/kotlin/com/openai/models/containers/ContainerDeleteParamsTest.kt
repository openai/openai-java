// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerDeleteParamsTest {

    @Test
    fun create() {
        ContainerDeleteParams.builder().containerId("container_id").build()
    }

    @Test
    fun pathParams() {
        val params = ContainerDeleteParams.builder().containerId("container_id").build()

        assertThat(params._pathParam(0)).isEqualTo("container_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
