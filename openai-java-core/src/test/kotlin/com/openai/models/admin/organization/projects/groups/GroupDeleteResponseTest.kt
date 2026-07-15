// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.groups

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupDeleteResponseTest {

    @Test
    fun create() {
        val groupDeleteResponse = GroupDeleteResponse.builder().deleted(true).build()

        assertThat(groupDeleteResponse.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val groupDeleteResponse = GroupDeleteResponse.builder().deleted(true).build()

        val roundtrippedGroupDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(groupDeleteResponse),
                jacksonTypeRef<GroupDeleteResponse>(),
            )

        assertThat(roundtrippedGroupDeleteResponse).isEqualTo(groupDeleteResponse)
    }
}
