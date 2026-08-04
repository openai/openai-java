// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.projects.spendlimit

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectSpendLimitDeletedTest {

    @Test
    fun create() {
        val projectSpendLimitDeleted = ProjectSpendLimitDeleted.builder().deleted(true).build()

        assertThat(projectSpendLimitDeleted.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val projectSpendLimitDeleted = ProjectSpendLimitDeleted.builder().deleted(true).build()

        val roundtrippedProjectSpendLimitDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectSpendLimitDeleted),
                jacksonTypeRef<ProjectSpendLimitDeleted>(),
            )

        assertThat(roundtrippedProjectSpendLimitDeleted).isEqualTo(projectSpendLimitDeleted)
    }
}
