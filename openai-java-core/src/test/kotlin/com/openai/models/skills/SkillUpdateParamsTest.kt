// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SkillUpdateParamsTest {

    @Test
    fun create() {
        SkillUpdateParams.builder().skillId("skill_123").defaultVersion("default_version").build()
    }

    @Test
    fun pathParams() {
        val params =
            SkillUpdateParams.builder()
                .skillId("skill_123")
                .defaultVersion("default_version")
                .build()

        assertThat(params._pathParam(0)).isEqualTo("skill_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }

    @Test
    fun body() {
        val params =
            SkillUpdateParams.builder()
                .skillId("skill_123")
                .defaultVersion("default_version")
                .build()

        val body = params._body()

        assertThat(body.defaultVersion()).isEqualTo("default_version")
    }
}
