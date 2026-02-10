// File generated from our OpenAPI spec by Stainless.

package com.openai.models.responses

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class FunctionShellToolTest {

    @Test
    fun create() {
        val functionShellTool =
            FunctionShellTool.builder()
                .environment(
                    ContainerAuto.builder()
                        .addFileId("file-123")
                        .memoryLimit(ContainerAuto.MemoryLimit._1G)
                        .networkPolicy(ContainerNetworkPolicyDisabled.builder().build())
                        .addSkill(SkillReference.builder().skillId("x").version("version").build())
                        .build()
                )
                .build()

        assertThat(functionShellTool.environment())
            .contains(
                FunctionShellTool.Environment.ofContainerAuto(
                    ContainerAuto.builder()
                        .addFileId("file-123")
                        .memoryLimit(ContainerAuto.MemoryLimit._1G)
                        .networkPolicy(ContainerNetworkPolicyDisabled.builder().build())
                        .addSkill(SkillReference.builder().skillId("x").version("version").build())
                        .build()
                )
            )
    }

    @Test
    fun roundtrip() {
        val jsonMapper = jsonMapper()
        val functionShellTool =
            FunctionShellTool.builder()
                .environment(
                    ContainerAuto.builder()
                        .addFileId("file-123")
                        .memoryLimit(ContainerAuto.MemoryLimit._1G)
                        .networkPolicy(ContainerNetworkPolicyDisabled.builder().build())
                        .addSkill(SkillReference.builder().skillId("x").version("version").build())
                        .build()
                )
                .build()

        val roundtrippedFunctionShellTool =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(functionShellTool),
                jacksonTypeRef<FunctionShellTool>(),
            )

        assertThat(roundtrippedFunctionShellTool).isEqualTo(functionShellTool)
    }
}
