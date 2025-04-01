// File generated from our OpenAPI spec by Stainless.

package com.openai.models

import com.fasterxml.jackson.module.kotlin.jacksonTypeRef
import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.errors.OpenAIInvalidDataException
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.EnumSource

internal class AllModelsTest {

    @Test
    fun ofString() {
        val string = "string"

        val allModels = AllModels.ofString(string)

        assertThat(allModels.string()).contains(string)
        assertThat(allModels.chatModel()).isEmpty
        assertThat(allModels.unionMember2()).isEmpty
    }

    @Test
    fun ofStringRoundtrip() {
        val jsonMapper = jsonMapper()
        val allModels = AllModels.ofString("string")

        val roundtrippedAllModels =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(allModels),
                jacksonTypeRef<AllModels>(),
            )

        assertThat(roundtrippedAllModels).isEqualTo(allModels)
    }

    @Test
    fun ofChatModel() {
        val chatModel = ChatModel.O3_MINI

        val allModels = AllModels.ofChatModel(chatModel)

        assertThat(allModels.string()).isEmpty
        assertThat(allModels.chatModel()).contains(chatModel)
        assertThat(allModels.unionMember2()).isEmpty
    }

    @Test
    fun ofChatModelRoundtrip() {
        val jsonMapper = jsonMapper()
        val allModels = AllModels.ofChatModel(ChatModel.O3_MINI)

        val roundtrippedAllModels =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(allModels),
                jacksonTypeRef<AllModels>(),
            )

        assertThat(roundtrippedAllModels).isEqualTo(allModels)
    }

    @Test
    fun ofUnionMember2() {
        val unionMember2 = AllModels.UnionMember2.O1_PRO

        val allModels = AllModels.ofUnionMember2(unionMember2)

        assertThat(allModels.string()).isEmpty
        assertThat(allModels.chatModel()).isEmpty
        assertThat(allModels.unionMember2()).contains(unionMember2)
    }

    @Test
    fun ofUnionMember2Roundtrip() {
        val jsonMapper = jsonMapper()
        val allModels = AllModels.ofUnionMember2(AllModels.UnionMember2.O1_PRO)

        val roundtrippedAllModels =
            jsonMapper.readValue(
                jsonMapper.writeValueAsString(allModels),
                jacksonTypeRef<AllModels>(),
            )

        assertThat(roundtrippedAllModels).isEqualTo(allModels)
    }

    enum class IncompatibleJsonShapeTestCase(val value: JsonValue) {
        OBJECT(JsonValue.from(mapOf("invalid" to "object"))),
        ARRAY(JsonValue.from(listOf("invalid", "array"))),
    }

    @ParameterizedTest
    @EnumSource
    fun incompatibleJsonShapeDeserializesToUnknown(testCase: IncompatibleJsonShapeTestCase) {
        val allModels = jsonMapper().convertValue(testCase.value, jacksonTypeRef<AllModels>())

        val e = assertThrows<OpenAIInvalidDataException> { allModels.validate() }
        assertThat(e).hasMessageStartingWith("Unknown ")
    }
}
