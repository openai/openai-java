// File generated from our OpenAPI spec by Stainless.

package com.openai.models.conversations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerFileCitationBodyTest {

    @Test
    fun create() {
        val containerFileCitationBody =
            ContainerFileCitationBody.builder()
                .containerId("container_id")
                .endIndex(0L)
                .fileId("file_id")
                .filename("filename")
                .startIndex(0L)
                .build()

        assertThat(containerFileCitationBody.containerId()).isEqualTo("container_id")
        assertThat(containerFileCitationBody.endIndex()).isEqualTo(0L)
        assertThat(containerFileCitationBody.fileId()).isEqualTo("file_id")
        assertThat(containerFileCitationBody.filename()).isEqualTo("filename")
        assertThat(containerFileCitationBody.startIndex()).isEqualTo(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val containerFileCitationBody =
            ContainerFileCitationBody.builder()
                .containerId("container_id")
                .endIndex(0L)
                .fileId("file_id")
                .filename("filename")
                .startIndex(0L)
                .build()

        val roundtrippedContainerFileCitationBody =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containerFileCitationBody),
                jacksonTypeRef<ContainerFileCitationBody>(),
            )

        assertThat(roundtrippedContainerFileCitationBody).isEqualTo(containerFileCitationBody)
    }
}
