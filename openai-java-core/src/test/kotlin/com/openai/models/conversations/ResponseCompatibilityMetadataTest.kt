package com.openai.models.conversations

import com.fasterxml.jackson.databind.JsonNode
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.ValueSource

internal class ResponseCompatibilityMetadataTest {

    @Test
    fun emptyMetadataIsAnEmptyObject() {
        val conversation = decode(""","metadata":{}""").validate()
        assertThat(conversation.metadataOrThrow()._allProperties()).isEmpty()
        val json = jsonMapper().valueToTree<JsonNode>(conversation)
        assertThat(json["metadata"].isObject).isTrue
    }

    @Test
    fun numericMetadataValueCannotBeReadAsAString() {
        val metadata = decode(""","metadata":{"priority":7}""").metadataOrThrow()
        val priority = metadata._allProperties().getValue("priority")
        assertThatThrownBy { priority.asStringOrThrow() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
    }

    @ParameterizedTest
    @ValueSource(strings = ["", ""","metadata":null""", ""","metadata":[]"""])
    fun invalidMetadataFailsStrictValidation(member: String) {
        assertThatThrownBy { decode(member).validate() }
            .isInstanceOf(OpenAIInvalidDataException::class.java)
            .hasMessageContaining("metadata")
    }

    private fun decode(member: String): Conversation =
        jsonMapper()
            .readValue(
                """{"id":"conv_1","object":"conversation","created_at":1$member}""",
                Conversation::class.java,
            )
}
