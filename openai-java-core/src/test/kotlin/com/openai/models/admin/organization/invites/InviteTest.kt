// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.invites

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InviteTest {

    @Test
    fun create() {
        val invite =
            Invite.builder()
                .id("id")
                .createdAt(0L)
                .email("email")
                .expiresAt(0L)
                .role(Invite.Role.OWNER)
                .status(Invite.Status.ACCEPTED)
                .acceptedAt(0L)
                .addProject(
                    Invite.Project.builder().id("id").role(Invite.Project.Role.MEMBER).build()
                )
                .build()

        assertThat(invite.id()).isEqualTo("id")
        assertThat(invite.createdAt()).isEqualTo(0L)
        assertThat(invite.email()).isEqualTo("email")
        assertThat(invite.expiresAt()).contains(0L)
        assertThat(invite.role()).isEqualTo(Invite.Role.OWNER)
        assertThat(invite.status()).isEqualTo(Invite.Status.ACCEPTED)
        assertThat(invite.acceptedAt()).contains(0L)
        assertThat(invite.projects().getOrNull())
            .containsExactly(
                Invite.Project.builder().id("id").role(Invite.Project.Role.MEMBER).build()
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val invite =
            Invite.builder()
                .id("id")
                .createdAt(0L)
                .email("email")
                .expiresAt(0L)
                .role(Invite.Role.OWNER)
                .status(Invite.Status.ACCEPTED)
                .acceptedAt(0L)
                .addProject(
                    Invite.Project.builder().id("id").role(Invite.Project.Role.MEMBER).build()
                )
                .build()

        val roundtrippedInvite =
            jsonMapper.readValue(jsonMapper.writeValueAsString(invite), jacksonTypeRef<Invite>())

        assertThat(roundtrippedInvite).isEqualTo(invite)
    }
}
