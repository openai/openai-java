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

internal class CredentialNetworkingTest {

    @Test
    fun ofUnrestricted() {
        val credentialNetworking = CredentialNetworking.ofUnrestricted()

        assertThat(credentialNetworking.unrestricted())
            .contains(JsonValue.from(mapOf("type" to "unrestricted")))
        assertThat(credentialNetworking.limited()).isEmpty
    }

    @Test
    fun ofUnrestrictedRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialNetworking = CredentialNetworking.ofUnrestricted()

        val roundtrippedCredentialNetworking =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialNetworking),
                jacksonTypeRef<CredentialNetworking>(),
            )

        assertThat(roundtrippedCredentialNetworking).isEqualTo(credentialNetworking)
    }

    @Test
    fun ofLimited() {
        val limited = CredentialNetworking.Limited.builder().addAllowedHost("string").build()

        val credentialNetworking = CredentialNetworking.ofLimited(limited)

        assertThat(credentialNetworking.unrestricted()).isEmpty
        assertThat(credentialNetworking.limited()).contains(limited)
    }

    @Test
    fun ofLimitedRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialNetworking =
            CredentialNetworking.ofLimited(
                CredentialNetworking.Limited.builder().addAllowedHost("string").build()
            )

        val roundtrippedCredentialNetworking =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialNetworking),
                jacksonTypeRef<CredentialNetworking>(),
            )

        assertThat(roundtrippedCredentialNetworking).isEqualTo(credentialNetworking)
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
        val credentialNetworking =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<CredentialNetworking>())

        val e = assertThrows<OpenAIInvalidDataException> { credentialNetworking.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
