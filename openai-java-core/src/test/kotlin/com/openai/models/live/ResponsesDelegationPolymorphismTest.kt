package com.openai.models.live

import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
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
    fun sessionUpdateSendsTypedToolsAndStringChoice() {
        val responses =
            ResponsesDelegationUpdateConfig.builder()
                .addToolWebSearch()
                .toolChoice(ResponsesDelegationUpdateConfig.ToolChoice.LiveToolChoiceEnum.AUTO)
                .build()
        val delegation =
            SessionUpdateConfig.Delegation.Responses.builder().responses(responses).build()
        val session = SessionUpdateConfig.builder().delegation(delegation).build()
        val event =
            ClientEvent.ofSessionUpdate(SessionUpdateEvent.builder().session(session).build())
        val json = mapper.readTree(mapper.writeValueAsString(event.validate()))
        assertThat(json["type"].asText()).isEqualTo("session.update")
        val settings = json["session"]["delegation"]["responses"]
        assertThat(settings["tool_choice"].asText()).isEqualTo("auto")
        assertThat(settings["tools"][0]["type"].asText()).isEqualTo("web_search")
    }

    @Test
    fun sessionUpdatedEventDecodesDelegationToolChoice() {
        val event =
            mapper.readValue(
                """{"type":"session.updated","session":{"delegation":{"type":"responses","responses":$payload}}}""",
                ServerEvent::class.java,
            )
        val config =
            event
                .asSessionUpdated()
                .sessionOrThrow()
                .delegation()
                .get()
                .asResponses()
                .responsesOrThrow()
                .validate()
        assertThat(config.toolChoice().get().isLiveSpecificFileSearchParam()).isTrue()
        assertThat(config.tools().get().single().isShell()).isTrue()
    }

    @Test
    fun createDelegationDecodesAndDispatchesExpandedVariants() {
        val config = mapper.readValue(payload, ResponsesDelegationConfig::class.java).validate()
        val choice = config.toolChoice().get()
        val shell = config.tools().get().single()

        assertThat(choice.isLiveSpecificFileSearchParam()).isTrue()
        assertThat(
                shell.match(
                    ResponsesDelegationConfig.Tool.Handler.builder<String>()
                        .onShell {
                            it.environment().get().asContainerReference().containerIdOrThrow()
                        }
                        .build()
                )
            )
            .isEqualTo("ctr_test")
        val handler =
            ResponsesDelegationConfig.ToolChoice.Handler.builder<JsonValue>()
                .onLiveToolChoiceEnum { JsonValue.from(it.value().name) }
                .onDefault { JsonValue.from(it) }
                .build()
        val auto = mapper.readValue("\"auto\"", ResponsesDelegationConfig.ToolChoice::class.java)
        assertThat(auto.match(handler)).isEqualTo(JsonValue.from("AUTO"))
        assertThat(choice.match(handler)).isEqualTo(JsonValue.from(mapOf("type" to "file_search")))
        val unknown =
            mapper.readValue(unknownPayload, ResponsesDelegationConfig.ToolChoice::class.java)
        assertThat(unknown.match(handler)).isEqualTo(JsonValue.from("_UNKNOWN"))
        val fallback =
            ResponsesDelegationConfig.ToolChoice.Handler.builder<JsonValue>()
                .onDefault { it._json().get() }
                .build()
        assertThat(unknown.match(fallback)).isEqualTo(unknownValue)
        assertThat(mapper.readTree(mapper.writeValueAsString(config)))
            .isEqualTo(mapper.readTree(payload))
    }

    @Test
    fun updateDelegationDecodesAndDispatchesExpandedVariants() {
        val config =
            mapper.readValue(payload, ResponsesDelegationUpdateConfig::class.java).validate()
        val choice = config.toolChoice().get()
        val shell = config.tools().get().single()

        assertThat(shell.asShell().environment().get().asContainerReference().containerIdOrThrow())
            .isEqualTo("ctr_test")
        assertThat(
                choice.match(
                    ResponsesDelegationUpdateConfig.ToolChoice.Handler.builder<JsonValue>()
                        .onLiveSpecificFileSearchParam { it }
                        .build()
                )
            )
            .isEqualTo(JsonValue.from(mapOf("type" to "file_search")))
        val handler =
            ResponsesDelegationUpdateConfig.Tool.Handler.builder<JsonValue>()
                .onWebSearch { it }
                .onDefault { JsonValue.from(it) }
                .build()
        assertThat(shell.match(handler))
            .isEqualTo(JsonValue.from(mapper.readTree(payload)["tools"][0]))
        val unknown =
            mapper.readValue(unknownPayload, ResponsesDelegationUpdateConfig.Tool::class.java)
        assertThat(unknown.match(handler)).isEqualTo(unknownValue)
        val withoutFallback = ResponsesDelegationUpdateConfig.Tool.Handler.builder<Unit>().build()
        assertThatThrownBy { shell.match(withoutFallback) }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
        assertThatThrownBy { unknown.match(withoutFallback) }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
        assertThat(mapper.readTree(mapper.writeValueAsString(config)))
            .isEqualTo(mapper.readTree(payload))
    }
}
