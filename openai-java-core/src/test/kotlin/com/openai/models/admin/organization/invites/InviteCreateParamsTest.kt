// File generated from our OpenAPI spec by Stainless.

package com.openai.models.admin.organization.invites

import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class InviteCreateParamsTest {

    @Test
    fun create() {
        InviteCreateParams.builder()
            .email("email")
            .role(InviteCreateParams.Role.READER)
            .addProject(
                InviteCreateParams.Project.builder()
                    .id("id")
                    .role(InviteCreateParams.Project.Role.MEMBER)
                    .build()
            )
            .build()
    }

    @Test
    fun body() {
        val params =
            InviteCreateParams.builder()
                .email("email")
                .role(InviteCreateParams.Role.READER)
                .addProject(
                    InviteCreateParams.Project.builder()
                        .id("id")
                        .role(InviteCreateParams.Project.Role.MEMBER)
                        .build()
                )
                .build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("email")
        assertThat(body.role()).isEqualTo(InviteCreateParams.Role.READER)
        assertThat(body.projects().getOrNull())
            .containsExactly(
                InviteCreateParams.Project.builder()
                    .id("id")
                    .role(InviteCreateParams.Project.Role.MEMBER)
                    .build()
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params =
            InviteCreateParams.builder().email("email").role(InviteCreateParams.Role.READER).build()

        val body = params._body()

        assertThat(body.email()).isEqualTo("email")
        assertThat(body.role()).isEqualTo(InviteCreateParams.Role.READER)
    }
}
