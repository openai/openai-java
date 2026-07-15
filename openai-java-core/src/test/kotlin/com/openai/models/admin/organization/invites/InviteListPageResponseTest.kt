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
                        .createdAt(0L)
                        .email("email")
                        .addProject(
                            Invite.Project.builder()
                                .id("id")
                                .role(Invite.Project.Role.MEMBER)
                                .build()
                        )
                        .role(Invite.Role.OWNER)
                        .status(Invite.Status.ACCEPTED)
                        .acceptedAt(0L)
                        .expiresAt(0L)
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
                .lastId("last_id")
                .build()

        assertThat(inviteListPageResponse.data())
            .containsExactly(
                Invite.builder()
                    .id("id")
                    .createdAt(0L)
                    .email("email")
                    .addProject(
                        Invite.Project.builder().id("id").role(Invite.Project.Role.MEMBER).build()
                    )
                    .role(Invite.Role.OWNER)
                    .status(Invite.Status.ACCEPTED)
                    .acceptedAt(0L)
                    .expiresAt(0L)
                    .build()
            )
        assertThat(inviteListPageResponse.hasMore()).isEqualTo(true)
        assertThat(inviteListPageResponse.firstId()).contains("first_id")
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
                        .createdAt(0L)
                        .email("email")
                        .addProject(
                            Invite.Project.builder()
                                .id("id")
                                .role(Invite.Project.Role.MEMBER)
                                .build()
                        )
                        .role(Invite.Role.OWNER)
                        .status(Invite.Status.ACCEPTED)
                        .acceptedAt(0L)
                        .expiresAt(0L)
                        .build()
                )
                .hasMore(true)
                .firstId("first_id")
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
