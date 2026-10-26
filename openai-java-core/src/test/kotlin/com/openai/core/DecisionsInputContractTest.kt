package com.openai.core

import com.fasterxml.jackson.databind.JsonNode
import com.openai.models.DecisionInputJson
import com.openai.models.decisions.DecisionCreateParams
import com.openai.models.decisions.DecisionInputItem
import com.openai.models.decisions.DecisionInputMessage
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.junit.jupiter.api.Test

internal class DecisionsInputContractTest {
    @Test
    fun serializesUserMessageInCreateRequest() {
        val message =
            DecisionInputMessage.ofUser(
                DecisionInputMessage.User.builder().content("Review this request").build()
            )
        val params =
            DecisionCreateParams.builder()
                .inputOfDecisionInputItems(
                    listOf(DecisionInputItem.ofDecisionInputMessage(message))
                )
                .model("model")
                .addPredicateQuestion("Is this a request?")
                .build()

        val input = jsonMapper().valueToTree<JsonNode>(params._body()).path("input").path(0)
        assertThat(input.path("role").asText()).isEqualTo("user")
        assertThat(input.path("content").asText()).isEqualTo("Review this request")
    }

    @Test
    fun snapshotsJsonInputMaps() {
        val original = JsonValue.from("original")
        val source = mutableMapOf("answer" to original)
        val input = DecisionInputJson.builder().dataOfMaps(listOf(source)).build()
        val expected =
            DecisionInputJson.builder().dataOfMaps(listOf(mapOf("answer" to original))).build()
        val originalHashCode = input.hashCode()

        source["answer"] = JsonValue.from("changed")
        val serialized = jsonMapper().writeValueAsString(input)
        assertThat(jsonMapper().readTree(serialized).path("data").path(0).path("answer").asText())
            .isEqualTo("original")
        val roundtripped = jsonMapper().readValue(serialized, DecisionInputJson::class.java)

        for (model in listOf(input, roundtripped)) {
            val returned = model.data().asMaps().single() as MutableMap
            assertThatThrownBy { returned["answer"] = JsonValue.from("changed") }
                .isInstanceOf(UnsupportedOperationException::class.java)
            assertThat(model).isEqualTo(expected)
            assertThat(model.hashCode()).isEqualTo(originalHashCode).isEqualTo(expected.hashCode())
        }
    }
}
