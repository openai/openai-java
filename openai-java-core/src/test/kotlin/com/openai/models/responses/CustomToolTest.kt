// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import com.openai.models.CustomToolInputFormat
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class CustomToolTest {

    @Test
    fun create() {
        val customTool =
            CustomTool.builder()
                .name("name")
                .addAllowedCaller(CustomTool.AllowedCaller.DIRECT)
                .deferLoading(true)
                .description("description")
                .formatText()
                .build()

        assertThat(customTool.name()).isEqualTo("name")
        assertThat(customTool.allowedCallers().getOrNull())
            .containsExactly(CustomTool.AllowedCaller.DIRECT)
        assertThat(customTool.deferLoading()).contains(true)
        assertThat(customTool.description()).contains("description")
        assertThat(customTool.format()).contains(CustomToolInputFormat.ofText())
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val customTool =
            CustomTool.builder()
                .name("name")
                .addAllowedCaller(CustomTool.AllowedCaller.DIRECT)
                .deferLoading(true)
                .description("description")
                .formatText()
                .build()

        val roundtrippedCustomTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(customTool),
                jacksonTypeRef<CustomTool>(),
            )

        assertThat(roundtrippedCustomTool).isEqualTo(customTool)
    }
}
