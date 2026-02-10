// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DeletedSkillTest {

    @Test
    fun create() {
        val deletedSkill = DeletedSkill.builder().id("id").deleted(true).build()

        assertThat(deletedSkill.id()).isEqualTo("id")
        assertThat(deletedSkill.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val deletedSkill = DeletedSkill.builder().id("id").deleted(true).build()

        val roundtrippedDeletedSkill =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(deletedSkill),
                jacksonTypeRef<DeletedSkill>(),
            )

        assertThat(roundtrippedDeletedSkill).isEqualTo(deletedSkill)
    }
}
