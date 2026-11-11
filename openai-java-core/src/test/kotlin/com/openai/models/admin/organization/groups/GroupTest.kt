// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.groups

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupTest {

    @Test
    fun createAndRoundtrip() {
        val group =
            Group.builder()
                .id("id")
                .createdAt(0L)
                .groupType(Group.GroupType.GROUP)
                .isScimManaged(true)
                .name("name")
                .build()

        assertThat(group.id()).contains("id")
        assertThat(group.createdAt()).contains(0L)
        assertThat(group.groupType()).contains(Group.GroupType.GROUP)
        assertThat(group.isScimManaged()).contains(true)
        assertThat(group.name()).contains("name")

        val jsonMapper = jsonMapper()

        val roundtrippedGroup =
            jsonMapper.readValue(jsonMapper.writeValueAsString(group), jacksonTypeRef<Group>())

        assertThat(roundtrippedGroup).isEqualTo(group)
    }
}
