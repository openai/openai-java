// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupTest {

    @Test
    fun create() {
        val group = Group.builder().id("id").createdAt(0L).isScimManaged(true).name("name").build()

        assertThat(group.id()).isEqualTo("id")
        assertThat(group.createdAt()).isEqualTo(0L)
        assertThat(group.isScimManaged()).isEqualTo(true)
        assertThat(group.name()).isEqualTo("name")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val group = Group.builder().id("id").createdAt(0L).isScimManaged(true).name("name").build()

        val roundtrippedGroup =
            jsonMapper.readValue(jsonMapper.writeValueAsString(group), jacksonTypeRef<Group>())

        assertThat(roundtrippedGroup).isEqualTo(group)
    }
}
