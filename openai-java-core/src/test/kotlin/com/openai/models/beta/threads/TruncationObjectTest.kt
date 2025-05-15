// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.threads

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class TruncationObjectTest {

    @Test
    fun create() {
        val truncationObject =
            TruncationObject.builder().type(TruncationObject.Type.AUTO).lastMessages(1L).build()

        assertThat(truncationObject.type()).isEqualTo(TruncationObject.Type.AUTO)
        assertThat(truncationObject.lastMessages()).contains(1L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val truncationObject =
            TruncationObject.builder().type(TruncationObject.Type.AUTO).lastMessages(1L).build()

        val roundtrippedTruncationObject =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(truncationObject),
                jacksonTypeRef<TruncationObject>(),
            )

        assertThat(roundtrippedTruncationObject).isEqualTo(truncationObject)
    }
}
