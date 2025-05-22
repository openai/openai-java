// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FileDeleteParamsTest {

    @Test
    fun create() {
        FileDeleteParams.builder().containerId("container_id").fileId("file_id").build()
    }

    @Test
    fun pathParams() {
        val params =
            FileDeleteParams.builder().containerId("container_id").fileId("file_id").build()

        assertThat(params._pathParam(0)).isEqualTo("container_id")
        assertThat(params._pathParam(1)).isEqualTo("file_id")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
