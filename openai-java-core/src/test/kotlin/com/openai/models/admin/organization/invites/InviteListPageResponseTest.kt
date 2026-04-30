// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.invites

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InviteListPageResponseTest {

    @Test
    fun create() {
        val inviteListPageResponse =
            InviteListPageResponse.builder()
                .addData(
                    Invite.builder()
                        .id("id")
                        .email("email")
                        .expiresAt(0L)
                        .invitedAt(0L)
                        .role(Invite.Role.OWNER)
                        .status(Invite.Status.ACCEPTED)
                        .acceptedAt(0L)
                        .addProject(
                            Invite.Project.builder()
                                .id("id")
                                .role(Invite.Project.Role.MEMBER)
                                .build()
                        )
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        assertThat(inviteListPageResponse.data())
            .containsExactly(
                Invite.builder()
                    .id("id")
                    .email("email")
                    .expiresAt(0L)
                    .invitedAt(0L)
                    .role(Invite.Role.OWNER)
                    .status(Invite.Status.ACCEPTED)
                    .acceptedAt(0L)
                    .addProject(
                        Invite.Project.builder().id("id").role(Invite.Project.Role.MEMBER).build()
                    )
                    .build()
            )
        assertThat(inviteListPageResponse.firstId()).contains("first_id")
        assertThat(inviteListPageResponse.hasMore()).contains(true)
        assertThat(inviteListPageResponse.lastId()).contains("last_id")
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val inviteListPageResponse =
            InviteListPageResponse.builder()
                .addData(
                    Invite.builder()
                        .id("id")
                        .email("email")
                        .expiresAt(0L)
                        .invitedAt(0L)
                        .role(Invite.Role.OWNER)
                        .status(Invite.Status.ACCEPTED)
                        .acceptedAt(0L)
                        .addProject(
                            Invite.Project.builder()
                                .id("id")
                                .role(Invite.Project.Role.MEMBER)
                                .build()
                        )
                        .build()
                )
                .firstId("first_id")
                .hasMore(true)
                .lastId("last_id")
                .build()

        val roundtrippedInviteListPageResponse =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(inviteListPageResponse),
                jacksonTypeRef<InviteListPageResponse>(),
            )

        assertThat(roundtrippedInviteListPageResponse).isEqualTo(inviteListPageResponse)
    }
}
