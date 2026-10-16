package com.openai.models.beta.agents.vaults.credentials

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class CredentialAuthRedactionTest {
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
                .metadata(Credential.Metadata.builder().build())
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
        assertThat(error).hasMessage("Unknown CredentialAuth")
        assertThat(auth._json()).contains(raw)
        assertThat(credential.auth()._json()).contains(raw)
        assertThat(mapper.readTree(mapper.writeValueAsString(auth)))
            .isEqualTo(mapper.readTree(original))
    }

    @ParameterizedTest
    @ValueSource(strings = ["{}", "{\"type\":\"future\",\"future_field\":\"preserved\"}"])
    fun unknownDiagnosticsOmitPayloadWithoutChangingToString(json: String) {
        val mapper = jsonMapper()
        val raw = mapper.readValue(json, jacksonTypeRef<JsonValue>())
        val auth = mapper.readValue(json, jacksonTypeRef<CredentialAuth>())

        assertThat(auth.toString()).isEqualTo("CredentialAuth{_unknown=$raw}")
        assertThat(assertThrows<OpenAIInvalidDataException> { auth.validate() })
            .hasMessage("Unknown CredentialAuth")
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
                .metadata(Credential.Metadata.builder().build())
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
}
