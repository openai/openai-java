package com.openai.models.live

import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class LiveMcpDiagnosticRedactionTest {
    @Test
    fun typedCredentialsAreRedactedInDiagnosticsAndPreservedOnTheWire() {
        val authorization = "fake-mcp-token"
        val authorizationHeader = "Bearer fake-mcp-header-token"
        val cookie = "session=fake-mcp-cookie"
        val headers =
            McpTool.Headers.builder()
                .putAdditionalProperty("Authorization", JsonValue.from(authorizationHeader))
                .putAdditionalProperty("Cookie", JsonValue.from(cookie))
                .build()
        val tool =
            McpTool.builder()
                .serverLabel("lookup")
                .authorization(authorization)
                .headers(headers)
                .build()
        val create = ResponsesDelegationConfig.builder().model("test-model").addTool(tool).build()
        val update = ResponsesDelegationUpdateConfig.builder().addTool(tool).build()

        assertThat(headers.toString()).doesNotContain(authorizationHeader, cookie)
        for (value in listOf(tool, create, update)) {
            assertThat(value.toString())
                .doesNotContain(authorization, authorizationHeader, cookie)
                .contains("lookup")
        }

        val mapper = jsonMapper()
        val wireTool = mapper.readTree(mapper.writeValueAsString(tool))
        assertThat(wireTool.path("authorization").asText()).isEqualTo(authorization)
        assertThat(wireTool.path("headers").path("Authorization").asText())
            .isEqualTo(authorizationHeader)
        assertThat(wireTool.path("headers").path("Cookie").asText()).isEqualTo(cookie)
        for (config in listOf(create, update)) {
            val wireConfig = mapper.readTree(mapper.writeValueAsString(config))
            assertThat(wireConfig.path("tools").path(0)).isEqualTo(wireTool)
        }
    }

    @Test
    fun legacyAdditionalPropertiesAreRedactedInDiagnosticsAndPreservedOnTheWire() {
        val authorization = "fake-legacy-mcp-token"
        val cookie = "session=fake-legacy-mcp-cookie"
        val tool =
            McpTool.builder()
                .putAdditionalProperty("authorization", JsonValue.from(authorization))
                .putAdditionalProperty("headers", JsonValue.from(mapOf("Cookie" to cookie)))
                .putAdditionalProperty("future_field", JsonValue.from("preserved"))
                .build()
        val create = ResponsesDelegationConfig.builder().model("test-model").addTool(tool).build()
        val update = ResponsesDelegationUpdateConfig.builder().addTool(tool).build()

        for (value in listOf(tool, create, update)) {
            assertThat(value.toString())
                .doesNotContain(authorization, cookie)
                .contains("future_field", "preserved")
        }

        val mapper = jsonMapper()
        for (config in listOf(create, update)) {
            val wireTool = mapper.readTree(mapper.writeValueAsString(config)).path("tools").path(0)
            assertThat(wireTool.path("authorization").asText()).isEqualTo(authorization)
            assertThat(wireTool.path("headers").path("Cookie").asText()).isEqualTo(cookie)
        }
    }
}
