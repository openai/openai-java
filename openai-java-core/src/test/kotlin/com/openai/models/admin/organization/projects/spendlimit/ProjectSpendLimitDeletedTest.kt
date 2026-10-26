// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.spendlimit

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectSpendLimitDeletedTest {

    @Test
    fun createAndRoundtrip() {
        val projectSpendLimitDeleted = ProjectSpendLimitDeleted.builder().deleted(true).build()

        assertThat(projectSpendLimitDeleted.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedProjectSpendLimitDeleted =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectSpendLimitDeleted),
                jacksonTypeRef<ProjectSpendLimitDeleted>(),
            )

        assertThat(roundtrippedProjectSpendLimitDeleted).isEqualTo(projectSpendLimitDeleted)
    }
}
