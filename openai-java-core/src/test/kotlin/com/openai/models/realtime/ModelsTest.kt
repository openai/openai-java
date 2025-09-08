// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ModelsTest {

    @Test
    fun create() {
        val models =
            Models.builder()
                .description("description")
                .name("name")
                .parameters(JsonValue.from(mapOf<String, Any>()))
                .type(Models.Type.FUNCTION)
                .build()

        assertThat(models.description()).contains("description")
        assertThat(models.name()).contains("name")
        assertThat(models._parameters()).isEqualTo(JsonValue.from(mapOf<String, Any>()))
        assertThat(models.type()).contains(Models.Type.FUNCTION)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val models =
            Models.builder()
                .description("description")
                .name("name")
                .parameters(JsonValue.from(mapOf<String, Any>()))
                .type(Models.Type.FUNCTION)
                .build()

        val roundtrippedModels =
            jsonMapper.readValue(jsonMapper.writeValueAsString(models), jacksonTypeRef<Models>())

        assertThat(roundtrippedModels).isEqualTo(models)
    }
}
