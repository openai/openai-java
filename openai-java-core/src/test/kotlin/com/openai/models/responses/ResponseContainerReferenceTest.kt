// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ResponseContainerReferenceTest {

    @Test
    fun createAndRoundtrip() {
        val responseContainerReference =
            ResponseContainerReference.builder().containerId("container_id").build()

        assertThat(responseContainerReference.containerId()).isEqualTo("container_id")

        val jsonMapper = jsonMapper()

        val roundtrippedResponseContainerReference =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(responseContainerReference),
                jacksonTypeRef<ResponseContainerReference>(),
            )

        assertThat(roundtrippedResponseContainerReference).isEqualTo(responseContainerReference)
    }
}
