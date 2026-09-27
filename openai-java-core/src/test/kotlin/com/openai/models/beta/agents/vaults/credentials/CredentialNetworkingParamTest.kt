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

internal class CredentialNetworkingParamTest {

    @Test
    fun ofUnrestricted() {
        val credentialNetworkingParam = CredentialNetworkingParam.ofUnrestricted()

        assertThat(credentialNetworkingParam.unrestricted())
            .contains(JsonValue.from(mapOf("type" to "unrestricted")))
        assertThat(credentialNetworkingParam.limited()).isEmpty
    }

    @Test
    fun ofUnrestrictedRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialNetworkingParam = CredentialNetworkingParam.ofUnrestricted()

        val roundtrippedCredentialNetworkingParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialNetworkingParam),
                jacksonTypeRef<CredentialNetworkingParam>(),
            )

        assertThat(roundtrippedCredentialNetworkingParam).isEqualTo(credentialNetworkingParam)
    }

    @Test
    fun ofLimited() {
        val limited = CredentialNetworkingParam.Limited.builder().addAllowedHost("string").build()

        val credentialNetworkingParam = CredentialNetworkingParam.ofLimited(limited)

        assertThat(credentialNetworkingParam.unrestricted()).isEmpty
        assertThat(credentialNetworkingParam.limited()).contains(limited)
    }

    @Test
    fun ofLimitedRoundtrip() {
        val jsonMapper = jsonMapper()
        val credentialNetworkingParam =
            CredentialNetworkingParam.ofLimited(
                CredentialNetworkingParam.Limited.builder().addAllowedHost("string").build()
            )

        val roundtrippedCredentialNetworkingParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(credentialNetworkingParam),
                jacksonTypeRef<CredentialNetworkingParam>(),
            )

        assertThat(roundtrippedCredentialNetworkingParam).isEqualTo(credentialNetworkingParam)
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
        val credentialNetworkingParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<CredentialNetworkingParam>())

        val e = assertThrows<OpenAIInvalidDataException> { credentialNetworkingParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
