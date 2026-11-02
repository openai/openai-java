package com.openai.models.live

import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class ResponsesDelegationPolymorphismTest {
    private val mapper = jsonMapper()
    private val payload =
        """
        {
          "model": "test-model",
          "tool_choice": {"type": "file_search"},
          "tools": [
            {
              "type": "shell",
              "environment": {"type": "container_reference", "container_id": "ctr_test"},
              "client_tag": "retained"
            }
          ]
        }
        """
            .trimIndent()
    private val unknownPayload = """{"type":"future_variant","value":"retained"}"""
    private val unknownValue =
        JsonValue.from(mapOf("type" to "future_variant", "value" to "retained"))

    @Test
    fun createDelegationDecodesAndDispatchesExpandedVariants() {
        val config = mapper.readValue(payload, ResponsesDelegationConfig::class.java).validate()
        val choice = config.toolChoice().get()
        val shell = config.tools().get().single()

        assertThat(choice.isLiveSpecificFileSearchParam()).isTrue()
        assertThat(
                shell.match(
                    ResponsesDelegationConfig.Tool.Handler.builder<String>()
                        .onShell { it.environment().get().asContainerReference().containerId() }
                        .build()
                )
            )
            .isEqualTo("ctr_test")
        val legacyVisitor =
            object : ResponsesDelegationConfig.ToolChoice.Visitor<JsonValue?> {
                override fun visitLiveToolChoiceEnum(
                    liveToolChoiceEnum: ResponsesDelegationConfig.ToolChoice.LiveToolChoiceEnum
                ): JsonValue = JsonValue.from(liveToolChoiceEnum.value().name)

                override fun visitLiveFunctionToolChoiceParam(
                    liveFunctionToolChoiceParam:
                        ResponsesDelegationConfig.ToolChoice.LiveFunctionToolChoiceParam
                ): JsonValue? = null

                override fun visitLiveMcpToolChoiceParam(
                    liveMcpToolChoiceParam:
                        ResponsesDelegationConfig.ToolChoice.LiveMcpToolChoiceParam
                ): JsonValue? = null

                override fun unknown(json: JsonValue?) = json
            }
        assertThat(choice.accept(legacyVisitor))
            .isEqualTo(JsonValue.from(mapOf("type" to "file_search")))
        val unknown =
            mapper.readValue(unknownPayload, ResponsesDelegationConfig.ToolChoice::class.java)
        assertThat(unknown.accept(legacyVisitor)).isEqualTo(JsonValue.from("_UNKNOWN"))
        assertThat(
                unknown.match(
                    ResponsesDelegationConfig.ToolChoice.Handler.builder<JsonValue>()
                        .onDefault { it._json().get() }
                        .build()
                )
            )
            .isEqualTo(unknownValue)
        assertThat(mapper.readTree(mapper.writeValueAsString(config)))
            .isEqualTo(mapper.readTree(payload))
    }

    @Test
    fun updateDelegationDecodesAndDispatchesExpandedVariants() {
        val config =
            mapper.readValue(payload, ResponsesDelegationUpdateConfig::class.java).validate()
        val choice = config.toolChoice().get()
        val shell = config.tools().get().single()

        assertThat(shell.asShell().environment().get().asContainerReference().containerId())
            .isEqualTo("ctr_test")
        assertThat(
                choice.match(
                    ResponsesDelegationUpdateConfig.ToolChoice.Handler.builder<JsonValue>()
                        .onLiveSpecificFileSearchParam { it }
                        .build()
                )
            )
            .isEqualTo(JsonValue.from(mapOf("type" to "file_search")))
        val legacyVisitor =
            object : ResponsesDelegationUpdateConfig.Tool.Visitor<JsonValue?> {
                override fun visitFunction(function: FunctionTool): JsonValue? = null

                override fun visitWebSearch(webSearch: JsonValue): JsonValue? = null

                override fun unknown(json: JsonValue?) = json
            }
        assertThat(shell.accept(legacyVisitor))
            .isEqualTo(
                JsonValue.from(
                    mapOf(
                        "type" to "shell",
                        "environment" to
                            mapOf("type" to "container_reference", "container_id" to "ctr_test"),
                        "client_tag" to "retained",
                    )
                )
            )
        val unknown =
            mapper.readValue(unknownPayload, ResponsesDelegationUpdateConfig.Tool::class.java)
        assertThat(unknown.accept(legacyVisitor)).isEqualTo(unknownValue)
        assertThat(
                unknown.match(
                    ResponsesDelegationUpdateConfig.Tool.Handler.builder<JsonValue>()
                        .onDefault { it._json().get() }
                        .build()
                )
            )
            .isEqualTo(unknownValue)
        assertThat(mapper.readTree(mapper.writeValueAsString(config)))
            .isEqualTo(mapper.readTree(payload))
    }
}
