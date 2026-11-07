// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.beta.agents.automations

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.beta.agents.HostedPlugin
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AutomationEnvironmentTest {

    @Test
    fun ofNone() {
        val automationEnvironment = AutomationEnvironment.ofNone()

        assertThat(automationEnvironment.none()).contains(JsonValue.from(mapOf("type" to "none")))
        assertThat(automationEnvironment.openaiHosted()).isEmpty
        assertThat(automationEnvironment.selfHosted()).isEmpty
    }

    @Test
    fun ofNoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationEnvironment = AutomationEnvironment.ofNone()

        val roundtrippedAutomationEnvironment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationEnvironment),
                jacksonTypeRef<AutomationEnvironment>(),
            )

        assertThat(roundtrippedAutomationEnvironment).isEqualTo(automationEnvironment)
    }

    @Test
    fun ofOpenAIHosted() {
        val openaiHosted =
            AutomationEnvironment.OpenAIHosted.builder()
                .addCapabilityDirectory("string")
                .containerSize(AutomationEnvironment.OpenAIHosted.ContainerSize.SMALL)
                .desktop(AutomationEnvironment.OpenAIHosted.Desktop.builder().enabled(true).build())
                .environmentId("environment_id")
                .environmentTemplateId("environment_template_id")
                .addFile(
                    AutomationEnvironment.OpenAIHosted.File.FileId.builder()
                        .fileId("file_id")
                        .path("path")
                        .build()
                )
                .network(
                    AutomationEnvironment.OpenAIHosted.Network.builder()
                        .access(AutomationEnvironment.OpenAIHosted.Network.Access.ENABLED)
                        .addAllowedDomain("string")
                        .build()
                )
                .packages(
                    AutomationEnvironment.OpenAIHosted.Packages.builder()
                        .addNpm("string")
                        .addPython("string")
                        .addSystem("string")
                        .build()
                )
                .addPlugin(HostedPlugin.builder().description("description").name("name").build())
                .addSkill(
                    AutomationEnvironment.OpenAIHosted.Skill.SkillReference.builder()
                        .skillId("skill_id")
                        .version("version")
                        .build()
                )
                .build()

        val automationEnvironment = AutomationEnvironment.ofOpenAIHosted(openaiHosted)

        assertThat(automationEnvironment.none()).isEmpty
        assertThat(automationEnvironment.openaiHosted()).contains(openaiHosted)
        assertThat(automationEnvironment.selfHosted()).isEmpty
    }

    @Test
    fun ofOpenAIHostedRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationEnvironment =
            AutomationEnvironment.ofOpenAIHosted(
                AutomationEnvironment.OpenAIHosted.builder()
                    .addCapabilityDirectory("string")
                    .containerSize(AutomationEnvironment.OpenAIHosted.ContainerSize.SMALL)
                    .desktop(
                        AutomationEnvironment.OpenAIHosted.Desktop.builder().enabled(true).build()
                    )
                    .environmentId("environment_id")
                    .environmentTemplateId("environment_template_id")
                    .addFile(
                        AutomationEnvironment.OpenAIHosted.File.FileId.builder()
                            .fileId("file_id")
                            .path("path")
                            .build()
                    )
                    .network(
                        AutomationEnvironment.OpenAIHosted.Network.builder()
                            .access(AutomationEnvironment.OpenAIHosted.Network.Access.ENABLED)
                            .addAllowedDomain("string")
                            .build()
                    )
                    .packages(
                        AutomationEnvironment.OpenAIHosted.Packages.builder()
                            .addNpm("string")
                            .addPython("string")
                            .addSystem("string")
                            .build()
                    )
                    .addPlugin(
                        HostedPlugin.builder().description("description").name("name").build()
                    )
                    .addSkill(
                        AutomationEnvironment.OpenAIHosted.Skill.SkillReference.builder()
                            .skillId("skill_id")
                            .version("version")
                            .build()
                    )
                    .build()
            )

        val roundtrippedAutomationEnvironment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationEnvironment),
                jacksonTypeRef<AutomationEnvironment>(),
            )

        assertThat(roundtrippedAutomationEnvironment).isEqualTo(automationEnvironment)
    }

    @Test
    fun ofSelfHosted() {
        val selfHosted =
            AutomationEnvironment.SelfHosted.builder()
                .addCapabilityDirectory("string")
                .environmentId("environment_id")
                .workspaceDirectory("workspace_directory")
                .build()

        val automationEnvironment = AutomationEnvironment.ofSelfHosted(selfHosted)

        assertThat(automationEnvironment.none()).isEmpty
        assertThat(automationEnvironment.openaiHosted()).isEmpty
        assertThat(automationEnvironment.selfHosted()).contains(selfHosted)
    }

    @Test
    fun ofSelfHostedRoundtrip() {
        val jsonMapper = jsonMapper()
        val automationEnvironment =
            AutomationEnvironment.ofSelfHosted(
                AutomationEnvironment.SelfHosted.builder()
                    .addCapabilityDirectory("string")
                    .environmentId("environment_id")
                    .workspaceDirectory("workspace_directory")
                    .build()
            )

        val roundtrippedAutomationEnvironment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(automationEnvironment),
                jacksonTypeRef<AutomationEnvironment>(),
            )

        assertThat(roundtrippedAutomationEnvironment).isEqualTo(automationEnvironment)
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
        val automationEnvironment =
            jsonMapper().convertValue(testCase.value, jacksonTypeRef<AutomationEnvironment>())

        val e = assertThrows<OpenAIInvalidDataException> { automationEnvironment.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
