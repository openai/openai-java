// File generated from our OpenAPI spec by Castiron. See CONTRIBUTING.md for details.

package com.openai.models.live

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class InitialItemTest {

    @Test
    fun ofDeveloper() {
        val developer =
            InitialItem.Developer.builder()
                .addContent(
                    InitialItem.Developer.Content.builder()
                        .text("text")
                        .type(InitialItem.Developer.Content.Type.INPUT_TEXT)
                        .build()
                )
                .id("id")
                .status(InitialItem.Developer.Status.INCOMPLETE)
                .type(InitialItem.Developer.Type.MESSAGE)
                .build()

        val initialItem = InitialItem.ofDeveloper(developer)

        assertThat(initialItem.developer()).contains(developer)
        assertThat(initialItem.user()).isEmpty
        assertThat(initialItem.assistant()).isEmpty
    }

    @Test
    fun ofDeveloperRoundtrip() {
        val jsonMapper = jsonMapper()
        val initialItem =
            InitialItem.ofDeveloper(
                InitialItem.Developer.builder()
                    .addContent(
                        InitialItem.Developer.Content.builder()
                            .text("text")
                            .type(InitialItem.Developer.Content.Type.INPUT_TEXT)
                            .build()
                    )
                    .id("id")
                    .status(InitialItem.Developer.Status.INCOMPLETE)
                    .type(InitialItem.Developer.Type.MESSAGE)
                    .build()
            )

        val roundtrippedInitialItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(initialItem),
                jacksonTypeRef<InitialItem>(),
            )

        assertThat(roundtrippedInitialItem).isEqualTo(initialItem)
    }

    @Test
    fun ofUser() {
        val user =
            InitialItem.User.builder()
                .addContent(
                    InitialItem.User.Content.builder()
                        .text("text")
                        .type(InitialItem.User.Content.Type.INPUT_TEXT)
                        .build()
                )
                .id("id")
                .status(InitialItem.User.Status.INCOMPLETE)
                .type(InitialItem.User.Type.MESSAGE)
                .build()

        val initialItem = InitialItem.ofUser(user)

        assertThat(initialItem.developer()).isEmpty
        assertThat(initialItem.user()).contains(user)
        assertThat(initialItem.assistant()).isEmpty
    }

    @Test
    fun ofUserRoundtrip() {
        val jsonMapper = jsonMapper()
        val initialItem =
            InitialItem.ofUser(
                InitialItem.User.builder()
                    .addContent(
                        InitialItem.User.Content.builder()
                            .text("text")
                            .type(InitialItem.User.Content.Type.INPUT_TEXT)
                            .build()
                    )
                    .id("id")
                    .status(InitialItem.User.Status.INCOMPLETE)
                    .type(InitialItem.User.Type.MESSAGE)
                    .build()
            )

        val roundtrippedInitialItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(initialItem),
                jacksonTypeRef<InitialItem>(),
            )

        assertThat(roundtrippedInitialItem).isEqualTo(initialItem)
    }

    @Test
    fun ofAssistant() {
        val assistant =
            InitialItem.Assistant.builder()
                .addTextContent("text")
                .id("id")
                .status(InitialItem.Assistant.Status.INCOMPLETE)
                .type(InitialItem.Assistant.Type.MESSAGE)
                .build()

        val initialItem = InitialItem.ofAssistant(assistant)

        assertThat(initialItem.developer()).isEmpty
        assertThat(initialItem.user()).isEmpty
        assertThat(initialItem.assistant()).contains(assistant)
    }

    @Test
    fun ofAssistantRoundtrip() {
        val jsonMapper = jsonMapper()
        val initialItem =
            InitialItem.ofAssistant(
                InitialItem.Assistant.builder()
                    .addTextContent("text")
                    .id("id")
                    .status(InitialItem.Assistant.Status.INCOMPLETE)
                    .type(InitialItem.Assistant.Type.MESSAGE)
                    .build()
            )

        val roundtrippedInitialItem =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(initialItem),
                jacksonTypeRef<InitialItem>(),
            )

        assertThat(roundtrippedInitialItem).isEqualTo(initialItem)
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
        val initialItem = jsonMapper().convertValue(testCase.value, jacksonTypeRef<InitialItem>())

        val e = assertThrows<OpenAIInvalidDataException> { initialItem.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
