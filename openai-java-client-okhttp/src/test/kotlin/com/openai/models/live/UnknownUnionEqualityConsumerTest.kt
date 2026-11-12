package com.openai.models.live

import com.openai.core.jsonMapper
import com.openai.models.decisions.DecisionChoiceOption
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class UnknownUnionEqualityConsumerTest {
    private val mapper = jsonMapper()

    @Test
    fun assistantEnvelopesKeepContentAndIdPresence() {
        for (content in listOf("", ""","content":null""")) {
            val wire = """{"role":"assistant","id":"stored"$content}"""
            val create = mapper.readValue(wire, DecisionAssistantMessage::class.java)
            val stored = mapper.readValue(wire, DecisionStoredAssistantMessage::class.java)
            for (field in listOf(create._content(), stored._content())) {
                assertThat(field.isMissing()).isEqualTo(content.isEmpty())
                assertThat(field.isNull()).isEqualTo(content.isNotEmpty())
            }
            assertThat(create.isValid()).isFalse()
            assertThat(stored.isValid()).isFalse()
        }
        for (id in listOf("", ""","id":null""")) {
            val wire = """{"role":"assistant","content":"ok"$id}"""
            assertThat(mapper.readValue(wire, DecisionAssistantMessage::class.java).isValid())
                .isTrue()
            assertThat(mapper.readValue(wire, DecisionStoredAssistantMessage::class.java).isValid())
                .isFalse()
        }
        for (part in
            listOf(
                """{"type":"input_text","text":"bad"}""",
                """{"type":"refusal","text":"bad"}""",
            )) {
            val wire = """{"role":"assistant","id":"stored","content":[$part]}"""
            val create = mapper.readValue(wire, DecisionAssistantMessage::class.java)
            val stored = mapper.readValue(wire, DecisionStoredAssistantMessage::class.java)
            assertThat(create.content()).isEqualTo(stored.content())
            assertThat(create.isValid()).isFalse()
            assertThat(stored.isValid()).isFalse()
        }
    }

    @Test
    fun distinctUnknownTopLevelPayloadsRemainDistinct() {
        assertUnknownIdentity(DecisionQuestionInputPart::class.java)
    }

    @Test
    fun distinctUnknownNestedPayloadsRemainDistinct() {
        assertUnknownIdentity(DecisionStoredDeveloperMessage.Content::class.java)
    }

    @Test
    fun distinctUnknownCreateItemsRemainDistinct() {
        assertUnknownIdentity(DecisionItemCreateEvent.Item::class.java)
    }

    @Test
    fun distinctUnknownCreatedItemsRemainDistinct() {
        assertUnknownIdentity(DecisionItemCreatedEvent.Item::class.java)
    }

    @Test
    fun unknownMessageRolesRetainTheirWireIdentity() {
        val first = """{"id":"item","type":"message","role":"future_one","content":"same"}"""
        val second = """{"id":"item","type":"message","role":"future_two","content":"same"}"""
        val request = assertUnknownIdentity(DecisionItemCreateEvent.Item::class.java, first, second)
        val stored = assertUnknownIdentity(DecisionItemCreatedEvent.Item::class.java, first, second)
        assertThat(request._json()).isPresent()
        assertThat(stored._json()).isPresent()
        assertThat(request.isValid()).isFalse()
        assertThat(stored.isValid()).isFalse()
    }

    @Test
    fun distinctUnknownSystemContentRemainsDistinct() {
        assertUnknownIdentity(DecisionStoredSystemMessage.Content::class.java)
    }

    @Test
    fun distinctUnknownUserContentRemainsDistinct() {
        assertUnknownIdentity(DecisionStoredUserMessage.Content::class.java)
    }

    @Test
    fun knownTopLevelBuilderAndDecodedValuesRemainEqual() {
        assertKnownIdentity(
            DecisionQuestionInputPart.ofInputText(
                DecisionInputText.builder().text("synthetic").build()
            ),
            DecisionQuestionInputPart::class.java,
        )
    }

    @Test
    fun knownNestedBuilderAndDecodedValuesRemainEqual() {
        assertKnownIdentity(
            DecisionStoredDeveloperMessage.Content.ofString("synthetic"),
            DecisionStoredDeveloperMessage.Content::class.java,
        )
    }

    @Test
    fun unknownChoiceAndMessageContentRemainDistinct() {
        assertUnknownIdentity(DecisionChoiceOption.Value::class.java)
        assertUnknownIdentity(DecisionAssistantMessageContent::class.java)
        assertUnknownIdentity(DecisionAssistantMessageContentPart::class.java)
        assertUnknownIdentity(DecisionDeveloperMessage.Content::class.java)
        assertUnknownIdentity(DecisionSystemMessage.Content::class.java)
        assertUnknownIdentity(DecisionUserMessage.Content::class.java)
        assertUnknownIdentity(
            DecisionUserMessage.Content.DecisionUserMessageContentItem::class.java
        )
        assertUnknownIdentity(
            DecisionStoredUserMessage.Content.DecisionStoredUserMessageContentItem::class.java
        )
        assertUnknownIdentity(DecisionQuestion::class.java)
        assertUnknownIdentity(DecisionQuestionInstructions::class.java)
    }

    @Test
    fun sharedToolOutputKeepsItsTextAndImageContract() {
        val image =
            DecisionToolOutputContentPart.ofInputImage(
                DecisionToolOutputContentPart.InputImage.builder()
                    .imageUrl("https://example.test/image.png")
                    .build()
            )
        val text =
            DecisionToolOutputContentPart.ofInputText(
                DecisionInputText.builder().text("done").build()
            )
        val parts = DecisionToolOutput.ofParts(listOf(text, image))
        for (output in listOf(DecisionToolOutput.ofString("done"), parts)) {
            val item =
                DecisionItemCreateEvent.Item.FunctionCallOutput.builder()
                    .callId("call")
                    .output(output)
                    .build()
            val wire = mapper.readTree(mapper.writeValueAsBytes(item.validate()))
            assertThat(wire["type"].textValue()).isEqualTo("function_call_output")
            assertThat(
                    mapper.treeToValue(wire["output"], DecisionToolOutput::class.java).validate()
                )
                .isEqualTo(output)
        }
        for (kind in listOf("input_json", "input_file")) {
            val wire = mapper.readTree("""[{"type":"$kind","data":{}}]""")
            val output = mapper.treeToValue(wire, DecisionToolOutput::class.java)
            assertThat(output.isValid()).isFalse()
            assertThat(mapper.readTree(mapper.writeValueAsBytes(output))).isEqualTo(wire)
        }
    }

    @Test
    fun toolOutputItemsPreserveMissingAndNullFields() {
        for (tag in listOf("function_call_output", "custom_tool_call_output")) {
            for (field in listOf("", ""","output":null""")) {
                val json = """{"type":"$tag","id":"item","call_id":"call"$field}"""
                val create = mapper.readValue(json, DecisionItemCreateEvent.Item::class.java)
                val stored = mapper.readValue(json, DecisionItemCreatedEvent.Item::class.java)
                val values =
                    if (tag == "function_call_output") {
                        listOf(
                            create.asFunctionCallOutput()._output(),
                            stored.asFunctionCallOutput()._output(),
                        )
                    } else {
                        listOf(
                            create.asCustomToolCallOutput()._output(),
                            stored.asCustomToolCallOutput()._output(),
                        )
                    }
                for (value in values) {
                    assertThat(value.isMissing()).isEqualTo(field.isEmpty())
                    assertThat(value.isNull()).isEqualTo(field.isNotEmpty())
                }
                assertThat(create.isValid()).isFalse()
                assertThat(stored.isValid()).isFalse()
            }
            val withoutId = """{"type":"$tag","call_id":"call","output":"done"}"""
            assertThat(
                    mapper.readValue(withoutId, DecisionItemCreateEvent.Item::class.java).isValid()
                )
                .isTrue()
            assertThat(
                    mapper.readValue(withoutId, DecisionItemCreatedEvent.Item::class.java).isValid()
                )
                .isFalse()
        }
    }

    @Test
    fun unknownToolOutputAndPartsRemainDistinct() {
        assertUnknownIdentity(DecisionToolOutput::class.java)
        assertUnknownIdentity(DecisionToolOutputContentPart::class.java)
    }

    @Test
    fun unknownBooleanDataRemainDistinct() {
        assertUnknownIdentity(DecisionQuestionInputPart.InputJson.Data::class.java, "true", "false")
        assertUnknownIdentity(
            DecisionUserMessage.Content.DecisionUserMessageContentItem.InputJson.Data::class.java,
            "true",
            "false",
        )
        assertUnknownIdentity(
            DecisionStoredUserMessage.Content.DecisionStoredUserMessageContentItem.InputJson
                    .Data::class
                .java,
            "true",
            "false",
        )
    }

    @Test
    fun unknownPartsRemainDistinctInsideMessages() {
        fun message(role: String, value: String) =
            """{"id":"synthetic_message","type":"message","role":"$role","content":[{"type":"future_variant","text":"$value"}]}"""

        val assistant =
            assertUnknownIdentity(
                DecisionAssistantMessage::class.java,
                message("assistant", "first"),
                message("assistant", "second"),
            )
        assertThat(assistant.contentOrThrow().isParts()).isTrue()
        val storedAssistant =
            assertUnknownIdentity(
                DecisionStoredAssistantMessage::class.java,
                message("assistant", "first"),
                message("assistant", "second"),
            )
        assertThat(storedAssistant.contentOrThrow().isParts()).isTrue()
        val user =
            assertUnknownIdentity(
                DecisionUserMessage::class.java,
                message("user", "first"),
                message("user", "second"),
            )
        assertThat(user.contentOrThrow().isDecisionItemCreateEventItemContentItems()).isTrue()
        val storedUser =
            assertUnknownIdentity(
                DecisionStoredUserMessage::class.java,
                message("user", "first"),
                message("user", "second"),
            )
        assertThat(storedUser.contentOrThrow().isDecisionItemCreatedEventItemContentItems())
            .isTrue()
    }

    @Test
    fun unknownOutputPartsRemainDistinctInsideEvents() {
        fun event(eventType: String, outputType: String, value: String) =
            """{"event_id":"synthetic_event","type":"$eventType","item":{"id":"synthetic_item","type":"$outputType","call_id":"synthetic_call","output":[{"type":"future_variant","text":"$value"}]}}"""

        for (outputType in listOf("function_call_output", "custom_tool_call_output")) {
            val create =
                assertUnknownIdentity(
                    DecisionItemCreateEvent::class.java,
                    event("decision.item.create", outputType, "first"),
                    event("decision.item.create", outputType, "second"),
                )
            val created =
                assertUnknownIdentity(
                    DecisionItemCreatedEvent::class.java,
                    event("decision.item.created", outputType, "first"),
                    event("decision.item.created", outputType, "second"),
                )
            val outputs =
                if (outputType == "function_call_output") {
                    listOf(
                        create.itemOrThrow().asFunctionCallOutput().outputOrThrow(),
                        created.itemOrThrow().asFunctionCallOutput().outputOrThrow(),
                    )
                } else {
                    listOf(
                        create.itemOrThrow().asCustomToolCallOutput().outputOrThrow(),
                        created.itemOrThrow().asCustomToolCallOutput().outputOrThrow(),
                    )
                }
            for (output: DecisionToolOutput in outputs) {
                val part: DecisionToolOutputContentPart = output.asParts().single()
                assertThat(mapper.readTree(mapper.writeValueAsBytes(part)))
                    .isEqualTo(mapper.readTree("""{"type":"future_variant","text":"first"}"""))
                assertThat(output.isValid()).isFalse()
            }
        }
    }

    @Test
    fun knownMessageRolesRetainFutureContentWithoutRelaxingValidation() {
        for (role in listOf("user", "assistant", "developer", "system")) {
            for (tag in listOf("", """"type":"message",""")) {
                val item =
                    """{"id":"synthetic_item",$tag"role":"$role","content":[{"type":"future_part","text":"synthetic"}]}"""
                val create =
                    mapper.readValue(
                        """{"type":"decision.item.create","item":$item}""",
                        DecisionItemCreateEvent::class.java,
                    )
                val created =
                    mapper.readValue(
                        """{"type":"decision.item.created","event_id":"synthetic_event","item":$item}""",
                        DecisionItemCreatedEvent::class.java,
                    )
                when (role) {
                    "user" -> {
                        check(
                            create
                                .itemOrThrow()
                                .asDecisionUserMessage()
                                .contentOrThrow()
                                .asDecisionItemCreateEventItemContentItems()
                                .single()
                                ._json()
                                .isPresent
                        )
                        check(
                            created
                                .itemOrThrow()
                                .asDecisionStoredUserMessage()
                                .contentOrThrow()
                                .asDecisionItemCreatedEventItemContentItems()
                                .single()
                                ._json()
                                .isPresent
                        )
                    }
                    "assistant" -> {
                        check(
                            create
                                .itemOrThrow()
                                .asDecisionAssistantMessage()
                                .contentOrThrow()
                                .asParts()
                                .single()
                                ._json()
                                .isPresent
                        )
                        check(
                            created
                                .itemOrThrow()
                                .asDecisionStoredAssistantMessage()
                                .contentOrThrow()
                                .asParts()
                                .single()
                                ._json()
                                .isPresent
                        )
                    }
                    "developer" -> {
                        create.itemOrThrow().asDecisionDeveloperMessage().contentOrThrow()
                        created.itemOrThrow().asDecisionStoredDeveloperMessage().contentOrThrow()
                    }
                    "system" -> {
                        create.itemOrThrow().asDecisionSystemMessage().contentOrThrow()
                        created.itemOrThrow().asDecisionStoredSystemMessage().contentOrThrow()
                    }
                }
                check(mapper.writeValueAsString(create).contains("future_part"))
                check(mapper.writeValueAsString(created).contains("future_part"))
                check(runCatching { create.validate() }.isFailure)
                check(runCatching { created.validate() }.isFailure)
            }
        }
        for (role in listOf("future_role", "")) {
            val item = """{"type":"message","role":"$role","content":"synthetic"}"""
            val create = mapper.readValue(item, DecisionItemCreateEvent.Item::class.java)
            val created = mapper.readValue(item, DecisionItemCreatedEvent.Item::class.java)
            check(
                !create.isDecisionUserMessage() &&
                    !create.isDecisionAssistantMessage() &&
                    !create.isDecisionDeveloperMessage() &&
                    !create.isDecisionSystemMessage()
            )
            check(
                !created.isDecisionStoredUserMessage() &&
                    !created.isDecisionStoredAssistantMessage() &&
                    !created.isDecisionStoredDeveloperMessage() &&
                    !created.isDecisionStoredSystemMessage()
            )
            check(create._json().isPresent && created._json().isPresent)
        }
    }

    private fun <T> assertUnknownIdentity(
        type: Class<T>,
        firstJson: String = """{"type":"future_variant","value":"first"}""",
        secondJson: String = """{"type":"future_variant","value":"second"}""",
    ): T {
        val first = mapper.readValue(firstJson, type)
        val same = mapper.readValue(firstJson, type)
        val second = mapper.readValue(secondJson, type)
        assertThat(first).isEqualTo(same)
        assertThat(first.hashCode()).isEqualTo(same.hashCode())
        assertThat(first).isNotEqualTo(second)
        assertThat(setOf(first, same, second)).hasSize(2)
        assertThat(mapOf(first to "first", second to "second")).hasSize(2)
        return first
    }

    private fun <T> assertKnownIdentity(built: T, type: Class<T>) {
        val decoded = mapper.readValue(mapper.writeValueAsString(built), type)
        assertThat(decoded).isEqualTo(built)
        assertThat(built).isEqualTo(decoded)
        assertThat(decoded.hashCode()).isEqualTo(built.hashCode())
        assertThat(setOf(built, decoded)).hasSize(1)
    }
}
