package com.openai.helpers

import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.vaults.credentials.CredentialAuthCreateParam
import com.openai.models.beta.agents.vaults.credentials.CredentialAuthRotateParam
import com.openai.models.beta.agents.vaults.credentials.McpOAuthTokenEndpointAuthCreateParam
import com.openai.models.beta.agents.vaults.credentials.McpOAuthTokenEndpointAuthRotateParam
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CredentialVisitorDiagnosticsTest {

    @ParameterizedTest
    @ValueSource(strings = ["static_bearer", "mcp_oauth", "environment_variable", "future_auth"])
    fun credentialFallbackPreservesDataWithoutIncludingItInDefaultErrors(type: String) {
        val json =
            """{"type":"$type","token":"fake-bearer","access_token":"fake-access","mcp_server_url":"https://example.invalid","secret_name":"TEST_KEY","secret_value":"fake-environment","networking":{"type":"unrestricted"},"refresh":{"client_id":"test-client","refresh_token":"fake-refresh","token_endpoint":"https://example.invalid/token","token_endpoint_auth":{"type":"client_secret_basic","client_secret":"fake-client"}},"future_field":"fake-future-secret"}"""
        val mapper = jsonMapper()
        val create = mapper.readValue(json, CredentialAuthCreateParam::class.java)
        val rotate = mapper.readValue(json, CredentialAuthRotateParam::class.java)
        assertThat(create.isValid()).isEqualTo(type != "future_auth")
        assertThat(rotate.isValid()).isEqualTo(type != "future_auth")
        checkFallback(
            create,
            "CredentialAuthCreateParam",
            { create.accept(object : CredentialAuthCreateParam.Visitor<JsonValue?> {}) },
            {
                create.accept(
                    object : CredentialAuthCreateParam.Visitor<JsonValue?> {
                        override fun unknown(json: JsonValue?): JsonValue? = json
                    }
                )
            },
        )
        checkFallback(
            rotate,
            "CredentialAuthRotateParam",
            { rotate.accept(object : CredentialAuthRotateParam.Visitor<JsonValue?> {}) },
            {
                rotate.accept(
                    object : CredentialAuthRotateParam.Visitor<JsonValue?> {
                        override fun unknown(json: JsonValue?): JsonValue? = json
                    }
                )
            },
        )
    }

    @ParameterizedTest
    @ValueSource(strings = ["client_secret_basic", "client_secret_post", "future_auth"])
    fun tokenEndpointFallbackPreservesDataWithoutIncludingItInDefaultErrors(type: String) {
        val json =
            """{"type":"$type","client_secret":"fake-client-secret","future_field":"fake-future-secret"}"""
        val mapper = jsonMapper()
        val create = mapper.readValue(json, McpOAuthTokenEndpointAuthCreateParam::class.java)
        val rotate = mapper.readValue(json, McpOAuthTokenEndpointAuthRotateParam::class.java)
        assertThat(create.isValid()).isEqualTo(type != "future_auth")
        assertThat(rotate.isValid()).isEqualTo(type != "future_auth")
        checkFallback(
            create,
            "McpOAuthTokenEndpointAuthCreateParam",
            { create.accept(object : McpOAuthTokenEndpointAuthCreateParam.Visitor<JsonValue?> {}) },
            {
                create.accept(
                    object : McpOAuthTokenEndpointAuthCreateParam.Visitor<JsonValue?> {
                        override fun unknown(json: JsonValue?): JsonValue? = json
                    }
                )
            },
        )
        checkFallback(
            rotate,
            "McpOAuthTokenEndpointAuthRotateParam",
            { rotate.accept(object : McpOAuthTokenEndpointAuthRotateParam.Visitor<JsonValue?> {}) },
            {
                rotate.accept(
                    object : McpOAuthTokenEndpointAuthRotateParam.Visitor<JsonValue?> {
                        override fun unknown(json: JsonValue?): JsonValue? = json
                    }
                )
            },
        )
    }

    private fun checkFallback(
        auth: Any,
        name: String,
        defaultVisitor: () -> JsonValue?,
        customVisitor: () -> JsonValue?,
    ) {
        val mapper = jsonMapper()
        val original = mapper.readTree(mapper.writeValueAsString(auth))
        assertThat(assertThrows<OpenAIInvalidDataException> { defaultVisitor() })
            .hasMessage("Unknown $name: [REDACTED]")
            .hasNoCause()
        assertThat(mapper.readTree(mapper.writeValueAsString(customVisitor()))).isEqualTo(original)
        assertThat(mapper.readTree(mapper.writeValueAsString(auth))).isEqualTo(original)
    }
}
