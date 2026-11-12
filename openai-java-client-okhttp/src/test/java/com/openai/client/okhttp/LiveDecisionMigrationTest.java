package com.openai.client.okhttp;

import static org.assertj.core.api.Assertions.assertThat;

import com.fasterxml.jackson.databind.JsonNode;
import com.openai.core.ObjectMappers;
import com.openai.models.decisions.DecisionChoiceOption;
import com.openai.models.decisions.DecisionCreateParams;
import com.openai.models.live.DecisionAssistantMessage;
import com.openai.models.live.DecisionAssistantMessageContent;
import com.openai.models.live.DecisionAssistantMessageContentPart;
import com.openai.models.live.DecisionInputText;
import com.openai.models.live.DecisionItemCreateEvent;
import com.openai.models.live.DecisionItemCreatedEvent;
import com.openai.models.live.DecisionQuestion;
import com.openai.models.live.DecisionQuestionInputPart;
import com.openai.models.live.DecisionQuestionInstructions;
import com.openai.models.live.DecisionStoredAssistantMessage;
import com.openai.models.live.DecisionToolOutput;
import com.openai.models.live.DecisionToolOutputContentPart;
import com.openai.models.live.DecisionTrigger;
import com.openai.models.live.DecisionUserMessage;
import com.openai.models.live.DecisionsDelegationUpdateConfig;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import org.junit.jupiter.api.Test;

final class LiveDecisionMigrationTest {
    @Test
    void reuseAssistantContentAndPartsBetweenEnvelopes() {
        List<DecisionAssistantMessageContentPart> parts = Arrays.asList(
                DecisionAssistantMessageContentPart.ofOutputText(
                        DecisionAssistantMessageContentPart.OutputText.builder()
                                .text("hello")
                                .build()),
                DecisionAssistantMessageContentPart.ofRefusal(DecisionAssistantMessageContentPart.Refusal.builder()
                        .refusal("declined")
                        .build()));
        DecisionAssistantMessageContent content = DecisionAssistantMessageContent.ofParts(parts);
        DecisionStoredAssistantMessage stored = DecisionStoredAssistantMessage.builder()
                .id("item")
                .content(content)
                .build();
        DecisionAssistantMessage create = DecisionAssistantMessage.builder()
                .content(stored.contentOrThrow())
                .build();
        assertThat(DecisionStoredAssistantMessage.builder()
                        .id("copy")
                        .content(create.contentOrThrow())
                        .build()
                        .contentOrThrow())
                .isEqualTo(content);
        assertThat(DecisionAssistantMessage.builder()
                        .contentOfParts(parts)
                        .build()
                        .contentOrThrow())
                .isEqualTo(content);
        assertThat(DecisionStoredAssistantMessage.builder()
                        .id("parts")
                        .contentOfParts(parts)
                        .build()
                        .contentOrThrow())
                .isEqualTo(content);
    }

    @Test
    void reuseChoiceOptionsInLiveAndDecisions() {
        DecisionChoiceOption bool = DecisionChoiceOption.builder().value(false).build();
        DecisionChoiceOption text =
                DecisionChoiceOption.builder().value("false").build();
        DecisionQuestion.Choice live = DecisionQuestion.Choice.builder()
                .instructions("Choose")
                .choices(Collections.singletonList(bool))
                .addChoice(text)
                .build();
        DecisionCreateParams.Question.Choice question = DecisionCreateParams.Question.Choice.builder()
                .instructions("Choose")
                .choices(live.choicesOrThrow())
                .build();
        assertThat(question.choicesOrThrow()).containsExactly(bool, text);
        assertThat(bool.valueOrThrow().asBool()).isFalse();
        assertThat(text.valueOrThrow().asString()).isEqualTo("false");
        JsonNode wire = ObjectMappers.jsonMapper().valueToTree(live);
        JsonNode choices = wire.path("choices");
        assertThat(choices.get(0).get("value").isBoolean()).isTrue();
        assertThat(choices.get(0).get("value").booleanValue()).isFalse();
        assertThat(choices.get(1).get("value").textValue()).isEqualTo("false");
        assertThat(choices.get(0).has("description")).isFalse();
    }

    @Test
    void buildAndReadUserMessage() {
        DecisionUserMessage message =
                DecisionUserMessage.builder().content("Ready?").build();
        DecisionItemCreateEvent event =
                DecisionItemCreateEvent.builder().item(message).build();
        DecisionItemCreateEvent original = DecisionItemCreateEvent.builder()
                .item(DecisionItemCreateEvent.Item.builder()
                        .type(DecisionItemCreateEvent.Item.Type.MESSAGE)
                        .content("Ready?")
                        .build())
                .build();
        assertThat(original).isEqualTo(event);
        assertThat(event.itemOrThrow().asDecisionUserMessage().contentOrThrow().asString())
                .isEqualTo("Ready?");
    }

    @Test
    void reuseToolOutputAcrossCreateAndStoredItems() {
        DecisionToolOutputContentPart text = DecisionToolOutputContentPart.ofInputText(
                DecisionInputText.builder().text("done").build());
        DecisionToolOutput output = DecisionToolOutput.ofParts(Collections.singletonList(text));
        DecisionItemCreateEvent.Item.FunctionCallOutput createFunction =
                DecisionItemCreateEvent.Item.FunctionCallOutput.builder()
                        .callId("call")
                        .output(output)
                        .build();
        DecisionItemCreateEvent.Item.CustomToolCallOutput createCustom =
                DecisionItemCreateEvent.Item.CustomToolCallOutput.builder()
                        .callId("call")
                        .output(output)
                        .build();
        DecisionItemCreatedEvent.Item.FunctionCallOutput storedFunction =
                DecisionItemCreatedEvent.Item.FunctionCallOutput.builder()
                        .id("item")
                        .callId("call")
                        .output(output)
                        .build();
        DecisionItemCreatedEvent.Item.CustomToolCallOutput storedCustom =
                DecisionItemCreatedEvent.Item.CustomToolCallOutput.builder()
                        .id("item")
                        .callId("call")
                        .output(output)
                        .build();
        assertThat(createFunction.validate().outputOrThrow()).isEqualTo(output);
        assertThat(createCustom.validate().outputOrThrow()).isEqualTo(output);
        assertThat(storedFunction.validate().outputOrThrow()).isEqualTo(output);
        assertThat(storedCustom.validate().outputOrThrow()).isEqualTo(output);
    }

    @Test
    void reuseStructuredQuestionInstructions() {
        DecisionQuestionInputPart part = DecisionQuestionInputPart.ofInputText(
                DecisionInputText.builder().text("Ready?").build());
        DecisionQuestionInstructions instructions =
                DecisionQuestionInstructions.ofParts(Collections.singletonList(part));
        DecisionQuestion question = DecisionQuestion.ofPredicate(
                DecisionQuestion.Predicate.builder().instructions(instructions).build());
        DecisionTrigger.Decisions trigger =
                DecisionTrigger.Decisions.builder().addQuestion(question).build();
        assertThat(trigger.questionsOrThrow()).containsExactly(question);
        DecisionsDelegationUpdateConfig update =
                DecisionsDelegationUpdateConfig.builder().addQuestion(question).build();
        assertThat(update.questions()
                        .get()
                        .get(0)
                        .asPredicate()
                        .instructionsOrThrow()
                        .asParts())
                .containsExactly(part);
    }
}
