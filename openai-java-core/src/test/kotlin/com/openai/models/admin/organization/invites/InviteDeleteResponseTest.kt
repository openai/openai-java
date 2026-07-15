// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.invites

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InviteDeleteResponseTest {

    @Test
    fun create() {
        val inviteDeleteResponse = InviteDeleteResponse.builder().id("id").deleted(true).build()

        assertThat(inviteDeleteResponse.id()).isEqualTo("id")
        assertThat(inviteDeleteResponse.deleted()).isEqualTo(true)
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inviteDeleteResponse = InviteDeleteResponse.builder().id("id").deleted(true).build()

        val roundtrippedInviteDeleteResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inviteDeleteResponse),
                jacksonTypeRef<InviteDeleteResponse>(),
            )

        assertThat(roundtrippedInviteDeleteResponse).isEqualTo(inviteDeleteResponse)
    }
}
