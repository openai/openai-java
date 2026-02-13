// File generated from our OpenAPI spec by Stainless.

package com.openai.models.containers

import com.openai.models.responses.ContainerNetworkPolicyDisabled
import com.openai.models.responses.SkillReference
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerCreateParamsTest {

    @Test
    fun create() {
        ContainerCreateParams.builder()
            .name("name")
            .expiresAfter(
                ContainerCreateParams.ExpiresAfter.builder()
                    .anchor(ContainerCreateParams.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                    .minutes(0L)
                    .build()
            )
            .addFileId("string")
            .memoryLimit(ContainerCreateParams.MemoryLimit._1G)
            .networkPolicy(ContainerNetworkPolicyDisabled.builder().build())
            .addSkill(SkillReference.builder().skillId("x").version("version").build())
            .build()
    }

    @Test
    fun body() {
        val params =
            ContainerCreateParams.builder()
                .name("name")
                .expiresAfter(
                    ContainerCreateParams.ExpiresAfter.builder()
                        .anchor(ContainerCreateParams.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                        .minutes(0L)
                        .build()
                )
                .addFileId("string")
                .memoryLimit(ContainerCreateParams.MemoryLimit._1G)
                .networkPolicy(ContainerNetworkPolicyDisabled.builder().build())
                .addSkill(SkillReference.builder().skillId("x").version("version").build())
                .build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
        assertThat(body.expiresAfter())
            .contains(
                ContainerCreateParams.ExpiresAfter.builder()
                    .anchor(ContainerCreateParams.ExpiresAfter.Anchor.LAST_ACTIVE_AT)
                    .minutes(0L)
                    .build()
            )
        assertThat(body.fileIds().getOrNull()).containsExactly("string")
        assertThat(body.memoryLimit()).contains(ContainerCreateParams.MemoryLimit._1G)
        assertThat(body.networkPolicy())
            .contains(
                ContainerCreateParams.NetworkPolicy.ofDisabled(
                    ContainerNetworkPolicyDisabled.builder().build()
                )
            )
        assertThat(body.skills().getOrNull())
            .containsExactly(
                ContainerCreateParams.Skill.ofReference(
                    SkillReference.builder().skillId("x").version("version").build()
                )
            )
    }

    @Test
    fun bodyWithoutOptionalFields() {
        val params = ContainerCreateParams.builder().name("name").build()

        val body = params._body()

        assertThat(body.name()).isEqualTo("name")
    }
}
