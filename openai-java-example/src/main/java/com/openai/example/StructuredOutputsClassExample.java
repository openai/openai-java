package com.openai.example;

import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.openai.client.OpenAIClient;
import com.openai.client.okhttp.OpenAIOkHttpClient;
import com.openai.models.ChatModel;
import com.openai.models.chat.completions.ChatCompletionCreateParams;
import com.openai.models.chat.completions.StructuredChatCompletionCreateParams;
import java.util.List;

public final class StructuredOutputsClassExample {

    public static class Person {
        public String firstName;
        public String surname;

        @JsonPropertyDescription("The date of birth of the person.")
        public String dateOfBirth;

        @Override
        public String toString() {
            return "Person{firstName=" + firstName + ", surname=" + surname + ", dateOfBirth=" + dateOfBirth + '}';
        }
    }

    public static class Laureate {
        public Person person;
        public String majorAchievement;
        public int yearWon;

        @JsonPropertyDescription("The share of the prize money won by the Nobel Laureate.")
        public double prizeMoney;

        @Override
        public String toString() {
            return "Laureate{person="
                    + person + ", majorAchievement="
                    + majorAchievement + ", yearWon="
                    + yearWon + ", prizeMoney="
                    + prizeMoney + '}';
        }
    }

    public static class Laureates {
        @JsonPropertyDescription("A list of winners of a Nobel Prize.")
        public List<Laureate> laureates;

        @Override
        public String toString() {
            return "Laureates{laureates=" + laureates + '}';
        }
    }

    private StructuredOutputsClassExample() {}

    public static void main(String[] args) {
        // Configures using one of:
        // - The `OPENAI_API_KEY` environment variable
        // - The `OPENAI_BASE_URL` and `AZURE_OPENAI_KEY` environment variables
        OpenAIClient client = OpenAIOkHttpClient.fromEnv();

        StructuredChatCompletionCreateParams<Laureates> createParams = ChatCompletionCreateParams.builder()
                .model(ChatModel.GPT_4O_MINI)
                .maxCompletionTokens(2048)
                .responseFormat(Laureates.class)
                .addUserMessage("List some winners of the Nobel Prize in Physics since 2000.")
                .build();

        client.chat().completions().create(createParams).choices().stream()
                .flatMap(choice -> choice.message().content().stream())
                .forEach(System.out::println);
    }
}
