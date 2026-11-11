// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.skills.versions

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class DeletedSkillVersionTest {

    @Test
    fun createAndRoundtrip() {
        val deletedSkillVersion =
            DeletedSkillVersion.builder().id("id").deleted(true).version("version").build()

        assertThat(deletedSkillVersion.id()).contains("id")
        assertThat(deletedSkillVersion.deleted()).contains(true)
        assertThat(deletedSkillVersion.version()).contains("version")

        val jsonMapper = jsonMapper()

        val roundtrippedDeletedSkillVersion =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(deletedSkillVersion),
                jacksonTypeRef<DeletedSkillVersion>(),
            )

        assertThat(roundtrippedDeletedSkillVersion).isEqualTo(deletedSkillVersion)
    }
}
