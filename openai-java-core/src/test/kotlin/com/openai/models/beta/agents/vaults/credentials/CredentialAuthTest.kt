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
import org.junit.jupiter.params.provider.ValueSource

internal class CredentialAuthTest {

    @ParameterizedTest
    @ValueSource(strings = ["", "future_environment_variable"])
    fun unknownStringsRedactSecretWithoutChangingSerialization(type: String) {
        val secret = "fake-unknown-response-secret"
        val fields =
            mutableMapOf(
                "secret_value" to JsonValue.from(secret),
                "future_field" to JsonValue.from("preserved"),
            )
        if (type.isNotEmpty()) {
            fields["type"] = JsonValue.from(type)
        }
        val raw = JsonValue.from(fields)
        val mapper = jsonMapper()
        val original = mapper.writeValueAsString(raw)
        val auth = mapper.readValue(original, jacksonTypeRef<CredentialAuth>())
        val credential =
            Credential.builder()
                .id("credential_test")
                .auth(auth)
                .createdAt(0L)
                .name("Test credential")
                .updatedAt(0L)
                .vaultId("vault_test")
                .build()

        assertThat(auth.environmentVariable()).isEmpty
        for (value in listOf(auth, credential)) {
            assertThat(value.toString())
                .doesNotContain(secret)
                .contains("[REDACTED]", "future_field", "preserved")
        }
        val error = assertThrows<OpenAIInvalidDataException> { auth.validate() }
        assertThat(error).hasNoCause()
        assertThat(error.message)
            .doesNotContain(secret)
            .contains("[REDACTED]", "future_field", "preserved")
        assertThat(auth._json()).contains(raw)
        assertThat(credential.auth()._json()).contains(raw)
        assertThat(mapper.readTree(mapper.writeValueAsString(auth)))
            .isEqualTo(mapper.readTree(original))
    }

    @ParameterizedTest
    @ValueSource(strings = ["{}", "{\"type\":\"future\",\"future_field\":\"preserved\"}"])
    fun unknownDiagnosticsWithoutSecretAreUnchanged(json: String) {
        val mapper = jsonMapper()
        val raw = mapper.readValue(json, jacksonTypeRef<JsonValue>())
        val auth = mapper.readValue(json, jacksonTypeRef<CredentialAuth>())

        assertThat(auth.toString()).isEqualTo("CredentialAuth{_unknown=$raw}")
        assertThat(assertThrows<OpenAIInvalidDataException> { auth.validate() })
            .hasMessage("Unknown CredentialAuth: $raw")
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "\"fake-response-secret\"",
                "{\"token\":\"fake-response-secret\"}",
                "[\"fake-response-secret\"]",
            ]
    )
    fun environmentVariableStringsRedactUnexpectedSecretWithoutChangingSerialization(
        secretJson: String
    ) {
        val mapper = jsonMapper()
        val raw = mapper.readValue(secretJson, jacksonTypeRef<JsonValue>())
        val original =
            CredentialAuth.EnvironmentVariable.builder()
                .networkingUnrestricted()
                .secretName("SDK_TEST_KEY")
                .putAdditionalProperty("secret_value", raw)
                .putAdditionalProperty("future_field", JsonValue.from("preserved"))
                .build()
        val serialized = mapper.writeValueAsString(CredentialAuth.ofEnvironmentVariable(original))
        val auth = mapper.readValue(serialized, jacksonTypeRef<CredentialAuth>())
        val environmentVariable = auth.asEnvironmentVariable()
        val credential =
            Credential.builder()
                .id("credential_test")
                .auth(auth)
                .createdAt(0L)
                .name("Test credential")
                .updatedAt(0L)
                .vaultId("vault_test")
                .build()

        for (value in listOf(original, environmentVariable, auth, credential)) {
            assertThat(value.toString())
                .doesNotContain("fake-response-secret")
                .contains("secret_value", "[REDACTED]", "future_field", "preserved")
        }
        assertThat(environmentVariable._additionalProperties()["secret_value"]).isEqualTo(raw)
        assertThat(original._additionalProperties()["secret_value"]).isEqualTo(raw)
        assertThat(environmentVariable).isEqualTo(original)
        assertThat(mapper.readTree(mapper.writeValueAsString(auth)))
            .isEqualTo(mapper.readTree(serialized))
    }

    @Test
    fun environmentVariableStringsPreserveAdditionalPropertiesWithoutSecret() {
        val environmentVariable =
            CredentialAuth.EnvironmentVariable.builder()
                .networkingUnrestricted()
                .secretName("SDK_TEST_KEY")
                .putAdditionalProperty("future_field", JsonValue.from("preserved"))
                .build()

        assertThat(environmentVariable.toString())
            .contains("future_field", "preserved")
            .doesNotContain("secret_value", "[REDACTED]")
        assertThat(environmentVariable._additionalProperties())
            .containsExactlyEntriesOf(mapOf("future_field" to JsonValue.from("preserved")))
    }

    @Test
    fun ofMcpO() {
        val mcpO =
            CredentialAuth.McpOAuth.builder()
                .expiresAt("expires_at")
                .mcpServerUrl("mcp_server_url")
                .refresh(
                    CredentialAuth.McpOAuth.Refresh.builder()
                        .clientId("client_id")
                        .resource("resource")
                        .scope("scope")
                        .tokenEndpoint("token_endpoint")
                        .tokenEndpointAuthNone()
                        .build()
                )
                .build()

        val credentialAuth = CredentialAuth.ofMcpO(mcpO)

        assertThat(credentialAuth.mcpO()).contains(mcpO)
        assertThat(credentialAuth.staticBearer()).isEmpty
        assertThat(credentialAuth.environmentVariable()).isEmpty
    }

    @Test
    fun ofMcpORoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuth =
            CredentialAuth.ofMcpO(
                CredentialAuth.McpOAuth.builder()
                    .expiresAt("expires_at")
                    .mcpServerUrl("mcp_server_url")
                    .refresh(
                        CredentialAuth.McpOAuth.Refresh.builder()
                            .clientId("client_id")
                            .resource("resource")
                            .scope("scope")
                            .tokenEndpoint("token_endpoint")
                            .tokenEndpointAuthNone()
                            .build()
                    )
                    .build()
            )

        val roundtrippedCredentialAuth =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuth),
                jacksonTypeRef<CredentialAuth>(),
            )

        assertThat(roundtrippedCredentialAuth).isEqualTo(credentialAuth)
    }

    @Test
    fun ofStaticBearer() {
        val staticBearer =
            CredentialAuth.StaticBearer.builder().mcpServerUrl("mcp_server_url").build()

        val credentialAuth = CredentialAuth.ofStaticBearer(staticBearer)

        assertThat(credentialAuth.mcpO()).isEmpty
        assertThat(credentialAuth.staticBearer()).contains(staticBearer)
        assertThat(credentialAuth.environmentVariable()).isEmpty
    }

    @Test
    fun ofStaticBearerRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuth =
            CredentialAuth.ofStaticBearer(
                CredentialAuth.StaticBearer.builder().mcpServerUrl("mcp_server_url").build()
            )

        val roundtrippedCredentialAuth =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuth),
                jacksonTypeRef<CredentialAuth>(),
            )

        assertThat(roundtrippedCredentialAuth).isEqualTo(credentialAuth)
    }

    @Test
    fun ofEnvironmentVariable() {
        val environmentVariable =
            CredentialAuth.EnvironmentVariable.builder()
                .networkingUnrestricted()
                .secretName("secret_name")
                .build()

        val credentialAuth = CredentialAuth.ofEnvironmentVariable(environmentVariable)

        assertThat(credentialAuth.mcpO()).isEmpty
        assertThat(credentialAuth.staticBearer()).isEmpty
        assertThat(credentialAuth.environmentVariable()).contains(environmentVariable)
    }

    @Test
    fun ofEnvironmentVariableRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuth =
            CredentialAuth.ofEnvironmentVariable(
                CredentialAuth.EnvironmentVariable.builder()
                    .networkingUnrestricted()
                    .secretName("secret_name")
                    .build()
            )

        val roundtrippedCredentialAuth =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuth),
                jacksonTypeRef<CredentialAuth>(),
            )

        assertThat(roundtrippedCredentialAuth).isEqualTo(credentialAuth)
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
        val credentialAuth =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<CredentialAuth>())

        val e = assertThrows<OpenAIInvalidDataException> { credentialAuth.validate() }
        assertThat(e).hasMessage("Unknown CredentialAuth: ${testCase.value}")
        assertThat(credentialAuth.toString())
            .isEqualTo("CredentialAuth{_unknown=${testCase.value}}")
    }
}
