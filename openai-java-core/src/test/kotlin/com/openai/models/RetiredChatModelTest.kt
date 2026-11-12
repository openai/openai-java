package com.openai.models

import com.openai.core.jsonMapper
import com.openai.models.beta.responses.BetaResponse
import com.openai.models.beta.responses.BetaResponsesClientEvent
import com.openai.models.beta.responses.ResponseCompactParams as BetaResponseCompactParams
import com.openai.models.beta.responses.ResponseCreateParams as BetaResponseCreateParams
import com.openai.models.responses.ResponseCompactParams
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class RetiredChatModelTest {
    @Test
    fun modelWrappersAndLegacyEnumsKeepTheSurvivingAlias() {
        val wrappers =
            listOf(
                ChatModel::class.java,
                BetaResponse.Model::class.java,
                BetaResponsesClientEvent.ResponseCreate.Model::class.java,
                BetaResponseCompactParams.Model::class.java,
                BetaResponseCreateParams.Model::class.java,
                ResponseCompactParams.Model::class.java,
            )
        for (wrapper in wrappers) {
            val projections = wrapper.declaredClasses.associateBy { it.simpleName }
            for (type in
                listOf(wrapper, projections.getValue("Known"), projections.getValue("Value"))) {
                assertThat(type.fields.map { it.name })
                    .describedAs("public fields of %s", type.name)
                    .contains("GPT_3_5_TURBO_16K")
                    .doesNotContain(
                        "GPT_3_5_TURBO_0613",
                        "GPT_3_5_TURBO_16K_0613",
                        "GPT_4_VISION_PREVIEW",
                    )
            }
        }
    }

    @Test
    fun retiredAndCustomModelIdsRoundTripAsUnknownStrings() {
        val mapper = jsonMapper()
        for (id in
            listOf(
                "gpt-4-vision-preview",
                "gpt-3.5-turbo-0613",
                "gpt-3.5-turbo-16k-0613",
                "custom-deployment",
            )) {
            val json = mapper.writeValueAsString(id)
            val model = mapper.readValue(json, ChatModel::class.java)

            assertThat(model).isEqualTo(ChatModel.of(id))
            assertThat(model.asString()).isEqualTo(id)
            assertThat(model.value()).isEqualTo(ChatModel.Value._UNKNOWN)
            assertThat(mapper.writeValueAsString(model)).isEqualTo(json)
        }
    }
}
