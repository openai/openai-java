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
                .name("name")
                .status(Project.Status.ACTIVE)
                .archivedAt(0L)
                .build()

        assertThat(project.id()).isEqualTo("id")
        assertThat(project.createdAt()).isEqualTo(0L)
        assertThat(project.name()).isEqualTo("name")
        assertThat(project.status()).isEqualTo(Project.Status.ACTIVE)
        assertThat(project.archivedAt()).contains(0L)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val project =
            Project.builder()
                .id("id")
                .createdAt(0L)
                .name("name")
                .status(Project.Status.ACTIVE)
                .archivedAt(0L)
                .build()

        val roundtrippedProject =
            jsonMapper.readValue(jsonMapper.writeValueAsString(project), jacksonTypeRef<Project>())

        assertThat(roundtrippedProject).isEqualTo(project)
    }
}
