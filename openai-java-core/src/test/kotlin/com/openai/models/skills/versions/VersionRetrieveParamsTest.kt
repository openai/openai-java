// File generated from our OpenAPI spec by Stainless.

package com.openai.models.skills.versions

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class VersionRetrieveParamsTest {

    @Test
    fun create() {
        VersionRetrieveParams.builder().skillId("skill_123").version("version").build()
    }

    @Test
    fun pathParams() {
        val params = VersionRetrieveParams.builder().skillId("skill_123").version("version").build()

        assertThat(params._pathParam(0)).isEqualTo("skill_123")
        assertThat(params._pathParam(1)).isEqualTo("version")
        // out-of-bound path param
        assertThat(params._pathParam(2)).isEqualTo("")
    }
}
