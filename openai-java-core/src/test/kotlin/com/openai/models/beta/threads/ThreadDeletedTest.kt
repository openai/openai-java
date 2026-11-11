// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ThreadDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val threadDeleted = ThreadDeleted.builder().id("id").deleted(true).build()

        assertThat(threadDeleted.id()).contains("id")
        assertThat(threadDeleted.deleted()).contains(true)

        val jsonMapper = jsonMapper()

        val roundtrippedThreadDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(threadDeleted),
                jacksonTypeRef<ThreadDeleted>(),
            )

        assertThat(roundtrippedThreadDeleted).isEqualTo(threadDeleted)
    }
}
