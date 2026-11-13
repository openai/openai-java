package com.openai.helpers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonField
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.responses.ResponseInputItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

internal class ResponseInputItemCompactionTriggerTest {

    @Test
    fun rawCompactionTriggerPreservesAdditionalFieldsAcrossRoundtrip() {
        val raw =
            JsonValue.from(
                mapOf(
                    "type" to "compaction_trigger",
                    "id" to "cmp_123",
                    "future_field" to mapOf("enabled" to true),
                )
            )
        val inputItem = ResponseInputItem.ofCompactionTrigger(raw)

        inputItem.validate()
        assertThat(inputItem.asCompactionTrigger().id()).contains("cmp_123")

        val mapper = jsonMapper()
        val json = mapper.writeValueAsString(inputItem)
        val roundtripped = mapper.readValue(json, jacksonTypeRef<ResponseInputItem>())

        roundtripped.validate()
        assertThat(JsonValue.from(roundtripped.asCompactionTrigger())).isEqualTo(raw)
        assertThat(mapper.readTree(mapper.writeValueAsString(roundtripped)))
            .isEqualTo(mapper.readTree(json))
    }

    @Test
    fun typedTriggerPreservesMissingNullAndPopulatedId() {
        val empty = ResponseInputItem.ofCompactionTrigger()
        assertThat(empty.isCompactionTrigger()).isTrue()
        assertThat(empty.asCompactionTrigger()._id().isMissing()).isTrue()

        for (id in listOf(null, "", "cmp_1")) {
            val trigger =
                ResponseInputItem.CompactionTrigger.builder()
                    .id(JsonField.ofNullable(id))
                    .putAdditionalProperty("future", JsonValue.from(true))
                    .build()
            val item = ResponseInputItem.ofCompactionTrigger(trigger)
            assertThat(item.compactionTrigger()).contains(trigger)
            val visitor = mock<ResponseInputItem.Visitor<String>>()
            item.accept(visitor)
            verify(visitor).visitCompactionTrigger(trigger)
            val restored = checkNotNull(JsonValue.from(item).convert(ResponseInputItem::class.java))
            val typed = restored.validate().asCompactionTrigger()
            assertThat(typed._id().isNull()).isEqualTo(id == null)
            assertThat(typed.id().orElse(null)).isEqualTo(id)
            assertThat(typed._allProperties()["future"]).isEqualTo(JsonValue.from(true))
        }
    }

    enum class InvalidDiscriminator(val value: JsonValue) {
        NULL(JsonValue.from(null)),
        SCALAR(JsonValue.from("future")),
        MISSING(JsonValue.from(mapOf("id" to "cmp_123"))),
        NON_STRING(JsonValue.from(mapOf("type" to 123))),
        INCORRECT(JsonValue.from(mapOf("type" to "other"))),
    }

    @ParameterizedTest
    @EnumSource
    fun rawCompactionTriggerRejectsInvalidDiscriminator(testCase: InvalidDiscriminator) {
        val inputItem = ResponseInputItem.ofCompactionTrigger(testCase.value)

        assertThat(inputItem.isCompactionTrigger()).isFalse()
        assertThat(JsonValue.from(inputItem)).isEqualTo(testCase.value)
        assertThrows<OpenAIInvalidDataException> { inputItem.validate() }
    }
}
