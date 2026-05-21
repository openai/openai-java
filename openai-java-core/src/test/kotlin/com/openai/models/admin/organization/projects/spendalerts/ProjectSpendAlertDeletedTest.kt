// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.spendalerts

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectSpendAlertDeletedTest {

    @Test
    fun create() {
        val projectSpendAlertDeleted =
            ProjectSpendAlertDeleted.builder().id("id").deleted(true).build()

        assertThat(projectSpendAlertDeleted.id()).isEqualTo("id")
        assertThat(projectSpendAlertDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectSpendAlertDeleted =
            ProjectSpendAlertDeleted.builder().id("id").deleted(true).build()

        val roundtrippedProjectSpendAlertDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectSpendAlertDeleted),
                jacksonTypeRef<ProjectSpendAlertDeleted>(),
            )

        assertThat(roundtrippedProjectSpendAlertDeleted).isEqualTo(projectSpendAlertDeleted)
    }
}
