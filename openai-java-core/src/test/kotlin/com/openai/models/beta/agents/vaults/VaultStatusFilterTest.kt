// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.vaults

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class VaultStatusFilterTest {

    @Test
    fun ofVaultStatus() {
        val vaultStatus = VaultStatus.ACTIVE

        val vaultStatusFilter = VaultStatusFilter.ofVaultStatus(vaultStatus)

        assertThat(vaultStatusFilter.vaultStatus()).contains(vaultStatus)
        assertThat(vaultStatusFilter.vaultStatuses()).isEmpty
    }

    @Test
    fun ofVaultStatusRoundtrip() {
        val jsonMapper = jsonMapper()
        val vaultStatusFilter = VaultStatusFilter.ofVaultStatus(VaultStatus.ACTIVE)

        val roundtrippedVaultStatusFilter =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vaultStatusFilter),
                jacksonTypeRef<VaultStatusFilter>(),
            )

        assertThat(roundtrippedVaultStatusFilter).isEqualTo(vaultStatusFilter)
    }

    @Test
    fun ofVaultStatuses() {
        val vaultStatuses = listOf(VaultStatus.ACTIVE)

        val vaultStatusFilter = VaultStatusFilter.ofVaultStatuses(vaultStatuses)

        assertThat(vaultStatusFilter.vaultStatus()).isEmpty
        assertThat(vaultStatusFilter.vaultStatuses()).contains(vaultStatuses)
    }

    @Test
    fun ofVaultStatusesRoundtrip() {
        val jsonMapper = jsonMapper()
        val vaultStatusFilter = VaultStatusFilter.ofVaultStatuses(listOf(VaultStatus.ACTIVE))

        val roundtrippedVaultStatusFilter =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(vaultStatusFilter),
                jacksonTypeRef<VaultStatusFilter>(),
            )

        assertThat(roundtrippedVaultStatusFilter).isEqualTo(vaultStatusFilter)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        OBJECT(JsonValue.from(mapOf("invalid" to "object"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val vaultStatusFilter =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<VaultStatusFilter>())

        val e = assertThrows<OpenAIInvalidDataException> { vaultStatusFilter.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
