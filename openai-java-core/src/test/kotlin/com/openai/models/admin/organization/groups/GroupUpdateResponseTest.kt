// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.groups

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupUpdateResponseTest {

    @Test
    fun createAndRoundtrip() {
        val groupUpdateResponse =
            GroupUpdateResponse.builder()
                .id("id")
                .createdAt(0L)
                .isScimManaged(true)
                .name("name")
                .build()

        assertThat(groupUpdateResponse.id()).contains("id")
        assertThat(groupUpdateResponse.createdAt()).contains(0L)
        assertThat(groupUpdateResponse.isScimManaged()).contains(true)
        assertThat(groupUpdateResponse.name()).contains("name")

        val jsonMapper = jsonMapper()

        val roundtrippedGroupUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(groupUpdateResponse),
                jacksonTypeRef<GroupUpdateResponse>(),
            )

        assertThat(roundtrippedGroupUpdateResponse).isEqualTo(groupUpdateResponse)
    }
}
