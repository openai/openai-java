// File generated from our OpenAPI spec by Stainless.

package com.openai.models.vectorstores.files

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class FileContentResponseTest {

    @Test
    fun createFileContentResponse() {
        val fileContentResponse = FileContentResponse.builder().text("text").type("type").build()
        assertThat(fileContentResponse).isNotNull
        assertThat(fileContentResponse.text()).contains("text")
        assertThat(fileContentResponse.type()).contains("type")
    }
}
