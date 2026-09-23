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

internal class CredentialAuthRotateParamTest {

    @ParameterizedTest
    @ValueSource(
        strings =
            ["{\"token\":\"fake-malformed-secret\"}", "[\"fake-malformed-secret\"]", "123", "true"]
    )
    fun environmentVariableValidationRedactsMalformedSecret(secretJson: String) {
        val mapper = jsonMapper()
        val raw = mapper.readValue(secretJson, jacksonTypeRef<JsonValue>())
        val original =
            CredentialAuthRotateParam.EnvironmentVariable.builder().secretValue(raw).build()
        val serialized =
            mapper.writeValueAsString(CredentialAuthRotateParam.ofEnvironmentVariable(original))
        val auth = mapper.readValue(serialized, jacksonTypeRef<CredentialAuthRotateParam>())
        val params =
            CredentialUpdateParams.builder()
                .vaultId("vault_test")
                .credentialId("credential_test")
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
            CredentialAuthRotateParam.EnvironmentVariable.builder().secretValue(raw).build()
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
        val auth = mapper.readValue(original, jacksonTypeRef<CredentialAuthRotateParam>())
        val params =
            CredentialUpdateParams.builder()
                .vaultId("vault_test")
                .credentialId("credential_test")
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
            CredentialAuthRotateParam.EnvironmentVariable.builder()
                .secretValue(secret)
                .putAdditionalProperty("secret_value", raw)
                .putAdditionalProperty("future_field", JsonValue.from("preserved"))
                .build()
        val auth = CredentialAuthRotateParam.ofEnvironmentVariable(environmentVariable)
        val params =
            CredentialUpdateParams.builder()
                .vaultId("vault_test")
                .credentialId("credential_test")
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
        val secret = "fake-replacement-secret-do-not-log"
        val environmentVariable =
            CredentialAuthRotateParam.EnvironmentVariable.builder().secretValue(secret).build()
        val auth = CredentialAuthRotateParam.ofEnvironmentVariable(environmentVariable)
        val params =
            CredentialUpdateParams.builder()
                .vaultId("vault_test")
                .credentialId("credential_test")
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
            CredentialAuthRotateParam.McpOAuth.builder()
                .accessToken("access_token")
                .expiresAt("expires_at")
                .refresh(
                    CredentialAuthRotateParam.McpOAuth.Refresh.builder()
                        .refreshToken("refresh_token")
                        .scope("scope")
                        .tokenEndpointAuth(
                            McpOAuthTokenEndpointAuthRotateParam.ClientSecretBasic.builder()
                                .clientSecret("client_secret")
                                .build()
                        )
                        .build()
                )
                .build()

        val credentialAuthRotateParam = CredentialAuthRotateParam.ofMcpOAuth(mcpOauth)

        assertThat(credentialAuthRotateParam.mcpOauth()).contains(mcpOauth)
        assertThat(credentialAuthRotateParam.staticBearer()).isEmpty
        assertThat(credentialAuthRotateParam.environmentVariable()).isEmpty
    }

    @Test
    fun ofMcpOAuthRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuthRotateParam =
            CredentialAuthRotateParam.ofMcpOAuth(
                CredentialAuthRotateParam.McpOAuth.builder()
                    .accessToken("access_token")
                    .expiresAt("expires_at")
                    .refresh(
                        CredentialAuthRotateParam.McpOAuth.Refresh.builder()
                            .refreshToken("refresh_token")
                            .scope("scope")
                            .tokenEndpointAuth(
                                McpOAuthTokenEndpointAuthRotateParam.ClientSecretBasic.builder()
                                    .clientSecret("client_secret")
                                    .build()
                            )
                            .build()
                    )
                    .build()
            )

        val roundtrippedCredentialAuthRotateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuthRotateParam),
                jacksonTypeRef<CredentialAuthRotateParam>(),
            )

        assertThat(roundtrippedCredentialAuthRotateParam).isEqualTo(credentialAuthRotateParam)
    }

    @Test
    fun ofStaticBearer() {
        val staticBearer = CredentialAuthRotateParam.StaticBearer.builder().token("token").build()

        val credentialAuthRotateParam = CredentialAuthRotateParam.ofStaticBearer(staticBearer)

        assertThat(credentialAuthRotateParam.mcpOauth()).isEmpty
        assertThat(credentialAuthRotateParam.staticBearer()).contains(staticBearer)
        assertThat(credentialAuthRotateParam.environmentVariable()).isEmpty
    }

    @Test
    fun ofStaticBearerRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuthRotateParam =
            CredentialAuthRotateParam.ofStaticBearer(
                CredentialAuthRotateParam.StaticBearer.builder().token("token").build()
            )

        val roundtrippedCredentialAuthRotateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuthRotateParam),
                jacksonTypeRef<CredentialAuthRotateParam>(),
            )

        assertThat(roundtrippedCredentialAuthRotateParam).isEqualTo(credentialAuthRotateParam)
    }

    @Test
    fun ofEnvironmentVariable() {
        val environmentVariable =
            CredentialAuthRotateParam.EnvironmentVariable.builder().secretValue("x").build()

        val credentialAuthRotateParam =
            CredentialAuthRotateParam.ofEnvironmentVariable(environmentVariable)

        assertThat(credentialAuthRotateParam.mcpOauth()).isEmpty
        assertThat(credentialAuthRotateParam.staticBearer()).isEmpty
        assertThat(credentialAuthRotateParam.environmentVariable()).contains(environmentVariable)
    }

    @Test
    fun ofEnvironmentVariableRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialAuthRotateParam =
            CredentialAuthRotateParam.ofEnvironmentVariable(
                CredentialAuthRotateParam.EnvironmentVariable.builder().secretValue("x").build()
            )

        val roundtrippedCredentialAuthRotateParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialAuthRotateParam),
                jacksonTypeRef<CredentialAuthRotateParam>(),
            )

        assertThat(roundtrippedCredentialAuthRotateParam).isEqualTo(credentialAuthRotateParam)
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
        val credentialAuthRotateParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<CredentialAuthRotateParam>())

        val e = assertThrows<OpenAIInvalidDataException> { credentialAuthRotateParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
