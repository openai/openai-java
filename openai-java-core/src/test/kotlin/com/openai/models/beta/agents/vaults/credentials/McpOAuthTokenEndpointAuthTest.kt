// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class McpOAuthTokenEndpointAuthTest {

    @Test
    fun ofNone() {
        val mcpOAuthTokenEndpointAuth = McpOAuthTokenEndpointAuth.ofNone()

        assertThat(mcpOAuthTokenEndpointAuth.none())
            .contains(JsonValue.from(mapOf("type" to "none")))
        assertThat(mcpOAuthTokenEndpointAuth.clientSecretBasic()).isEmpty
        assertThat(mcpOAuthTokenEndpointAuth.clientSecretPost()).isEmpty
    }

    @Test
    fun ofNoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpOAuthTokenEndpointAuth = McpOAuthTokenEndpointAuth.ofNone()

        val roundtrippedMcpOAuthTokenEndpointAuth =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpOAuthTokenEndpointAuth),
                jacksonTypeRef<McpOAuthTokenEndpointAuth>(),
            )

        assertThat(roundtrippedMcpOAuthTokenEndpointAuth).isEqualTo(mcpOAuthTokenEndpointAuth)
    }

    @Test
    fun ofClientSecretBasic() {
        val mcpOAuthTokenEndpointAuth = McpOAuthTokenEndpointAuth.ofClientSecretBasic()

        assertThat(mcpOAuthTokenEndpointAuth.none()).isEmpty
        assertThat(mcpOAuthTokenEndpointAuth.clientSecretBasic())
            .contains(JsonValue.from(mapOf("type" to "client_secret_basic")))
        assertThat(mcpOAuthTokenEndpointAuth.clientSecretPost()).isEmpty
    }

    @Test
    fun ofClientSecretBasicRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpOAuthTokenEndpointAuth = McpOAuthTokenEndpointAuth.ofClientSecretBasic()

        val roundtrippedMcpOAuthTokenEndpointAuth =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpOAuthTokenEndpointAuth),
                jacksonTypeRef<McpOAuthTokenEndpointAuth>(),
            )

        assertThat(roundtrippedMcpOAuthTokenEndpointAuth).isEqualTo(mcpOAuthTokenEndpointAuth)
    }

    @Test
    fun ofClientSecretPost() {
        val mcpOAuthTokenEndpointAuth = McpOAuthTokenEndpointAuth.ofClientSecretPost()

        assertThat(mcpOAuthTokenEndpointAuth.none()).isEmpty
        assertThat(mcpOAuthTokenEndpointAuth.clientSecretBasic()).isEmpty
        assertThat(mcpOAuthTokenEndpointAuth.clientSecretPost())
            .contains(JsonValue.from(mapOf("type" to "client_secret_post")))
    }

    @Test
    fun ofClientSecretPostRoundtrip() {
        val jsonMapper = jsonMapper()
        val mcpOAuthTokenEndpointAuth = McpOAuthTokenEndpointAuth.ofClientSecretPost()

        val roundtrippedMcpOAuthTokenEndpointAuth =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(mcpOAuthTokenEndpointAuth),
                jacksonTypeRef<McpOAuthTokenEndpointAuth>(),
            )

        assertThat(roundtrippedMcpOAuthTokenEndpointAuth).isEqualTo(mcpOAuthTokenEndpointAuth)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val mcpOAuthTokenEndpointAuth =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<McpOAuthTokenEndpointAuth>())

        val e = assertThrows<OpenAIInvalidDataException> { mcpOAuthTokenEndpointAuth.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
