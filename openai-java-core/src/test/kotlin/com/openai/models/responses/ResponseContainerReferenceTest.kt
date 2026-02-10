// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseContainerReferenceTest {

    @Test
    fun create() {
        val responseContainerReference =
            ResponseContainerReference.builder().containerId("container_id").build()

        assertThat(responseContainerReference.containerId()).isEqualTo("container_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val responseContainerReference =
            ResponseContainerReference.builder().containerId("container_id").build()

        val roundtrippedResponseContainerReference =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseContainerReference),
                jacksonTypeRef<ResponseContainerReference>(),
            )

        assertThat(roundtrippedResponseContainerReference).isEqualTo(responseContainerReference)
    }
}
