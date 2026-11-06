// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.admin.organization.projects.servicetiersettings

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ProjectServiceTierSettingsTest {

    @Test
    fun createAndRoundtrip() {
        val projectServiceTierSettings =
            ProjectServiceTierSettings.builder()
                .default_(ProjectServiceTierSettings.Default.STANDARD)
                .enabledTiersAll()
                .build()

        assertThat(projectServiceTierSettings.default_())
            .isEqualTo(ProjectServiceTierSettings.Default.STANDARD)
        assertThat(projectServiceTierSettings.enabledTiers())
            .isEqualTo(ProjectServiceTierSettings.EnabledTiers.ofAll())

        val jsonMapper = jsonMapper()

        val roundtrippedProjectServiceTierSettings =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(projectServiceTierSettings),
                jacksonTypeRef<ProjectServiceTierSettings>(),
            )

        assertThat(roundtrippedProjectServiceTierSettings).isEqualTo(projectServiceTierSettings)
    }
}
