package com.openai.core

import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.live.DecisionItemCreateEvent
import com.openai.models.live.DecisionItemCreatedEvent
import java.util.Optional
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class DecisionItemGetterTest {
    private val mapper = jsonMapper()

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                """{"id":"m","type":"message","role":"user","content":"hello"}""",
                """{"id":"m","type":"message","role":"developer","content":"hello"}""",
                """{"id":"m","type":"message","role":"system","content":"hello"}""",
                """{"id":"m","type":"message","role":"assistant","content":"hello"}""",
                """{"id":"c","type":"function_call","call_id":"c","name":"f","arguments":"{}"}""",
                """{"id":"c","type":"function_call_output","call_id":"c","output":"ok"}""",
                """{"id":"c","type":"custom_tool_call","call_id":"c","name":"f","input":"in"}""",
                """{"id":"c","type":"custom_tool_call_output","call_id":"c","output":"ok"}""",
            ]
    )
    fun readsDiscriminatorsOfValidServiceItems(json: String) {
        val input = mapper.readTree(json)
        val create = mapper.readValue(json, DecisionItemCreateEvent.Item::class.java).validate()
        val created = mapper.readValue(json, DecisionItemCreatedEvent.Item::class.java).validate()
        fun check(name: String, raw: JsonField<*>, optional: Optional<*>, throwing: () -> Any) {
            val token = input.get(name)
            if (token == null) {
                assertThat(optional).isEmpty()
                assertThat(raw.isMissing()).isTrue()
                assertThrows<OpenAIInvalidDataException> { throwing() }
            } else {
                val expected = JsonValue.fromJsonNode(token)
                assertThat(optional.map { JsonValue.from(it) }).contains(expected)
                assertThat(JsonValue.from(throwing())).isEqualTo(expected)
                assertThat(JsonValue.from(raw)).isEqualTo(expected)
            }
        }

        check("type", create._type(), create.type(), create::typeOrThrow)
        check("type", created._type(), created.type(), created::typeOrThrow)
        check("role", create._role(), create.role(), create::roleOrThrow)
        check("role", created._role(), created.role(), created::roleOrThrow)
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "{}",
                """{"type":null,"role":null}""",
                """{"type":1,"role":1}""",
                """{"type":{},"role":{}}""",
                """{"type":{"value":"message"},"role":{"value":"user"}}""",
                """{"type":[],"role":[]}""",
                """{"type":true,"role":true}""",
                """{"type":"unknown","role":"unknown"}""",
            ]
    )
    fun distinguishesMissingNullAndInvalidDiscriminators(json: String) {
        val input = mapper.readTree(json)
        val create = mapper.readValue(json, DecisionItemCreateEvent.Item::class.java)
        val created = mapper.readValue(json, DecisionItemCreatedEvent.Item::class.java)

        fun check(
            name: String,
            raw: JsonField<*>,
            optional: () -> Optional<*>,
            throwing: () -> Any,
        ) {
            val token = input.get(name)
            when {
                token == null -> assertThat(raw.isMissing()).isTrue()
                token.isNull -> assertThat(raw.isNull()).isTrue()
                else -> assertThat(JsonValue.from(raw)).isEqualTo(JsonValue.fromJsonNode(token))
            }
            if (token == null || token.isNull) {
                assertThat(optional()).isEmpty()
            } else {
                assertThat(assertThrows<OpenAIInvalidDataException> { optional() })
                    .hasMessageContaining(name)
            }
            assertThat(assertThrows<OpenAIInvalidDataException> { throwing() })
                .hasMessageContaining(name)
        }

        check("type", create._type(), create::type, create::typeOrThrow)
        check("type", created._type(), created::type, created::typeOrThrow)
        check("role", create._role(), create::role, create::roleOrThrow)
        check("role", created._role(), created::role, created::roleOrThrow)
    }

    @ParameterizedTest
    @ValueSource(strings = ["system", "developer", "assistant"])
    fun preservesReleasedNullTypeValidationForServiceRoles(role: String) {
        val wire =
            mapper.createObjectNode().put("id", "m").put("role", role).put("content", "hello")
        for (explicitNull in listOf(false, true)) {
            if (explicitNull) wire.putNull("type")
            val create = mapper.treeToValue(wire, DecisionItemCreateEvent.Item::class.java)
            val created = mapper.treeToValue(wire, DecisionItemCreatedEvent.Item::class.java)
            assertThat(create.roleOrThrow()).isEqualTo(JsonValue.from(role))
            assertThat(created.roleOrThrow()).isEqualTo(JsonValue.from(role))
            assertThat(create.isValid()).isEqualTo(!explicitNull)
            assertThat(created.isValid()).isEqualTo(!explicitNull)
        }
    }

    @Test
    fun outerEventTypesStillRequireTheirOwnConstant() {
        val json = """{"type":"message"}"""
        val create = mapper.readValue(json, DecisionItemCreateEvent::class.java)
        val created = mapper.readValue(json, DecisionItemCreatedEvent::class.java)
        assertThrows<OpenAIInvalidDataException> { create.type() }
        assertThrows<OpenAIInvalidDataException> { create.typeOrThrow() }
        assertThrows<OpenAIInvalidDataException> { created.type() }
        assertThrows<OpenAIInvalidDataException> { created.typeOrThrow() }
    }
}
