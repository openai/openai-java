// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.serviceaccounts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ServiceAccountDeleteResponseTest {

    @Test
    fun create() {
        val serviceAccountDeleteResponse =
            ServiceAccountDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(serviceAccountDeleteResponse.id()).isEqualTo("id")
        assertThat(serviceAccountDeleteResponse.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val serviceAccountDeleteResponse =
            ServiceAccountDeleteResponse.builder().id("id").deleted(true).build()

        val roundtrippedServiceAccountDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(serviceAccountDeleteResponse),
                jacksonTypeRef<ServiceAccountDeleteResponse>(),
            )

        assertThat(roundtrippedServiceAccountDeleteResponse).isEqualTo(serviceAccountDeleteResponse)
    }
}
