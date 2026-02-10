// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills.versions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DeletedSkillVersionTest {

    @Test
    fun create() {
        val deletedSkillVersion =
            DeletedSkillVersion.builder().id("id").deleted(true).version("version").build()

        assertThat(deletedSkillVersion.id()).isEqualTo("id")
        assertThat(deletedSkillVersion.deleted()).isEqualTo(true)
        assertThat(deletedSkillVersion.version()).isEqualTo("version")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val deletedSkillVersion =
            DeletedSkillVersion.builder().id("id").deleted(true).version("version").build()

        val roundtrippedDeletedSkillVersion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(deletedSkillVersion),
                jacksonTypeRef<DeletedSkillVersion>(),
            )

        assertThat(roundtrippedDeletedSkillVersion).isEqualTo(deletedSkillVersion)
    }
}
