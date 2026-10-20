package com.openai.helpers

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import com.openai.models.responses.ResponseInputItem
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

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
        assertThat(inputItem.asCompactionTrigger()).isEqualTo(raw)

        val mapper = jsonMapper()
        val json = mapper.writeValueAsString(inputItem)
        val roundtripped = mapper.readValue(json, jacksonTypeRef<ResponseInputItem>())

        roundtripped.validate()
        assertThat(roundtripped.asCompactionTrigger()).isEqualTo(raw)
        assertThat(mapper.readTree(mapper.writeValueAsString(roundtripped)))
            .isEqualTo(mapper.readTree(json))
    }

    enum class InvalidDiscriminator(val value: JsonValue) {
        MISSING(JsonValue.from(mapOf("id" to "cmp_123"))),
        NON_STRING(JsonValue.from(mapOf("type" to 123))),
        INCORRECT(JsonValue.from(mapOf("type" to "other"))),
    }

    @ParameterizedTest
    @EnumSource
    fun rawCompactionTriggerRejectsInvalidDiscriminator(testCase: InvalidDiscriminator) {
        val inputItem = ResponseInputItem.ofCompactionTrigger(testCase.value)

        val error = assertThrows<OpenAIInvalidDataException> { inputItem.validate() }
        assertThat(error).hasMessageContaining("'compactionTrigger' is invalid")
    }
}
