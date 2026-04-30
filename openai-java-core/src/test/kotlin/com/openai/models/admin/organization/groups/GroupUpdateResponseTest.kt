// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupUpdateResponseTest {

    @Test
    fun create() {
        val groupUpdateResponse =
            GroupUpdateResponse.builder()
                .id("id")
                .createdAt(0L)
                .isScimManaged(true)
                .name("name")
                .build()

        assertThat(groupUpdateResponse.id()).isEqualTo("id")
        assertThat(groupUpdateResponse.createdAt()).isEqualTo(0L)
        assertThat(groupUpdateResponse.isScimManaged()).isEqualTo(true)
        assertThat(groupUpdateResponse.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val groupUpdateResponse =
            GroupUpdateResponse.builder()
                .id("id")
                .createdAt(0L)
                .isScimManaged(true)
                .name("name")
                .build()

        val roundtrippedGroupUpdateResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(groupUpdateResponse),
                jacksonTypeRef<GroupUpdateResponse>(),
            )

        assertThat(roundtrippedGroupUpdateResponse).isEqualTo(groupUpdateResponse)
    }
}
