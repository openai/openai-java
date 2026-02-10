// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class ContainerAutoTest {

    @Test
    fun create() {
        val containerAuto =
            ContainerAuto.builder()
                .addFileId("file-123")
                .memoryLimit(ContainerAuto.MemoryLimit._1G)
                .networkPolicy(ContainerNetworkPolicyDisabled.builder().build())
                .addSkill(SkillReference.builder().skillId("x").version("version").build())
                .build()

        assertThat(containerAuto.fileIds().getOrNull()).containsExactly("file-123")
        assertThat(containerAuto.memoryLimit()).contains(ContainerAuto.MemoryLimit._1G)
        assertThat(containerAuto.networkPolicy())
            .contains(
                ContainerAuto.NetworkPolicy.ofDisabled(
                    ContainerNetworkPolicyDisabled.builder().build()
                )
            )
        assertThat(containerAuto.skills().getOrNull())
            .containsExactly(
                ContainerAuto.Skill.ofReference(
                    SkillReference.builder().skillId("x").version("version").build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val containerAuto =
            ContainerAuto.builder()
                .addFileId("file-123")
                .memoryLimit(ContainerAuto.MemoryLimit._1G)
                .networkPolicy(ContainerNetworkPolicyDisabled.builder().build())
                .addSkill(SkillReference.builder().skillId("x").version("version").build())
                .build()

        val roundtrippedContainerAuto =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(containerAuto),
                jacksonTypeRef<ContainerAuto>(),
            )

        assertThat(roundtrippedContainerAuto).isEqualTo(containerAuto)
    }
}
