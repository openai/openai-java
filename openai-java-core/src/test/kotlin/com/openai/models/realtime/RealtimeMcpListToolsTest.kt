// File generated from our OpenAPI spec by Stainless.

package com.openai.models.realtime

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RealtimeMcpListToolsTest {

    @Test
    fun create() {
        val realtimeMcpListTools =
            RealtimeMcpListTools.builder()
                .serverLabel("server_label")
                .addTool(
                    RealtimeMcpListTools.Tool.builder()
                        .inputSchema(JsonValue.from(mapOf<String, Any>()))
                        .name("name")
                        .annotations(JsonValue.from(mapOf<String, Any>()))
                        .description("description")
                        .build()
                )
                .id("id")
                .build()

        assertThat(realtimeMcpListTools.serverLabel()).isEqualTo("server_label")
        assertThat(realtimeMcpListTools.tools())
            .containsExactly(
                RealtimeMcpListTools.Tool.builder()
                    .inputSchema(JsonValue.from(mapOf<String, Any>()))
                    .name("name")
                    .annotations(JsonValue.from(mapOf<String, Any>()))
                    .description("description")
                    .build()
            )
        assertThat(realtimeMcpListTools.id()).contains("id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val realtimeMcpListTools =
            RealtimeMcpListTools.builder()
                .serverLabel("server_label")
                .addTool(
                    RealtimeMcpListTools.Tool.builder()
                        .inputSchema(JsonValue.from(mapOf<String, Any>()))
                        .name("name")
                        .annotations(JsonValue.from(mapOf<String, Any>()))
                        .description("description")
                        .build()
                )
                .id("id")
                .build()

        val roundtrippedRealtimeMcpListTools =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(realtimeMcpListTools),
                jacksonTypeRef<RealtimeMcpListTools>(),
            )

        assertThat(roundtrippedRealtimeMcpListTools).isEqualTo(realtimeMcpListTools)
    }
}
