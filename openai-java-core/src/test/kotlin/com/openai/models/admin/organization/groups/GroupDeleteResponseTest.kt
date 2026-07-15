// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupDeleteResponseTest {

    @Test
    fun create() {
        val groupDeleteResponse = GroupDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(groupDeleteResponse.id()).isEqualTo("id")
        assertThat(groupDeleteResponse.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val groupDeleteResponse = GroupDeleteResponse.builder().id("id").deleted(true).build()

        val roundtrippedGroupDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(groupDeleteResponse),
                jacksonTypeRef<GroupDeleteResponse>(),
            )

        assertThat(roundtrippedGroupDeleteResponse).isEqualTo(groupDeleteResponse)
    }
}
