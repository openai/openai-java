// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.invites

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InviteRetrieveParamsTest {

    @Test
    fun create() {
        InviteRetrieveParams.builder().inviteId("invite_id").build()
    }

    @Test
    fun pathParams() {
        val params = InviteRetrieveParams.builder().inviteId("invite_id").build()

        assertThat(params._pathParam(0)).isEqualTo("invite_id")
        // out-of-bound path param
        assertThat(params._pathParam(1)).isEqualTo("")
    }
}
