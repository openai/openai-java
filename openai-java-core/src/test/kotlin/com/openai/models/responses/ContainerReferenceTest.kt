// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerReferenceTest {

    @Test
    fun create() {
        val containerReference = ContainerReference.builder().containerId("cntr_123").build()

        assertThat(containerReference.containerId()).isEqualTo("cntr_123")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val containerReference = ContainerReference.builder().containerId("cntr_123").build()

        val roundtrippedContainerReference =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containerReference),
                jacksonTypeRef<ContainerReference>(),
            )

        assertThat(roundtrippedContainerReference).isEqualTo(containerReference)
    }
}
