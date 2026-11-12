package com.openai.models.live

import com.openai.core.JsonValue
import com.openai.core.jsonMapper
import com.openai.models.decisions.DecisionChoiceOption
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

internal class SharedQuestionInstructionsConsumerTest {
    @Test
    fun invalidJsonInstructionsFailStrictValidation() {
        val mapper = jsonMapper()
        for (fields in
            listOf("{}", """{"data":null}""", """{"data":false}""", """{"data":[1]}""")) {
            val json = mapper.readTree(fields) as com.fasterxml.jackson.databind.node.ObjectNode
            json.put("type", "input_json")
            val decoded = mapper.treeToValue(json, DecisionQuestionInputPart::class.java)
            assertThat(decoded.isValid()).describedAs(fields).isFalse()
            assertThat(mapper.readTree(mapper.writeValueAsBytes(decoded))).isEqualTo(json)
        }
    }

    @Test
    fun sharedPartsWorkAcrossAllQuestionKinds() {
        val parts =
            listOf(
                DecisionQuestionInputPart.ofInputText(
                    DecisionInputText.builder().text("synthetic instructions").build()
                ),
                DecisionQuestionInputPart.ofInputImage(
                    DecisionQuestionInputPart.InputImage.builder()
                        .imageUrl("https://example.com/image")
                        .build()
                ),
                DecisionQuestionInputPart.ofInputJson(
                    DecisionQuestionInputPart.InputJson.builder()
                        .data(
                            DecisionJsonObject.builder()
                                .putAdditionalProperty("count", JsonValue.from(2))
                                .build()
                        )
                        .build()
                ),
                DecisionQuestionInputPart.ofInputJson(
                    DecisionQuestionInputPart.InputJson.builder()
                        .dataOfDecisionJsonObjects(listOf(DecisionJsonObject.builder().build()))
                        .build()
                ),
            )
        val instructions = DecisionQuestionInstructions.ofParts(parts)
        val choice =
            DecisionQuestion.Choice.builder()
                .instructions(instructions)
                .addChoice(DecisionChoiceOption.builder().value("yes").build())
                .addChoice(DecisionChoiceOption.builder().value("no").build())
                .build()
        val predicate = DecisionQuestion.Predicate.builder().instructionsOfParts(parts).build()
        val score =
            DecisionQuestion.Score.builder()
                .instructions(instructions)
                .addLevel(DecisionQuestion.Score.Level.builder().label("low").build())
                .build()
        val mapper = jsonMapper()
        val questions =
            listOf(
                DecisionQuestion.ofChoice(choice),
                DecisionQuestion.ofPredicate(predicate),
                DecisionQuestion.ofScore(score),
            )
        val update = DecisionsDelegationUpdateConfig.builder().questions(questions).build()
        val trigger = DecisionTrigger.Decisions.builder().addQuestion(questions[1]).build()
        assertThat(trigger.questionsOrThrow().single().asPredicate().instructionsOrThrow())
            .isEqualTo(instructions)
        val wire = mapper.readTree(mapper.writeValueAsBytes(update))
        val expected =
            mapper.readTree(
                """[{"type":"input_text","text":"synthetic instructions"},{"type":"input_image","image_url":"https://example.com/image"},{"type":"input_json","data":{"count":2}},{"type":"input_json","data":[{}]}]"""
            )
        assertThat(wire.path("questions").size()).isEqualTo(questions.size)
        for (question in wire.path("questions")) {
            assertThat(question.path("instructions")).isEqualTo(expected)
        }
        assertThat(mapper.treeToValue(wire, DecisionsDelegationUpdateConfig::class.java))
            .isEqualTo(update)
        assertThat(choice.instructionsOrThrow())
            .isEqualTo(predicate.instructionsOrThrow())
            .isEqualTo(score.instructionsOrThrow())
    }
}
