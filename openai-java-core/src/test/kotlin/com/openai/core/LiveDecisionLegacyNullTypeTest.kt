package com.openai.core

import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.live.DecisionItemCreateEvent
import com.openai.models.live.DecisionItemCreatedEvent
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class LiveDecisionLegacyNullTypeTest {
    private val mapper = jsonMapper()

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "{\"role\":\"user\",\"content\":\"fixture\",\"type\":null}",
                "{\"role\":\"user\",\"content\":[{\"type\":\"input_text\",\"text\":\"fixture\"}],\"type\":null}",
                "{\"role\":\"user\",\"content\":[{\"type\":\"input_image\",\"image_url\":\"https://invalid.example/image.png\"}],\"type\":null}",
                "{\"role\":\"user\",\"content\":[],\"type\":null}",
                "{\"role\":\"user\",\"content\":\"fixture\",\"type\":null,\"call_id\":false,\"name\":false,\"status\":false}",
            ]
    )
    fun acceptsReleasedNullTypeMessagesAndPreservesWireType(wire: String) {
        for (id in listOf("", ",\"id\":null", ",\"id\":\"i_demo\"")) {
            val inputJson = wire.dropLast(1) + id + "}"
            val input = mapper.readValue(inputJson, DecisionItemCreateEvent.Item::class.java)
            assertThat(input._type().isNull()).isTrue()
            assertThat(input.isValid()).isTrue()
            assertThat(input.validate()).isSameAs(input)
            assertThat(mapper.readTree(mapper.writeValueAsString(input)))
                .isEqualTo(mapper.readTree(inputJson))
        }
        val storedJson = wire.dropLast(1) + ",\"id\":\"i_demo\"}"
        val stored = mapper.readValue(storedJson, DecisionItemCreatedEvent.Item::class.java)
        assertThat(stored._type().isNull()).isTrue()
        assertThat(stored.isValid()).isTrue()
        assertThat(stored.validate()).isSameAs(stored)
        assertThat(mapper.readTree(mapper.writeValueAsString(stored)))
            .isEqualTo(mapper.readTree(storedJson))
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                "{\"role\":\"user\",\"content\":null,\"type\":null}",
                "{\"role\":\"user\",\"type\":null}",
                "{\"role\":\"user\",\"content\":false,\"type\":null}",
                "{\"role\":\"user\",\"content\":[{\"type\":\"input_text\",\"text\":false}],\"type\":null}",
                "{\"role\":\"user\",\"content\":[{\"type\":\"input_image\",\"image_url\":null}],\"type\":null}",
                "{\"role\":\"user\",\"content\":[{\"type\":\"input_json\",\"data\":{\"n\":1}}],\"type\":null}",
                "{\"role\":\"system\",\"content\":\"fixture\",\"type\":null}",
                "{\"content\":\"fixture\",\"type\":null}",
                "{\"role\":null,\"content\":\"fixture\",\"type\":null}",
                "{\"role\":\"admin\",\"content\":\"fixture\",\"type\":null}",
                "{\"role\":\"user\",\"content\":\"fixture\",\"type\":null,\"id\":37}",
            ]
    )
    fun rejectsNullTypeValuesThatFailedReleasedValidation(wire: String) {
        val input = mapper.readValue(wire, DecisionItemCreateEvent.Item::class.java)
        assertThat(input.isValid()).isFalse()
        assertThrows<OpenAIInvalidDataException> { input.validate() }
        val withStoredId =
            mapper.readTree(wire).deepCopy<com.fasterxml.jackson.databind.node.ObjectNode>()
        if (!withStoredId.has("id")) withStoredId.put("id", "i_demo")
        val stored = mapper.treeToValue(withStoredId, DecisionItemCreatedEvent.Item::class.java)
        assertThat(stored.isValid()).isFalse()
        assertThrows<OpenAIInvalidDataException> { stored.validate() }
    }

    @Test
    fun retainsReleasedBuilderAndRequiredStoredIdBehavior() {
        val input =
            DecisionItemCreateEvent.Item.builder()
                .content("fixture")
                .type(JsonValue.from(null))
                .build()
        assertThat(input.validate()).isSameAs(input)
        assertThat(input._type().isNull()).isTrue()
        val stored =
            DecisionItemCreatedEvent.Item.builder()
                .id("i_demo")
                .content("fixture")
                .type(JsonValue.from(null))
                .build()
        assertThat(stored.validate()).isSameAs(stored)
        assertThat(stored._type().isNull()).isTrue()
        for (id in listOf("", ",\"id\":null")) {
            val wire = "{\"role\":\"user\",\"content\":\"fixture\",\"type\":null" + id + "}"
            val missingStoredId = mapper.readValue(wire, DecisionItemCreatedEvent.Item::class.java)
            assertThat(missingStoredId.isValid()).isFalse()
            assertThrows<OpenAIInvalidDataException> { missingStoredId.validate() }
        }
    }

    @ParameterizedTest
    @ValueSource(
        strings =
            [
                """[{"type":"input_json","data":[null]}]""",
                """[{"type":"input_json","data":[{"ok":[null,3,true]},false]}]""",
            ]
    )
    fun rejectsMalformedNewContentWithConcreteOrOmittedMessageType(content: String) {
        for (type in listOf("", ""","type":"message"""")) {
            val wire = """{"role":"user","content":$content$type}"""
            val input = mapper.readValue(wire, DecisionItemCreateEvent.Item::class.java)
            assertThat(input.isValid()).isFalse()
            assertThrows<OpenAIInvalidDataException> { input.validate() }
            val withId = wire.dropLast(1) + ""","id":"i_demo"}"""
            val stored = mapper.readValue(withId, DecisionItemCreatedEvent.Item::class.java)
            assertThat(stored.isValid()).isFalse()
            assertThrows<OpenAIInvalidDataException> { stored.validate() }
        }
    }
}
