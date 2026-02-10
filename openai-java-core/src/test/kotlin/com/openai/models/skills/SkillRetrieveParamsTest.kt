// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SkillRetrieveParamsTest {

    @Test
    fun create() {
        SkillRetrieveParams.builder().skillId("skill_123").build()
    }

    @Test
    fun pathParams() {
        val params = SkillRetrieveParams.builder().skillId("skill_123").build()

        assertThat(params._pathParam(0)).isEqualTo("skill_123")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
