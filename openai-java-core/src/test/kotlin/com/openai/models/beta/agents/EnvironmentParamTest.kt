// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class EnvironmentParamTest {

    @Test
    fun ofNone() {
        val environmentParam = EnvironmentParam.ofNone()

        assertThat(environmentParam.none()).contains(JsonValue.from(mapOf("type" to "none")))
        assertThat(environmentParam.openaiHosted()).isEmpty
        assertThat(environmentParam.selfHosted()).isEmpty
    }

    @Test
    fun ofNoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val environmentParam = EnvironmentParam.ofNone()

        val roundtrippedEnvironmentParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environmentParam),
                jacksonTypeRef<EnvironmentParam>(),
            )

        assertThat(roundtrippedEnvironmentParam).isEqualTo(environmentParam)
    }

    @Test
    fun ofOpenAIHosted() {
        val openaiHosted =
            EnvironmentParam.OpenAIHosted.builder()
                .addCapabilityDirectory("string")
                .env(
                    EnvironmentParam.OpenAIHosted.Env.builder()
                        .putAdditionalProperty("foo", JsonValue.from("string"))
                        .build()
                )
                .environmentTemplateId("environment_template_id")
                .addFile(HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build())
                .network(
                    EnvironmentParam.OpenAIHosted.Network.builder()
                        .access(EnvironmentParam.OpenAIHosted.Network.Access.ENABLED)
                        .addAllowedDomain("string")
                        .build()
                )
                .packages(
                    EnvironmentParam.OpenAIHosted.Packages.builder()
                        .addNpm("string")
                        .addPython("string")
                        .addSystem("string")
                        .build()
                )
                .addPlugin(
                    HostedPluginParam.builder()
                        .description("description")
                        .name("x")
                        .source(InlineCapabilitySourceParam.builder().data("x").build())
                        .build()
                )
                .addSetupCommand(SetupCommandParam.builder().command("command").cwd("cwd").build())
                .addSkill(
                    HostedSkillParam.SkillReference.builder()
                        .skillId("x")
                        .version("version")
                        .build()
                )
                .build()

        val environmentParam = EnvironmentParam.ofOpenAIHosted(openaiHosted)

        assertThat(environmentParam.none()).isEmpty
        assertThat(environmentParam.openaiHosted()).contains(openaiHosted)
        assertThat(environmentParam.selfHosted()).isEmpty
    }

    @Test
    fun ofOpenAIHostedRoundtrip() {
        val jsonMapper = jsonMapper()
        val environmentParam =
            EnvironmentParam.ofOpenAIHosted(
                EnvironmentParam.OpenAIHosted.builder()
                    .addCapabilityDirectory("string")
                    .env(
                        EnvironmentParam.OpenAIHosted.Env.builder()
                            .putAdditionalProperty("foo", JsonValue.from("string"))
                            .build()
                    )
                    .environmentTemplateId("environment_template_id")
                    .addFile(
                        HostedEnvironmentFileParam.FileId.builder().fileId("x").path("x").build()
                    )
                    .network(
                        EnvironmentParam.OpenAIHosted.Network.builder()
                            .access(EnvironmentParam.OpenAIHosted.Network.Access.ENABLED)
                            .addAllowedDomain("string")
                            .build()
                    )
                    .packages(
                        EnvironmentParam.OpenAIHosted.Packages.builder()
                            .addNpm("string")
                            .addPython("string")
                            .addSystem("string")
                            .build()
                    )
                    .addPlugin(
                        HostedPluginParam.builder()
                            .description("description")
                            .name("x")
                            .source(InlineCapabilitySourceParam.builder().data("x").build())
                            .build()
                    )
                    .addSetupCommand(
                        SetupCommandParam.builder().command("command").cwd("cwd").build()
                    )
                    .addSkill(
                        HostedSkillParam.SkillReference.builder()
                            .skillId("x")
                            .version("version")
                            .build()
                    )
                    .build()
            )

        val roundtrippedEnvironmentParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environmentParam),
                jacksonTypeRef<EnvironmentParam>(),
            )

        assertThat(roundtrippedEnvironmentParam).isEqualTo(environmentParam)
    }

    @Test
    fun ofSelfHosted() {
        val selfHosted =
            EnvironmentParam.SelfHosted.builder()
                .workspaceDirectory("workspace_directory")
                .addCapabilityDirectory("string")
                .build()

        val environmentParam = EnvironmentParam.ofSelfHosted(selfHosted)

        assertThat(environmentParam.none()).isEmpty
        assertThat(environmentParam.openaiHosted()).isEmpty
        assertThat(environmentParam.selfHosted()).contains(selfHosted)
    }

    @Test
    fun ofSelfHostedRoundtrip() {
        val jsonMapper = jsonMapper()
        val environmentParam =
            EnvironmentParam.ofSelfHosted(
                EnvironmentParam.SelfHosted.builder()
                    .workspaceDirectory("workspace_directory")
                    .addCapabilityDirectory("string")
                    .build()
            )

        val roundtrippedEnvironmentParam =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environmentParam),
                jacksonTypeRef<EnvironmentParam>(),
            )

        assertThat(roundtrippedEnvironmentParam).isEqualTo(environmentParam)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        BOOLEAN(JsonValue.from(false)),
        STRING(JsonValue.from("invalid")),
        INTEGER(JsonValue.from(-1)),
        FLOAT(JsonValue.from(3.14)),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val environmentParam =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<EnvironmentParam>())

        val e = assertThrows<OpenAIInvalidDataException> { environmentParam.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
