// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults.credentials

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonMissing
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.junit.jupiter.params.provider.ValueSource

internal class CredentialAuthCreateParamTest {

    @ParameterizedTest
    @ValueSource(
        strings =
            ["{\"token\":\"fake-malformed-secret\"}", "[\"fake-malformed-secret\"]", "123", "true"]
    )
    fun environmentVariableValidationRedactsMalformedSecret(secretJson: String) {
        val mapper = jsonMapper()
        val raw = mapper.readValue(secretJson, jacksonTypeRef<JsonValue>())
        val original =
            CredentialAuthCreateParam.EnvironmentVariable.builder()
                .networkingUnrestricted()
                .secretName("SDK_TEST_KEY")
                .secretValue(raw)
                .build()
        val serialized =
            mapper.writeValueAsString(CredentialAuthCreateParam.ofEnvironmentVariable(original))
        val auth = mapper.readValue(serialized, jacksonTypeRef<CredentialAuthCreateParam>())
        val params =
            CredentialCreateParams.builder()
                .vaultId("vault_test")
                .name("Test credential")
                .auth(auth)
                .build()

        for (environmentVariable in listOf(original, auth.asEnvironmentVariable())) {
            val accessorError =
                assertThrows<OpenAIInvalidDataException> { environmentVariable.secretValue() }
            val validationError =
                assertThrows<OpenAIInvalidDataException> { environmentVariable.validate() }
            for (error in listOf(accessorError, validationError)) {
                assertThat(error)
                    .hasMessage("`secret_value` is invalid, received [REDACTED]")
                    .hasNoCause()
            }
            assertThat(environmentVariable._secretValue()).isEqualTo(raw)
            assertThat(environmentVariable.isValid()).isFalse()
        }
        for (error in
            listOf(
                assertThrows<OpenAIInvalidDataException> { auth.validate() },
                assertThrows<OpenAIInvalidDataException> { params._body().validate() },
            )) {
            assertThat(error)
                .hasMessage("`secret_value` is invalid, received [REDACTED]")
                .hasNoCause()
        }
        assertThat(mapper.readTree(mapper.writeValueAsString(auth)))
            .isEqualTo(mapper.readTree(serialized))
    }

    @ParameterizedTest
    @ValueSource(booleans = [false, true])
    fun environmentVariablePreservesMissingAndNullSecretDiagnostics(isNull: Boolean) {
        val raw = if (isNull) JsonValue.from(null) else JsonMissing.of()
        val environmentVariable =
            CredentialAuthCreateParam.EnvironmentVariable.builder()
                .networkingUnrestricted()
                .secretName("SDK_TEST_KEY")
                .secretValue(raw)
                .build()
        val expected = if (isNull) "`secret_value` is null" else "`secret_value` is not set"

        assertThat(assertThrows<OpenAIInvalidDataException> { environmentVariable.secretValue() })
            .hasMessage(expected)
            .hasNoCause()
        assertThat(assertThrows<OpenAIInvalidDataException> { environmentVariable.validate() })
            .hasMessage(expected)
            .hasNoCause()
        assertThat(environmentVariable._secretValue()).isEqualTo(raw)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", "future_environment_variable"])
    fun unknownStringsRedactSecretWithoutChangingSerialization(type: String) {
        val secret = "fake-unknown-environment-secret"
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
        val auth = mapper.readValue(original, jacksonTypeRef<CredentialAuthCreateParam>())
        val params =
            CredentialCreateParams.builder()
                .vaultId("vault_test")
                .name("Test credential")
                .auth(auth)
                .build()

        assertThat(auth.environmentVariable()).isEmpty
        for (value in listOf(auth, params)) {
            assertThat(value.toString())
                .doesNotContain(secret)
                .contains("[REDACTED]", "future_field", "preserved")
        }
        assertThat(auth._json()).contains(raw)
        assertThat(params._body().auth()._json()).contains(raw)
        assertThat(mapper.readTree(mapper.writeValueAsString(auth)))
            .isEqualTo(mapper.readTree(original))
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "\"fake-additional-secret\"",
                "{\"token\":\"fake-additional-secret\"}",
                "[\"fake-additional-secret\"]",
            ]
    )
    fun environmentVariableStringsRedactAdditionalSecretWithoutChangingSerialization(
        secretJson: String
    ) {
        val mapper = jsonMapper()
        val raw = mapper.readValue(secretJson, jacksonTypeRef<JsonValue>())
        val secret = "fake-typed-secret"
        val environmentVariable =
            CredentialAuthCreateParam.EnvironmentVariable.builder()
                .networkingUnrestricted()
                .secretName("SDK_TEST_KEY")
                .secretValue(secret)
                .putAdditionalProperty("secret_value", raw)
                .putAdditionalProperty("future_field", JsonValue.from("preserved"))
                .build()
        val auth = CredentialAuthCreateParam.ofEnvironmentVariable(environmentVariable)
        val params =
            CredentialCreateParams.builder()
                .vaultId("vault_test")
                .name("Test credential")
                .auth(auth)
                .build()
        val serialized = mapper.writeValueAsString(auth)

        for (value in listOf(environmentVariable, auth, params)) {
            assertThat(value.toString())
                .doesNotContain(secret, "fake-additional-secret")
                .contains(
                    "secretValue=[REDACTED]",
                    "secret_value",
                    "[REDACTED]",
                    "future_field",
                    "preserved",
                )
        }
        assertThat(environmentVariable.secretValue()).isEqualTo(secret)
        assertThat(environmentVariable._additionalProperties()["secret_value"]).isEqualTo(raw)
        assertThat(params._body().auth().asEnvironmentVariable()).isEqualTo(environmentVariable)
        assertThat(mapper.writeValueAsString(auth)).isEqualTo(serialized)
        assertThat(serialized).contains(secret, "fake-additional-secret")
        assertThat(mapper.readTree(serialized).get("secret_value"))
            .isEqualTo(mapper.readTree(secretJson))
    }

    @Test
    fun environmentVariableStringsRedactSecretWithoutChangingSerialization() {
        val secret = "fake-environment-secret-do-not-log"
        val environmentVariable =
            CredentialAuthCreateParam.EnvironmentVariable.builder()
                .networkingUnrestricted()
                .secretName("SDK_TEST_KEY")
                .secretValue(secret)
                .build()
        val auth = CredentialAuthCreateParam.ofEnvironmentVariable(environmentVariable)
        val params =
            CredentialCreateParams.builder()
                .vaultId("vault_test")
                .name("Test credential")
                .auth(auth)
                .build()

        for (value in listOf(environmentVariable, auth, params)) {
            assertThat(value.toString()).doesNotContain(secret).contains("secretValue=[REDACTED]")
        }
        assertThat(environmentVariable.secretValue()).isEqualTo(secret)
        val mapper = jsonMapper()
        assertThat(mapper.readTree(mapper.writeValueAsString(auth)).get("secret_value").asText())
            .isEqualTo(secret)
        assertThat(params._body().auth().asEnvironmentVariable().secretValue()).isEqualTo(secret)
    }

    @Test
    fun ofMcpOAuth() {
        val mcpOauth =
            CredentialAuthCreateParam.McpOAuth.builder()
                .accessToken("access_token")
                .mcpServerUrl("mcp_server_url")
                .expiresAt("expires_at")
                .refresh(
                    CredentialAuthCreateParam.McpOAuth.Refresh.builder()
                        .clientId("client_id")
                        .refreshToken("refresh_token")
                        .tokenEndpoint("token_endpoint")
                        .tokenEndpointAuthNone()
                        .resource("resource")
                        .scope("scope")
                        .build()
                )
                .build()

        val credentialAuthCreateParam = CredentialAuthCreateParam.ofMcpOAuth(mcpOauth)

        assertThat(credentialAuthCreateParam.mcpOauth()).contains(mcpOauth)
        assertThat(credentialAuthCreateParam.staticBearer()).isEmpty
        assertThat(credentialAuthCreateParam.environmentVariable()).isEmpty
    }

    @Test
    fun ofMcpOAuthRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuthCreateParam =
            CredentialAuthCreateParam.ofMcpOAuth(
                CredentialAuthCreateParam.McpOAuth.builder()
                    .accessToken("access_token")
                    .mcpServerUrl("mcp_server_url")
                    .expiresAt("expires_at")
                    .refresh(
                        CredentialAuthCreateParam.McpOAuth.Refresh.builder()
                            .clientId("client_id")
                            .refreshToken("refresh_token")
                            .tokenEndpoint("token_endpoint")
                            .tokenEndpointAuthNone()
                            .resource("resource")
                            .scope("scope")
                            .build()
                    )
                    .build()
            )

        val roundtrippedCredentialAuthCreateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuthCreateParam),
                jacksonTypeRef<CredentialAuthCreateParam>(),
            )

        assertThat(roundtrippedCredentialAuthCreateParam).isEqualTo(credentialAuthCreateParam)
    }

    @Test
    fun ofStaticBearer() {
        val staticBearer =
            CredentialAuthCreateParam.StaticBearer.builder()
                .token("token")
                .mcpServerUrl("mcp_server_url")
                .build()

        val credentialAuthCreateParam = CredentialAuthCreateParam.ofStaticBearer(staticBearer)

        assertThat(credentialAuthCreateParam.mcpOauth()).isEmpty
        assertThat(credentialAuthCreateParam.staticBearer()).contains(staticBearer)
        assertThat(credentialAuthCreateParam.environmentVariable()).isEmpty
    }

    @Test
    fun ofStaticBearerRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuthCreateParam =
            CredentialAuthCreateParam.ofStaticBearer(
                CredentialAuthCreateParam.StaticBearer.builder()
                    .token("token")
                    .mcpServerUrl("mcp_server_url")
                    .build()
            )

        val roundtrippedCredentialAuthCreateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuthCreateParam),
                jacksonTypeRef<CredentialAuthCreateParam>(),
            )

        assertThat(roundtrippedCredentialAuthCreateParam).isEqualTo(credentialAuthCreateParam)
    }

    @Test
    fun ofEnvironmentVariable() {
        val environmentVariable =
            CredentialAuthCreateParam.EnvironmentVariable.builder()
                .networkingUnrestricted()
                .secretName("x")
                .secretValue("x")
                .build()

        val credentialAuthCreateParam =
            CredentialAuthCreateParam.ofEnvironmentVariable(environmentVariable)

        assertThat(credentialAuthCreateParam.mcpOauth()).isEmpty
        assertThat(credentialAuthCreateParam.staticBearer()).isEmpty
        assertThat(credentialAuthCreateParam.environmentVariable()).contains(environmentVariable)
    }

    @Test
    fun ofEnvironmentVariableRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuthCreateParam =
            CredentialAuthCreateParam.ofEnvironmentVariable(
                CredentialAuthCreateParam.EnvironmentVariable.builder()
                    .networkingUnrestricted()
                    .secretName("x")
                    .secretValue("x")
                    .build()
            )

        val roundtrippedCredentialAuthCreateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuthCreateParam),
                jacksonTypeRef<CredentialAuthCreateParam>(),
            )

        assertThat(roundtrippedCredentialAuthCreateParam).isEqualTo(credentialAuthCreateParam)
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
        val credentialAuthCreateParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<CredentialAuthCreateParam>())

        val e = assertThrows<OpenAIInvalidDataException> { credentialAuthCreateParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
