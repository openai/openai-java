// File generated from our OpenAPI spec by Stainless.

package com.openai.models.beta.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import kotlin.jvm.optionals.getOrNull
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class BetaFunctionShellToolTest {

    @Test
    fun create() {
        val betaFunctionShellTool =
            BetaFunctionShellTool.builder()
                .addAllowedCaller(BetaFunctionShellTool.AllowedCaller.DIRECT)
                .environment(
                    BetaContainerAuto.builder()
                        .addFileId("file-123")
                        .memoryLimit(BetaContainerAuto.MemoryLimit._1G)
                        .networkPolicy(BetaContainerNetworkPolicyDisabled.builder().build())
                        .addSkill(
                            BetaSkillReference.builder().skillId("x").version("version").build()
                        )
                        .build()
                )
                .build()

        assertThat(betaFunctionShellTool.allowedCallers().getOrNull())
            .containsExactly(BetaFunctionShellTool.AllowedCaller.DIRECT)
        assertThat(betaFunctionShellTool.environment())
            .contains(
                BetaFunctionShellTool.Environment.ofContainerAuto(
                    BetaContainerAuto.builder()
                        .addFileId("file-123")
                        .memoryLimit(BetaContainerAuto.MemoryLimit._1G)
                        .networkPolicy(BetaContainerNetworkPolicyDisabled.builder().build())
                        .addSkill(
                            BetaSkillReference.builder().skillId("x").version("version").build()
                        )
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val betaFunctionShellTool =
            BetaFunctionShellTool.builder()
                .addAllowedCaller(BetaFunctionShellTool.AllowedCaller.DIRECT)
                .environment(
                    BetaContainerAuto.builder()
                        .addFileId("file-123")
                        .memoryLimit(BetaContainerAuto.MemoryLimit._1G)
                        .networkPolicy(BetaContainerNetworkPolicyDisabled.builder().build())
                        .addSkill(
                            BetaSkillReference.builder().skillId("x").version("version").build()
                        )
                        .build()
                )
                .build()

        val roundtrippedBetaFunctionShellTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(betaFunctionShellTool),
                jacksonTypeRef<BetaFunctionShellTool>(),
            )

        assertThat(roundtrippedBetaFunctionShellTool).isEqualTo(betaFunctionShellTool)
    }
}
