// File generated from our OpenAPI spec by Stainless.

package com.openai.models.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelDeletedTest {

    @Test
    fun create() {
        val modelDeleted = ModelDeleted.builder().id("id").deleted(true).object_("object").build()

        assertThat(modelDeleted.id()).isEqualTo("id")
        assertThat(modelDeleted.deleted()).isEqualTo(true)
        assertThat(modelDeleted.object_()).isEqualTo("object")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val modelDeleted = ModelDeleted.builder().id("id").deleted(true).object_("object").build()

        val roundtrippedModelDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(modelDeleted),
                jacksonTypeRef<ModelDeleted>(),
            )

        assertThat(roundtrippedModelDeleted).isEqualTo(modelDeleted)
    }
}
