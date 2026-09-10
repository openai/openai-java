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

internal class EnvironmentTest {

    @Test
    fun ofNone() {
        val environment = Environment.ofNone()

        assertThat(environment.none()).contains(JsonValue.from(mapOf("type" to "none")))
        assertThat(environment.openaiHosted()).isEmpty
        assertThat(environment.selfHosted()).isEmpty
    }

    @Test
    fun ofNoneRoundtrip() {
        val jsonMapper = jsonMapper()
        val environment = Environment.ofNone()

        val roundtrippedEnvironment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environment),
                jacksonTypeRef<Environment>(),
            )

        assertThat(roundtrippedEnvironment).isEqualTo(environment)
    }

    @Test
    fun ofOpenAIHosted() {
        val openaiHosted =
            Environment.OpenAIHosted.builder()
                .id("id")
                .addCapabilityDirectory("string")
                .addFile(
                    HostedEnvironmentFileId.builder()
                        .id("id")
                        .fileId("file_id")
                        .path("path")
                        .sizeBytes(0L)
                        .build()
                )
                .network(
                    Environment.OpenAIHosted.Network.builder()
                        .access(Environment.OpenAIHosted.Network.Access.ENABLED)
                        .addAllowedDomain("string")
                        .build()
                )
                .packages(
                    Environment.OpenAIHosted.Packages.builder()
                        .addNpm("string")
                        .addPython("string")
                        .addSystem("string")
                        .build()
                )
                .addPlugin(HostedPlugin.builder().description("description").name("name").build())
                .addSkill(
                    HostedSkillReference.builder()
                        .description("description")
                        .name("name")
                        .skillId("skill_id")
                        .version("version")
                        .build()
                )
                .build()

        val environment = Environment.ofOpenAIHosted(openaiHosted)

        assertThat(environment.none()).isEmpty
        assertThat(environment.openaiHosted()).contains(openaiHosted)
        assertThat(environment.selfHosted()).isEmpty
    }

    @Test
    fun ofOpenAIHostedRoundtrip() {
        val jsonMapper = jsonMapper()
        val environment =
            Environment.ofOpenAIHosted(
                Environment.OpenAIHosted.builder()
                    .id("id")
                    .addCapabilityDirectory("string")
                    .addFile(
                        HostedEnvironmentFileId.builder()
                            .id("id")
                            .fileId("file_id")
                            .path("path")
                            .sizeBytes(0L)
                            .build()
                    )
                    .network(
                        Environment.OpenAIHosted.Network.builder()
                            .access(Environment.OpenAIHosted.Network.Access.ENABLED)
                            .addAllowedDomain("string")
                            .build()
                    )
                    .packages(
                        Environment.OpenAIHosted.Packages.builder()
                            .addNpm("string")
                            .addPython("string")
                            .addSystem("string")
                            .build()
                    )
                    .addPlugin(
                        HostedPlugin.builder().description("description").name("name").build()
                    )
                    .addSkill(
                        HostedSkillReference.builder()
                            .description("description")
                            .name("name")
                            .skillId("skill_id")
                            .version("version")
                            .build()
                    )
                    .build()
            )

        val roundtrippedEnvironment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environment),
                jacksonTypeRef<Environment>(),
            )

        assertThat(roundtrippedEnvironment).isEqualTo(environment)
    }

    @Test
    fun ofSelfHosted() {
        val selfHosted =
            Environment.SelfHosted.builder()
                .id("id")
                .addCapabilityDirectory("string")
                .remoteUrl("remote_url")
                .workspaceDirectory("workspace_directory")
                .build()

        val environment = Environment.ofSelfHosted(selfHosted)

        assertThat(environment.none()).isEmpty
        assertThat(environment.openaiHosted()).isEmpty
        assertThat(environment.selfHosted()).contains(selfHosted)
    }

    @Test
    fun ofSelfHostedRoundtrip() {
        val jsonMapper = jsonMapper()
        val environment =
            Environment.ofSelfHosted(
                Environment.SelfHosted.builder()
                    .id("id")
                    .addCapabilityDirectory("string")
                    .remoteUrl("remote_url")
                    .workspaceDirectory("workspace_directory")
                    .build()
            )

        val roundtrippedEnvironment =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(environment),
                jacksonTypeRef<Environment>(),
            )

        assertThat(roundtrippedEnvironment).isEqualTo(environment)
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
        val environment = jsonMapper().convertValue(testCase.value, jacksonTypeRef<Environment>())

        val e = assertThrows<OpenAIInvalidDataException> { environment.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
