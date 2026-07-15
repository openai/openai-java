// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.groups

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class GroupCreateParamsTest {

    @Test
    fun create() {
        GroupCreateParams.builder().name("x").build()
    }

    @Test
    fun body() {
        val params = GroupCreateParams.builder().name("x").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("x")
    }
}
