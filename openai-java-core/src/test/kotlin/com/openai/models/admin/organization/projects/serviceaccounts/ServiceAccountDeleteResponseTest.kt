// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.serviceaccounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ServiceAccountDeleteResponseTest {

    @Test
    fun createAndRoundtrip() {
        val serviceAccountDeleteResponse =
            ServiceAccountDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(serviceAccountDeleteResponse.id()).contains("id")
        assertThat(serviceAccountDeleteResponse.deleted()).contains(true)

        val jsonMapper = jsonMapper()

        val roundtrippedServiceAccountDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serviceAccountDeleteResponse),
                jacksonTypeRef<ServiceAccountDeleteResponse>(),
            )

        assertThat(roundtrippedServiceAccountDeleteResponse).isEqualTo(serviceAccountDeleteResponse)
    }
}
