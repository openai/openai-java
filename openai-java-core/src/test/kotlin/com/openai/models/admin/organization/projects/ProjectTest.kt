// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectTest {

    @Test
    fun create() {
        val project =
            Project.builder()
                .id("id")
                .createdAt(0L)
                .archivedAt(0L)
                .externalKeyId("external_key_id")
                .name("name")
                .status("status")
                .build()

        assertThat(project.id()).isEqualTo("id")
        assertThat(project.createdAt()).isEqualTo(0L)
        assertThat(project.archivedAt()).contains(0L)
        assertThat(project.externalKeyId()).contains("external_key_id")
        assertThat(project.name()).contains("name")
        assertThat(project.status()).contains("status")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val project =
            Project.builder()
                .id("id")
                .createdAt(0L)
                .archivedAt(0L)
                .externalKeyId("external_key_id")
                .name("name")
                .status("status")
                .build()

        val roundtrippedProject =
            jsonMapper.readValue(jsonMapper.writeValueAsString(project), jacksonTypeRef<Project>())

        assertThat(roundtrippedProject).isEqualTo(project)
    }
}
