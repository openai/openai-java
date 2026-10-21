// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.skills

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DeletedSkillTest {

    @Test
    fun createAndRoundtrip() {
        val deletedSkill = DeletedSkill.builder().id("id").deleted(true).build()

        assertThat(deletedSkill.id()).isEqualTo("id")
        assertThat(deletedSkill.deleted()).isEqualTo(true)

        val jsonMapper = jsonMapper()

        val roundtrippedDeletedSkill =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(deletedSkill),
                jacksonTypeRef<DeletedSkill>(),
            )

        assertThat(roundtrippedDeletedSkill).isEqualTo(deletedSkill)
    }
}
