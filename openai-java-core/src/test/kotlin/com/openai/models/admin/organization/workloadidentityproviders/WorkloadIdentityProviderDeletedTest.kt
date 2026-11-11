// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.workloadidentityproviders

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class WorkloadIdentityProviderDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val workloadIdentityProviderDeleted =
            WorkloadIdentityProviderDeleted.builder().id("id").deleted(true).build()

        assertThat(workloadIdentityProviderDeleted.id()).contains("id")
        assertThat(workloadIdentityProviderDeleted.deleted()).contains(true)

        val jsonMapper = jsonMapper()

        val roundtrippedWorkloadIdentityProviderDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(workloadIdentityProviderDeleted),
                jacksonTypeRef<WorkloadIdentityProviderDeleted>(),
            )

        assertThat(roundtrippedWorkloadIdentityProviderDeleted)
            .isEqualTo(workloadIdentityProviderDeleted)
    }
}
