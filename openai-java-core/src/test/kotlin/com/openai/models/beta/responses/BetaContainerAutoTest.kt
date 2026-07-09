// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaContainerAutoTest {

    @Test
    fun create() {
        val betaContainerAuto =
            BetaContainerAuto.builder()
                .addFileId("file-123")
                .memoryLimit(BetaContainerAuto.MemoryLimit._1G)
                .networkPolicy(BetaContainerNetworkPolicyDisabled.builder().build())
                .addSkill(BetaSkillReference.builder().skillId("x").version("version").build())
                .build()

        assertThat(betaContainerAuto.fileIds().getOrNull()).containsExactly("file-123")
        assertThat(betaContainerAuto.memoryLimit()).contains(BetaContainerAuto.MemoryLimit._1G)
        assertThat(betaContainerAuto.networkPolicy())
            .contains(
                BetaContainerAuto.NetworkPolicy.ofDisabled(
                    BetaContainerNetworkPolicyDisabled.builder().build()
                )
            )
        assertThat(betaContainerAuto.skills().getOrNull())
            .containsExactly(
                BetaContainerAuto.Skill.ofReference(
                    BetaSkillReference.builder().skillId("x").version("version").build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaContainerAuto =
            BetaContainerAuto.builder()
                .addFileId("file-123")
                .memoryLimit(BetaContainerAuto.MemoryLimit._1G)
                .networkPolicy(BetaContainerNetworkPolicyDisabled.builder().build())
                .addSkill(BetaSkillReference.builder().skillId("x").version("version").build())
                .build()

        val roundtrippedBetaContainerAuto =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaContainerAuto),
                jacksonTypeRef<BetaContainerAuto>(),
            )

        assertThat(roundtrippedBetaContainerAuto).isEqualTo(betaContainerAuto)
    }
}
